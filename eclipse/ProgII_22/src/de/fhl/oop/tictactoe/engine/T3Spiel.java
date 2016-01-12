package de.fhl.oop.tictactoe.engine;

/**
 * Definition eines Tic Tac Toe Spiels.
 * @author Nane Kratzke
 *
 */
public class T3Spiel {
	
	/* Das 3x3 Spielfeld von Tic Tac Toe
	 * Die Felder koennen X oder O annehmen oder leer sein
	 */
	protected char[][] feld = { { T3Konstanten.LEER, T3Konstanten.LEER, T3Konstanten.LEER },
			                    { T3Konstanten.LEER, T3Konstanten.LEER, T3Konstanten.LEER },
			                    { T3Konstanten.LEER, T3Konstanten.LEER, T3Konstanten.LEER }
	                          };
	
	/* Zustandsattribut des Spielfelds, welches mitzaehlt
	 * wieviel Spielfelder noch leer sind.
	 */
	protected int anz_leere_felder = T3Konstanten.BREITE * T3Konstanten.BREITE;
	
	/* Zustandsattribut des Spielfels, welcher Spieler
	 * (X oder O) gerade am Zug ist. 
	 */
	protected boolean X_am_zug = true;
	protected boolean O_am_zug = !X_am_zug;
	
	/* Die beiden Spieler die dieses Tic Tac Toe Spiel
	 * in der Rolle X und Rolle O spielen.
	 */
	protected T3Spieler spielerX;
	protected T3Spieler spielerO;
	
	/**
	 * Konstruktur zum initialisieren eines Spiels
	 * @param sp1 Spieler der die Rolle X einnimmt
	 * @param sp2 Spieler der die Rolle O einnimmt
	 */
	public T3Spiel(T3Spieler sp1, T3Spieler sp2) {
		this.spielerX = sp1;
		this.spielerO = sp2;
	}
	
	/* Liefert eine Kopie des Zustands des Spielfelds
	 */
	public char[][] lese_feld() {
		return T3Routinen.deepclone(feld);
	}
	
	/**
	 * Wird von einem Spieler aus seiner am_zug Methode aufgerufen, um nach seiner
	 * Strategie ein Feld zu belegen.
	 * @param s Spieler der am Zug ist
	 * @param v X oder O, je nachdem welcher Rolle der Spieler hat
	 * @param x die x-Position zwischen 0 und BREITE - 1 die gesetzt werden soll
	 * @param y die y-Position zwischen 0 und BREITE - 1 die gesetzt werden soll
	 * @throws IllegalerZug wenn ein Illegaler Zug von einem Spieler gemacht wurde
	 */
	public void setze_auf_feld(T3Spieler s, char v, int x, int y) throws Exception {
		// Pruefe die Zulaessigkeit eines Zugs
		if ((v == T3Konstanten.X) && !X_am_zug) throw new Exception(v + " spielt und ist nicht am Zug.");
		if ((v == T3Konstanten.O) && !O_am_zug) throw new Exception( v + " spielt uns ist nicht am Zug.");
		if ((v != T3Konstanten.O) && (v != T3Konstanten.X)) throw new Exception(v + " will einen Wert ungleich X oder O in das Feld eintragen.");
		if (x < 0 || x >= T3Konstanten.BREITE) throw new Exception(v + " spielt ausserhalb des Feldes (" + x + "," + y +").");
		if (y < 0 || y >= T3Konstanten.BREITE) throw new Exception(v + "spielt ausserhalb des Feldes (" + x + "," + y +").");
		if (feld[x][y] != T3Konstanten.LEER) throw new Exception(v + " will nicht leeres Feld (" + x + "," + y + ") aendern.");

		// Belege das Feld
		this.feld[x][y] = v;
		
		// Aktualisiere den Zustand des Spiels
		this.anz_leere_felder--;
		this.X_am_zug = !this.X_am_zug;
		this.O_am_zug = !this.O_am_zug;
	}
	
	/**
	 * Prueft ob Spieler X oder O gewonnen hat.
	 * @param v X oder O, je nachdem ob geprueft werden soll ob X oder O gewonnen hat.
	 * @return true wenn v=X und X gewonnen hat, true wenn v=O und O gewonnen hat, andernfalls false
	 */
	public boolean gewonnen(char v) {
		return T3Routinen.gewonnen(v, this.feld);
	}
	
	/**
	 * Prueft ob das Spiel unentschieden ist
	 * @return true wenn unentschieden, andernfalls false
	 */
	public boolean unentschieden() {
		return this.anz_leere_felder == 0 && !gewonnen(T3Konstanten.X) && !gewonnen(T3Konstanten.O);
	}
	
	/**
	 * Methode zur Ausgabe von Fehlermeldungen waehrend des Spiels.
	 * Sollte sich ein Spieler nicht an die Regeln gehalten haben, 
	 * wird der Regelverstoss inklusive des aktuellen Spielstands
	 * an dem der Regelverstoss begangen wurde, protokolliert.
	 * @param ex
	 * @return String mit der Fehlermeldung
	 */
	protected String schiedsrichter_information(char durch, Exception ex) {
		String message = "Folgende Regelverletzung ist durch " + durch + " begannen worden: " + ex.getMessage() + "\n";
		message += "X: " + this.spielerX + "\n";
		message += "O: " + this.spielerO + "\n";
		message += this.toString();
		return message;
	}
	
	
	/**
	 * compute next move
	 * @return return winner or empty
	 */
	public char next() {
		if (gewonnen(T3Konstanten.X)) return T3Konstanten.X;
		if (gewonnen(T3Konstanten.O)) return T3Konstanten.O;
		if (this.anz_leere_felder > 0) {
			
			if (spielerX.name != "Player 1") {
				try { 
					int nochfrei = this.anz_leere_felder;
					spielerX.am_zug(T3Konstanten.X, this);
					if (gewonnen(T3Konstanten.X)) return T3Konstanten.X;
					if (nochfrei - 1 != this.anz_leere_felder) throw new Exception("X hat zuviele oder zuwenige Zuege gemacht");
				}
				catch (Exception ex) { 
					// X hat sich nicht an die Regeln gehalten => O gewinnt
					spielerX.melde_regelverstoss();
					System.out.println(schiedsrichter_information(T3Konstanten.X, ex));
					return T3Konstanten.O; 
				}			
			} else {
				// Spieler O am Zug
				try {
					int nochfrei = this.anz_leere_felder;
					spielerO.am_zug(T3Konstanten.O, this);
					if (gewonnen(T3Konstanten.O)) return T3Konstanten.O;
					if (nochfrei - 1 != this.anz_leere_felder) throw new Exception("O hat zuviele oder zuwenige Zuege gemacht.");
				} catch (Exception ex) {
					// O hat sich nicht an die Regeln gehalten => X gewinnt
					spielerO.melde_regelverstoss();
					System.out.println(schiedsrichter_information(T3Konstanten.O, ex));
					return T3Konstanten.X;
				}				
			}
		}
		return ' ';
	}
	
	/**
	 * Leite eine Partie zwischen X und O
	 * @return X wenn X die Partie gewonnen hat, O wenn O die Partie gewonnen hat, LEER wenn unentschieden
	 */
	public char leite_partie() {
		// Solange spielen bis unentschieden oder einer gewonnen hat.
		while (this.anz_leere_felder > 0) {
			// Spieler X am Zug
			try { 
				int nochfrei = this.anz_leere_felder;
				spielerX.am_zug(T3Konstanten.X, this);
				if (gewonnen(T3Konstanten.X)) return T3Konstanten.X;
				if (nochfrei - 1 != this.anz_leere_felder) throw new Exception("X hat zuviele oder zuwenige Zuege gemacht");
			}
			catch (Exception ex) { 
				// X hat sich nicht an die Regeln gehalten => O gewinnt
				spielerX.melde_regelverstoss();
				System.out.println(schiedsrichter_information(T3Konstanten.X, ex));
				return T3Konstanten.O; 
			}
			
			if (unentschieden()) return T3Konstanten.LEER;
			
			// Spieler O am Zug
			try {
				int nochfrei = this.anz_leere_felder;
				spielerO.am_zug(T3Konstanten.O, this);
				if (gewonnen(T3Konstanten.O)) return T3Konstanten.O;
				if (nochfrei - 1 != this.anz_leere_felder) throw new Exception("O hat zuviele oder zuwenige Zuege gemacht.");
			} catch (Exception ex) {
				// O hat sich nicht an die Regeln gehalten => X gewinnt
				spielerO.melde_regelverstoss();
				System.out.println(schiedsrichter_information(T3Konstanten.O, ex));
				return T3Konstanten.X;
			}
		}
		return T3Konstanten.LEER;
  	}
	
	/**
	 * Liefert eine String Repraesentation des Spielfelds in einer Form
	 * wie folgendes Bsp. zeigt
	 * 
	 *   | |X
	 *  -+-+-
	 *  O|X| 
	 *  -+-+-
	 *  X|O| 
	 */
	public String toString() {
		String ret = "";
		for (char[] zeilen : feld) {
			String zeile = "";
			for (char spalte : zeilen) {
				zeile += spalte + T3Konstanten.HSEP;
			}
			ret += zeile.substring(0, zeile.length() - 1) + "\n";
			ret += T3Konstanten.VSEP + "\n";
		}
		return ret.substring(0, ret.length() - T3Konstanten.VSEP.length() - 1);
	}
}
