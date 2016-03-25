package faustLinkedList;

public interface List<E> extends Collection<E>{
    E get();
    boolean remove();
    void goToFirst();
    void goToNext();
    boolean atEnd();
}
