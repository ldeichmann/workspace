package tictactoe;

import de.fhl.oop.tictactoe.engine.T3Konstanten;
import de.fhl.oop.tictactoe.engine.T3Spiel;
import de.fhl.oop.tictactoe.engine.T3Spieler;

public class Model {

	private char player = T3Konstanten.LEER;
	private T3Spieler playerClass;
	private T3Spiel match;
	private char winner = T3Konstanten.LEER;
	private T3Spieler enemyClass;

	/**
	 * Set Player Character
	 * @param c T3Konstanten.X or T3Konstanten.O
	 */
	public void setPlayer(char c) {
		this.player = c;
	}

	/**
	 * Start a new match
	 * @param player character to use
	 */
	public void startNewMatch(char player) {
		this.setPlayer(player);
		this.winner = T3Konstanten.LEER;
		this.playerClass = new InteractivePlayer("Player 1");
		
		if (this.player == T3Konstanten.X) {
			match = new T3Spiel(this.playerClass, this.enemyClass);
		} else {
			match = new T3Spiel(this.enemyClass, this.playerClass);
			this.match.next();
		}
		
	}
	
	/**
	 * Set field using player character
	 * @param i row
	 * @param j column
	 * @throws Exception well shit, it done blocked man
	 */
	public void setField(int i, int j) throws Exception {
		if (this.winner == T3Konstanten.LEER) {
			this.match.setze_auf_feld(this.playerClass, this.player, i, j);
			char win = this.match.next();
			if (win != T3Konstanten.LEER) {
				this.winner = win;
			}
		}
	}
	
	/**
	 * @return current Field
	 */
	public char[][] getField() {
		return this.match.lese_feld();
	}
	
	/**
	 * @return Status Text
	 */
	public String getText() {
		try {
			if (this.winner != T3Konstanten.LEER) {
				return "Winner: " + this.winner + " against " + this.enemyClass.get_name();
			} else if (this.match.unentschieden()) {
				return "Draw against " + this.enemyClass.get_name();
			} else {
				return "Playing against " + this.enemyClass.get_name();
			}
		} catch (Exception e) {
//			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Set enemy class
	 * @param e enemy class
	 */
	public void setEnemyClass(T3Spieler e) {
		this.enemyClass = e;
	}
	
	/**
	 * @return is match over
	 */
	public boolean isMatchover() {
		return (this.match.unentschieden() || !(this.winner == T3Konstanten.LEER));
	}
	
		
}
