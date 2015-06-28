package de.fhl.oop.tictactoe.engine;

/**
 * Definition eines Tic Tac Toe Soielers.
 * @author Nane Kratzke
 *
 */
public abstract class T3Spieler {
	
	/**
	 * Protokolliert die Anzahl begangener Regelverstoesse mit
	 */
	private int regelverstoesse = 0;
	
	/**
	 * Name des Spielers
	 */
	protected String name = "";
		
	/**
	 * Konstruktor - setzt den Namen des Spielers, damit dieser
	 * bei Auswertungen ausgegeben werden kann.
	 * @param name Name des Spielers
	 */
	public T3Spieler(String name) {
		this.name = name;
	}
	
	/**
	 * Meldet einen Regelverstoss. Veranlasst das Heraufzaehlen
	 * des Regelverstosszaehlers.
	 * Die Methode ist final deklariert, damit sie in Erweiterungen
	 * nicht bspw. dahingehend umformuliert wird, dass 
	 * die Protokollierung von Regelverstoessen ignoriert wird.
	 */
	public final void melde_regelverstoss() {
		this.regelverstoesse++;
	}
	
	/**
	 * Liefert die Anzahl begonnener Regelverstoesse, die
	 * im Verlaufe aller Partien der Spieler begannen hat.
	 * Die Methode ist final deklariert, damit sie in Spieler Implementierungen
	 * nicht bspw. dahingehend umformuliert wird, dass 
	 * Regelverstoesse reduziert oder auf null gesetzt werden.
	 */
	public final int anz_regelverstoesse() {
		return this.regelverstoesse;
	}
	
	/**
	 * Liefert den Namen des Strategieentwicklers. Der Name wird in 
	 * Protokollierungsfunktionen von TicTacToe benoetigt.
	 * @return String - mit dem Namen des/der Implementiers/in
	 */
	public final String get_name() {
		return this.name;
	}
		
	/**
	 * Hook-Methode
	 * Diese Methode wird immer dann von Tic Tac Toe "Engine" aufgerufen, wenn der
	 * Spieler am Zug ist.
	 * @param v Zeichen, dass fuer diesen Zug zu verwenden ist.
	 * @param s Spielobjekt, um den aktuellen Status des Spiels im anstehenden Zug beruecksichtigen zu koennen.
	 * @throws Exception - begeht der Spieler einen Regelverstoss, so wird dieser als Exception gemeldet.
	 */
	public abstract void am_zug(char v, T3Spiel s) throws Exception;
	
	/**
	 * Returns a String Representation of this Object
	 */
	public final String toString() {
		return this.get_name() + " mit der Strategie " + this.getClass().getCanonicalName();
	}
}
