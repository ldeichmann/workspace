import static org.junit.Assert.*;

import org.junit.Test;

public class TestCar {

	@Test
	public void testCreation() {
		Auto.resetBestand();
		Auto a1 = new Auto("Ford", 125000, 7999.99, "silber metallic", false,
				"Diesel", 101.0);

		assertTrue(a1.getHersteller().equals("Ford")
				&& a1.getLaufleistung() == 125000 && a1.getPreis() == 7999.99
				&& a1.getFarbe().equals("silber metallic")
				&& a1.isUnfallwagen() == false);
	}
	
	@Test
	public void testSort() {
		Auto.resetBestand();
	
		Auto[] autos = {
		new Auto("Ford", 125000, 7999.99, "silber metallic", false,
				"Diesel", 101.0),
		new Auto("Mercedes", 63000, 22999.99, "blue silver", true,
				"Super", 137.0),
		new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true,
				"Benzin", 75.0)
		};
		Auto.bubbleSort();
		boolean sorted = true;
		for (int i = 0; i < autos.length - 1; i++) {
			
			if ( !(autos[i].getPreis() > autos[i+1].getPreis())) { sorted = false; break; }
			
		}
		assertTrue(sorted);
		
	}
	
	@Test
	public void testCalcs() {
		Auto.resetBestand();

		Auto[] autobestand = {
				new Auto("Ford", 125000, 7999.99, "silber metallic", false,
						"Diesel", 101.0),
				new Auto("Mercedes", 63000, 22999.99, "blue silver", true,
						"Super", 137.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", false,
						"Benzin", 75.0),
				new Auto("Ford", 1700, 17999.99, "silber metallic", false,
						"Diesel", 101.0),
				new Auto("Mercedes", 63000, 22999.99, "blue silver", true,
						"Elektro", 37.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true,
						"Benzin", 75.0),
				new Auto("Ford", 12500, 12999.99, "silber metallic", false,
						"Super", 121.0),
				new Auto("Mercedes", 6300, 32999.99, "blue silver", false,
						"Super", 137.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true,
						"Benzin", 75.0),
				new Auto("Ford", 1700, 17999.99, "silber metallic", false,
						"Diesel", 101.0),
				new Auto("Mercedes", 63000, 22999.99, "blue silver", true,
						"Elektro", 37.0),
				new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true,
						"Benzin", 75.0) };
		
		System.out.println("Verkaufserlös: " + Auto.verkaufserloes());
		System.out.println("Unfallwagen: " + Auto.anteil_unfallwagen());
		System.out.println("Anteil an Feinstaubstreuern: "
				+ Auto.anteil_kraftstoffart("Diesel"));
		System.out.println("Anteil an Hippies: "
				+ Auto.anteil_kraftstoffart("Elektro"));
		System.out.println("Verkaufserlös mit Nachlässen: "
				+ Auto.erloes_inkl_nachlass(0.10, 0.25));
	
		assertTrue(Auto.verkaufserloes() == 171399.88
				&& Auto.anteil_unfallwagen() == 50.0
				&& Auto.anteil_kraftstoffart("Diesel") == 25.0
				&& Auto.anteil_kraftstoffart("Elektro") == 16.666666666666664
				&& Auto.erloes_inkl_nachlass(0.10, 0.25) == 142514.90099999998);
	
	}
	
	@Test
	public void testBestandsverwaltung() {
		Auto.resetBestand();
	
		new Auto("Ford", 125000, 7999.99, "silber metallic", false, "Diesel",
				101.0);
		new Auto("Mercedes", 63000, 22999.99, "blue silver", true, "Super",
				137.0);
		new Auto("Daihatsu", 12000, 3099.99, "green dynamite", true, "Benzin",
				75.0);
//		for (Auto a : Auto.getBestand())
//			System.out.println(a);
//		System.out.println("Insgesamt " + Auto.getAnzahl() + " Autos im Bestand.");
		
		assertTrue(Auto.getAnzahl() == 3);
		
	}
	
	@Test
	public void testRefactoring() {
		
		Auto.resetBestand();
		new Auto("Ford", 125000, 7999.99, "silbermetallic", false, "Diesel",
				101.0);
		new Auto("Mercedes", 63000, 22999.99, "bluesilver", true, "Super",
				137.0);
		new Auto("Daihatsu", 12000, 3099.99, "greendynamite", false, "Benzin",
				75.0);
		new Auto("Ford", 1700, 17999.99, "silbermetallic", false, "Diesel",
				101.0);
		new Auto("Mercedes", 63000, 22999.99, "bluesilver", true, "Elektro",
				37.0);

		Auto.bubbleSort();

		for (Auto a : Auto.getBestand())
			System.out.println(a);
		System.out.println("Dieselautos:" + Auto.anteil_kraftstoffart("Diesel")
				+ "%");
		System.out.println("Elektroautos:"
				+ Auto.anteil_kraftstoffart("Elektro") + "%");
		System.out.println("Unfallwagen:" + Auto.anteil_unfallwagen() + "%");
		System.out.println("ErlösohneNachlass:"
				+ Auto.erloes_inkl_nachlass(0, 0) + "EUR");
		System.out.println("ErlösmitNachlass:"
				+ Auto.erloes_inkl_nachlass(0.1, 0.25) + "EUR");
		
		assertTrue(true);
	}

}
