package de.fhl.oop.tictactoe.player;

import de.fhl.oop.tictactoe.engine.T3Konstanten;
import de.fhl.oop.tictactoe.engine.T3Spiel;
import de.fhl.oop.tictactoe.engine.T3Spieler;

public class CrazySpieler extends T3Spieler {
	
	/**
	 * Konstruktor zum Setzen des Namens des Spielers
	 * @param name
	 */
	public CrazySpieler(String name) {
		super(name);
	}

	/**
	 * Die Strategie des CrazySpielers sieht wie folgt aus:
	 * Er durchsucht das Spielfeld zeilenweise nach einem leeren Feld.
	 * Hat er dieses gefunden, setzt er sein X oder O.
	 */
	public void am_zug(char v, T3Spiel s) throws Exception {
		char[][] feld = s.lese_feld();
		for (int x = 0; x < T3Konstanten.BREITE; x++) {
			for (int y = 0; y < T3Konstanten.BREITE; y++) {
				if (feld[x][y] == T3Konstanten.LEER) {
					s.setze_auf_feld(this, v, x, y);
					return;
				}
			}
		}
	}
}
