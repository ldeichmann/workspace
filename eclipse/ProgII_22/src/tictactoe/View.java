package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import de.fhl.oop.tictactoe.engine.T3Konstanten;

public class View extends JFrame {
	// Datenfeld des Taschenrechner-Views zur Darstellung des Displays
	private JTextField display = new JTextField();
	{
		this.display.setEditable(false);
		this.display.setSize(200, 60);
	}

	/*
	 * Datenfeld in Form einer Liste, in der alle Tasten des Taschenrechners
	 * abgelegt werden Die Tasten werden ueber den entsprechenden Index
	 * angesprochen.
	 */
	public List<JButton> buttons = new LinkedList<JButton>();
	{
		for (int i = 0; i < 9; i++) {
			buttons.add(new JButton());
		}

	}
	/*
	 * Datenfelder des Views die auf das Modelobjekt und Controllerobjekt des TR
	 * verweisen
	 */
	protected Model model = new Model();
	protected Controller controller = new Controller(this, model);

	/*
	 * Konstruktor zum Anlegen eines Viewobjekts eines Taschenrechners. Der
	 * Konstruktor platziert alle Bedienelemente und "verlinkt" diese mit einem
	 * Controller
	 */
	public View() {
		super("Tic Toc Hoe");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Panel tastenpanel = new Panel();
		GridLayout gbLayout = new GridLayout(3, 3);
		gbLayout.setHgap(5);
		gbLayout.setVgap(5);
		tastenpanel.setLayout(gbLayout);
		// Zeile 1 des Bedienpanels des TR wird angelegt
		for (int i = 0; i < 9; i++) {
			tastenpanel.add(this.buttons.get(i));
		}

		// Display des TR in die erste Zeile setzen. Das Bedienpanel direkt
		// darunter
		this.add(display, BorderLayout.SOUTH);
		this.add(tastenpanel, BorderLayout.CENTER);
		this.setResizable(false);
		this.setSize(500, 300);
		// Alle Tasten des Rechners mit dem Controllerobjekt verknuepfen
		for (JButton b : buttons) {
			b.addActionListener(controller);
		}
		this.setVisible(true);
	}

	/**
	 * Diese Methode wird vom Controller aufgerufen, wenn der View aufdatiert
	 * werden soll.
	 */
	public void update() {
		char[][] feld = model.getField();
		System.out.println(feld[0]);
		System.out.println(feld[1]);
		System.out.println(feld[2]);
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (feld[i][j] != T3Konstanten.LEER) {
					this.buttons.get(cnt).setEnabled(false);
					this.buttons.get(cnt).setBackground(feld[i][j] == T3Konstanten.X ? Color.GREEN : Color.RED);
				} else {
					this.buttons.get(cnt).setEnabled(true);
					this.buttons.get(cnt).setBackground(Color.WHITE);
				}
				this.buttons.get(cnt).setText(feld[i][j] + "");
				cnt++;
			}
			
		}
		
		display.setText(model.getText());
	}
}

