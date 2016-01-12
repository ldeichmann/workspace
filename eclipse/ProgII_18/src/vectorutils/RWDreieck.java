package vectorutils;

public class RWDreieck extends FigMZLA {

	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param a Seitenlaenge a
	 * @param b Seitenlaenge b
	 */
	RWDreieck(int x, int y, int z, int a, int b) {
		
		super(x, y, z, a, b);
		this.figurenTyp = "Rechtwinkliges Dreieck";

	}

	/* (non-Javadoc)
	 * @see vectorutils.FigMZLA#berechneFlaeche()
	 */
	double berechneFlaeche() {
		return (((double)this.A * (double)this.B)/2);
	}
	
}
