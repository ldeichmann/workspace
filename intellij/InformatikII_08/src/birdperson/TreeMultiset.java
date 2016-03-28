package birdperson;

import LinkedListMultiset.Multiset;

import java.util.Iterator;
import LinkedListMultiset.Entry;
import LinkedListMultiset.EntryImpl;
import faustLinkedList.Set;

public class TreeMultiset<E extends Comparable<E>> implements Multiset<E> {

    private int size;
    private Set<Entry<E>> storageTree;

    TreeMultiset() {
        storageTree = new SuchBaum<>();
    }

    @Override
    public int count(E element) {
        return storageTree.getMatch(new EntryImpl<>(element)).getCount();
    }

    @Override
    public int distinct() {
        return storageTree.size();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(E e) {
        return storageTree.contains(new EntryImpl<>(e));
    }

    @Override
    public boolean add(E e) {
        Entry<E> entry = new EntryImpl<>(e);
        if (storageTree.add(entry)) {
            size++;
            return true;
        } else {
            storageTree.getMatch(entry).incCount();
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(E e) {
        Entry<E> entry = new EntryImpl<>(e);
        Entry<E> match = storageTree.getMatch(entry);
        if (match.getElement().equals(e)) { // TODO really necessary?
            if (match.getCount() > 1) {
                match.decCount();
                size--;
                return true;
            } else {
                storageTree.remove(entry);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        storageTree.clear();
    }

    @Override
    public E getMatch(E e) {
        Entry<E> entry = new EntryImpl<>(e);
        Entry<E> match = storageTree.getMatch(entry);
        return match == null ? null : match.getElement();
    }

    @Override
    public Iterator<E> iterator() { // fuck off.
        return null;
    }

    public String toString() {
        return storageTree.toString();
    }
}
