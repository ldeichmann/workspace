import java.io.Serializable;

/**
* Umsatzdaten zu einem Produkt in einer Region in USD.
* @author Nane Kratzke
*
*/
public class SaleData implements Serializable {
	
	/**
	* For serialization.
	*/
	public static final long serialVersionUID = -1881535325376543699L;
	
	/**
	* Produkt mit dem der Umsatz gemacht wurde.
	*/
	public String product;
	
	/**
	* Region in der der Umsatz gemacht wurde.
	*/
	public String region;
	
	/**
	* Umsatz in einer Waehrung.
	* @see #currency
	*/
	public int volume;
	
	/**
	* 3 stelliges Waehrungssymbol.
	*/
	public String currency;
	
	/**
	* Konstruktor zum Erzeugen eines Umsatzobjekts.
	* @param p Produkt
	* @param r Region
	* @param a Umsatz
	* @param c Waehrung (dreistelliges Symbol, z.B. USD)
	*/
	public SaleData(String p, String r, int a, String c) {
		this.product = p;
		this.region = r;
		this.volume = a;
		this.currency = c;
	}
	
	/**
	* Gibt eine kommaseparierte Repraesentation eines SaleData Objekts zurueck.
	* @return Zeichenkette folgenden Formats: ’"{product}", "{region}", "{amount}"\n’
	*/
	public String toString() {
		return "\"" + this.product + "\", " +
		"\"" + this.region + "\", " +
		"\"" + this.volume + "\", " +
		"\"" + this.currency + "\"";
	}
	
	/**
	* @see #toString()
	*/
	public String toCSV() { return this.toString(); }
	
	/**
	* Gibt eine XML Repraesentation eines SaleData Objekts zurueck.
	* @return Zeichenketten im in Aufgabe 11.2 definierten Formats.
	*/
	public String toXML() {
		String p = "\t\t<product>" + this.product + "</product>\n";
		String r = "\t\t<region>" + this.region + "</region>\n";
		String v = "\t\t<volume>" + this.volume + "</volume>\n";
		String c = "\t\t<currency>" + this.currency + "</currency>\n";
		return "\t<SaleData>\n" + p + r + v + c + "\t</SaleData>";
	}
}