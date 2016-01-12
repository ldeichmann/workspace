package vectorutils;

import java.util.List;

public class main {

	public static void a18_1() {
		
		new Rechteck(5, 5, 3, 10, 20);
		new RWDreieck(30, 2, 4, 3, 4);
		new Ellipse(4, 10, 5, 10, 20);
		new Kreis(10, 10, 6, 5);
		new Quadrat(100, 200, -10, 35);
		
		
		for (Figur f : Figur.getAlleFiguren()) {
			System.out.println(f);
		}
		
	}
	
	public static void a18_2() {

		new Rechteck(5, 5, 3, 10, 20);
		new RWDreieck(30, 2, 4, 3, 4);
		new Ellipse(4, 10, 5, 10, 20);
		new Kreis(10, 10, 6, 5);
		new Quadrat(100, 200, -10, 35);

		for (Figur f : Figur.getZsortierteFiguren()) {
			System.out.println(f);
		}
		
	}
	
	public static void a18_3() {

		new Rechteck(5, 5, -10, 10, 20);
		new RWDreieck(30, 2, 80, 3, 4);
		new Ellipse(4, 10, 31, 10, 20);
		new Kreis(10, 10, 31, 5);
		new Quadrat(100, 200, 13, 35);
		new Rechteck(5, 5, 7, 10, 20);
		new RWDreieck(30, 2, -11, 3, 4);
		new Ellipse(4, 10, -17, 10, 20);
		new Kreis(10, 10, 50, 5);
		new Quadrat(100, 200, 30, 35);
		new Rechteck(5, 5, 25, 10, 20);
		new RWDreieck(30, 2, 7, 3, 4);
		new Ellipse(4, 10, 4, 10, 20);
		new Kreis(10, 10, 10, 5);
		new Quadrat(100, 200, 5, 35);

		for (Figur f : Figur.filterZ(0, 50, Figur.getZsortierteFiguren())) {
			System.out.println(f);
		}
	}
	
	public static void a18_4() {

		new Rechteck(5, 5, -10, 10, 20);
		new RWDreieck(30, 2, 80, 3, 4);
		new Ellipse(4, 10, 31, 10, 20);
		new Kreis(10, 10, 31, 5);
		new Quadrat(100, 200, 13, 35);
		new Rechteck(5, 5, 7, 10, 20);
		new RWDreieck(30, 2, -11, 3, 4);
		new Ellipse(4, 10, -17, 10, 20);
		new Kreis(10, 10, 50, 5);
		new Quadrat(100, 200, 30, 35);
		new Rechteck(5, 5, 25, 10, 20);
		new RWDreieck(30, 2, 7, 3, 4);
		new Ellipse(4, 10, 4, 10, 20);
		new Kreis(10, 10, 10, 5);
		new Quadrat(100, 200, 5, 35);
		
		List<Figur> l = Figur.filterZ(0, 50, Figur.getZsortierteFiguren());
		double totalFlaeche = 0.0;
		for (Figur f : l) {
			FigMZLA d = (FigMZLA) f;
			totalFlaeche += d.berechneFlaeche();
		}
		
		System.out.println("Die Gesamtfläche aller " + l.size() + " Figuren beträgt " + totalFlaeche + " Flächeneinheiten.");
		System.out.println("Die durchschnittliche Fläche pro Figur beträgt " + (totalFlaeche/l.size()) + " Flächeneinheiten.");
		
				
	}
	
	public static void main(String args[]) {
		a18_4();
	}
	
}
