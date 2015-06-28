package de.fhl.oop.tictactoe.engine;

/**
 * Diese Klasse buendelt ein paar wiederkehrend genutzte Hilfsroutinen.
 * @author Nane Kratzke
 *
 */
public class T3Routinen {
	
	/**
	 * Fuehrt ein komplettes Klonen eines 2D Arrays durch. Ein normales Klonen
	 * eines Arrays klont nur die erste Dimension eines Arrays aber nicht die
	 * dahinter liegenden Arrays der zweiten Dimension.
	 * Aufgrund der zwar streng logischen, jedoch wenig intuitive Semantik des clone Operators
	 * in JAVA ist diese deepclone Methode erforderlich. Andernfalls wuerden in
	 * der Gewinnfelder-Bestimmung die "Testzuege" zu echten "Zuegen" werden.
	 * @param feld - Das zu klonende 2D-Array
	 * @return ein komplett geklontes 2D-Array
	 */
	public static char[][] deepclone(char[][] feld) {
		char[][] clone = feld.clone();
		for (int i = 0; i < feld.length; i++) clone[i] = feld[i].clone();
		return clone;
	}

	/**
	 * Prueft auf dem Feld feld ob der Spieler mit v (X oder O) gewonnen hat
	 * @param v (X oder O) je nachdem fuer welchen Fall der Gewinn geprueft werden soll.
	 * @param feld das zu pruefende Feld
	 * @return true, wenn v eine Reihe, Spalte oder Diagnole nur mit eigenen Werten v (X oder O) belegt hat, 
	 *         false sonst
	 */
	public static boolean gewonnen(char v, char[][] feld) {
		boolean diag1 = true;
		boolean diag2 = true;
		
		for (int i = 0; i < T3Konstanten.BREITE; i++) {
			boolean spalte = true;
			boolean zeile = true;
			for (int j = 0; j < T3Konstanten.BREITE; j++) {
				spalte = spalte && feld[i][j] == v;
				zeile = zeile && feld[j][i] == v;
			}
			
			if (spalte || zeile) return true;
			
			diag1 = diag1 && feld[i][i] == v;
			diag2 = diag2 && feld[i][T3Konstanten.BREITE - 1 - i] == v;
		}

		return diag1 || diag2;
	}
	
}
