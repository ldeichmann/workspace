package Wordcount;

import java.io.*;
import java.util.Scanner;

public class Wc {
	
	public static int countWords(InputStream in) {
		
		AllWords words = new AllWords(15000);
		
		try {
			Scanner scanner = new Scanner(in);
			while (scanner.hasNext()) {
				String t = scanner.next().replaceAll("[^\\p{L}\\p{Nd}]+", "");
				if (t.equals("exit")) { break; }
//				System.out.println(t);
				if (t.length() > 0) { words.add(t); }
				
			}
			scanner.close();
		} catch (Exception e) {
	        System.out.println(e.toString());
	    }
		words.sort();
		System.out.println(words.toString()); // gib alle Wörter aus
		System.out.println(words.distinctWords()); // gib Vokabulargröße aus
		System.out.println(words.totalWords()); // gib Textlänge aus
		return words.totalWords();
	}
	
	public static void main(String[] args) {

		countWords(System.in);
		
	}
}
