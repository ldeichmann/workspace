import java.util.Scanner;


public class Metropolenbestimmung {

	public static boolean isMetropolis(String name, boolean istHauptstadt, int anzahlEinwohner, double steuernProEinwohner) {
		double totalTaxes = (double) anzahlEinwohner * steuernProEinwohner;
		
		if (istHauptstadt == false && anzahlEinwohner > 200000 && totalTaxes >= 1000000000) {
			return true;
		} else if (istHauptstadt == true && anzahlEinwohner > 100000 && totalTaxes >= 1000000000) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void main(String args[]) {

		String name;
		boolean istHauptstadt;
		int anzahlEinwohner = 0;
		double steuernProEinwohner = 0.0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Name der Stadt: ");
		name = scan.nextLine();
		
		System.out.println("Hauptstadt: ");
		while (!scan.hasNextBoolean()) {
		   System.out.println("It's simple, really. It's either true or false and you still got it wrong! Try again:");
		   scan.nextLine();
		}				
		istHauptstadt = scan.nextBoolean();

		do {
			System.out.println("Einwohnerzahl: ");
			while (!scan.hasNextInt()) {
				   System.out.println("Input not int, try again.");
				   scan.nextLine();
			}				
			anzahlEinwohner = scan.nextInt();
		} while (anzahlEinwohner <= 0);

		do {
			System.out.println("Steuern Pro Einwohner: ");
			while (!scan.hasNextDouble()) {
			   System.out.println("Double required, try again.");
			   scan.nextLine();
			}
			steuernProEinwohner = scan.nextDouble();
			System.out.println(steuernProEinwohner);
		} while (steuernProEinwohner <= 0.0);
		scan.close();
		
		if (isMetropolis(name, istHauptstadt, anzahlEinwohner, steuernProEinwohner) == true) {
			System.out.println(name + " ist eine Metropole");
		} else {
			System.out.println(name + " ist keine Metropole");
		}
	}
}
