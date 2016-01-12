package bouncingbears;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class MyCanvas extends JPanel {

	List<FigurenGruppe> figs = new LinkedList<FigurenGruppe>();
	
	/**
	 * @param figs vararg of figures for this canvas
	 */
	public MyCanvas(FigurenGruppe... figs) {
		for (FigurenGruppe f: figs) {
			this.figs.add(f);
		}
	}
	
	/**
	 * @return List of FigurenGruppens
	 */
	public List<FigurenGruppe> getFiguren() {
		return figs;
	}
	
	/**
	* Hook der zur Darstellung unserer MyCanvas Komponente aufgerufen wird
	* @param g Graphics object, dass zur Darstellung der Komponente zu nutzen ist.
	*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = this.getWidth() / 2;
		int y = this.getHeight() / 2;
		for (FigurenGruppe f : this.getFiguren()) {
			f.zeichne(x, y, g);
		}
	}
	
}
