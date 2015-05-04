package faustLinkedList;

import java.util.Collection;
import faustLinkedList.LinkedList;
import java.util.Iterator;
import java.util.Set;


public class LinkedListSet<E extends Comparable<E>> implements Set<E> {

	private LinkedList<E> ll = new  LinkedList<E>();
	
	@Override
	public boolean add(E arg0) {
		if (!ll.contains(arg0)) {
			
			ll.add(arg0);
			return true;
			
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		boolean mod = false;
		for (E e: arg0) {
			
			if (add(e) == true) mod = true;
			
		}
		return mod;
	}

	@Override
	public void clear() {
		ll.clear();
	}

	@Override
	public boolean contains(Object arg0) {
//		System.out.println("CONTAINS " + arg0);
		return ll.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		boolean mod = false;
		for (Object e: arg0) {
			
			if (contains(e) != true) {
				mod = false;
				break;
			} else {
				mod = true;
			}
			
		}
		return mod;
	}

	@Override
	public boolean isEmpty() {
		return ll.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) ll.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return ll.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		boolean mod = false;
		for (Object e: arg0) {
			
			if (remove(e) != true) {
				mod = false;
				break;
			} else {
				mod = true;
			}
			
		}
		return mod;

	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return ll.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
