package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import de.fhl.oop.tictactoe.engine.T3Konstanten;
import de.fhl.oop.tictactoe.player.CrazySpieler;
import de.fhl.oop.tictactoe.player.IhreStrategie;
import de.fhl.oop.tictactoe.player.NichtVerlierer;
import de.fhl.oop.tictactoe.player.ZufallsSpieler;

public class Controller implements ActionListener {

	/**
	 * View and Model
	 */
	private View view;
	private Model model;

	/**
	 * @param view
	 * @param model
	 */
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		this.startNewMatch();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent ev) {
		for (int i = 0; i < 9; i++) {
			if (ev.getSource() == view.buttons.get(i))
				if (i > 5) {
					setField(2, i - 6);
				} else if (i > 2) {
					setField(1, i - 3);
				} else {
					setField(0, i);
				}
		}
	}

	/**
	 * Set enemy class by showing a dialog to choose from things and stuff
	 */
	public void setEnemyClass() {
		String[] choices = { "Random", "Crazy", "IhreStrategie",
				"NichtVerlierer" };
		String input = (String) JOptionPane.showInputDialog(null,
				"Choose now...", "The Choice of a Lifetime",
				JOptionPane.OK_OPTION, null, // Use
												// default
												// icon
				choices, // Array of choices
				choices[1]); // Initial choice
		if (input.equals("IhreStrategie")) {
			model.setEnemyClass(new IhreStrategie("Enemy"));
		} else if (input.equals("Crazy")) {
			model.setEnemyClass(new CrazySpieler("Crazy Enemy"));
		} else if (input.equals("NichtVerlierer")) {
			model.setEnemyClass(new NichtVerlierer("Pappnase"));
		} else if (input.equals("Random")) {
			model.setEnemyClass(new ZufallsSpieler("Spinner"));
		} else {
			model.setEnemyClass(new ZufallsSpieler("Fallback"));
		}
	}

	/**
	 * Set Field using player character
	 * @param i row
	 * @param j column
	 */
	private void setField(int i, int j) {
		try {
			model.setField(i, j);
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.update();
		if (model.isMatchover()) {
			int newgame = JOptionPane.showConfirmDialog(null, "New Game?",
					"That's that", JOptionPane.YES_NO_OPTION);
			if (newgame == 0) {
				this.startNewMatch();
			}
		}
	}

	/**
	 * initialize a new match
	 */
	private void startNewMatch() {
		int player = JOptionPane.showConfirmDialog(null, "Play as X?",
				"Choose Side", JOptionPane.YES_NO_OPTION);
		this.setEnemyClass();
		if (player == 0) {
			model.startNewMatch(T3Konstanten.X);
		} else {
			model.startNewMatch(T3Konstanten.O);
		}
		view.update();
	}
}
