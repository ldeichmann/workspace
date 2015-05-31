package vectorutils;

import java.util.LinkedList;
import java.util.List;

public class Figur {

	protected int X;
	protected int Y;
	protected int Z;
	private static List<Figur> figuren = new LinkedList<Figur>();
	
	Figur(int x, int y, int z) {
		
		this.X = x;
		this.Y = y;
		this.Z = z;
		figuren.add(this);
		
	}
	
	static final int anzFiguren() {
		
		return figuren.size();
		
	}
	
	static final List<Figur> getAlleFiguren() {
		
		return figuren;
		
	}
	
	static final Figur[] getZsortierteFiguren() {
		
		Figur[] xs = figuren.toArray(new Figur[figuren.size()]);
		
		boolean unsorted = true;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < xs.length - 1; i++) {
				if (!(xs[i].Z <= xs[i + 1].Z)) {
					Figur dummy = xs[i];
					xs[i] = xs[i + 1];
					xs[i + 1] = dummy;
					unsorted = true;
				}
			}
		}

		return xs;
		
	}

	public static List<Figur> filterZ(int i, int j, Figur[] zsortierteFiguren) {
		List<Figur> filteredFiguren = new LinkedList<Figur>();
		for (Figur f : zsortierteFiguren) {
			
//			System.out.println(f.Z + " " + i);
			if (f.Z >= i && f.Z <= j) {
				filteredFiguren.add(f);
			}
			
		}
		
		return filteredFiguren;
	}
	
}
