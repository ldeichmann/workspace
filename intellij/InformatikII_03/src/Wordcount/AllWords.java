package Wordcount;

import java.util.Arrays;

public class AllWords {
	private Word words[]; // das Array, in dem alle Wörter erfasst
//	private List<Word> words; //uml generation needs this to be there, otherwise it'll generate a one-to-one relationship
	private int wordsSize = 0;
	public AllWords (int max) {	words = new Word[max];}
	public void add(String s) {
		Word sWord = new Word(s);
		boolean found = false;
		if (wordsSize == 0) {
			words[0] = sWord;
			wordsSize++;
		} else {
			for (int i = 0; i < wordsSize; i++) { // Laufzeit: O(n/2)
				if (words[i].content().equals(sWord.content())) {
					
					words[i].inc();
					found = true;
					break;
					
				}
	
			}
			if (found == false) {
				if (words.length == wordsSize) {
					System.exit(-1);
				} else {
					words[wordsSize] = sWord;
					wordsSize++;
				}
			}
		}
		// Vergleiche mit allen bereits im Array erfassten Wörtern.
		// Falls s bereits als Wort enthalten ist, erhöhe den Zähler
		// dieses Wortes.
		// Ansonsten erzeuge neues Wort und trage es in das Array ein.
		// Falls kein Platz für neue Wörter mehr ist (bereits
		// max Wörter eingetragen) erzeuge Fehlerausschrift und beende
		// Programm mit System.exit(-1).
	}

	/**
	 * Sort the array by copying it to a smaller array, thus removing all null fields and then sorting it
	 */
	public void sort() {
		
		Word newWords[] = new Word[wordsSize]; // newArray
		System.arraycopy( words, 0, newWords, 0, wordsSize );

		words = newWords;
		Arrays.sort(words);
		
	}
	public int distinctWords() {
		return wordsSize;
	}
	public int totalWords() {
		int count = 0;
		for (int i = 0; i < wordsSize; i++) {
			count = count + words[i].count();
		}
		return count;
		// liefere Gesamtzahl aller Wörter
	}
	public String toString() {
		String stringWords = ""; // TODO Stringbuffer/Stringbuilder nutzen
		for (int i = 0; i < wordsSize; i++) {
			stringWords = stringWords + words[i].toString() + "\n";
		}
		return stringWords;
		// liefere Stringrepraesentation aller Wörter
	}
}