package vectorutils;

public class Kreis extends Ellipse {

	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param r Radius
	 */
	Kreis(int x, int y, int z, int r) {
		super(x, y, z, r, r);
		this.figurenTyp = "Kreis";

	}

}
