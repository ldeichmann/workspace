package vectorutils;

public class Rechteck extends FigMZLA {

	Rechteck(int x, int y, int z, int a, int b) {
		
		super(x, y, z, a, b);
		this.figurenTyp = "Rechteck";
		
	}

	double berechneFlaeche() {
		
		return ((double)this.A * (double)this.B);

	}
	
}
