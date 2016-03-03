import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Aufgabe11_2 {

	/**
	* Zu generierender Umsatzbereich.
	* Zwischen [MIN_VOLUME ... MIN_VOLUME+VOLUME_RANGE].
	*/
	public static final int VOLUME_RANGE = 10000000;

	/**
	* Minimaler zu generierender Umsatz (in USD).
	*/
	public static final int MIN_VOLUME = 100000;

	/**
	* Regionen fuer die Umsatzdaten generiert werden sollen.
	*/
	public static final String[] regions = {
	"North America", "Middle America", "South America",
	"West Europe", "Central Europe", "East Europe",
	"North Africa", "Central Africa", "East Africa",
	"Central Asia", "North Asia", "Asia Pacific",
	"China", "India"
	};

	/**
	* Produktqualifizierer die fuer Produktgenerierung herangezogen werden sollen.
	*/
	public static final String[] qualifier = {
	"Smart", "Mobile", "Intelli", "Brilliant", "Wonder", "Genius"
	};

	/**
	* Produkte, die fuer Produktgenerierung herangezogen werden sollen.
	*/
	public static final String[] products = {
	"Phone", "Tablet", "Glass", "Thing", "Thinker", "Cruncher"
	};

	/**
	* Produktcodes, die fuer Produktgenerierung herangezogen werden sollen.
	*/
	public static final String[] codes = {
	"V0", "1DX", "MX2", "U3R", "X4", "G5T", "HU6"
	};
	
	
	/**
	 * Stores data as .csv file
	 * @param data the List<SaleData> to be stored, not null
	 * @param f the File to be stored inside, not null
	 * @throws IOException
	 */
	public static void storeCSV(List<SaleData> data, File f) throws IOException {
		
		OutputStream os = new FileOutputStream(f); // Sink Stream	
		OutputStreamWriter bridge = new OutputStreamWriter(os); // Bridge Stream	
		BufferedWriter writer = new BufferedWriter(bridge); // Writer Stream
		 
		writer.write("\"Product\", \"Region\", \"Volume\", \"Currency\"\n");
		
		for (SaleData saledata : data) {
			
			writer.write(saledata.toCSV() + "\n");
			
		}
		 
		// Schließen der Streams nicht vergessen
		writer.close(); bridge.close(); os.close();
		
	}
	
	/**
	 * Stores data as .xml file
	 * @param data the List<SaleData> to be stored, not null
	 * @param f the File to be stored inside, not null
	 * @throws IOException
	 */
	public static void storeXML(List<SaleData> data, File f) throws IOException {
		
		OutputStream os = new FileOutputStream(f); // Sink Stream	
		OutputStreamWriter bridge = new OutputStreamWriter(os); // Bridge Stream	
		BufferedWriter writer = new BufferedWriter(bridge); // Writer Stream
		 
		writer.write("<Sales>\n");
		
		for (SaleData saledata : data) {
			
			writer.write(saledata.toXML());
			
		}
		
		writer.write("\n</Sales>");		
		 
		// Schließen der Streams nicht vergessen
		writer.close(); bridge.close(); os.close();	
		
	}
	
	/**
	 * Stores data as .ser file
	 * @param data the List<SaleData> to be stored, not null
	 * @param f the File to be stored inside, not null
	 * @throws IOException
	 */
	public static void storeSER(List<SaleData> data, File f) throws IOException {
		
        FileOutputStream fileOut = new FileOutputStream(f);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

		out.writeObject(data);

        out.close();
        fileOut.close();

		
	}
	
	/**
	 * Generates random sales data
	 * @param n int amount of data to be generated, not null
	 * @return List<SaleData> of generated data
	 */
	public static List<SaleData> generateData(int n) {
		
		List<SaleData> listA = new ArrayList();
		Random random = new Random();
		
		for (int i = 1; i <= n; i++) {
			
			// random qualifier
			String randomQualifier = qualifier[random.nextInt(qualifier.length-1)];
			// random products
			String randomProducts = products[random.nextInt(products.length-1)];
			// random codes
			String randomCodes = codes[random.nextInt(codes.length-1)];
			// random volume
			int randomVolume = 10000 + random.nextInt(9900000);
			// random region
			String randomRegions = regions[random.nextInt(regions.length-1)];
			
			
			SaleData a = new SaleData(randomQualifier + randomProducts + " " + randomCodes, randomRegions, randomVolume, "USD");
			
			listA.add(a);
			
		}
		
		
		return listA;
		
	}
	
	
	public static void main(String args[]) {
		
//		System.out.println(generateData(1).toString());
		
		File csv = new File("./output.csv");	
		File xml = new File("./output.xml");
		File ser = new File("./output.ser");
		
		List<SaleData> data = generateData(20);
		
		try {
			
			storeCSV(data, csv);
			storeXML(data, xml);
			storeSER(data, ser);
			
		} catch(Exception E) {
			E.printStackTrace();
		}
	}
	
}
