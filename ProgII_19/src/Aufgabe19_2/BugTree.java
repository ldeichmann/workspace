package Aufgabe19_2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Ein BugTree Objekt dient zur Repraesentation von Binaerbaeumen. Aus mehreren
 * Knoten kann ein Binaerbaum gebildet werden. Ein Knoten in einem Binaerbaum
 * hat einen Wert value, sowie einen linken Ast left und einen rechten Ast
 * right. Der Wert eines Knotens kann von beliebigem Typ sein, muss aber mittels
 * der Schnittstelle Comparable verglichen werden koennen. Binaerbaeume koennen
 * mit den Methoden ascending und descending in Listen serialisiert werden, in
 * dem der Binaerbaum inorder nach dem Schema LKR bzw. RKL durchlaufen wird.
 * 
 * @author Nane Kratzke
 */
public class BugTree<T extends Comparable<T>> {
	/**
	 * Wert des Knotens.
	 */
	private T value;

	/**
	 * Verweis auf den linken Ast des Knotens.
	 */
	private BugTree<T> left;

	/**
	 * Verweis auf den rechten Ast des Knotens.
	 */
	private BugTree<T> right;

	/**
	 * Konstruktor zum Erzeugen eines Wurzelnotens mit dem Wert v. Der linke und
	 * rechte Teilast dieses Binaerbaums sind immer null.
	 * 
	 * @param v
	 */
	public BugTree(final T v) {
		this.value = v;
	}

	/**
	 * Konstruktur zum Erzeugen eines sortierten Binaerbaums aus einer Liste.
	 * 
	 * @param list
	 *            Liste von Werten aus denen der sortierte Binaerbaum gebildet
	 *            werden soll
	 */
	public BugTree(final List<T> list) {
		Random rand = new Random();

		if (list.size() == 0) return;
		
		List<T> insert = list;
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
			this.insert(v);
		}
	}

	/**
	 * Liefert den linken Ast des Knotens.
	 * 
	 * @return Linker Ast
	 */
	public BugTree<T> getLeft() {
		return this.left;
	}

	/**
	 * Haengt einen Baum unter den linken Ast.
	 * 
	 * @param tree
	 *            Baum der unter den linken Ast gehaengt werden soll
	 */
	public void setLeft(final BugTree<T> tree) {
		this.left = tree;
	}

	/**
	 * Liefert den rechten Ast des Knotens.
	 * 
	 * @return Rechter Ast
	 */
	public BugTree<T> getRight() {
		return this.right;
	}

	/**
	 * Haengt einen Baum unter den rechten Ast.
	 * 
	 * @param tree
	 *            Baum der unter den rechten Ast gehaengt werden soll
	 */
	public void setRight(final BugTree<T> tree) {
		this.right = tree;
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
	 * Serialisiert einen Binaerbaum in eine lineare Liste in dem der Binaerbaum
	 * inorder (LKR) durchlaufen wird.
	 * 
	 * @param tree
	 *            Zu serialisierender Binaerbaum
	 * @return Aus Binaerbaum serialisierte Liste von Werten nach dem LKR
	 *         Durchlauf
	 */
	public List<T> ascending() {
		List<T> ret = new LinkedList<T>();
		if (this.getLeft() != null) {
			ret.addAll(this.getLeft().ascending());
		}
		if (this.value() != null) {
			ret.add(this.value());
		}
		if (this.getRight() != null) {
			ret.addAll(this.getRight().ascending());
		}
		return ret;
	}

	/**
	 * Serialisiert einen Binaerbaum in eine sortierte lineare Liste in dem der
	 * Binaerbaum inorder (RKL) durchlaufen wird.
	 * 
	 * @param tree
	 *            Zu serialisierender Binaerbaum
	 * @return Aus Binaerbaum serialisierte Liste von Werten nach dem RKL
	 *         Durchlauf
	 */
	public List<T> descending() {
		List<T> ret = new LinkedList<T>();
		if (this.getRight() != null) {
			ret.addAll(this.getRight().descending());
		}
		if (this.value() != null) {
			ret.add(this.value());
		}
		if (this.getLeft() != null) {
			ret.addAll(this.getLeft().descending());
		}
		return ret;
	}

	/**
	 * Fuegt den Wert v in den Binaerbaum ein.
	 * 
	 * @param v
	 *            Einzufuegender Wert
	 */
	public void insert(final T v) {
		//
		if (v == null) return;
		//
		if (v.compareTo(this.value()) < 0) {
			if (this.getLeft() == null) {
				this.setLeft(new BugTree<T>(v));
			} else {
				this.getLeft().insert(v);
			}
		}

		if (v.compareTo(this.value()) > 0) {
			if (this.getRight() == null) {
				this.setRight(new BugTree<T>(v));
			}

			else {
				this.getRight().insert(v);
			}

		}
		//
		if (v.compareTo(this.value()) == 0) {
			if (this.getLeft() == null) {
				this.setLeft(new BugTree<T>(v));
			} else {
				this.getLeft().insert(v);
			}
		}
		//


	}

}