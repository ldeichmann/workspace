package de.fhl.oop.tictactoe.engine;

/**
 * Klasse, die TicTacToe Partien startet.
 * @author Nane Kratzke
 *
 */
public class T3Starter {

	/**
	 * Starte eine Partie zwischen zwei Spielern
	 * @param n Anzahl an zu spielenden Partien
	 * @param s1 Spieler 1
	 * @param s2 Spieler 2
     * return int >  0 s1 hat gewonnen,
	 *            <  0 s2 hat gewonnen
	 *            == 0 unentschieden
	 */
	public static int starte_partie(int n, T3Spieler s1, T3Spieler s2) {
		return starte_partie(n, s1, s2, false);
	}
	
	/**
	 * Starte eine Partie zwischen zwei Spielern
	 * @param n    Anzahl der zu spielenden Partien (1 Partie beinhaltet X gegen O und O gegen X)
	 * @param s1   Spieler 1
	 * @param s2   Spieler 2
	 * @param verbose wenn true wird jedes Ergebnis jeder Partie ausgegeben, wenn false wird nur die Zusammenfassung ausgegeben.
	 * return int >  0 s1 hat gewonnen,
	 *            <  0 s2 hat gewonnen
	 *            == 0 unentschieden
	 */
	public static int starte_partie(int n, T3Spieler s1, T3Spieler s2, boolean verbose) {
		// Zaehlvariablen zum mitzaehlen, wer wie oft gewonnen hat
		int gewonnen_s1 = 0;
		int gewonnen_s2 = 0;
		
		// n Partien spielen
		for (int i = 0; i < n; i++) {
			T3Spiel spiel = new T3Spiel(s1, s2);
			char erg = spiel.leite_partie();
			if (erg == T3Konstanten.X) gewonnen_s1++;
			if (erg == T3Konstanten.O) gewonnen_s2++;
			if (verbose == true) {
			  System.out.println(s1.get_name() + " (X) gegen " + s2.get_name() + " (O) endete:");
			  System.out.println(spiel);
			}
			
			spiel = new T3Spiel(s2, s1);
			erg = spiel.leite_partie();
			if (erg == T3Konstanten.X) gewonnen_s2++;
			if (erg == T3Konstanten.O) gewonnen_s1++;
			if (verbose == true) {
				System.out.println(s2.get_name() + " (X) gegen " + s1.get_name() + " (O) endete:");
				System.out.println(spiel);
			}
			
		}
		
		// Abschlussstatistik ausgeben
		System.out.println(s1.get_name() + " gewinnt " + gewonnen_s1 + " von " + 2 * n + " Spielen bei " + s1.anz_regelverstoesse() + " Regelverstoessen.");
		System.out.println(s2.get_name() + " gewinnt " + gewonnen_s2 + " von " + 2 * n + " Spielen bei " + s2.anz_regelverstoesse() + " Regelverstoessen.");
		System.out.println("Anzahl unentschiedener Partien: " + (2 * n - gewonnen_s1 - gewonnen_s2));
		
		return gewonnen_s1 - gewonnen_s2;
	}
	
}
