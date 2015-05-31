package vectorutils;

public abstract class FigMZLA extends Figur {

	protected int A;
	protected int B;
	protected String figurenTyp;
	
	FigMZLA(int x, int y, int z, int a, int b) {
		
		super(x, y, z);
		this.A = a;
		this.B = b;
		
	}
	
	public String toString() {
		
		return figurenTyp + " an Position (" + this.X + ", " + this.Y + ", "
				+ this.Z + ") mit einer Fläche von " + this.berechneFlaeche()
				+ " Flächeneinheiten";
		
	}
	
	abstract double berechneFlaeche();
	
}
