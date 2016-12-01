package aufgabe2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Value {
	
	double val = 0;
	int[] position = null;
	boolean used = false;
	Value[] nachbarn;
	
	public Value(int[] p, boolean u, Double v) {
		this.val = v;
		this.position = p;
		this.used = u;
	}

	public boolean neighborsFree(Value[] v){
		for(int i = 0; i < v.length; i++){
			if(!v[i].isUsed()){
				return true;
			}
		}
		return false;
	}
	
	public double checkNeighborsVal(){
		return 0;
	}
	
	public int[] checkNeighbors(){
		for(Value i : nachbarn){
			if(!i.isUsed()){
				i.setUsed(true);
				return i.getPosition();
			} else{
				i.setUsed(true);
			}
		}
		return null;
	}
	
	public Value[] getNeighbors(){
		return this.nachbarn;
	}

	public List<Value> getNeighbours(Value[][] values, int step) {
		List<Value> returnList = new ArrayList<>();
		int x_max = values.length;
		int y_max = values[0].length;

		if (step < 1) {
			return returnList;
		}
		List<Integer> innerList = new ArrayList<>();
		List<Integer> outerList = new ArrayList<>();
		outerList.add(step);
		outerList.add((-1) * step);
		innerList.add(0);
		for (int i = 1; i < step; i++) {
			innerList.add(i);
			innerList.add((-1) * i);
		}

		for (int i = 0; i < 2; i++) {
			if ((this.position[0] + outerList.get(i)) < x_max && (this.position[1] + outerList.get(i)) < y_max &&
					(this.position[0] + outerList.get(i)) >= 0 && (this.position[1] + outerList.get(i)) >= 0)
			{
				returnList.add(values[this.position[0] + outerList.get(i)][this.position[1] + outerList.get(i)]);
			}

			if ((this.position[0] + outerList.get(i)) < x_max && (this.position[1] - outerList.get(i)) < y_max &&
					(this.position[0] + outerList.get(i)) >= 0 && (this.position[1] - outerList.get(i)) >= 0)
			{
				returnList.add(values[this.position[0] + outerList.get(i)][this.position[1] - outerList.get(i)]);
			}

			for (int k = 0; k < innerList.size(); k++) {

				if ((this.position[0] + outerList.get(i)) < x_max && (this.position[1] + innerList.get(k)) < y_max &&
						(this.position[0] + outerList.get(i)) >= 0 && (this.position[1] + innerList.get(k)) >= 0)
				{
					returnList.add(values[this.position[0] + outerList.get(i)][this.position[1] + innerList.get(k)]);
				}

				if ((this.position[0] + innerList.get(k)) < x_max && (this.position[1] + outerList.get(i)) < y_max &&
						(this.position[0] + innerList.get(k)) >= 0 && (this.position[1] + outerList.get(i)) >= 0)
				{
					returnList.add(values[this.position[0] + innerList.get(k)][this.position[1] + outerList.get(i)]);
				}
//				returnList.add(new Point(this.getX() + outerList.get(i), this.getY() + innerList.get(k), this.getZ()));
//				returnList.add(new Point(this.getX() + innerList.get(k), this.getY() + outerList.get(i), this.getZ()));
			}
		}

		return returnList;

	}

	public void setNachbarn(Value[] n){
		this.nachbarn = n;
	}
	
	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public String toString() {
		return "Value [val=" + val + ", position=" + Arrays.toString(position) + ", used=" + used + "]";
	}	
}
