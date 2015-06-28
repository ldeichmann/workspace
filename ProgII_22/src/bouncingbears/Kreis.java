package bouncingbears;

import java.awt.Color;

public class Kreis extends Ellipse {

	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param r Radius
	 */
	Kreis(int x, int y, int z, int r, Color c) {
		super(x, y, z, r, r, c);
		this.figurenTyp = "Kreis";

	}

}
