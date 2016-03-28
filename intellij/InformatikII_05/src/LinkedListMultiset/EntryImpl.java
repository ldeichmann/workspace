package LinkedListMultiset;

public class EntryImpl<E extends Comparable> implements Entry<E> {

    private E element;
    private int count;

    public EntryImpl(E e) {
        this.element = e;
        this.count = 1;
    }

    @Override
    public E getElement() {
        return this.element;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void incCount() {
        this.count++;
    }

    @Override
    public void decCount() {
        this.count--;
    }

    @Override
    public int compareTo(Entry<E> e) {
        return this.element.compareTo(e.getElement());
    }

    @Override
    public String toString() {
        return this.element.toString() + " : " + count;
    }

}