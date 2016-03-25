package LinkedListMultiset;

import faustLinkedList.Collection;

public interface Multiset<E> extends Collection<E> {
    int count(E element); //liefert die Häufigkeit des Elementes
    int distinct(); // liefert die Anzahl der verschiedenen Elemente
    String toString(); // liefert eine Stringrepräsentation der Multimenge
}