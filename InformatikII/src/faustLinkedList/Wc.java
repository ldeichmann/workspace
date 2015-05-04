package faustLinkedList;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class Wc {
	
	public static boolean addWord(String word) {
		
		
		return false;
	}
	
	public static int countWords(InputStream in) {

		LinkedListSet<String> lls = new LinkedListSet<String>();
		
		System.out.println("Words please: ");
		
		try {
			Scanner scanner = new Scanner(in);
			while (scanner.hasNext()) {
				String t = scanner.next().replaceAll("[^\\p{L}\\p{Nd}]+", "");
				if (t.equals("exit")) { break; }
//				System.out.println(t);
				if (t.length() > 0) { 
					if (!lls.contains(t)) {
//						System.out.println("add " + t);
						lls.add(t);
					}
				}
				
			}
			scanner.close();
		} catch (Exception e) {
	        System.out.println(e.toString());
	    }
//		System.out.println("Done Adding");
//		System.out.println(lls.size());
		System.out.println("Total words: " + lls.size());
		if (lls.size() > 0) {
			Iterator<String> llsi = lls.iterator();
//			System.out.println(lls);
			while (llsi.hasNext()) {
				
				System.out.println(llsi.next());
				
			}
		}
		System.out.println("Total words: " + lls.size());
		return lls.size();
	}
	
	public static void main(String[] args) {

		countWords(System.in);
		
	}
}