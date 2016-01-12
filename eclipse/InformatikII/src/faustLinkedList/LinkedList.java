package faustLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class LinkedList<E extends Comparable<E>> implements List<E> {
	private Zelle<E> anker = new Zelle<E>(null, null);
	private Cursor<E> cursor = new Cursor<E>(anker);

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

//	public boolean contains(E e) {
//		cursor.goToFirst();
//		while (cursor.hasNext()) {
//			
//			if (cursor.get().equals(e)) {
//				return true;
//			}
//			cursor.next();
//		}
//		return false;
//	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		cursor.goToFirst();
		return cursor.hasNext();
	}

	public E remove(E e) {
		cursor.goTo(e);
		E f = cursor.get();
		cursor.remove();
		return f;
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
	
	E getMatch(E e) {
		
		cursor.goToFirst();
		while (cursor.hasNext()) {
			
			if (cursor.get().equals(e)) {
				return cursor.get();
			}
			cursor.next();
		}
		
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		cursor.goToFirst();
		while (cursor.hasNext()) {
			
			if (cursor.get().equals(o)) {
				return true;
			}
			cursor.next();
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}