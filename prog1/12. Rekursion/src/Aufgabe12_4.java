
public class Aufgabe12_4 {

	/**
	 * Mirrors a given String
	 * @param s Given String
	 * @return Mirrored String
	 */
	public static String mirror(String s) {
		
		if (s.length() > 1) {
			return s.charAt(0) + mirror(s.substring(1, s.length())) + s.charAt(0);
		} else {
			return Character.toString(s.charAt(0)) + Character.toString(s.charAt(0));
		}
		
	}
	
	public static void main(String args[]) {
		
		System.out.println(mirror("Spiegel"));
		
	}
	
}
