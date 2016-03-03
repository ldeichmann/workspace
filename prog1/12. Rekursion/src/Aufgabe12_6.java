import java.util.LinkedList;
import java.util.List;


public class Aufgabe12_6 {

	/**
	 * Returns a list in string form using a given separator
	 * @param vs To be converted list
	 * @param sep Separator
	 * @return String representation of given list
	 */
	public static String serialize(List vs, String sep) {
		String r = vs.remove(0).toString();
		if (vs.size() >= 1) {
			return r + sep + serialize(vs, sep);
		} else {
			return r;
		}
		
	}
	
	public static void main(String args[]) {
		
		List vs = new LinkedList();
		for (int i = 1; i <= 5; i++) vs.add(i);
		System.out.println(serialize(vs, "+"));
		
	}
	
}
