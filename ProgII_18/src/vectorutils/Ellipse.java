package vectorutils;

public class Ellipse extends FigMZLA {

	Ellipse(int x, int y, int z, int a, int b) {
		super(x, y, z, a, b);
		this.figurenTyp = "Ellipse";

	}

	double berechneFlaeche() {
		return (Math.PI * this.A * this.B);
	}

	
	
}
