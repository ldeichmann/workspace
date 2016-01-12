package Raumverwaltung;

/**
 * @author lukas
 * Ist das eine Uhrzeit? Ja. Ja, ist es.
 */
public class Uhrzeit {

	private int stunde;
	private int minute;
	
	/**
	 * @param s Stunde der Reservierung, eg. 18
	 * @param m Minute der Reservierung
	 */
	public Uhrzeit(int s, int m) {
		
		stunde = s;
		minute = m;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return stunde + "." + minute + " Uhr";
		
	}
}
