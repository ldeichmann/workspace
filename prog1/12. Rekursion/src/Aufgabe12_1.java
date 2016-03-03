
public class Aufgabe12_1 {

	/**
	 * Converts an int Array into a string using separator sep
	 * @param xs The int array to be converted @NotNull
	 * @param sep The separator for the output  @NotNull
	 * @return The string containing all ints separated by sep
	 */
	public static String zeichenweise(int[] xs, String sep) {
		
		if (xs.length > 1) {
			return xs[0] + sep + zeichenweise(1, xs, sep);
		} else {
			return Integer.toString(xs[0]);
		}
	}

	/**
	 * Converts an int Array into a string using separator sep
	 * @param count The position the recursion is currently in
	 * @param xs The int array to be converted @NotNull
	 * @param sep The separator for the output  @NotNull
	 * @return The string containing all ints separated by sep
	 */
	public static String zeichenweise(int count, int[] xs, String sep) {
		
		if (xs.length-1 > count) {
			return xs[count] + sep + zeichenweise(count + 1, xs, sep);
		} else {
			return Integer.toString(xs[count]);
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(zeichenweise(a, "-"));
		
	}
	
}
