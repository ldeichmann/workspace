package vectorutils;

public class RWDreieck extends FigMZLA {

	RWDreieck(int x, int y, int z, int a, int b) {
		
		super(x, y, z, a, b);
		this.figurenTyp = "Rechtwinkliges Dreieck";

	}

	double berechneFlaeche() {
		return (((double)this.A * (double)this.B)/2);
	}
	
}
