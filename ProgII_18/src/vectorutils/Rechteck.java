package vectorutils;

public class Rechteck extends FigMZLA {

	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param a Seitenlaenge a
	 * @param b Seitenlaenge b
	 */
	Rechteck(int x, int y, int z, int a, int b) {
		
		super(x, y, z, a, b);
		this.figurenTyp = "Rechteck";
		
	}

	/* (non-Javadoc)
	 * @see vectorutils.FigMZLA#berechneFlaeche()
	 */
	double berechneFlaeche() {
		
		return ((double)this.A * (double)this.B);

	}
	
}
