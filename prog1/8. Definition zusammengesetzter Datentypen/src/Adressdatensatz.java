
public class Adressdatensatz {

	public static void main(String[] args) {
		
		Adresse adr1 = new Adresse("Max", "Mustermann", "Beispielgasse", 12, 'c', 12345, "Exemplaria", "Germany");
		
		Adresse adr2 = new Adresse("Maren", "Musterfrau", "Beispielgasse", 12, 'c', 12345, "Exemplaria", "Germany");

		Adresse adr3 = adr1;
		Adresse adr4 = adr1.clone();
		
		System.out.println("adr1 == adr2 " + (adr1 == adr2)); // false
		System.out.println("adr1 == adr3 " + (adr1 == adr3)); // true
		System.out.println("adr1 == adr4 " + (adr1 == adr4)); // false
		System.out.println("adr1.equals(adr4): " + adr1.equals(adr4)); // true
		System.out.println("adr4.equals(adr1): " + adr4.equals(adr1)); // true
		
		System.out.println("\nAdresse 1:");
		System.out.println(adr1);
		System.out.println("\nAdresse 2:");
		System.out.println(adr2);		
		System.out.println("\nAdresse 3:");
		System.out.println(adr3);		
		System.out.println("\nAdresse 4:");
		System.out.println(adr4);		
	}
	
	
}
