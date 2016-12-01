package aufgabe2;

import java.util.Arrays;

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
