package bouncingbears;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Figur {

	protected int X;
	protected int Y;
	protected int Z;
	protected Color FARBE;
	
	private static List<Figur> figuren = new LinkedList<Figur>();
	
	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 */
	Figur(int x, int y, int z, Color farbe) {
		
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.FARBE = farbe;
		figuren.add(this);
		
	}
	
	/**
	 * @return Anzahl an Figuren
	 */
	static final int anzFiguren() {
		
		return figuren.size();
		
	}
	
	/**
	 * @return Alle Figuren
	 */
	static final List<Figur> getAlleFiguren() {
		
		return figuren;
		
	}
	
	/**
	 * @return Alle Figuren nach Z Achse aufsteigend sortiert
	 */
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

	/**
	 * Filtert Figuren nach Z Achse 
	 * @param i minimum
	 * @param j maximum
	 * @param zsortierteFiguren zu sortierende Figuren
	 * @return
	 */
	public static List<Figur> filterZ(int i, int j, Figur[] zsortierteFiguren) {
		List<Figur> filteredFiguren = new LinkedList<Figur>();
		for (Figur f : zsortierteFiguren) {
			
			if (f.Z >= i && f.Z <= j) {
				filteredFiguren.add(f);
			}
			
		}
		
		return filteredFiguren;
	}
	
	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}
	public int getZ() {
		return X;
	}
	
	public void zeichne(int x, int y, Graphics g) {
		System.out.println("a");

	}
	
}
