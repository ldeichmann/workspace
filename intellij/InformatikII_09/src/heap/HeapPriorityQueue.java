package heap;

public class HeapPriorityQueue<E extends Comparable<E> > extends Heap<E> {

    public HeapPriorityQueue(E[] b) {
        super(b);
    }

    public HeapPriorityQueue(int len) {
        super(len);
    }

    public void insert(E e){
        super.insert(e);
    }

    public E extractMax(){
        return super.extractMax();
    }

}
