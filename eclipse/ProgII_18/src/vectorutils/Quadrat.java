package vectorutils;

public class Quadrat extends Rechteck {

	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param a Seitenlaenge
	 */
	Quadrat(int x, int y, int z, int a) {
		super(x, y, z, a, a);
		this.figurenTyp = "Quadrat";

	}

}
