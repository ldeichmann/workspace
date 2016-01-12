
/**
 * @author lukas
 * Ein Auto-Objekt
 */
public class Auto {

	private String hersteller;
	private long laufleistung;
	private double preis;
	private String farbe;
	private boolean unfallwagen;
	private String kraftstoff;
	private double psLeistung;
	private Bestand bp = null;;

	
	/**
	 * @return Hersteller
	 */
	public String getHersteller() {
		return hersteller;
	}

	/**
	 * @return Laufleistung in KM
	 */
	public long getLaufleistung() {
		return laufleistung;
	}

	/**
	 * @return Preis in EUR
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * @return Farbe
	 */
	public String getFarbe() {
		return farbe;
	}

	/**
	 * @return Unfallwagen
	 */
	public boolean isUnfallwagen() {
		return unfallwagen;
	}

	/**
	 * @return Kraftstoffart
	 */
	public String getKraftstoff() {
		return kraftstoff;
	}

	/**
	 * @return Leistung in PS
	 */
	public double getLeistung() {
		return psLeistung;
	}
	
	/**
	 * Fügt dieses Objekt einem Bestand hinzu
	 * Ein Auto kann nicht mehr als einem Bestand angehören!
	 * @param b Der Bestand, zu dem dieses Objekt hinzgefügt werden soll
	 * @return False, wenn Objekt bereits in Bestand b, sonst true
	 */
	public boolean zumBestandHinzu(Bestand b) {
		
		if (b.istVorhanden(this) || bp != null) {
			return false;
		} else {
			b.aufnehmen(this);
			bp = b;
			return true;
		}
		
	}

	
	/**
	 * Entfernt dieses Objekt aus seinem Bestand
	 * @return
	 */
	public boolean ausDemBestand() {
		
		if (bp != null) {
			bp.entnehmen(this);
			bp = null;
			return true;
		}
		return false;
		
	}
	
	/**
	 * @param h Hersteller
	 * @param l Laufleistung
	 * @param p Preis
	 * @param f Farbe
	 * @param u Unfallwagen
	 * @param k Kraftstoff
	 * @param le Leistung
	 */
	Auto(String h, long l, double p, String f, boolean u, String k, double le) {

		this.hersteller = h;
		this.laufleistung = l;
		this.preis = p;
		this.farbe = f;
		this.unfallwagen = u;
		this.kraftstoff = k;
		this.psLeistung = le;

	}

	public String toString() {
		StringBuilder str = new StringBuilder("---\n");
		str.append("Hersteller: " + this.getHersteller() + "\n");
		str.append("Preis: " + this.getPreis() + " EUR\n");
		str.append("Motor: " + this.getLeistung() + " PS ("
				+ this.getKraftstoff() + ")\n");
		str.append("KM-Stand: " + this.getLaufleistung() + " km\n");
		str.append("Farbe: " + this.getFarbe() + "\n");
		if (!this.isUnfallwagen())
			str.append("unfallfrei\n");
		str.append("---");
		return str.toString();
	}
	

}
