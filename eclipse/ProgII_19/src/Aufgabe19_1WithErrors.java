import java.util.HashMap;
import java.util.Map;


public class Aufgabe19_1WithErrors {

	/**
	* Zaehlt die Vorkommensanzahl von Zeichen innerhalb eines Strings.
	* @param sensitive Soll case sensitive gezaehlt werden oder nicht?
	* @param str Zu durchsuchender String.
	* @param cs Zu zaehlende Zeichen innerhalb von str.
	* @return Map<Character, Integer> Gezaehlte Vorkommen als
	*
	Mapping von Zeichen auf Haeufigkeit.
	*/
	public static Map<Character, Integer> countChars(boolean sensitive,
			String str, char... cs) {
		Map<Character, Integer> ret = new HashMap<Character, Integer>();
		for (char c : cs) {
			ret.put(c, 0);
		}

		if (sensitive) {
			str = str.toLowerCase();
		}

		int l = str.length();
		for (int i = 1; i < l - 1; i++) {
			for (char c : cs) {
				if (!sensitive) {
					if (c == str.charAt(i)) {
						ret.put(c, ret.get(c) + 1);
					}
				} else {
					if (c == str.charAt(i)) {
						ret.put(c, ret.get(c) + 1);
						ret.put(Character.toUpperCase(c), ret.get(c));
					}
				}

			}

		}
		return ret;
	}
	
}
