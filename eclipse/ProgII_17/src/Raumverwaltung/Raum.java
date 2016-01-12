package Raumverwaltung;

import java.util.LinkedList;
import java.util.List;

public class Raum {

	private int geb;
	private int etage;
	private int raum;
	protected List<Reservierung> reservierungen = new LinkedList<Reservierung>();
	
	/**
	 * @param geb Die Gebäudenummer
	 * @param etage Die Etage
	 * @param raum Die Raumnummer
	 */
	Raum(int geb, int etage, int raum) {
		
		this.geb = geb;
		this.etage = etage;
		this.raum = raum;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Raum " + this.geb + "-" + this.etage + "." + this.raum);
		if (reservierungen.size() > 0) {
			for (Reservierung r: reservierungen) {
				sb.append("\n" + r.toString());
			}
		}
		
		
		return sb.toString();
		
	}
	
	/**
	 * Fügt eine Reservierung zu dem Raum hinzu
	 * @param r die hinzuzufügende Reservierung
	 */
	public void addReservierung(Reservierung r) {
		
		reservierungen.add(r);
		
	}
	
}
