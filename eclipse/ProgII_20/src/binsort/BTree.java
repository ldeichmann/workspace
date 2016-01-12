package binsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BTree<T extends Comparable<T>> {
	
	/**
	 * binsort given list
	 * @param is
	 * @return
	 */
	public static <T extends Comparable<T>> List<T> bsort(List<T> is) {
		BTree<T> tree = new BTree<T>(is);
		List<T> sl = tree.buildInOrderList(tree);
		return sl;
	}
	/**
	 * Wert des Knotens.
	 */
	private T value;

	/**
	 * Verweis auf den linken Ast des Knotens.
	 */
	private BTree<T> left;

	/**
	 * Verweis auf den rechten Ast des Knotens.
	 */
	private BTree<T> right;

	/**
	 * Konstruktor zum Erzeugen eines Wurzelnotens mit dem Wert v. Der linke und
	 * rechte Teilast dieses Binaerbaums sind immer null.
	 * 
	 * @param v
	 */
	public BTree(final T v) {
		this.value = v;
	}
	/**
	 * Liefert den Wert des Knotens.
	 * 
	 * @return Wert des Knotens.
	 */
	public T value() {
		return this.value;
	}
	/**
	 * Liefert den linken Ast des Knotens.
	 * 
	 * @return Linker Ast
	 */
	public BTree<T> getLeft() {
		return this.left;
	}

	/**
	 * Haengt einen Baum unter den linken Ast.
	 * 
	 * @param tree
	 *            Baum der unter den linken Ast gehaengt werden soll
	 */
	public void setLeft(final BTree<T> tree) {
		this.left = tree;
	}

	/**
	 * Liefert den rechten Ast des Knotens.
	 * 
	 * @return Rechter Ast
	 */
	public BTree<T> getRight() {
		return this.right;
	}

	/**
	 * Haengt einen Baum unter den rechten Ast.
	 * 
	 * @param tree
	 *            Baum der unter den rechten Ast gehaengt werden soll
	 */
	public void setRight(final BTree<T> tree) {
		this.right = tree;
	}
		
	/**
	 * Konstruktur zum Erzeugen eines sortierten Binaerbaums aus einer Liste.
	 * 
	 * @param list
	 *            Liste von Werten aus denen der sortierte Binaerbaum gebildet
	 *            werden soll
	 */
	public BTree(final List<T> list) {
		Random rand = new Random();

		if (list.size() == 0) return;
		
		List<T> insert = new LinkedList<T>(list);
		//this.value = insert.remove(0);
		
		
		// don't accept null as initial value
		Iterator<T> it = insert.iterator();
		while (it.hasNext()) {
			T t = it.next();
			if (t != null) {
				this.value = t;
				insert.remove(t);
				break;
			}
		}

///		System.out.println("dasd " + insert);
		
		// Wir durchlaufen die Liste in zufaelliger Reihenfolge,
		// um ggf. bereits vorsortierte Listen zu durchbrechen
		// und so die Leistungsfaehigkeit des BinSort (im Mittel) zu erhalten.
		while (!insert.isEmpty()) {
			T v = insert.remove(rand.nextInt(insert.size()));
			this.insert(this, v);
		}
	}
	
	/**
	 * Insert element into tree
	 * @param tree branch
	 * @param element element to be added
	 */
	public void insert(BTree<T> tree, T element) {
		if (element == null) return;
		if (element.compareTo(this.value()) <= 0) {
			if (this.getLeft() == null) {
				this.setLeft(new BTree<T>(element));
			} else {
				this.getLeft().insert(this.getLeft(), element);
			}
		}

		if (element.compareTo(this.value()) > 0) {
			if (this.getRight() == null) {
				this.setRight(new BTree<T>(element));
			}

			else {
				this.getRight().insert(this.getRight(), element);
			}

		}
	}
	
	/**
	 * Generate ascending List from given tree
	 * @param tree root
	 * @return Sorted List
	 */
	public List<T> buildInOrderList(BTree<T> tree) {
		List<T> ret = new LinkedList<T>();
		if (this.getLeft() != null) {
			ret.addAll(this.getLeft().buildInOrderList(this.getLeft()));
		}
		if (this.value() != null) {
			ret.add(this.value());
		}
		if (this.getRight() != null) {
			ret.addAll(this.getRight().buildInOrderList(this.getRight()));
		}
		return ret;		
	}
}