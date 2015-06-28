package de.fhl.oop.tictactoe.player;

import de.fhl.oop.tictactoe.engine.*;

/**
 * Der Katastrophenspieler ist ein Worst Case Testspieler,
 * um zu pruefen, ob die T3Engine auch Programmierfehler
 * verkraftet.
 * Der Katastrophenspieler teilt durch null. Dies darf ein
 * Turnier nicht zum Absturz bringen (Beispiel fuer robuste
 * Programmierung).
 * Solche katastrophalen Faelle faengt die Engine ab und
 * wertet dies als Sieg fuer den Gegner.
 * @author Nane Kratzke
 *
 */
public class Katastrophenspieler extends T3Spieler {

	/**
	 * Konstruktor zum Setzen des Namens des Spielers
	 * @param name
	 */
	public Katastrophenspieler(String name) {
		super(name);
	}

	/**
	 * Hook
	 * Wird aufgerufen, wenn der Spieler am Zug ist.
	 * Hier wird durch null geteilt, um einen besonders
	 * schlimmen Fehler zu provozieren.
	 * Das System muss dennoch weiterlaufen! Robuste Programmierung!
	 */
	public void am_zug(char v, T3Spiel s) throws Exception {
		int i = 5;
		int j = 0;
		i /= j;
	}

}
