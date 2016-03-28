package LinkedListMultiset;

public interface Entry<E> extends Comparable<Entry<E>> {
    E getElement();
    int getCount();
    void incCount();
    void decCount();
    String toString();
}
