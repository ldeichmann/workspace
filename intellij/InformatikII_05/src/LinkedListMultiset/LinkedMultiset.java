package LinkedListMultiset;

import faustLinkedList.LinkedSet;
import faustLinkedList.Set;

import java.util.Iterator;

public class LinkedMultiset<E extends Comparable<E>> implements Multiset<E> {

    private Set<Entry<E>> s = new LinkedSet<Entry<E>>();
    private int wordCount = 0;

    @Override
    public int count(E e) {
        return s.getMatch(new EntryImpl<E>(e)).getCount();
    }

    @Override
    public int distinct() {
        return s.size();
    }

    @Override
    public int size() {
        return wordCount;
    }

    @Override
    public boolean isEmpty() {
        return (s.size() > 0);
    }

    @Override
    public boolean contains(E e) {
        return s.contains(new EntryImpl<E>(e));
    }

    @Override
    public boolean add(E e) {
        Entry<E> temp = new EntryImpl<E>(e);
        if (s.contains(temp)) {
            wordCount++;
            s.getMatch(temp).incCount();
            return true;
        } else {
            wordCount++;
            s.add(temp);
            return true;
        }
    }

    @Override
    public boolean remove(E e) {
        Entry<E> temp = new EntryImpl<E>(e);
        if(s.contains(temp)) {
            temp = s.getMatch(temp);
            temp.decCount();
            if(temp.getCount() == 0) {
                s.remove(temp);
            }
            wordCount--;
            return true;
        }

        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E getMatch(E e) {
        Entry<E> temp = new EntryImpl<E>(e);
        return s.getMatch(temp).getElement();
    }

    @Override
    public Iterator iterator() {
        return null; // fuck this
    }
}
