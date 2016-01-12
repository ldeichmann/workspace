import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class Aufgabe19_1Test {

	
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	
	
	/**
	 * Pruefe ob countChars bei einem Funktionsaufruf funktioniert, der nicht case sensitive ist.
	 */
	@Test
	public void testCaseInsensitiveReal() {
		Map<Character, Integer> m = Aufgabe19_1.countChars(false,
				"Hello WOrld", 'e', 'O');

		System.out.println(m);
		
		// Pruefe die Struktur der Rueckgabe
		assertTrue(m.keySet().contains('O'));
		assertTrue(m.keySet().contains('e'));

		// Pruefe Inhalt der Rueckgabe
		assertTrue(m.get('O') == 2);
		assertTrue(m.get('e') == 1);

	}
	
	/**
	 * Pruefe ob countChars case sensitive korrekt verarbeitet.
	 */
	@Test
	public void testCaseSensitiveReal() {
		Map<Character, Integer> m = Aufgabe19_1.countChars(true,
				"Hello World", 'o', 'e', '!');

//		System.out.println(m);
		// Pruefe die Struktur der Rueckgabe
		assertTrue(m.keySet().size() == 3);
		assertTrue(m.keySet().contains('o'));
		assertTrue(m.keySet().contains('e'));
		
		assertTrue(m.get('o') == 2);
		assertTrue(m.get('e') == 1);
		assertTrue(m.get('!') == 0);

	}

	
//	/**
//	 * Pruefe ob der ganze String verarbeitet wird
//	 */
//	@Test
//	public void testWholeStringChecked() {
//		Map<Character, Integer> m = Aufgabe19_1.countChars(false,
//				"hello world", 'h', 'e', 'l', 'o', 'w', 'r', 'd');
//
//		assertTrue(m.get('h') == 1);
//		assertTrue(m.get('e') == 1);
//		assertTrue(m.get('l') == 3);
//		assertTrue(m.get('o') == 2);
//		assertTrue(m.get('w') == 1);
//		assertTrue(m.get('r') == 1);
//		assertTrue(m.get('d') == 1);
//
//	} 

	/**
	 * Pruefe ob der erste Character im String verarbeitet wird
	 */
	@Test
	public void testFirstCharacterFound() {
		Map<Character, Integer> m = Aufgabe19_1.countChars(false,
				"hello world", 'h');

		assertTrue(m.get('h') == 1);

	}

	/**
	 * Pruefe ob der letzte Character im String verarbeitet wird
	 */
	@Test
	public void testLastCharacterFound() {
		Map<Character, Integer> m = Aufgabe19_1.countChars(false,
				"hello world", 'd');

		assertTrue(m.get('d') == 1);

	}

	/**
	 * Teste Aufruf mit einem Null-String 
	 */
	@Test
	public void testNullString() {
		Map<Character, Integer> m = Aufgabe19_1.countChars(false,
				null, 'o', 'e', '!');
		
		assertTrue(m.size() == 0);
		
	}
		

	/**
	 * Teste Aufruf case insensitive fuer capital Chars
	 */
	@Test
	public void testCapsCharCaseInsensitive() {
		Map<Character, Integer> m = Aufgabe19_1.countChars(true,
				"Hello World", 'W');
		
		assertTrue(m.get('W') == 1);

	}
	

}
