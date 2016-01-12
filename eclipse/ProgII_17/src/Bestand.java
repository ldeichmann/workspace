import java.util.LinkedList;
import java.util.List;


public class Bestand {

	static private List<Auto> bestand = new LinkedList<Auto>();
	
	public Bestand() {
		
		
		
	}
	
	
	/**
	 * @param uf Nachlass unfallfreier Wagen
	 * @param u Nachlass Unfallwagen
	 * @return Erlös der Fahrzeuge im Bestand mit entsprechenden Nachlässen
	 */
	public double erloes_inkl_nachlass(double uf, double u) {
		double erloes = 0.0;

		for (Auto a : bestand) {
			erloes += (a.isUnfallwagen()) ? a.getPreis() * (1.0 - u) : a
					.getPreis() * (1.0 - uf);;
		}

		return erloes;
	}
	
	
	public boolean istVorhanden(Auto a) {
		
		return bestand.contains(a);

	}
	
	public boolean aufnehmen(Auto a) {
		
		if (this.istVorhanden(a)) return false;
		return bestand.add(a);
		
	}
	
	public boolean entnehmen(Auto a) {
		
		if (!this.istVorhanden(a)) return false;
		return bestand.remove(a);

	}
	
	public Auto[] getAutosAlsArray() {
		
		Auto[] autos = new Auto[bestand.size()];
		for(int i = 0; i < bestand.size(); i++) autos[i] = bestand.get(i);
		return autos;
		
	}
	
	public Auto[] sortiertNachPreis() {
		
		Auto[] autos = getAutosAlsArray();
		bubbleSort(autos);
		return autos;
		
	}
	
	
	/**
	 * Sortiert absteigend die Fahrzeuge im Array
	 * @param autos Auto Array
	 */
	private static void bubbleSort(Auto[] autos) {
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
