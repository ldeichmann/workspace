package Raumverwaltung;

public class Reservierung {

	private String bemerkung;
	private Uhrzeit beginn;
	private Uhrzeit ende;
	protected Mitarbeiter reservent;
	protected Raum raum;
	
	/**
	 * Erstellt die Reservierung
	 * @param beginn Die Zeit, ab welcher die Reservierung gelten soll
	 * @param Ende Die Zeit, ab welcher die Reservierung nicht mehr gelten soll
	 */
	public Reservierung(Uhrzeit beginn, Uhrzeit ende) {
		
		this.beginn = beginn;
		this.ende = ende;
		
		
	}
	
	/**
	 * Setzt die Bemerkung zur Reservierung
	 * @param bemerkung
	 */
	public void setBemerkung(String bemerkung) {
		
		this.bemerkung = bemerkung;
		
	}
	
	/**
	 * @param m der Mitarbeiter, der reserviert hat
	 */
	public void setMitarbeiter(Mitarbeiter m) {
		
		this.reservent = m;
		
	}
	
	/**
	 * Legt den Raum fest, für den die Reservierung gilt
	 * @param r der zu reservierende Raum
	 */
	public void setRaum(Raum r) {
		
		this.raum = r;
		r.addReservierung(this);
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return "gebucht von " + reservent + " von " + this.beginn + " bis " + this.ende + " für " + this.bemerkung;
		
	}
	
}
