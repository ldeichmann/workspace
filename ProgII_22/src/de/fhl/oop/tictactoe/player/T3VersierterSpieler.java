package de.fhl.oop.tictactoe.player;

import de.fhl.oop.tictactoe.engine.*;

import java.util.*;

/**
 * Der versierte T3Spieler hat zusaetzliche Faehigkeiten in Form von
 * Methoden, die ihn dazu befaehigen intelligenter zu spielen.
 * Der versierte Spieler kann alle leeren Felder bestimmen und rausfinden
 * ob ein naechster Zug fuer X oder O einen Gewinn bringt.
 * @author Nane Kratzke
 *
 */
public abstract class T3VersierterSpieler extends T3Spieler {
	
	public T3VersierterSpieler(String name) {
		super(name);
	}

	/**
	 * Liefert eine Liste aller leeren Felder. Die Felder sind als T3FeldPos
	 * strukturiert.
	 * @param feld - das zu analysierende Spielfeld
	 * @return Vector mit T3FeldPos Objekten - jedes dieser Objekte bezeichnet ein leeres Feld in feld, 
	 *         die leeren Felder sind nach Spalten und Zeilen geordnet.
	 */
	protected List<T3FeldPos> leere_felder(char[][] feld) {
		List<T3FeldPos> list = new LinkedList<T3FeldPos>();
		for (int x = 0; x < T3Konstanten.BREITE; x++) {
			for (int y = 0; y < T3Konstanten.BREITE; y++) {
				if (feld[x][y] == T3Konstanten.LEER) list.add(new T3FeldPos(x,y));
			}
		}
		return list;
	}
			
	/**
	 * Prueft welche Felder fuer v (X oder O) Gewinnfelder waeren.
	 * @param v (X oder O) je nachdem fuer welchen Spieler die Gewinnfelder bestimmt werden sollen.
	 * @param feld das zu pruefende Feld
	 * @return Liste von Feldern die fuer v (X oder O) im naechsten Zug den Gewinn bringen wuerden. 
	 *         Liste ist leer, wenn es solche Felder nicht gibt.
	 */
	protected List<T3FeldPos> gewinnfelder(char v, char[][] feld) {
		List<T3FeldPos> gewinnfelder = new LinkedList<T3FeldPos>();
		for (T3FeldPos pos : this.leere_felder(feld)) {
			char[][] testfeld = T3Routinen.deepclone(feld);
			testfeld[pos.getX()][pos.getY()] = v;
			if (T3Routinen.gewonnen(v, testfeld)) gewinnfelder.add(pos);
		}
		return gewinnfelder;
	}
	
}
