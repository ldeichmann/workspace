package de.fhl.oop.tictactoe.player;

import java.util.*;

import de.fhl.oop.tictactoe.engine.T3Konstanten;
import de.fhl.oop.tictactoe.engine.T3Spiel;
import de.fhl.oop.tictactoe.engine.T3Spieler;

public class ZufallsSpieler extends T3Spieler {
	
	/**
	 * Konstruktor zum Setzen des Namens des Spielers
	 * @param name
	 */
	public ZufallsSpieler(String name) {
		super(name);
	}

	/**
	 * Die Strategie des ZufallSpielers sieht wie folgt aus:
	 * Er wuerfelt die x und y Ordinate, die er belegen will,
	 * prueft, ob diese frei ist, wenn ja belegt er diese,
	 * ansonsten wuerfelt er noch mal.
	 */
	public void am_zug(char v, T3Spiel s) throws Exception {
		char[][] feld = s.lese_feld();
		Random rand = new Random();
		int x; int y;
		do {
			x = rand.nextInt(T3Konstanten.BREITE);
			y = rand.nextInt(T3Konstanten.BREITE);			
		} while (feld[x][y] != T3Konstanten.LEER);
		s.setze_auf_feld(this, v, x, y);
	}
}
