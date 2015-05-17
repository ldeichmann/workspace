
public class Auto {
	
	private String Hersteller;
	private long Laufleistung;
	private double Preis;
	private String Farbe;
	private boolean Unfallwagen;
	private String Kraftstoff;
	private double Leistung;
	
	/**
	 * @param h Hersteller
	 * @param l Laufleistung in KM
	 * @param p Preis in EUR
	 * @param f Farbe
	 * @param u Unfallwagen
	 * @param k Kraftstoffart
	 * @param le Leistung in PS
	 */
	Auto(String h, long l, double p, String f, boolean u, String k, double le) {

		this.Hersteller = h;
		this.Laufleistung = l;
		this.Preis = p;
		this.Farbe = f;
		this.Unfallwagen = u;
		this.Kraftstoff = k;
		this.Leistung = le;

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
	 * @param autos Auto Array
	 * @return Anteil der Unfallwagen im gegebenen Array
	 */
	public static double anteil_unfallwagen(Auto[] autos) {
		int unfallwagen = 0;

		for (Auto a : autos) {
			unfallwagen = unfallwagen + (a.isUnfallwagen() ? 1 : 0);
		}

		return ((double) unfallwagen / (double) autos.length) * 100;
	}

	/**
	 * @param autos Auto Array
	 * @param kraftstoff Gesuchter Kraftstoff
	 * @return Anteil der Fahrzeuge im Array, die den gesuchten Kraftstoff verwenden
	 */
	public static double anteil_kraftstoffart(Auto[] autos, String kraftstoff) {
		int kraftstoffvorkommen = 0;

		for (Auto a : autos) {
			kraftstoffvorkommen = kraftstoffvorkommen
					+ ((a.getKraftstoff().equals(kraftstoff)) ? 1 : 0);
		}

		return ((double) kraftstoffvorkommen / (double) autos.length) * 100;

	}

	/**
	 * @param autos Auto Array
	 * @param uf Nachlass unfallfreier Wagen
	 * @param u Nachlass Unfallwagen
	 * @return Erlös der Fahrzeuge im Array mit entsprechenden Nachlässen
	 */
	public static double erloes_inkl_nachlass(Auto[] autos, double uf, double u) {
		double erloes = 0.0;

		for (Auto a : autos) {
			erloes = erloes
					+ ((a.isUnfallwagen()) ? a.getPreis() * (1.0 - u) : a
							.getPreis() * (1.0 - uf));
		}

		return erloes;
	}
	
	/**
	 * Sortiert absteigend die Fahrzeuge im Array
	 * @param autos Auto Array
	 */
	public static void bubbleSort(Auto[] autos) {
		boolean unsorted = true;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < autos.length - 1; i++) {
				if (!(autos[i].getPreis() >= autos[i + 1].getPreis())) {
					Auto dummy = autos[i];
					autos[i] = autos[i + 1];
					autos[i + 1] = dummy;
					unsorted = true;
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Auto[] autobestand = {
				new Auto("Ford", 125000, 7999.99, "silber metallic", false,
						"Diesel", 101.0),
				new Auto("Mercedes", 63000, 22999.99, "blue silver", true,
						"Super", 137.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", false,
						"Benzin", 75.0),
				new Auto("Ford", 1700, 17999.99, "silber metallic", false,
						"Diesel", 101.0),
				new Auto("Mercedes", 63000, 22999.99, "blue silver", true,
						"Elektro", 37.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true,
						"Benzin", 75.0),
				new Auto("Ford", 12500, 12999.99, "silber metallic", false,
						"Super", 121.0),
				new Auto("Mercedes", 6300, 32999.99, "blue silver", false,
						"Super", 137.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true,
						"Benzin", 75.0),
				new Auto("Ford", 1700, 17999.99, "silber metallic", false,
						"Diesel", 101.0),
				new Auto("Mercedes", 63000, 22999.99, "blue silver", true,
						"Elektro", 37.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true,
						"Benzin", 75.0) };

		
		System.out.println("Verkaufserlös: " + Auto.erloes_inkl_nachlass(autobestand, 0.0, 0.0));
		System.out.println("Unfallwagen: " + Auto.anteil_unfallwagen(autobestand));
		System.out.println("Anteil an Feinstaubstreuern: "
				+ Auto.anteil_kraftstoffart(autobestand, "Diesel"));
		System.out.println("Anteil an Hippies: "
				+ Auto.anteil_kraftstoffart(autobestand, "Elektro"));
		System.out.println("Verkaufserlös mit Nachlässen: "
				+ Auto.erloes_inkl_nachlass(autobestand, 0.10, 0.25));
		
	}
	
}
