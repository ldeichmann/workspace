import de.fhl.oop.tictactoe.engine.T3Starter;
import de.fhl.oop.tictactoe.examples.halloffame.WinnerWinnerChickenDinner;
import de.fhl.oop.tictactoe.player.*;

public class Testspiel {
	public static void main(String[] args) {
		T3Starter.starte_partie(1000, new IhreStrategie("Lukas"), new WinnerWinnerChickenDinner(
				"Winner"));
		T3Starter.starte_partie(1000, new IhreStrategie("Lukas"), new ZufallsSpieler(
				"Zufall"));
		T3Starter.starte_partie(1000, new IhreStrategie("Lukas"), new CrazySpieler("Crazy"));
		T3Starter.starte_partie(1000, new IhreStrategie("Lukas"), new NichtVerlierer("Prof. Kratzke"));
		T3Starter.starte_partie(1000, new CrazySpieler("Crazy"), new ZufallsSpieler(
				"Zufall"));
	}

}
