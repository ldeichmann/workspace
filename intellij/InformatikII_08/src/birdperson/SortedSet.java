package birdperson;

import faustLinkedList.Set;

public interface SortedSet<E> extends Set<E> {
    E findMin();

    E findMax();
}
