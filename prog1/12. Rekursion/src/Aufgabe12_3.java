
public class Aufgabe12_3 {

	/**
	 * Separates every char in a given string using a - character
	 * @param s The string to be converted
	 * @return Converted string using separators
	 */
	public static String foo(String s) {
		
		if (s.length() > 1) {
			return s.charAt(0) + "-" + foo(s.substring(1, s.length()));
		} else {
			return Character.toString(s.charAt(0));
		}
	}
	
	public static void main(String args[]) {
		
		System.out.println(foo("Hello World"));
		
	}
	
}
