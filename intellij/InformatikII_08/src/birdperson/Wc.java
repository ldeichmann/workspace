package birdperson;

import LinkedListMultiset.Multiset;

import java.io.InputStream;
import java.util.Scanner;

public class Wc {

    public static int countWords(InputStream in) {

        Multiset<String> lls = new TreeMultiset<String>();

//		System.out.println("Words please: ");

        try {
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                String t = scanner.next().replaceAll("[^\\p{L}\\p{Nd}]+", "");
                if (t.equals("exit")) { break; }
                if (t.length() > 0) {
                    lls.add(t);
                }

            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("Total words: " + lls.size());
        System.out.println("Distinct words: " + lls.distinct());
        return lls.size();
    }

    public static void main(String[] args) {

        countWords(System.in);

    }
}
