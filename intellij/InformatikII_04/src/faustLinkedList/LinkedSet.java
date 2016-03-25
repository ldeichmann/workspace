package faustLinkedList;

import java.util.Iterator;

public class LinkedSet<E extends Comparable<E>> implements Set<E> {

    private List<E> internalLinkedList = new LinkedList<E>();

    @Override
    public int size() {
        return internalLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalLinkedList.isEmpty();
    }

    public boolean contains(E e) {
        return internalLinkedList.contains(e);
    }

    public boolean add(E e) {
        if (!contains(e)) {
            internalLinkedList.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(E e) {
        return internalLinkedList.remove(e);
    }

    @Override
    public void clear() {
        internalLinkedList.clear();
    }

    @Override
    public E getMatch(E e) {
        return internalLinkedList.getMatch(e);
    }

    @Override
    public Iterator iterator() {
        return (Iterator<E>) internalLinkedList.iterator();
    }
}