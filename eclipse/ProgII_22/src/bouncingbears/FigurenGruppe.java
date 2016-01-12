package bouncingbears;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class FigurenGruppe {

	protected int X;
	protected int Y;
	protected int DX;
	protected int DY;

	protected List<Figur> figs = new LinkedList<Figur>();
	
	public FigurenGruppe(int x, int y) {
		
		this.X = x;
		this.Y = y;
		
	}

	public FigurenGruppe(int x, int y, Figur... figs) {
		
		this.X = x;
		this.Y = y;		
		for (Figur f : figs) {
			this.figs.add(f);
		}
		this.sort();
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public int getDX() {
		return this.DX;
	}
	
	public int getDY() {
		return this.DY;
	}

	public FigurenGruppe setDX(int x) {
		this.DX = x;
		return this;
	}
	
	public FigurenGruppe setDY(int y) {
		this.DY = y;
		return this;
	}
	
	public FigurenGruppe bewege() {
		return this;
	}
	
	public FigurenGruppe add(Figur... figs) {
		return this;
	}
	
	public FigurenGruppe remove(Figur... figs) {
		return this;
	}
	
	protected FigurenGruppe sort() {
		boolean unsorted = true;
//		List<Figur> figuren = figs;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < figs.size() - 1; i++) {
				if (!(figs.get(i).Z <= figs.get(i + 1).Z)) {
					Figur dummy = figs.get(i);
					figs.set(i, figs.get(i + 1));
					figs.set(i + 1, dummy);
					unsorted = true;
				}
			}
		}
		return this;
	}
	
	public void zeichne(int x, int y, Graphics g) {

		this.X = this.X + this.DX;
		this.Y = this.Y + this.DY;
		
		for (Figur f : this.figs) {
			f.zeichne(x + this.X, y - this.Y, g);

		}
	}
}
