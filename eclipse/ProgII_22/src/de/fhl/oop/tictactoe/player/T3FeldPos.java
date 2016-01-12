package de.fhl.oop.tictactoe.player;

/**
 * Klasse um eine Feldposition innerhalb eines Tic Tac Toe
 * Spielfeldes in JAVA ausdruecken zu koennen,
 * da JAVA keine "Tupelwerte" kennt.
 * @author Nane Kratzke
 *
 */
public class T3FeldPos {

	/**
	 * X Angabe der Position auf einem T3 Spielfeld
	 */
	private int x;
	
	/**
	 * Y Angabe der Position auf einem T3 Spielfeld
	 */
	private int y;
	
	/**
	 * Konstruktur
	 */
	public T3FeldPos() {
		this.setXY(0, 0);
	}
	
	/**
	 * Konstruktur
	 * @param x X Angabe der Position
	 * @param y Y Angabe der Position
	 */
	public T3FeldPos(int x, int y) {
		this.setXY(x, y);
	}
	
	/**
	 * Liefert den X-Wert einer Position
	 * @return X-Wert der Position als int
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Liefert den Y-Wert einer Position
	 * @return Y-Wert der Position als int
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Setzt den X und Y-Wert einer Position
	 * @param x X-Angabe der Position
	 * @param y Y-Angabe der Position
	 */
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Erzeugt eine String Repraessentation der Position in Form
	 * (x, y).
	 * @return Zeichenkette die die Position als "(x, y)" darstellt
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	/**
	 * Generiert einen Hashcode zum inhaltlichen Vergleich.
	 * @return hashCode of the following String "(x, y)" x, y are the datafields of this object.
	 */
	public int hashCode() {
		return ("(" + this.x + ", " + this.y + ")").hashCode();
	}
	
	/**
	 * Dient dem inhaltlichen Vergleich zweier T3FeldPos Objekten
	 * @param p Das zu vergleichende Objekt
	 * @return true, wenn die X und Y Angaben Uebereinstimmen andernfalls false
	 */
	public boolean equals(Object p) {
		return p instanceof T3FeldPos ? this.hashCode() == p.hashCode() : false;
	}
	
}
