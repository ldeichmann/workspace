package faustLinkedList;

public interface Collection<E> extends Iterable<E> {
	int size(); // fehlt noch!

	boolean isEmpty(); // fehlt noch!

	boolean contains(E e); // fehlt noch!

	boolean add(E e);

	boolean remove(E e);

	void clear(); // löscht alle Elemente; fehlt noch!

	/**
	 * getMatch is not part of standard Java. Like contains, it checks if e is
	 * in the set. If it is, it returns the reference to the matching object;
	 * otherwise it returns null.
	 * 
	 * @param e
	 *            the object to search for.
	 * @return if contains(e) is false, the return value is null; otherwise, the
	 *         return value is the object that causes contains(e) to return
	 *         true.
	 */
	E getMatch(E e); // fehlt noch!
}