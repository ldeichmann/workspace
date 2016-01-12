package Raumverwaltung;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukas
 *	Ein Mitarbeiterobjekt
 */
public class Mitarbeiter extends Person {

	private String email;
	protected List<Reservierung> buchungen = new LinkedList<Reservierung>();
	
	
	/**
	 * @param vorname Vorname des Mitarbeiters
	 * @param nachname Nachname des Mitarbeiters
	 * @param email Emailadresse des Mitarbeiters
	 */
	public Mitarbeiter(String vorname, String nachname, String email) {
		
		super(vorname, nachname);
		this.email = email;
		
	}
	
	/* (non-Javadoc)
	 * @see Raumverwaltung.Person#toString()
	 */
	public String toString() {
		return super.toString() + " (" + this.email + ")";
	}
	
	/**
	 * Führt eine Reservierung für den Mitarbeiter durch
	 * @param r Raum, für welchen eine Reservierung vorgenommen werden soll
	 * @param anfang Die Zeit, ab welcher reserviert werden soll
	 * @param ende Die Zeit, ab welcher die Reservierung vorbei ist
	 * @param s Eine Bemerkung zur Reservierung
	 */
	public void reserviere(Raum r, Uhrzeit anfang, Uhrzeit ende, String s) {
		
		Reservierung res = new Reservierung(anfang, ende);
		res.setRaum(r);
		res.setBemerkung(s);
		res.setMitarbeiter(this);
		this.buchungen.add(res);		
		
		
	}
	
	
}
