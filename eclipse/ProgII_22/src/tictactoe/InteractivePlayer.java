package tictactoe;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import de.fhl.oop.tictactoe.engine.T3Konstanten;
import de.fhl.oop.tictactoe.engine.T3Spiel;
import de.fhl.oop.tictactoe.engine.T3Spieler;
import de.fhl.oop.tictactoe.player.T3VersierterSpieler;


public class InteractivePlayer extends T3Spieler {

	public InteractivePlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
//	public int zugnummer(char[][] feld) {
//		return T3Konstanten.BREITE * T3Konstanten.BREITE - this.leere_felder(feld).size() + 1;
//	}

	@Override
	public void am_zug(char v, T3Spiel s) throws Exception {


	}

}
