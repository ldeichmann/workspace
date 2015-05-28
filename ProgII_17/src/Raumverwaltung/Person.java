package Raumverwaltung;

/**
 * @author lukas
 * Eine Person
 */
public class Person {

	private String vorname;
	private String nachname;
	
	/**
	 * @param vorname Vorname der Person
	 * @param nachname Nachname der Person
	 */
	public Person(String vorname, String nachname) {
		
		this.vorname = vorname;
		this.nachname = nachname;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return this.vorname + " " + this.nachname;
		
	}
	
}
