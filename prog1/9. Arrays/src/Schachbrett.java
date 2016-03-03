
public class Schachbrett {

	public static void main(String args[]) {
		
		int[][] schachbrett = new int[8][8];

		for (int i = 0; i < schachbrett.length; i++) {
			for (int j = 0; j < schachbrett.length; j++) {
				schachbrett[i][j] = i + j + 1;
			}
		}
		
		for (int i = 0; i < schachbrett.length; i++) {
			for (int j = 0; j < schachbrett.length; j++) {
				System.out.print(schachbrett[i][j] + "\t");
			}
			System.out.print("\n");
		}		
		
	}
	
}
