package bouncingbears;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class main {

	public static void a22_1() {
		FigurenGruppe baer1 = new FigurenGruppe(-150, 0, new Kreis(0, 0, 0,
				100, Color.GRAY), // Gesicht
				new Kreis(0, -10, 1, 20, Color.RED), // Nase
				new Kreis(65, 65, -1, 40, Color.DARK_GRAY), // Linkes Ohr
				new Kreis(-65, 65, -1, 40, Color.DARK_GRAY), // Rechtes Ohr
				new Kreis(-25, 25, 1, 10, Color.WHITE), // Linkes Auge
				new Kreis(25, 25, 1, 10, Color.WHITE), // Rechtes Auge
				new Ellipse(0, -55, 1, 55, 15, Color.YELLOW), // Mund
				new Rechteck(-80, 90, 1, 160, 20, Color.GREEN), // Hut (Krempe,
																// unten)
				new Rechteck(-40, 90, 1, 80, 100, Color.GREEN) // Hut (oben)
		);
		FigurenGruppe baer2 = new FigurenGruppe(150, 0, new Kreis(0, 0, 0, 100,
				Color.GRAY), // Gesicht
				new Kreis(-25, 25, 1, 10, Color.BLUE), // Linkes Auge
				new Kreis(25, 25, 1, 10, Color.BLUE), // Rechtes Auge
				new Kreis(0, -10, 1, 20, Color.RED), // Nase
				new Kreis(65, 65, -1, 40, Color.DARK_GRAY), // Linkes Ohr
				new Kreis(-65, 65, -1, 40, Color.DARK_GRAY), // Rechtes Ohr
				new RWDreieck(0, -40, 1, -70, -30, Color.YELLOW), // Mund
																	// (links)
				new RWDreieck(0, -40, 1, 70, -30, Color.YELLOW), // Mund
																	// (rechts)
				new RWDreieck(0, 90, 1, -40, 100, Color.GREEN), // Partyhut
																// (links)
				new RWDreieck(0, 90, 1, 40, 100, Color.GREEN) // Partyhut
																// (rechts)
		);

		MyCanvas mc = new MyCanvas(baer1, baer2);
		
		JFrame mainFrame = new JFrame("Bouncing Bears");
		mainFrame.add(mc);
		mainFrame.setResizable(false);
		mainFrame.setSize(800, 600);
		mainFrame.setVisible(true);
		while (true) {
			try {
				Thread.sleep(10); // 10 ms schlafen
				int h = mc.getHeight() / 2; // Hoehe des Canvas bestimmen
				int w = mc.getWidth() / 2; // Breite des Canvas bestimmen

				// int
				
				
				for (FigurenGruppe fg:mc.getFiguren()) {
					
					if ((fg.X >= w && fg.DX > 0) || (fg.X <= -w && fg.DX < 0) || fg.DX == 0) {
						
						System.out.println(fg.X + " " + w);

						Random rand = new Random();

					    int randomNum = rand.nextInt((10 - 1) + 1) + 1;
						// invert DX
						if (fg.DX > 0) {
						    fg.DX = -randomNum;
						} else {
						    fg.DX = randomNum;
						}
						
						
					}

					if ((fg.Y >= h && fg.DY > 0) || (fg.Y <= -h && fg.DY < 0) || fg.DY == 0) {
						
						System.out.println(fg.Y + " " + h);
						
					    Random rand = new Random();

					    int randomNum = rand.nextInt((10 - 1) + 1) + 1;
						// invert DX
						if (fg.DY > 0) {
						    fg.DY = -randomNum;
						} else {
						    fg.DY = randomNum;
						}
						
						
					}
					
				}
				
				
				mc.repaint();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

	}
	

	public static void main(String args[]) {
		a22_1();
	}

}
