import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Aufgabe14_3 {

	/**
	 * Bubblesort list of integers
	 * @param vs list of integers
	 * @return sorted list
	 */
	public static List<Integer> bubbleSort(List<Integer> vs) {
		
		if (vs == null) { return vs; }
		
		boolean unsorted=true;
		
		for (int i=0; i < vs.size()-1; i++) {
			
			if (vs.get(i) > vs.get(i + 1)) {
				int tmp = vs.get(i);
				vs.set(i, vs.get(i+1));
				vs.set(i+1, tmp);
				unsorted = false;
			}
			
		}
		
		if (unsorted == false) {
			return bubbleSort(vs);
		}
		
		return vs;
	}

	/**
	 * Times bubblesort of list
	 * @param liste list to be timed
	 * @return time
	 */
	public static long timedBubbleSort(List<Integer> liste) {
		
//		System.out.println(vs);
		long bubbleStart = System.currentTimeMillis();
		List<Integer> bsliste = (bubbleSort(liste));
		long bubbleEnd = System.currentTimeMillis();
		return bubbleEnd - bubbleStart;		
		
	}
	
	/**
	 * Times binsort of list
	 * @param liste list to be timed
	 * @return time
	 */
	public static long timedBinSort(List<Integer> liste) {
		
		if (liste == null) { return 0; }
		
		long binStart = System.currentTimeMillis();
		List<Integer> bsliste = Aufgabe14_2.binSort(liste);
		long binEnd = System.currentTimeMillis();
		return binEnd - binStart;
		
		
	}
	
	public static void main(String args[]) {
		
		List<Integer> liste = new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		while (true) {
			
			try {
				System.out.print("Wieviele Zahlen sollen sortiert werden (0 für Programmende)? ");
			    int input = scan.nextInt();
			    if ( input < 0 ) {
			 	   throw new IllegalArgumentException("Inkorrekte Eingabe!");
			    } else if (input == 0) {
			    	break;
			    } else {
			    	liste.clear();
					for (int j = 1; j <= input; j++) {
						liste.add((int)(100000 * Math.random()));
					}
					System.out.println("Bubblesort: " + timedBubbleSort(liste) + "ms");
					System.out.println("Binsort: " + timedBinSort(liste) + "ms");		
					
			   }
			} catch (Exception e) {
				scan.nextLine();
			}
			
		}
		System.out.println("Ciao");	
		scan.close();
	
	}

}
