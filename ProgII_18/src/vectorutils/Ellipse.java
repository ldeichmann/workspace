package vectorutils;

/**
 * @author lukas
 *
 */
public class Ellipse extends FigMZLA {

	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param a Groesse a
	 * @param b Groesse b
	 */
	Ellipse(int x, int y, int z, int a, int b) {
		super(x, y, z, a, b);
		this.figurenTyp = "Ellipse";

	}

	/* (non-Javadoc)
	 * @see vectorutils.FigMZLA#berechneFlaeche()
	 */
	double berechneFlaeche() {
		return (Math.PI * this.A * this.B);
	}

	
	
}
