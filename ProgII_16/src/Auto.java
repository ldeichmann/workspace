import java.util.LinkedList;
import java.util.List;

public class Auto {

	static protected List<Auto> bestand = new LinkedList<Auto>();

	private String Hersteller;
	private long Laufleistung;
	private double Preis;
	private String Farbe;
	private boolean Unfallwagen;
	private String Kraftstoff;
	private double Leistung;

	/**
	 * @param h
	 * @param l
	 * @param p
	 * @param f
	 * @param u
	 * @param k
	 * @param le
	 */
	Auto(String h, long l, double p, String f, boolean u, String k, double le) {

		this.Hersteller = h;
		this.Laufleistung = l;
		this.Preis = p;
		this.Farbe = f;
		this.Unfallwagen = u;
		this.Kraftstoff = k;
		this.Leistung = le;

		bestand.add(this);

	}

	/**
	 * @return Hersteller
	 */
	public String getHersteller() {
		return Hersteller;
	}

	/**
	 * @return Laufleistung in KM
	 */
	public long getLaufleistung() {
		return Laufleistung;
	}

	/**
	 * @return Preis in EUR
	 */
	public double getPreis() {
		return Preis;
	}

	/**
	 * @return Farbe
	 */
	public String getFarbe() {
		return Farbe;
	}

	/**
	 * @return Unfallwagen
	 */
	public boolean isUnfallwagen() {
		return Unfallwagen;
	}

	/**
	 * @return Kraftstoffart
	 */
	public String getKraftstoff() {
		return Kraftstoff;
	}

	/**
	 * @return Leistung in PS
	 */
	public double getLeistung() {
		return Leistung;
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

	/**
	 * Sortiert absteigend die Fahrzeuge im Bestand
	 */
	public static void bubbleSort() {
		boolean unsorted = true;
		List<Auto> autos = getBestand();
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < Auto.getAnzahl() - 1; i++) {
				if (!(autos.get(i).getPreis() >= autos.get(i + 1).getPreis())) {
					Auto dummy = autos.get(i);
					autos.set(i, autos.get(i + 1));
					autos.set(i + 1, dummy);
					unsorted = true;
				}
			}
		}
	}
	
	/**
	 * @return Anteil der Unfallwagen im Fahrzeugbestand
	 */
	public static double anteil_unfallwagen() {
		int unfallwagen = 0;

		for (Auto a : bestand) {
			unfallwagen = unfallwagen + (a.isUnfallwagen() ? 1 : 0);
		}

		return ((double) unfallwagen / (double) Auto.getAnzahl()) * 100;
	}

	/**
	 * @param kraftstoff Gesuchter Kraftstoff
	 * @return Anteil der Fahrzeuge im Bestand, die den gesuchten Kraftstoff verwenden
	 */
	public static double anteil_kraftstoffart(String kraftstoff) {
		int kraftstoffvorkommen = 0;

		for (Auto a : bestand) {
			kraftstoffvorkommen = kraftstoffvorkommen
					+ ((a.getKraftstoff().equals(kraftstoff)) ? 1 : 0);
		}

		return ((double) kraftstoffvorkommen / (double) Auto.getAnzahl()) * 100;

	}
	
	/**
	 * @param uf Nachlass unfallfreier Wagen
	 * @param u Nachlass Unfallwagen
	 * @return Erlös der Fahrzeuge im Bestand mit entsprechenden Nachlässen
	 */
	public static double erloes_inkl_nachlass(double uf, double u) {
		double erloes = 0.0;

		for (Auto a : bestand) {
			erloes = erloes
					+ ((a.isUnfallwagen()) ? a.getPreis() * (1.0 - u) : a
							.getPreis() * (1.0 - uf));
		}

		return erloes;
	}

	/**
	 * @return Bestand aller Fahrzeuge
	 */
	public static List<Auto> getBestand() {
		return bestand;
	}

	/**
	 * @return Anzahl der Fahrzeuge im aktuellen Bestand
	 */
	public static int getAnzahl() {
		return bestand.size();
	}

	/**
	 * Setzt den Bestand zurück
	 */
	public static void resetBestand() {
		bestand.clear();
	}

	public static void main(String[] args) {
		Auto.resetBestand();
		new Auto("Ford", 125000, 7999.99, "silbermetallic", false, "Diesel",
				101.0);
		new Auto("Mercedes", 63000, 22999.99, "bluesilver", true, "Super",
				137.0);
		new Auto("Daihatsu", 12000, 3099.99, "greendynamite", false, "Benzin",
				75.0);
		new Auto("Ford", 1700, 17999.99, "silbermetallic", false, "Diesel",
				101.0);
		new Auto("Mercedes", 63000, 22999.99, "bluesilver", true, "Elektro",
				37.0);
		new Auto("Daihatsu", 12000, 3099.99, "greendynamite", true, "Benzin",
				75.0);
		new Auto("Ford", 12500, 12999.99, "silbermetallic", false, "Super",
				121.0);
		new Auto("Mercedes", 6300, 32999.99, "bluesilver", false, "Super",
				137.0);
		new Auto("Daihatsu", 12000, 3099.99, "greendynamite", true, "Benzin",
				75.0);
		new Auto("Ford", 1700, 17999.99, "silbermetallic", false, "Diesel",
				101.0);
		new Auto("Mercedes", 63000, 22999.99, "bluesilver", true, "Elektro",
				37.0);
		new Auto("Daihatsu", 12000, 3099.99, "greendynamite", true, "Benzin",
				75.0);

		Auto.bubbleSort();

		for (Auto a : Auto.getBestand())
			System.out.println(a);
		System.out.println("Dieselautos: "
				+ Auto.anteil_kraftstoffart("Diesel") + "%");
		System.out.println("Elektroautos: "
				+ Auto.anteil_kraftstoffart("Elektro") + "%");
		System.out.println("Unfallwagen: " + Auto.anteil_unfallwagen() + "%");
		System.out.println("Erlös ohne Nachlass: "
				+ Auto.erloes_inkl_nachlass(0, 0) + " EUR");
		System.out.println("Erlös mit Nachlass: "
				+ Auto.erloes_inkl_nachlass(0.1, 0.25) + " EUR");
		System.out.println("Prozentuale Steigerung des Erlöses: "
				+ (1.0 - (Auto.erloes_inkl_nachlass(0.1, 0.25) / Auto
						.erloes_inkl_nachlass(0.1, 0.1))) + "%");
		System.out.println("Absolute Steigerung des Erlöses: "
				+ (Auto.erloes_inkl_nachlass(0.1, 0.1) - (Auto
						.erloes_inkl_nachlass(0.1, 0.25))) + " EUR");
	}

}
