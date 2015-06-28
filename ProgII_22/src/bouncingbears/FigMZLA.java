package bouncingbears;

import java.awt.Color;

/**
 * @author lukas
 *
 */
public abstract class FigMZLA extends Figur {

	protected int A;
	protected int B;
	protected String figurenTyp;
	
	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param a Groesse a
	 * @param b Groesse b
	 */
	FigMZLA(int x, int y, int z, int a, int b, Color c) {
		
		super(x, y, z, c);
		this.A = a;
		this.B = b;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return figurenTyp + " an Position (" + this.X + ", " + this.Y + ", "
				+ this.Z + ") mit einer Fläche von " + this.berechneFlaeche()
				+ " Flächeneinheiten";
		
	}
	
	/**
	 * @return Flaeche der Figur
	 */
	abstract double berechneFlaeche();
	
	/**
	 * @return height
	 */
	public int getA() {
		return A;
	}

	/**
	 * @return width
	 */
	public int getB() {
		return B;
	}
	
}
