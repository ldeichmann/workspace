import java.util.Stack;


public class Cards {

	public static void main(String[] args) {
		
		Stack s1 = new Stack(); s1.add("Herz As"); s1.add("Pik Bube"); s1.add("Karo 7"); s1.add("Kreuz Dame"); 
		Stack s2 = new Stack(); s2.add("Herz 8"); s2.add("Pik 4"); s2.add("Kreuz Bube"); s2.add("Karo Dame"); s2.add("Herz Bube"); s2.add("Pik As");

		
		System.out.println(collection_to_string(merge(s1, s2)));
		
	}
	
	/**
	 * Merges two stacks, in our example stacks of cards, and return
	 * @param s1 first stack
	 * @param s2 second stack
	 * @return Stack, merged version of stack 1 and stack 2
	 */
	public static Stack merge(Stack s1, Stack s2) {
		
		Stack returnStack = new Stack();
		
		while (!s1.isEmpty() || !s2.isEmpty()) {
			
			if (!s1.isEmpty()) {
				returnStack.add(s1.pop());
			}
			if (!s2.isEmpty()) {
				returnStack.add(s2.pop());
			}
			
		}
		
		return returnStack;
		
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
		
		if (returnString.length() > 1) {
			returnString = returnString.substring(0, returnString.length()-2) + "]";
		} else {
			returnString = returnString + "]";
		}
		return returnString;
		
//		return s.toString();
		
	}
	
}
