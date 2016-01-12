import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Aufgabe23_1 {

	public static void main(String[] args) {
		String aux = "";
		String[] auxSplit;
		Storage s = new Storage();

		try {
			URL text = new URL(
					"http://www.nkode.io/assets/programming/pins.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					text.openStream()));
			List<Decrypter> threads = new ArrayList<Decrypter>();
			for (byte i = 0; i <= 15; i++) { threads.add(new Decrypter(s)); }
			while ((aux = reader.readLine()) != null) {
				auxSplit = aux.split(", ");
				// System.out.println(auxSplit[0].replace("\"", "") + " " +
				// auxSplit[1].replace("\"", ""));
				// threads.add(new Decrypter(auxSplit[0].replace("\"", ""),
				// auxSplit[1].replace("\"", "")));
				s.addPassword(new Password(auxSplit[0].replace("\"", ""),
						auxSplit[1].replace("\"", "")));
			}
			long start = System.currentTimeMillis();
			for (Decrypter t : threads) {
				t.start();
			} // Threads starten
			for (Decrypter t : threads) {
				t.join();
			} // Threads zusammenführen
			long runtime = System.currentTimeMillis() - start;
			// Auswertung
			long total = 0;
			long max = 0;
			for (Password p : s.getDecryptedList()) {
				long proc = p.getTime();
				System.out.println(p.getUsername() + ":" + p.getPassword() + " "
						+ " (berechnet in " + proc + " ms)");
				max = proc > max ? proc : max;
				total += proc;
			}
			System.out.println("Gemessene Laufzeit: " + runtime + " ms");
			System.out.println("Längste Laufzeit: " + max + " ms");
			System.out.println("Addierte Laufzeit: " + total + " ms");
			System.out.println("Speedup von: " + ((double) total / runtime));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
