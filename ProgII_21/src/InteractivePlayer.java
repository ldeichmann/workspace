import java.io.BufferedReader;
import java.io.InputStreamReader;

import de.fhl.oop.tictactoe.engine.T3Konstanten;
import de.fhl.oop.tictactoe.engine.T3Spiel;
import de.fhl.oop.tictactoe.player.T3VersierterSpieler;


public class InteractivePlayer extends T3VersierterSpieler {

	public InteractivePlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public int zugnummer(char[][] feld) {
		return T3Konstanten.BREITE * T3Konstanten.BREITE - this.leere_felder(feld).size() + 1;
	}

	@Override
	public void am_zug(char v, T3Spiel s) throws Exception {
		char[][] feld = s.lese_feld();
		int nr = zugnummer(feld);
		int x = 0, y = 0;
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Zug: " + nr);
        System.out.println(s);
        System.out.print("Row:");
        try{
            x = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        System.out.print("Column:");
        try{
            y = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        
        s.setze_auf_feld(this, v, x, y);
        

	}

}
