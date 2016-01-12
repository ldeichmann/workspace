package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	/**
	 * Datenfelder des Controller Objekts eines Taschenrechners
	 */
	private View view;
	private Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	/*
	 * ActionListener - Diese Methode wird immer aufgerufen, wenn ein Button auf
	 * dem TR betaetigt wurde.
	 */
	public void actionPerformed(ActionEvent ev) {
		for (int i = 0; i <= 9; i++) {
			if (ev.getSource() == view.buttons.get(i))
				zahlAnhaengen("" + i); // 0
		}
//		if (ev.getSource() == view.buttons.get(0))
//			zahlAnhaengen("0"); // 0
//		if (ev.getSource() == view.buttons.get(1))
//			zahlAnhaengen("1"); // 1
//		if (ev.getSource() == view.buttons.get(2))
//			zahlAnhaengen("2"); // 2
		
		// [...]
		if (ev.getSource() == view.buttons.get(10))
			setRechenzeichen("+"); // Plus
		if (ev.getSource() == view.buttons.get(11))
			setRechenzeichen("-"); // Minus
		if (ev.getSource() == view.buttons.get(12))
			setRechenzeichen("*"); // Mal
		if (ev.getSource() == view.buttons.get(13))
			setRechenzeichen("/"); // Geteilt
		if (ev.getSource() == view.buttons.get(14))
			berechnen(); // =
		if (ev.getSource() == view.buttons.get(15))
			loeschen(); // C
	}

	/**
	 * Wird aufgerufen, wenn eine Zahl auf dem Taschenrechner betaetigt wurde
	 * Diese Zahl wird der aktuell auf dem Display stehenden Zahl angehaengt
	 * 
	 * @param i
	 *            Die Ziffer die an den aktuell eingegebenen Operanden
	 *            angehaengt werden soll
	 */
	private void zahlAnhaengen(String i) {
		model.setOperand(model.getOperand() + i);
		view.update();
	}

	/**
	 * Wird aufgerufen, wenn eine Operatoraste, -, /, *) betaetigt wurde
	 * 
	 * @param i
	 *            Der eingegebene Operator (+, -, /, *)
	 */
	private void setRechenzeichen(String i) {
		model.setOperator(i);
		view.update();
	}

	/**
	 * Wird aufgerufen, wenn die C Taste auf einem Taschenrechner betaetigt
	 * wurde.
	 */
	private void loeschen() {
		model.clear();
		view.update();
	}

	
	/**
	 * Wird aufgerufen, wenn die = Taste auf einem Taschenrechner betaetigt
	 * wurde.
	 */
	private void berechnen() {
		model.berechne();
		view.update();
	}
}
