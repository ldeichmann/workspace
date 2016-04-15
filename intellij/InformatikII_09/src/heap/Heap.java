package heap;

import java.util.Arrays;

public class Heap<E extends Comparable<E>> implements PriorityQueue<E>{

    int länge;
    int heapgroeße;
    E[] array;

    @SafeVarargs
    static <E> E[] newArray(int length, E... array) {
        return Arrays.copyOf(array, length);
    }

    public Heap(int len) {
        länge = len;
        heapgroeße = 0;
        array=newArray(len);
        //A = (E[]) new Object[len];
    }

    public Heap(E[] b) {
        array = newArray(b.length);
        länge = b.length;
        heapgroeße = 0;
        for (int i = 0; i < b.length; i++) {
            insert(b[i]);
        }
    }

    public void insert(E e) {
        heapgroeße++;
        array[heapgroeße-1] = e;
        upHeap(heapgroeße);

    }


    // TODO Why the fuck does this work?
    private int Vater(int i) {
        if (i == 1)
            return i;
        else
            return (i / 2);
    }

    private void upHeap(int i) {
        while (i > 1 && array[i-1].compareTo(array[Vater(i)-1]) > 0) {
            E wert = array[Vater(i)-1];
            array[Vater(i)-1] = array[i-1];
            array[i-1] = wert;
            i=Vater(i);
        }

		/*
		 * int Vater = (i - 1) / 2; E Unten = A[i - 1]; while (i > 1 &&
		 * Unten.compareTo(A[Vater]) > 0) { Unten = A[i - 1]; A[i - 1] =
		 * A[Vater]; A[Vater] = Unten; i = Vater; Vater = (Vater - 1) / 2; }
		 * //A[i ] = Unten;
		 */
    }

    public E extractMax() {
        E Wurzel = array[0];
        heapgroeße--;
        array[0] = array[heapgroeße];
        heapify(0);
        return Wurzel;
    }

    private void heapify(int i) {
        while (i != -1) {
            i = heapifyLocally(i);
        }

    }

    private int maxkind(int i){
        int lk = i*2+1;
        int rk = i*2+2;
        if(lk > heapgroeße-1 && rk < heapgroeße-1)
            return rk;
        if(rk > heapgroeße-1 && lk < heapgroeße-1)
            return lk;
        if(rk > heapgroeße-1 && lk > heapgroeße-1)
            return i;
        if(array[lk].compareTo(array[rk]) > 0)
            return lk;
        if(array[rk].compareTo(array[lk]) >= 0)
            return rk;
        return -1;
    }

    private int heapifyLocally(int i) {
        int k = maxkind(i);
        if ( array[k].compareTo(array[i]) > 0) {
            E wert = array[i];
            array[i] = array[k];
            array[k] = wert;
            return k;
        } else {
            return -1;
        }
    }

    public String toString() {
        String ausgabe = "{";
        for (int i = 0; i < heapgroeße ; i++) {
            ausgabe = ausgabe + " " + array[i];
        }
        return ausgabe + " }";
    }
}
