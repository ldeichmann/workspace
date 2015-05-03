package faustLinkedList;

import java.util.Iterator;

class Cursor<E extends Comparable<E>> implements Iterator<E> {
	private Zelle<E> z;
	private Zelle<E> anker;
	
	Cursor(Zelle<E> z) {
		this.z = z;
		this.anker = z;
	}

	// Navigation
	void goToFirst() {
		z = anker;
	}

	boolean atEnd() {
		return z.next == null;
	}

	void goToNext() {
		if (!atEnd())
			z = z.next;
	}

	void goTo(E e) {
		goToFirst();
		while (!atEnd() && e.compareTo(get()) != 0)
			goToNext();
	}

	// Listenmodifikation und Inspektion
	void add(E e) {
		z.next = new Zelle<E>(e, z.next);
		goToNext();
	}

	public void remove() {
		if (z.next != null)
			z.next = z.next.next;
	}

	E get() {
		return z.next.inhalt;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !atEnd();
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		goToNext();
		return get();
	}
}