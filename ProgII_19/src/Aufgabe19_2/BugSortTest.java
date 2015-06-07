package Aufgabe19_2;

import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * Testet den in der Klasse Sort befindlichen BinSort Algorithmus. Vorgabe fuer
 * Aufgabe 19.2
 * 
 * @author Nane Kratzke
 */
public class BugSortTest {

	/**
	 * Testet aufsteigenden BinSort mit einer Liste von Strings.
	 */
	@Test
	public void testBinSortWithStrings() {
		List<String> strs = new LinkedList<String>();
		strs.add("Hello World");
		strs.add("Mein Name ist Hase");
		strs.add("Das wird schon klappen");

		BugSort<String> stringSorter = new BugSort<String>();
		List<String> sorted = stringSorter.binSort(strs);

		assertTrue(sorted.get(0).equals("Das wird schon klappen"));
		assertTrue(sorted.get(1).equals("Hello World"));
		assertTrue(sorted.get(2).equals("Mein Name ist Hase"));

	}


	/**
	 * Testet absteigend BinSort mit einer Liste von Strings.
	 */
	@Test
	public void testBinSortWithStringsDesc() {
		List<String> strs = new LinkedList<String>();
		strs.add("Hello World");
		strs.add("Mein Name ist Hase");
		strs.add("Das wird schon klappen");

		BugSort<String> stringSorter = new BugSort<String>();
		List<String> sorted = stringSorter.binSort(strs, false);
		
//		System.out.println(sorted);


		assertTrue(sorted.get(2).equals("Das wird schon klappen"));
		assertTrue(sorted.get(1).equals("Hello World"));
		assertTrue(sorted.get(0).equals("Mein Name ist Hase"));

	}
	
	/**
	 * Testet aufsteigenden BinSort mit einer Liste von Integern.
	 */
	@Test
	public void testBinSortWithIntegers() {
		List<Integer> is = new LinkedList<Integer>();
		for (int i = 0; i <= 5; i++)
			is.add(i);

		BugSort<Integer> integerSorter = new BugSort<Integer>();
		List<Integer> sorted = integerSorter.binSort(is);

		
		// Wir pruefen die aufsteigende Sortierung
		for (int i = 0; i < sorted.size() - 1; i++) {
			assertTrue(sorted.get(i) <= sorted.get(i + 1));
		}

	}
	
	///////////////////////
	///////////////////////
	///////////////////////
	
	/**
	 * Testet BinSort mit einer leeren Liste
	 */
	@Test
	public void testEmptyList() {
		List<Integer> is = new LinkedList<Integer>();

		BugSort<Integer> integerSorter = new BugSort<Integer>();
		List<Integer> sorted = integerSorter.binSort(is);
		
		System.out.println(sorted);

		assertTrue(sorted.size() == 0);

	}
	

	/**
	 * Testet absteigend BinSort mit einer Liste von Strings.
	 */
	@Test
	public void testManyIdenticalStrings() {
		List<String> strs = new LinkedList<String>();
		strs.add("Hello World");
		strs.add("Hello World");
		strs.add("Mein Name ist Hase");
		strs.add("Mein Name ist Hase");
		strs.add("Das wird schon klappen");
		strs.add("Das wird schon klappen");

		BugSort<String> stringSorter = new BugSort<String>();
		List<String> sorted = stringSorter.binSort(strs, false);
		
//		System.out.println(sorted);
		
		assertTrue(sorted.size() == 6);


	}
	
	/**
	 * Testet absteigend BinSort mit einer Liste von Strings.
	 */
	@Test
	public void testNullString() {
		List<String> strs = new LinkedList<String>();
		strs.add(null);
		strs.add("Hello World");
		strs.add("Hello World");
		strs.add("Hello World");
		strs.add("Hello World");

//		System.out.println(strs);


		BugSort<String> stringSorter = new BugSort<String>();
		List<String> sorted = stringSorter.binSort(strs, false);
		
//		System.out.println(sorted);
		
		assertTrue(sorted.size() == 4);




	}
}