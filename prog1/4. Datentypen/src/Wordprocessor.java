import java.util.Scanner;

public class Wordprocessor {
		
	public static String formatWord(String word, boolean first) {
		
		// only operate on non empty strings
		
		if (word.length() > 0) {
		
			// is the first character an underscore?
			
			if (word.charAt(0) == '_') {
				word = word.substring(1).toUpperCase();
			}
			// if the last character is an underscore as well, we'll just overwrite the previous function
			if (word.charAt(word.length() - 1) == '_') {
				word = word.substring(0, word.length() - 1).toLowerCase();
			}

		}
		
		// if this is the first word, do not add the remove delimiter
		if (first == true) {
			return word;
		} else {
			return " " + word;
		}
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte geben Sie die zu formatierende Zeichenkette ein: ");
		String origString = scan.nextLine();
		scan.close();
		
		String[] splitString = origString.split(" ");
		
		String finalString = "";
		
		for(int i = 0; i < splitString.length; i++)
		{
//		    System.out.println(splitString[i]);
			if (i == 0) {
				finalString = finalString + formatWord(splitString[i], true); 
			} else {
				finalString = finalString + formatWord(splitString[i], false); // add delimiter again.
				
			}
		}
		
		System.out.println(finalString);
		
	}
}
