package bouncingbears;
import java.awt.Color;

public class Quadrat extends Rechteck {

	/**
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @param a Seitenlaenge
	 */
	Quadrat(int x, int y, int z, int a, Color c) {
		super(x, y, z, a, a, c);
		this.figurenTyp = "Quadrat";

	}

}
