import java.util.LinkedList;
import java.util.List;


public class Aufgabe12_7 {

	/**
	 * Unifies two lists
	 * @param vs first list
	 * @param ws seconds list
	 * @return unified list
	 */
	public static List zip(List vs, List ws) {
		
		if (ws.size() > 1) {
			vs.add(0+(vs.size()-ws.size()), ws.remove(0));
			return zip(vs, ws);
		} else {
			vs.add(ws.remove(0));
			return vs;	
		}
		
		
	}
	
	public static void main(String args[]) {
		
		List as = new LinkedList();
		for (int i = 7; i >= 1; i -= 2) as.add(i);
		List bs = new LinkedList();
		for (int i = 2; i <= 6; i += 2) bs.add(i);
		System.out.println(Aufgabe12_6.serialize(zip(as, bs), " + "));
		
	}
	
}
