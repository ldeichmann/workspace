package de.fhl.oop.tictactoe.player;

import java.util.List;
import java.util.Vector;

import de.fhl.oop.tictactoe.engine.*;

public class NichtVerlierer extends T3VersierterSpieler {

	public NichtVerlierer(String name) {
		super(name);
	}

	/**
	 * Bestimmt der wievielte Zug gerade gespielt wird.
	 * @param feld
	 * @return Zugnummer (der sich aus dem Spielfeld ergibt = Anzahl an Feldern - leere Felder + 1)
	 */
	public int zugnummer(char[][] feld) {
		return T3Konstanten.BREITE * T3Konstanten.BREITE - this.leere_felder(feld).size() + 1;
	}
		
	/**
	 * Hook
	 * Wird von der T3Engine aufgerufen, wenn dieser Spieler am Zug ist.
	 * Seine Strategie ist es, nicht zu verlieren.
	 * Unentschieden ist ihm wichtiger als Sieg.
	 */
	public void am_zug(char v, T3Spiel s) throws Exception {
		char[][] feld = s.lese_feld();
		
		// Wenn Du gewinnen kannst, TU ES!
		List<T3FeldPos> gewinnfelder = this.gewinnfelder(v, feld);
		if (!gewinnfelder.isEmpty()) {
			T3FeldPos pos = gewinnfelder.get(0);
			s.setze_auf_feld(this, v, pos.getX(), pos.getY());
			return;
		}
		
		// Wenn der Gegner gewinnen kann, blocke ihn
		char gegner = v == T3Konstanten.X ? T3Konstanten.O : T3Konstanten.X;
		gewinnfelder = this.gewinnfelder(gegner, feld);
		if (!gewinnfelder.isEmpty()) {
			T3FeldPos pos = (T3FeldPos)gewinnfelder.get(0);
			s.setze_auf_feld(this, v, pos.getX(), pos.getY());
			return;
		}
		
		// Spezialzuege fuer X und O
		if (v == T3Konstanten.X) {
			// Spezialzuege X
			
			// Wenn es der erste Zug ist, setze das Mittelfeld
			if (this.zugnummer(feld) == 1) {
				s.setze_auf_feld(this, v, 1, 1);
				return;
			}
		}
		else {
			// Spezialzuege O
			
			// Wenn es der zweite Zug ist und das Mittelfeld ist frei, setze das Mittelfeld
			if (this.zugnummer(feld) == 2 && feld[1][1] == T3Konstanten.LEER) {
				s.setze_auf_feld(this, v, 1, 1);
				return;
			}
			
			// Wenn es der zweite Zug ist und das Mittelfeld ist nicht leer, setze auf 0,1
			if (this.zugnummer(feld) == 2) {
				s.setze_auf_feld(this, v, 0, 1);
				return;
			}			
		}
		
		// Ansonsten setze auf Felder, die maximal viele Chancen bieten
		int max = 0;
		T3FeldPos bestpos = new T3FeldPos();
		for (T3FeldPos pos : this.leere_felder(feld)) {
			char[][] lookahead = T3Routinen.deepclone(feld);
			lookahead[pos.getX()][pos.getY()] = v;
			int chancen = this.gewinnfelder(v, lookahead).size();
			max = chancen >= max ? chancen : max;
			if (max == chancen) bestpos = pos;
		}
		if (max > 0) {
			s.setze_auf_feld(this, v, bestpos.getX(), bestpos.getY());
			return;
		}
		
		// Ansonsten setze auf das erste freie Feld
		bestpos = (T3FeldPos)this.leere_felder(feld).get(0);
		s.setze_auf_feld(this, v, bestpos.getX(), bestpos.getY());
	}
}
