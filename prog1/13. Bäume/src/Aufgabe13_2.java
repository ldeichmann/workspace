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

/**
 * @author lukas
 *
 */
public class Aufgabe13_2 {



	/**
	 * Counts nodes in given Node n
	 * @param n Node to count all nodes for
	 * @return amount of nodes in n
	 */
	public static int countNodes(Node n) {
		
		if (n == null) { return 0; };
		
		return 1 + countNodes(n.left) + countNodes(n.right);
		
	}
	
	/**
	 * Counts edges in given Node n
	 * @param n Node to count all edges for
	 * @return amount of edges in n
	 */
	public static int countEdges(Node n) {
		
		if (n == null) { return 0; };
		
		return ((n.left != null) ? 1 : 0) + ((n.right != null) ? 1 : 0) + countEdges(n.left) + countEdges(n.right);
		
	}
	
	/**
	 * Returns height of Node n
	 * @param n Node to get height for
	 * @return height of node
	 */
	public static int height(Node n) {
		
		if (n == null) { return 0; };

		return 1 + Math.max(height(n.left), height(n.right));
		
	}
	
	public static void main(String args[]) {
		
		Node tree = new Node(5,
				new Node(3,
					new Node(1, null, null),
					new Node(4, null, null)
				),
				new Node(8,
					new Node(6, null, null),
					new Node(9, null, null)
				)
			);
		
		System.out.println(countNodes(tree));
		System.out.println(countEdges(tree));
		System.out.println(height(tree));
		
	}
	
}
