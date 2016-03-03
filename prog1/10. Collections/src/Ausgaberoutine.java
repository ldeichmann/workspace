import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class Ausgaberoutine {


	
	public static void main(String[] args) {
		List v = new LinkedList(); for (int i = 1; i < 5; i++) v.add(i);
		Stack s = new Stack(); for (int j = 1; j < 5; j++) s.add(j);
		Map t = new HashMap(); for (int k = 65; k < 69; k++) t.put(k, (char)k);
		
		System.out.println(collection_to_string(v));
		System.out.println(collection_to_string(s));
		System.out.println(collection_to_string(t));

	}
	
	/**
	 * Converts a given collection to a string
	 * @param v List
	 * @return String of v content
	 */
	public static String collection_to_string(List v) {

		return v.toString();
		
	}
	
	/**
	 * Converts a given collection to a string
	 * @param s Stack
	 * @return String with Stack contents
	 */
	public static String collection_to_string(Stack s) {
		
		String returnString = "[";
		while (!s.isEmpty()) {
			returnString = returnString + s.pop() + ", ";
		}
		
		returnString = returnString.substring(0, returnString.length()-2) + "]";

		return returnString;
		
//		return s.toString();
		
	}
	
	/**
	 * Converts a given collection to a string
	 * @param t HashMap
	 * @return String with HashMap Content with "->" as connectors
	 */
	public static String collection_to_string(Map t) {
		
		String returnString = "[";
		Iterator e = t.keySet().iterator();
		while (e.hasNext()) {
			Object l = e.next();
			returnString = returnString + l.toString() + " -> " + t.get(l).toString() + ", ";
		}
		returnString = returnString.substring(0, returnString.length()-2) + "]";
		return returnString;
		
	}
}
