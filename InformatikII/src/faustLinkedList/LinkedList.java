package faustLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class LinkedList<E extends Comparable<E>> implements List<E> {
	private Zelle<E> anker;
	private Cursor<E> cursor;

	public void goToFirst() {
		cursor.goToFirst();
	}

	public void goToNext() {
		cursor.goToNext();
	}

	public boolean atEnd() {
		return cursor.atEnd();
	}

	public boolean add(E e) {
		cursor.add(e);
		return true;
	}

	public boolean remove() {
		if (cursor.atEnd())
			return false;
		else {
			cursor.remove();
			return true;
		}
	}

	public void goTo(E e) {
		cursor.goTo(e);
	}

	public E get() {
		if (cursor.atEnd())
			return null;
		else
			return cursor.get();
	}

	public Iterator<E> iterator() {
		return new Cursor<E>(anker);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public E remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	E getMatch(E e) {
		
		return null;
	}
}