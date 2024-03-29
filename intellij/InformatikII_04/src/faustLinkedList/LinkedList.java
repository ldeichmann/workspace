package faustLinkedList;

import java.util.Iterator;

class LinkedList<E extends Comparable<E>> implements List<E>{
	private Zelle<E> anker = new Zelle<E>(null, null);
	private Cursor<E> cursor = new Cursor<E>(anker);

	int cnt = 0;

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
		cursor.goToFirst();
		while (cursor.hasNext()) {
			
			cursor.remove();
			
		}
		
	}

	public boolean contains(E e) {
		cursor.goToFirst();
		while (cursor.hasNext()) {

			if (e.compareTo(cursor.get()) == 0) {
				return true;
			}
			cursor.next();
		}
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		cursor.goToFirst();
		return cursor.hasNext();
	}

	public boolean remove(E e) {
		cursor.goTo(e);
		E f = cursor.get();
		cursor.remove();
		return true;
	}

	public int size() {
		int i = 0;
		cursor.goToFirst();
		while (cursor.hasNext()) {
			i++;
			cursor.next();
		}		
		return i;
	}
	
	LinkedList() {

	}
	
	@Override
	public E getMatch(E e) {
		
		cursor.goToFirst();
		while (cursor.hasNext()) {
			
			if (e.compareTo(cursor.get()) == 0) {
				return cursor.get();
			}
			cursor.next();
		}
		
		return null;
	}

}