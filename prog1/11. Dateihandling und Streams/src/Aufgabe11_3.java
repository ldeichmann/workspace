import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Aufgabe11_3 {
	
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
	
	public static List<SaleData> getCSV(String URL) throws IOException {
		
		List<SaleData> data = new ArrayList();
		
        URL csv = new URL(URL);
        BufferedReader in = new BufferedReader(new InputStreamReader(csv.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
        	if (!inputLine.contains("Currency") && inputLine != "") {
        		data.add(readCSVLine(inputLine));
            }
        in.close();
        
        return data;
	}
	
	
	/**
	 * Converts csv file lines to SaleData Entires
	 * @param line String to be converted, must be valid csv, not null
	 * @return SaleData conversion
	 */
	public static SaleData readCSVLine(String line) {

		String[] parts = line.split(",");
		
		String product = parts[0].substring(2, parts[0].length()-1);
		String country = parts[1].substring(2, parts[1].length()-1);;
		int volume = Integer.parseInt(parts[2].substring(2, parts[2].length()-1));
		String currency = parts[3].substring(2, parts[3].length()-1);;
		
		return new SaleData(product, country, volume, currency);
		
		
	}
	
	/**
	 * Prints the highest volume region in given data
	 * @param data valid List<SaleData>, not null
	 */
	public static void printBestRegions(List<SaleData> data) {
		
		int[] regionVolume = new int[regions.length];
		
		for (SaleData saledata : data) {
			
			int index = Arrays.asList(regions).indexOf(saledata.region);
//			System.out.println(saledata.region);
			
			regionVolume[index] = regionVolume[index] + saledata.volume;
			
		}
		
		List<Integer> positions = new ArrayList();
		
		positions.add(0);
		for ( int i = 0; i < regionVolume.length; i++) {
		    if ( regionVolume[i] > regionVolume[positions.get(0)]) {
		    	
		    	positions.clear();
		    	positions.add(i);
		    } else if (regionVolume[i] == regionVolume[positions.get(0)]) {
		    	positions.add(i);
		    }
		}
		
		List<String> maxRegions = new ArrayList();
		
		for (int i = 0; i < positions.size(); i++) {
			
			maxRegions.add(regions[positions.get(i)]);
			
		}
		
		System.out.println("Beste Region(en) ist/sind " + maxRegions.toString() + " mit " + regionVolume[positions.get(0)] + " USD Umsatz.");
		
		
	}
	
	/**
	 * Returns list of all products in given list
	 * @param valid List<SaleData>, not null
	 * @return List<String> containing product names
	 */
	public static List<String> getProducts(List<SaleData> data) {
		
		List<String> productNames = new ArrayList();
		
		for (SaleData saledata : data) {
			
			if (!productNames.contains(saledata.product)) {
				productNames.add(saledata.product);
			}
			
		}
		
		return productNames;
	}
	
	
	/**
	 * Prints the highest volume product in given data
	 * @param data valid List<SaleData>, not null
	 */
	public static void printBestProduct(List<SaleData> data) {
		
		List<String> productNames = getProducts(data);
		int[] productVolumes = new int[productNames.size()];
		int maxVolume = 0;
		
		
		
		
		for (SaleData saledata : data) {
			
			int index = productNames.indexOf(saledata.product);
			productVolumes[index] = productVolumes[index] + saledata.volume;
//			System.out.println(saledata.region);
			
			
		}
		
		List<Integer> positions = new ArrayList();
		
		positions.add(0);
		for ( int i = 0; i < productVolumes.length; i++) {
		    if ( productVolumes[i] > productVolumes[positions.get(0)]) {
		    	
		    	positions.clear();
		    	positions.add(i);
		    } else if (productVolumes[i] == productVolumes[positions.get(0)]) {
		    	positions.add(i);
		    }
		}
		
		List<String> maxProducts = new ArrayList();
		
		for (int i = 0; i < positions.size(); i++) {
			
			maxProducts.add(productNames.get(positions.get(i)));
			
		}
		
		System.out.println("Beste Produkt(e) ist/sind " + maxProducts.toString() + " mit " + productVolumes[positions.get(0)] + " USD Umsatz.");
		
		
	}
	
	
	
	public static void main(String args[]) {
		
		try {
			List<SaleData> data = getCSV("http://www.nkode.io/assets/programming/volume.csv");
			printBestRegions(data);
			printBestProduct(data);
			
		} catch(Exception E) {
			E.printStackTrace();
		}
		
	}
	
}
