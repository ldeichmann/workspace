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

	public String getHersteller() {
		return Hersteller;
	}

	public long getLaufleistung() {
		return Laufleistung;
	}

	public double getPreis() {
		return Preis;
	}

	public String getFarbe() {
		return Farbe;
	}

	public boolean isUnfallwagen() {
		return Unfallwagen;
	}

	public String getKraftstoff() {
		return Kraftstoff;
	}

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

	public static double verkaufserloes() {
		double erloes = 0;

		for (Auto a : bestand) {
			erloes = erloes + a.getPreis();
		}

		return erloes;
	}

	public static double anteil_unfallwagen() {
		int unfallwagen = 0;

		for (Auto a : bestand) {
			unfallwagen = unfallwagen + (a.isUnfallwagen() ? 1 : 0);
		}

		return ((double) unfallwagen / (double) Auto.getAnzahl()) * 100;
	}

	public static double anteil_kraftstoffart(String kraftstoff) {
		int kraftstoffvorkommen = 0;

		for (Auto a : bestand) {
			kraftstoffvorkommen = kraftstoffvorkommen
					+ ((a.getKraftstoff().equals(kraftstoff)) ? 1 : 0);
		}

		return ((double) kraftstoffvorkommen / (double) Auto.getAnzahl()) * 100;

	}

	public static double erloes_inkl_nachlass(double uf, double u) {
		double erloes = 0.0;

		for (Auto a : bestand) {
			erloes = erloes
					+ ((a.isUnfallwagen()) ? a.getPreis() * (1.0 - u) : a
							.getPreis() * (1.0 - uf));
		}

		return erloes;
	}

	public static List<Auto> getBestand() {
		return bestand;
	}

	public static int getAnzahl() {
		return bestand.size();
	}

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
