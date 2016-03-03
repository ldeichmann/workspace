import java.util.Arrays;
import java.util.Scanner;


public class DynamicArray {

	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		int[] userArray = getArray(scan);
		for (int i = 1; i <= userArray.length; i++) {
			userArray[i-1] = getUserInt(scan, i);
		}
		System.out.println("Sie haben folgendes Array erzeugt: " + Arrays.toString(userArray));
		System.out.println("Welche Positionen wollen Sie tauschen?");
		swap(userArray, getValidInt(scan, "Position Nr. 1: ", 1, userArray.length), getValidInt(scan, "Position Nr. 2: ", 1, userArray.length));
		System.out.println("Ihr Array sieht nun wie folgt aus: " + Arrays.toString(userArray));

		scan.close();
	}
	
	public static int getValidInt(Scanner scan, String request) {
		
		System.out.print(request);
		int requestedInt;
		while (!scan.hasNextInt()) {
		   System.out.print("Ungültige Eingabe\n" + request);
		   scan.nextLine();
		}
		requestedInt = scan.nextInt();
		
		return requestedInt;
		
	}

	public static int getValidInt(Scanner scan, String request, int min, int max) {
		
		int requestedInt;
		do {
			System.out.print(request);
			while (!scan.hasNextInt()) {
			   System.out.print("Ungültige Eingabe\n" + request);
			   scan.nextLine();
			}
			requestedInt = scan.nextInt();
		} while (!(min <= requestedInt && requestedInt <= max));
		
		return requestedInt;
		
	}
	
	public static int[] getArray(Scanner scan) {
		
		int userArrayLength = getValidInt(scan, "Wie viele Werte wollen Sie eingeben? ");
		return new int[userArrayLength];
		
	}
	
	public static int getUserInt(Scanner scan, int position) {
		
		return getValidInt(scan, "Wert Nr. " + position + ": ");
		
	}
	
	public static void swap(int[] xs, int p1, int p2) {
		
		int temp = xs[p1-1];
		xs[p1-1] = xs[p2-1];
		xs[p2-1] = temp;
		
	}
	
}
