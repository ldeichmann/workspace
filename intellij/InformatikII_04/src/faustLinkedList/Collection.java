package faustLinkedList;

public interface Collection<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(E e);
    boolean add(E e);
    boolean remove(E e);
    void clear();
    E getMatch(E e);
}