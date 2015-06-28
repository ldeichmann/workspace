package bouncingbears;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author lukas
 *
 */
public class Ellipse extends FigMZLA {

	/**
	 * @param x
	 *            X Position
	 * @param y
	 *            Y Position
	 * @param z
	 *            Z Position
	 * @param a
	 *            Groesse a
	 * @param b
	 *            Groesse b
	 */
	Ellipse(int x, int y, int z, int a, int b, Color c) {
		super(x, y, z, a, b, c);
		this.figurenTyp = "Ellipse";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vectorutils.FigMZLA#berechneFlaeche()
	 */
	double berechneFlaeche() {
		return (Math.PI * this.A * this.B);
	}

	/**
	 * Zeichnet eine Ellipse in einer Component mittels eines Graphics Objekts
	 * 
	 * @param x
	 *            X-Position zu der relativ gezeichnet werden soll
	 * @param y
	 *            Y-Position zu der relativ gezeichnet werden soll
	 * @param g
	 *            Graphics object das zum Zeichnen genutzt werden soll
	 */
	public void zeichne(int x, int y, Graphics g) {
		int x_draw = x + this.getX() - this.getA();
		int y_draw = y - this.getY() - this.getB();
		g.setColor(this.FARBE);
		g.fillOval(x_draw, y_draw, this.getA() * 2, this.getB() * 2);
	}

}
