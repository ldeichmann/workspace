package bouncingbears;

import java.awt.Color;
import java.awt.Graphics;

public class RWDreieck extends FigMZLA {

	/**
	 * @param x
	 *            X Position
	 * @param y
	 *            Y Position
	 * @param z
	 *            Z Position
	 * @param a
	 *            Seitenlaenge a
	 * @param b
	 *            Seitenlaenge b
	 */
	RWDreieck(int x, int y, int z, int a, int b, Color c) {

		super(x, y, z, a, b, c);
		this.figurenTyp = "Rechtwinkliges Dreieck";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vectorutils.FigMZLA#berechneFlaeche()
	 */
	double berechneFlaeche() {
		return (((double) this.A * (double) this.B) / 2);
	}

	/**
	 * Zeichnet ein RWDreieck in einer Component mittels eines Graphics Objekts
	 * 
	 * @param x
	 *            X-Position zu der relativ gezeichnet werden soll
	 * @param y
	 *            Y-Position zu der relativ gezeichnet werden soll
	 * @param g
	 *            Graphics object das zum Zeichnen genutzt werden soll
	 */
	public void zeichne(int x, int y, Graphics g) {
		int xpoints[] = { (x + this.getX()), (x + this.getX() - this.getA()),
				(x + this.getX()) };
		int ypoints[] = { (y - this.getY()), (y - this.getY()),
				(y - this.getY() - this.getB()) };
		int npoints = 3;

		g.setColor(this.FARBE);
		g.fillPolygon(xpoints, ypoints, npoints);

	}
}
