package Wordcount;

public class Word implements Comparable<Word> {
	private String content; // das Wort als Zeichenkette
	private int n; // die Anzahl des Auftretens dieses Wortes im Text
	public Word(String s) {

		content = s;// s als content übernehmen,
		n = 1;// zähler auf 1 setzen (erstes Auftreten)
	
	}

	public int count() { return n; }
	public String content() { return content; }
	public void inc() { n++; }
	public int compareTo(Word w) {
		if (w != null) {
			return w.count() - this.count();
		} else {
			return 1;
		}
	}
	public String toString(){
		return n + " : " + content;
		// liefert für dieses Wort die Zeichenkette: "Häufigkeit : Wort"
	}
}
