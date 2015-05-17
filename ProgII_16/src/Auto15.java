
public class Auto15 {
	
	private String Hersteller;
	private long Laufleistung;
	private double Preis;
	private String Farbe;
	private boolean Unfallwagen;
	private String Kraftstoff;
	private double Leistung;
	
	Auto15(String h, long l, double p, String f, boolean u, String k, double le) {

		this.Hersteller = h;
		this.Laufleistung = l;
		this.Preis = p;
		this.Farbe = f;
		this.Unfallwagen = u;
		this.Kraftstoff = k;
		this.Leistung = le;

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
	
}
