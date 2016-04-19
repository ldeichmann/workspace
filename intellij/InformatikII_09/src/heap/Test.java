package heap;

import static org.junit.Assert.assertEquals;

/**
 * Created by lukas on 4/19/16.
 */
public class Test {

    @org.junit.Test
    public void arrayconstruct() {
        Integer[] btest = {4,9,7,17,13,11,10};
        Heap<Integer> heap = new Heap<Integer>(btest);
        assertEquals(7,heap.heapsize);
    }

    @org.junit.Test
    public void extractmax() {
        Integer[] btest = {4,9,7,17,13,11,10};
        Heap<Integer> heap = new Heap<Integer>(btest);
        assertEquals(17,heap.extractMax().intValue());
        assertEquals(13,heap.extractMax().intValue());
        assertEquals(5,heap.heapsize);
    }

    @org.junit.Test
    public void arrayconstructPQ() {
        Integer[] btest = {4,9,7,17,13,11,10};
        PriorityQueue<Integer> heap = new Heap<Integer>(btest);
        assertEquals(17,heap.extractMax().intValue());
    }

    @org.junit.Test
    public void extractmaxPQ() {
        Integer[] btest = {4,9,7,17,13,11,10};
        PriorityQueue<Integer> heap = new Heap<Integer>(btest);
        assertEquals(17,heap.extractMax().intValue());
        assertEquals(13,heap.extractMax().intValue());
    }
}
