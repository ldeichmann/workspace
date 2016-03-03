import java.util.LinkedList;
import java.util.List;

class Node {
	public Node left;
	public Node right;
	public int value;
	public Node(int v, Node l, Node r) {
		value = v;
		left = l;
		right = r;
	}
	public String toString() {
		return value + " ";
	}
}

public class Aufgabe14_2 {

	/**
	 * Inserts values into node
	 * @param v value to be inserted
	 * @param tree Node to be inserted under
	 */
	public static void insert(int v, Node tree) {
		if(tree == null) return;
		if(tree.value == v) return;
		
		if(v < tree.value) {
			if(tree.left == null) {
				tree.left = new Node(v, null,null);
			} else
				insert(v,tree.left);
		}
		
		if(v > tree.value) {
			if(tree.right == null) {
				tree.right = new Node(v,null,null);
			} else
				insert(v,tree.right);
		}
	}
	
	/**
	 * Binary sorts a given list of integers
	 * @param vs given list
	 * @return sorted List
	 */
	public static List<Integer> binSort(List<Integer> vs) {
		
		Node tree = new Node(vs.remove(0), null, null);
		for(int i : vs) {
			insert(i, tree);
		}
		return inorder(tree);
		
	}
	
	/**
	 * Converts Binary tree into list
	 * @param tree to be converted
	 * @return List of binary tree
	 */
	public static List<Integer> inorder(Node tree) {
		
		List<Integer> liste = new LinkedList<Integer>();
		if (tree == null) { return liste; };

		liste.addAll(inorder(tree.left));
		liste.add(tree.value);
		liste.addAll(inorder(tree.right));
		return liste;
		
	}
	
	public static void main(String args[]) {
		
		List<Integer> liste = new LinkedList<Integer>();
		for (int j = 1; j <= 10; j++) {
			liste.add((int)(100000 * Math.random()));
		}
		System.out.println(liste);
		System.out.println(binSort(liste));

		for (int i : binSort(liste)) {
			System.out.println(i);
		}
		
	}
	
}
