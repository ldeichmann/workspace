package aufgabe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class FindMax {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//double[][] matrix = readData("data0.txt");
		Value[][] matrix2 = readData2("data0.txt");
		//ArrayList<int[]> labels = readLabel("label0.txt");
		//ArrayList<int[]> myLabels = ranCoordinate(matrix, 1390);
		//ArrayList<int[]> myLabels2 = findMaximas(matrix, 20);
		//printLabelValues(matrix, myLabels2);
		//System.out.println(fScore(labels,myLabels));
		//printLabels(myLabels2);
		//System.out.println(matrix.length);
		//System.out.println(matrix[0].length);
		//printMatrix(matrix);
		//System.out.println(labels.size());
	}

	/**
	 * 
	 * @param matrix
	 * @param labels
	 */
	public static void printLabelValues(double[][] matrix, ArrayList<int[]> labels) {
		for (int i[] : labels) {
			System.out.println(i[0]+" "+i[1]+" "+matrix[i[1]][i[0]]);
		}
		return;
	}

	/**
	 * 
	 * @param labels
	 * @param mylabels
	 * @return
	 */
	public static double fScore(ArrayList<int[]> labels, ArrayList<int[]> mylabels) {
		double correctLabels = 0;
		double recall;
		double precision;
		double fscore;
		for (int[] i : mylabels) {
			for (int[] j : labels) {
				if (i[0] == j[0] && i[1] == j[1]) {
					correctLabels += 1;
					System.out.println("Found Label");
				}
			}
		}
		recall = correctLabels / labels.size();
		precision = correctLabels / mylabels.size();

		fscore = 2 * precision * recall / (precision + recall);

		return fscore;
	}

	public static ArrayList<int[]> findMaximas2(double[][] matrix, int checkNeighbors) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		// boolean isMax = false;
		double current = 0;
		int[] savecurrentposition;
		int[] savelocalmaxposition = null;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				savecurrentposition = new int[] {i, j};
				//current = matrix[i][j];
				for (int k = 0; k <= checkNeighbors; k++) {
					if ((i - k) >= 0 && (j - k) >= 0 && (i + k) < matrix.length-1 && (j + k) < matrix[0].length-1){
						if (matrix[i - k][j - k] < current) {
							matrix[i - k][j - k] = current;
							savelocalmaxposition = new int[] { i - k, j - k };
							i = i - k;
							j = j - k;
							k=0;
						}
					}
				}
			}
		}
		return ret;
	}
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static ArrayList<int[]> findMaximas(double[][] matrix, int checkNeighbors) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		// boolean isMax = false;
		double current = 0;
		int[] savecurrentposition;
		int[] savelocalmaxposition = null;
		Stack<int[]> temp = new Stack<int[]>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				savecurrentposition = new int[] { i, j };
				current = matrix[i][j];
				for (int k = 0; k < checkNeighbors; k++) {
					if ((i - k) >= 0 && (j - k) >= 0 && (i - k) < matrix.length-1 && (j - k) < matrix[0].length-1)
						if (matrix[i - k][j - k] > current) {// oben links
							current = matrix[i - k][j - k];
							matrix[i][j] = 0;
							savelocalmaxposition = new int[] { i - k, j - k };
							i = i - k;
							j = j - k;
							k = 0;
							//break;
						}
					if (i >= 0 && (j - k) >= 0 && i < matrix.length-1 && (j - k) < matrix[0].length-1)
						if (matrix[i][j - k] > current) { // über
							current = matrix[i][j - k];
							savelocalmaxposition = new int[] { i, j - k };
							matrix[i][j] = 0;
							j = j - k;
							k = 0;
							//break;
						}
					if ((i + k) >= 0 && (j - k) >= 0 && (i + k) < matrix.length-1 && (j - k) < matrix[0].length-1)
						if (matrix[i + k][j - k] > current) { //
							current = matrix[i + k][j - k];
							savelocalmaxposition = new int[] { i + k, j - k };
							matrix[i][j] = 0;
							i = i + k;
							j = j - k;
							k = 0;
							//break;
						}
					if ((i + k) >= 0 && j >= 0 && (i + k) < matrix.length-1 && j < matrix[0].length-1)
						if (matrix[i + k][j] > current) {
							current = matrix[i + k][j];
							savelocalmaxposition = new int[] { i + k, j };
							matrix[i][j] = 0;
							i = i + k;
							k = 0;
							//break;
						}
					if ((i + k) >= 0 && (j + k) >= 0 && (i + k) < matrix.length-1 && (j + k) < matrix[0].length-1)
						if (matrix[i + k][j + k] > current) {
							current = matrix[i + k][j + k];
							savelocalmaxposition = new int[] { i + k, j + k };
							matrix[i][j] = 0;
							i = i + k;
							j = j + k;
							k = 0;
							//break;
						}
					if (i >= 0 && (j + k) >= 0 && i < matrix.length-1 && (j + k) < matrix[0].length-1)
						if (matrix[i][j + k] > current) {
							current = matrix[i][j + k];
							savelocalmaxposition = new int[] { i, j + k };
							matrix[i][j] = 0;
							j = j + k;
							k = 0;
							//break;
						}
					if ((i - k) >= 0 && (j + k) >= 0 && (i - k) < matrix.length-1 && (j + k) < matrix[0].length-1)
						if (matrix[i - k][j + k] > current) {
							current = matrix[i - k][j + k];
							savelocalmaxposition = new int[] { i - k, j + k };
							matrix[i][j] = 0;
							i = i - k;
							j = j + k;
							k = 0;
							//break;
						}
					if ((i - k) >= 0 && j >= 0 && (i - k) < matrix.length-1 && j < matrix[0].length-1)
						if (matrix[i - k][j] > current) {
							current = matrix[i - k][j];
							savelocalmaxposition = new int[] { i - k, j };
							matrix[i][j] = 0;
							i = i - k;
							k = 0;
							//break;
						}
				}
				if(savelocalmaxposition != null ){
					if(ret.size() <= 0)ret.add(savelocalmaxposition);
					for(int[] check : ret){
						if(check[0] == savelocalmaxposition[0] && check[1] == savelocalmaxposition[1]){
							//System.out.println("Position schon hinzugefüght");
							i = savecurrentposition[0];
							j = savecurrentposition[1];
							break;
						} 
						temp.push(savelocalmaxposition);
					}
					while(!temp.isEmpty() && temp.peek() != null){
						matrix[temp.peek()[0]][temp.peek()[1]] = 0;
						ret.add(temp.pop());
					}
				}
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param matrix
	 * @param runs
	 * @return
	 */
	public static ArrayList<int[]> ranCoordinate(double[][] matrix, int runs) {
		ArrayList<int[]> ret = new ArrayList<int[]>();

		int i = 0;
		while (i <= runs) {
			int x = (int) (Math.random() * matrix.length);
			int y = (int) (Math.random() * matrix[0].length);
			ret.add(new int[] { x, y });
			i++;
		}
		return ret;
	}

	/**
	 * 
	 * @param list
	 */
	public static void printLabels(ArrayList<int[]> list) {
		for (int[] i : list) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param arr
	 * @throws IOException
	 */
	public static void printMatrix(double[][] arr) throws IOException {
		FileWriter fw = new FileWriter("ausgabe.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// bw.write(arr[i][j]+"\t");
				System.out.print(arr[i][j] + " ");
			}
			// bw.write("\n");
			System.out.println();
		}
		bw.close();
		return;
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static double[][] readData(String file) throws NumberFormatException, IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str;
		String[] temp;
		int k = 0;
		double[][] ret = new double[800][1000];
		while ((str = br.readLine()) != null) {
			temp = str.split(",");
			for (int i = 0; i < temp.length; i++) {
				ret[k][i] = (new Double(temp[i]));
			}
			k++;
		}
		br.close();
		return ret;
	}
	
	public static Value[][] readData2(String file) throws NumberFormatException, IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str;
		String[] temp;
		int k = 0;
		Value[][] ret = new Value[800][1000];
		while ((str = br.readLine()) != null) {
			temp = str.split(",");
			for (int i = 0; i < temp.length; i++) {
				ret[k][i] = new Value(new int[]{k,i}, false, (new Double(temp[i])));
			}
			k++;
		}
		br.close();
		return ret;
	}


	/**
	 * 
	 * @param file
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static ArrayList<int[]> readLabel(String file) throws NumberFormatException, IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<int[]> ret = new ArrayList<int[]>();
		double x;
		double y;
		String str;
		String[] temp;
		while ((str = br.readLine()) != null) {
			temp = str.split(",");
			x = new Double(temp[0]);
			y = new Double(temp[1]);
			ret.add(new int[] { (int) x, (int) y });
		}
		br.close();
		return ret;
	}
}
