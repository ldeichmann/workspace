import java.util.List;

import de.fhl.oop.tictactoe.engine.T3Konstanten;
import de.fhl.oop.tictactoe.engine.T3Routinen;
import de.fhl.oop.tictactoe.engine.T3Spiel;
import de.fhl.oop.tictactoe.player.T3FeldPos;
import de.fhl.oop.tictactoe.player.T3VersierterSpieler;


public class IhreStrategie extends T3VersierterSpieler {

	public IhreStrategie(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Bestimmt der wievielte Zug gerade gespielt wird.
	 * @param feld
	 * @return Zugnummer (der sich aus dem Spielfeld ergibt = Anzahl an Feldern - leere Felder + 1)
	 */
	public int zugnummer(char[][] feld) {
		return T3Konstanten.BREITE * T3Konstanten.BREITE - this.leere_felder(feld).size() + 1;
	}
	
	/* (non-Javadoc)
	 * @see de.fhl.oop.tictactoe.engine.T3Spieler#am_zug(char, de.fhl.oop.tictactoe.engine.T3Spiel)
	 */
	public void am_zug(char v, T3Spiel s) throws Exception {
		char[][] feld = s.lese_feld();
		int nr = zugnummer(feld);

//		System.out.println(v);
//		System.out.println(s);
		
		List<T3FeldPos> gewinnfeld = this.gewinnfelder(v, feld);
		if (!gewinnfeld.isEmpty()) {
			s.setze_auf_feld(this, v, gewinnfeld.get(0).getX(), gewinnfeld.get(0).getY());
			return;
		}
		
		char gegner = v == T3Konstanten.X ? T3Konstanten.O : T3Konstanten.X;
		List<T3FeldPos> blockfeld = this.gewinnfelder(gegner, feld);
		if (!blockfeld.isEmpty()) {
			s.setze_auf_feld(this, v, blockfeld.get(0).getX(), blockfeld.get(0).getY());
			return;
		}
		
		
		if (v == T3Konstanten.X) {
			if (nr == 1) {
				s.setze_auf_feld(this, v, 0, 2);
				return;
			}
			
			if (nr == 3) {
				
				if (feld[1][1] == T3Konstanten.O) {
					s.setze_auf_feld(this, v, 2, 0);
					return;
				}
				
			}
			
			
			if (nr == 5) {
				if (feld[1][1] == T3Konstanten.LEER) {
					s.setze_auf_feld(this, v, 1, 1);
					return;
				} else if (feld[0][0] == T3Konstanten.LEER) {
					s.setze_auf_feld(this, v, 0, 0);
					return;
				} else if (feld[2][0] == T3Konstanten.LEER) {
					s.setze_auf_feld(this, v, 2, 0);
					return;
				} else if (feld[0][2] == T3Konstanten.LEER) {
					s.setze_auf_feld(this, v, 0, 2);
					return;
				} else if (feld[2][2] == T3Konstanten.LEER) {
					s.setze_auf_feld(this, v, 2, 2);
					return;
				}
			}
		} else {
			if (nr == 2) {
				if (feld[1][1] == T3Konstanten.LEER) {
					s.setze_auf_feld(this, v, 1, 1);
				} else {
					s.setze_auf_feld(this, v, 0, 0);
				}
				return;
			}
			
			if (nr == 4) {
	//			  |X| 
	//			 -+-+-
	//			 X|O| 
	//			 -+-+-
	//			  | | 
				if ((feld[1][1] == T3Konstanten.O)
						&& (feld[0][1] == T3Konstanten.X)
						&& (feld[1][0] == T3Konstanten.X)) {
					s.setze_auf_feld(this, v, 0, 0);
					return;
				}

				
	//			  | |X
	//			 -+-+-
	//			  |O| 
	//			 -+-+-
	//			  |X| 
				else if ((feld[1][1] == T3Konstanten.O)
						&& (feld[0][2] == T3Konstanten.X)
						&& (feld[2][1] == T3Konstanten.X)) {
					s.setze_auf_feld(this, v, 2, 2);
					return;
				}
			
	//			 X| | 
	//			 -+-+-
	//			  |O|  
	//			 -+-+-
	//			  |X|
				else if ((feld[1][1] == T3Konstanten.O)
						&& (feld[0][0] == T3Konstanten.X)
						&& (feld[2][1] == T3Konstanten.X)) {
					s.setze_auf_feld(this, v, 2, 0);
					return;
				}
		
	//			  | |   |X| 
	//			 -+-+- -+-+-
	//			 X|O|X  |O| 
	//			 -+-+- -+-+-
	//			  | |   |X|		
				else if (feld[1][1] == T3Konstanten.O
						&& (((feld[1][0] == T3Konstanten.X) && (feld[1][2] == T3Konstanten.X)) || ((s
								.lese_feld()[2][0] == T3Konstanten.X) && (s
								.lese_feld()[2][1] == T3Konstanten.X)))) {
					s.setze_auf_feld(this, v, 0, 2);
					return;
				}
	//			 x| |X
	//			 -+-+-
	//			  |O|  or
	//			 -+-+-
	//			 X| |x
				else if ((feld[1][1] == T3Konstanten.O)
						&& (feld[0][0] == T3Konstanten.X
								|| feld[0][2] == T3Konstanten.X
								|| feld[2][0] == T3Konstanten.X || feld[2][2] == T3Konstanten.X)) {
					if (feld[0][1] == T3Konstanten.LEER) {
						s.setze_auf_feld(this, v, 0, 1);
						return;
					} else if (feld[1][0] == T3Konstanten.LEER) {
						s.setze_auf_feld(this, v, 1, 0);
						return;
					} else if (feld[1][2] == T3Konstanten.LEER) {
						s.setze_auf_feld(this, v, 1, 2);
						return;
					} else if (feld[2][1] == T3Konstanten.LEER) {
						s.setze_auf_feld(this, v, 2, 1);
						return;
					}
				}				

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
