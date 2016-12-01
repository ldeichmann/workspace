package aufgabe2;

import java.io.*;
import java.util.*;

public class FindMaxWithObject {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Value[][] values = readData("data0.csv");
		System.out.println(values.length + " " + values[0].length);
		setNachbarn(values);
		ArrayList<int[]> labels = readLabel("label0.csv");
		List<Value> mylabel = findMax3(values, 40);
		fScore(labels, mylabel);

//		System.out.println(mylabel);
//		System.out.println(mylabel.size());
	}

	public static void printValues(Value[][] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				System.out.print(values[i][j].getVal() + " ");
			}
			System.out.println();
		}
	}

	public static aufgabe2.Value[][] readData(String file) throws NumberFormatException, IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str;
		String[] temp;
		int k = 0;
		Value[][] ret = new Value[800][1000];
		while ((str = br.readLine()) != null) {
			temp = str.split(",");
			for (int i = 0; i < temp.length; i++) {
				ret[k][i] = new Value(new int[] { k, i }, false, (new Double(temp[i])));
			}
			k++;
		}
		br.close();
		return ret;
	}

	public static double fScore(ArrayList<int[]> labels, List<Value> mylabels) {
		double correctLabels = 0;
		double recall;
		double precision;
		double fscore;
		for (Value i : mylabels) {
			for (int[] j : labels) {
				if (i.getPosition()[0] == j[1] && i.getPosition()[1] == j[0]) {
					correctLabels += 1;
					System.out.println("Found Label");
				}
			}
		}
		recall = correctLabels / labels.size();
		precision = correctLabels / mylabels.size();
		System.out.println("precision: " + precision + "recall: " + recall);
		fscore = 2 * precision * recall / (precision + recall);

		return fscore;
	}

	public static double fScoreInt(ArrayList<int[]> labels, ArrayList<int[]> mylabels) {
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
		System.out.println("precision: " + precision + "recall: " + recall);
		fscore = 2 * precision * recall / (precision + recall);

		return fscore;
	}

	public static void printLabels(ArrayList<int[]> list) {
		for (int[] i : list) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

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

	public static ArrayList<Value> findMaximas3(Value[][] values, int checkNeighbors){
		ArrayList<Value> ret = new ArrayList<Value>();
		Value current = values[0][0];
		int i = 0;
		int j = 0;
		int[] localmaxposition = null;
				while (current != null) {
					current = values[i][j];
					for (int k = 0; k < checkNeighbors; k++) {
						for (Value val : current.getNeighbors()) {
							if (!val.isUsed()) {
								val.setUsed(true);
								if (val.getVal() > current.getVal()) {
									current = val;
									localmaxposition = current.getPosition();
									i = current.getPosition()[0]+k;
									j = current.getPosition()[1]+k;
									k = 0;
								}
							}
						}
					}
					if (ret.size() == 0 && current != null) {
						System.out.println("Added: " + current.getVal() + " x: " + current.getPosition()[0] + " y: "
								+ current.getPosition()[1]);
						ret.add(current);
					} else if (localmaxposition != null) {
						boolean allreadyFound = false;
						for (Value v : ret) {
							if (v.getPosition()[0] == localmaxposition[0]
									&& v.getPosition()[1] == localmaxposition[1]) {
								allreadyFound = true;
								break;
							}
						}
						if (!allreadyFound) {
							System.out.println("Added: " + current.getVal() + " x: " + current.getPosition()[0] + " y: "
									+ current.getPosition()[1]);
							ret.add(current);
						}
					}
					for (int p = 0; p < values.length; p++) {
						for (int l = 0; l < values[0].length; l++) {
							if (!values[p][l].isUsed() && values[p][l].neighborsFree(values[p][l].getNeighbors())) {
								current = values[p][l];
								current.setUsed(true);
								break;
							} else {
								current = null;
							}
						}
						if (current != null) {
							break;
						}
					}
				}
		return ret;
	}

	public static ArrayList<Value> findMaximas2(Value[][] values, int checkNeighbors) {
		ArrayList<Value> ret = new ArrayList<Value>();
		Value current = values[0][0];
		int i;
		int j;
		int[] localmaxposition = null;
		do {
			for (int k = 0; k < checkNeighbors; k++) {
				while(k != checkNeighbors){
					i=current.getPosition()[0];
					j=current.getPosition()[1];
					if ((i - k) >= 0 && (j - k) >= 0 && (i - k) < values.length && (j - k) < values[0].length
						&& !values[i - k][j - k].isUsed()) {
					values[i - k][j - k].setUsed(true);
					if (values[i - k][j - k].getVal() > current.getVal()) {// oben
																			// links
						current = values[i - k][j - k];
						localmaxposition = current.getPosition();
							for(Value n : current.getNeighbors()){
								n.setUsed(true);
							}
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				if (i >= 0 && (j - k) >= 0 && i < values.length && (j - k) < values[0].length
						&& !values[i][j - k].isUsed()) {
					values[i][j - k].setUsed(true);
					// System.out.println("Benutzte: "+values[i][j -
					// k].position[0]+" "+values[i][j -
					// k].getPosition()[1]);
					if (values[i][j - k].getVal() > current.getVal()) { // über
						current = values[i][j - k];
						localmaxposition = current.getPosition();
						for(Value n : current.getNeighbors()){
							n.setUsed(true);
						}
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				if ((i + k) >= 0 && (j - k) >= 0 && (i + k) < values.length && (j - k) < values[0].length
						&& !values[i + k][j - k].isUsed()) {
					values[i + k][j - k].setUsed(true);
					// System.out.println("Benutzte: "+values[i + k][j -
					// k].position[0]+" "+values[i + k][j -
					// k].getPosition()[1]);
					if (values[i + k][j - k].getVal() > current.getVal()) { //
						current = values[i + k][j - k];
						localmaxposition = current.getPosition();
						for(Value n : current.getNeighbors()){
							n.setUsed(true);
						}
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				if ((i + k) >= 0 && j >= 0 && (i + k) < values.length && j < values[0].length
						&& !values[i + k][j].isUsed()) {
					values[i + k][j].setUsed(true);
					// System.out.println("Benutzte: "+values[i +
					// k][j].position[0]+" "+values[i +
					// k][j].getPosition()[1]);
					if (values[i + k][j].getVal() > current.getVal()) {
						current = values[i + k][j];
						for(Value n : current.getNeighbors()){
							n.setUsed(true);
						}
						localmaxposition = current.getPosition();
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				if ((i + k) >= 0 && (j + k) >= 0 && (i + k) < values.length && (j + k) < values[0].length
						&& !values[i + k][j + k].isUsed()) {
					values[i + k][j + k].setUsed(true);
					// System.out.println("Benutzte: "+values[i + k][j +
					// k].position[0]+" "+values[i + k][j +
					// k].getPosition()[1]);
					if (values[i + k][j + k].getVal() > current.getVal()) {
						current = values[i + k][j + k];
						localmaxposition = current.getPosition();
						for(Value n : current.getNeighbors()){
							n.setUsed(true);
						}
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				if (i >= 0 && (j + k) >= 0 && i < values.length && (j + k) < values[0].length
						&& !values[i][j + k].isUsed()) {
					values[i][j + k].setUsed(true);
					// System.out.println("Benutzte: "+values[i][j +
					// k].position[0]+" "+values[i][j +
					// k].getPosition()[1]);
					if (values[i][j + k].getVal() > current.getVal()) {
						current = values[i][j + k];
						localmaxposition = current.getPosition();
						for(Value n : current.getNeighbors()){
							n.setUsed(true);
						}
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				if ((i - k) >= 0 && (j + k) >= 0 && (i - k) < values.length && (j + k) < values[0].length
						&& !values[i - k][j + k].isUsed()) {
					values[i - k][j + k].setUsed(true);
					// System.out.println("Benutzte: "+values[i - k][j +
					// k].position[0]+" "+values[i - k][j +
					// k].getPosition()[1]);
					if (values[i - k][j + k].getVal() > current.getVal()) {
						current = values[i - k][j + k];
						localmaxposition = current.getPosition();
						for(Value n : current.getNeighbors()){
							n.setUsed(true);
						}
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				if ((i - k) >= 0 && j >= 0 && (i - k) < values.length && j < values[0].length
						&& !values[i - k][j].isUsed()) {
					values[i - k][j].setUsed(true);
					// System.out.println("Benutzte: "+values[i -
					// k][j].position[0]+" "+values[i -
					// k][j].getPosition()[1]);
					if (values[i - k][j].getVal() > current.getVal()) {
						current = values[i - k][j];
						localmaxposition = current.getPosition();
						for(Value n : current.getNeighbors()){
							n.setUsed(true);
						}
						i = current.getPosition()[0];
						j = current.getPosition()[1];
						k = 0;
						break;
					}
				}
				k++;
				}
			}
			if (ret.size() == 0 && current != null) {
				System.out.println("Added: " + current.getVal() + " x: " + current.getPosition()[0] + " y: "
						+ current.getPosition()[1]);
				ret.add(current);
			} else if (localmaxposition != null) {
				boolean allreadyFound = false;
				for (Value v : ret) {
					if (v.getPosition()[0] == localmaxposition[0]
							&& v.getPosition()[1] == localmaxposition[1]) {
						allreadyFound = true;
						break;
					}
				}
				if (!allreadyFound) {
					System.out.println("Added: " + current.getVal() + " x: " + current.getPosition()[0] + " y: "
							+ current.getPosition()[1]);
					ret.add(current);
				}
			}
			current = getNextVal(values);
			if (current == null) {
				break;
			}
		} while (true);
		return ret;
	}
	
	public static Value getNextVal(Value[][] values){
		Value ret = null;
		for (int p = 0; p < values.length; p++) {
			for (int l = 0; l < values[0].length; l++) {
				if (!values[p][l].isUsed()) {
					ret = values[p][l];
					return ret;
				} 
			}
		}
		return ret;
	}

	public static ArrayList<Value> findMaximas(Value[][] values, int checkNeighbors) {
		ArrayList<Value> ret = new ArrayList<Value>();
		double current = 0;
		int[] savecurrentposition;
		int[] localmaxposition = null;
		Stack<int[]> temp = new Stack<int[]>();

		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				savecurrentposition = new int[] { i, j };

				current = values[i][j].getVal();
				for (int k = 0; k < checkNeighbors; k++) {
					if ((i - k) >= 0 && (j - k) >= 0 && (i - k) < values.length - 1 && (j - k) < values[0].length - 1
							&& !values[i - k][j - k].isUsed()) {
						values[i - k][j - k].setUsed(true);
						// System.out.println("Benutzte: "+values[i - k][j -
						// k].position[0]+" "+values[i - k][j -
						// k].getPosition()[1]);
						if (values[i - k][j - k].getVal() > current) {// oben
																		// links
							current = values[i - k][j - k].getVal();
							localmaxposition = values[i - k][j - k].getPosition();
							i = i - k;
							j = j - k;
							k = 0;
							// break;
						}
					}
					if (i >= 0 && (j - k) >= 0 && i < values.length - 1 && (j - k) < values[0].length - 1
							&& !values[i][j - k].isUsed()) {
						values[i][j - k].setUsed(true);
						// System.out.println("Benutzte: "+values[i][j -
						// k].position[0]+" "+values[i][j -
						// k].getPosition()[1]);
						if (values[i][j - k].getVal() > current) { // über
							current = values[i][j - k].getVal();
							localmaxposition = values[i][j - k].getPosition();
							j = j - k;
							k = 0;
							// break;
						}
					}
					if ((i + k) >= 0 && (j - k) >= 0 && (i + k) < values.length - 1 && (j - k) < values[0].length - 1
							&& !values[i + k][j - k].isUsed()) {
						values[i + k][j - k].setUsed(true);
						// System.out.println("Benutzte: "+values[i + k][j -
						// k].position[0]+" "+values[i + k][j -
						// k].getPosition()[1]);
						if (values[i + k][j - k].getVal() > current) { //
							current = values[i + k][j - k].getVal();
							localmaxposition = values[i + k][j - k].getPosition();
							i = i + k;
							j = j - k;
							k = 0;
							// break;
						}
					}
					if ((i + k) >= 0 && j >= 0 && (i + k) < values.length - 1 && j < values[0].length - 1
							&& !values[i + k][j].isUsed()) {
						values[i + k][j].setUsed(true);
						// System.out.println("Benutzte: "+values[i +
						// k][j].position[0]+" "+values[i +
						// k][j].getPosition()[1]);
						if (values[i + k][j].getVal() > current) {
							current = values[i + k][j].getVal();
							localmaxposition = values[i + k][j].getPosition();
							i = i + k;
							k = 0;
							// break;
						}
					}
					if ((i + k) >= 0 && (j + k) >= 0 && (i + k) < values.length - 1 && (j + k) < values[0].length - 1
							&& !values[i + k][j + k].isUsed()) {
						values[i + k][j + k].setUsed(true);
						// System.out.println("Benutzte: "+values[i + k][j +
						// k].position[0]+" "+values[i + k][j +
						// k].getPosition()[1]);
						if (values[i + k][j + k].getVal() > current) {
							current = values[i + k][j + k].getVal();
							localmaxposition = values[i + k][j + k].getPosition();
							i = i + k;
							j = j + k;
							k = 0;
							// break;
						}
					}
					if (i >= 0 && (j + k) >= 0 && i < values.length - 1 && (j + k) < values[0].length - 1
							&& !values[i][j + k].isUsed()) {
						values[i][j + k].setUsed(true);
						// System.out.println("Benutzte: "+values[i][j +
						// k].position[0]+" "+values[i][j +
						// k].getPosition()[1]);
						if (values[i][j + k].getVal() > current) {
							current = values[i][j + k].getVal();
							localmaxposition = values[i][j + k].getPosition();
							j = j + k;
							k = 0;
							// break;
						}
					}
					if ((i - k) >= 0 && (j + k) >= 0 && (i - k) < values.length - 1 && (j + k) < values[0].length - 1
							&& !values[i - k][j + k].isUsed()) {
						values[i - k][j + k].setUsed(true);
						// System.out.println("Benutzte: "+values[i - k][j +
						// k].position[0]+" "+values[i - k][j +
						// k].getPosition()[1]);
						if (values[i - k][j + k].getVal() > current) {
							current = values[i - k][j + k].getVal();
							localmaxposition = values[i - k][j + k].getPosition();
							i = i - k;
							j = j + k;
							k = 0;
							// break;
						}
					}
					if ((i - k) >= 0 && j >= 0 && (i - k) < values.length - 1 && j < values[0].length - 1
							&& !values[i - k][j].isUsed()) {
						values[i - k][j].setUsed(true);
						// System.out.println("Benutzte: "+values[i -
						// k][j].position[0]+" "+values[i -
						// k][j].getPosition()[1]);
						if (values[i - k][j].getVal() > current) {
							current = values[i - k][j].getVal();
							localmaxposition = values[i - k][j].getPosition();
							i = i - k;
							k = 0;
							// break;
						}
					}
				}
				if (localmaxposition != null) {
					boolean allreadyFound = false;
					if (ret.size() <= 0)
						ret.add(values[localmaxposition[0]][localmaxposition[1]]);
					for (Value check : ret) {
						if (check.equals(values[localmaxposition[0]][localmaxposition[1]])) {
							// System.out.println("Position schon
							// hinzugefüght");
							i = savecurrentposition[0];
							j = savecurrentposition[1];
							allreadyFound = true;
							break;
						}
					}
					if (!allreadyFound) {
						ret.add(values[localmaxposition[0]][localmaxposition[1]]);
						System.out.println("Added: " + values[localmaxposition[0]][localmaxposition[1]].getVal());
					}
				}
				i = savecurrentposition[0];
				j = savecurrentposition[1];
			}
		}
		return ret;
	}

	public static ArrayList<int[]> ranCoordinate(Value[][] matrix, int runs) {
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
	
	public static void setNachbarn(Value[][] values) {
		Value[] temp;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				// *************************Fall für oben Links in der
				// Matrix*********************************
				if (i == 0 && j == 0) {
					temp = new Value[] { values[i + 1][j], values[i + 1][j + 1], values[i][j + 1] };
					// System.out.println("posi 0,0 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für unten Links in der
				// Matrix*********************************
				else if (i == 0 && j == values[0].length - 1) {
					temp = new Value[] { values[i][j - 1], values[i + 1][j - 1], values[i + 1][j] };
					// System.out.println("posi 0,999 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für unten Rechts in der
				// Matrix*********************************
				else if (i == values.length - 1 && j == values[0].length - 1) {
					temp = new Value[] { values[i][j - 1], values[i - 1][j - 1], values[i - 1][j] };
					// System.out.println("posi 799,999 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für oben Rechts in der
				// Matrix*********************************
				else if (i == values.length - 1 && j == 0) {
					temp = new Value[] { values[i - 1][j], values[i - 1][j + 1], values[i][j + 1] };
					// System.out.println("posi 799,0 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für links in der
				// Matrix*********************************
				else if (i == 0 && j > 0 && j < values[0].length - 1) {
					temp = new Value[] { values[i][j - 1], values[i + 1][j - 1], values[i + 1][j], values[i + 1][j + 1],
							values[i][j + 1] };
					// System.out.println("posi 0,1-998 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für rechts in der
				// Matrix*********************************
				else if (i == values.length - 1 && j > 0 && j < values[0].length - 1) {
					temp = new Value[] { values[i][j - 1], values[i - 1][j - 1], values[i - 1][j], values[i - 1][j + 1],
							values[i][j + 1] };
					// System.out.println("posi 799,1-998 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für oben in der
				// Matrix*********************************
				else if (i > 0 && i < values.length - 1 && j == 0) {
					temp = new Value[] { values[i - 1][j], values[i - 1][j + 1], values[i][j + 1], values[i + 1][j + 1],
							values[i + 1][j] };
					// System.out.println("posi 1-798,0 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für unten in der
				// Matrix*********************************
				else if (i > 0 && i < values.length - 1 && j == values[0].length - 1) {
					temp = new Value[] { values[i - 1][j], values[i - 1][j - 1], values[i][j - 1], values[i + 1][j - 1],
							values[i + 1][j] };
					// System.out.println("posi 1-798,999 gesetzt");
					values[i][j].setNachbarn(temp);
					// break;
				}
				// *************************Fall für in der
				// Matrix*********************************
				else if (i > 0 && i < values.length - 1 && j > 0 && j < values[0].length) {
					temp = new Value[] { values[i - 1][j - 1], values[i][j - 1], values[i + 1][j - 1], values[i + 1][j],
							values[i + 1][j + 1], values[i][j + 1], values[i - 1][j + 1], values[i - 1][j] };
					// System.out.println("posi 1-798,1-998 gesetzt");
					values[i][j].setNachbarn(temp);
				}
			}
		}
		return;
	}

	public static Value findMaxNeighbour(Value[][] values, Value center, int range) {

	    Value max = center;

	    for (int i = 1; i <= range; i++) {
            List<Value> neighbours = center.getNeighbours(values, i);
            for (Value n: neighbours) {
                if (max == null) {
                    if (!n.isUsed()) {
                        max = n;
                    }
                } else {
                    if (!n.isUsed()) {
                        n.setUsed(true);
                        if (n.getVal() > max.getVal()) {
                            max = n;
                        }
                    }
                }
            }
        }

        return max;
    }

	public static List<Value> findMax3(Value[][] values, int neighbourRange) {
	    List<Value> returnList = new ArrayList<>();
        Value currentMax = null;

	    for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {

                Value current = values[i][j];
                Value new_max = null;
                if (current.isUsed()) {
                    continue;
                }

                if (currentMax == null) {
                    currentMax = findMaxNeighbour(values, current, neighbourRange);
                }

                while (currentMax != new_max && currentMax != null) {
                	if (new_max != null) {
						currentMax = new_max;
					}
                    new_max = findMaxNeighbour(values, currentMax, neighbourRange);
                	if (new_max == null) {
                		break;
					}
//                	System.out.println("new_max " + new_max + " currentMax " + currentMax);
                }

                System.out.println("Adding " + currentMax);
                returnList.add(currentMax);
                currentMax = null;
            }

        }

	    return returnList;
    }
}
