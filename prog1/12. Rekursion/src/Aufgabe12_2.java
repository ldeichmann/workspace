

public class Aufgabe12_2 {

	/**
	 * Converts a 2D int array into a formatted string
	 * @param xs the 2d array to be converted
	 * @return Formatted string representation of 2d array
	 */
	public static String zeilenweise(int[][] xs) {
		
		if (xs.length > 1) {
			return Aufgabe12_1.zeichenweise(xs[0], "-") + "\n" + zeilenweise(1, xs);
		} else {
			return Aufgabe12_1.zeichenweise(xs[0], "-");
		}
	}
	
	/**
	 * Converts a 2D int array into a formatted string
	 * @param count The position the recursion is currently in
	 * @param xs the 2d array to be converted
	 * @return Formatted string representation of 2d array
	 */
	public static String zeilenweise(int count, int[][] xs) {
		
		if (xs.length-1 > count) {
			return Aufgabe12_1.zeichenweise(xs[count], "-") + "\n" + zeilenweise(count + 1, xs);
		} else {
			return Aufgabe12_1.zeichenweise(xs[count], "-");
			
		}

	}
	
	public static void main(String[] args) {
		
		int[][] xs = {
				{ 1, 2, 3 },
				{ 4, 5 },
				{ 6 }
				};
	
		System.out.println(zeilenweise(xs));
		
	}
	
}
