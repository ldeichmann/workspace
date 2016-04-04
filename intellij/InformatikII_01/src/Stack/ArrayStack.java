package Stack;

public class ArrayStack<E> implements Stack<E>{
    private E[] array;
    private int top;

    /**
     * Initialize ArrayStack with size
     * @param size
     */
    ArrayStack (int size) {
        array = (E[]) new Object[size];
        top = -1;
    }

    /**
     * Returns true if ArrayStack is empty
     * @return
     */
    @Override
    public boolean istLeer() { return top == -1;}

    /**
     * Returns true if ArrayStack is full
     * @return
     */
    private boolean istVoll() { return top+1 == array.length;}

    /**
     * Pushes element on top of the ArrayStack
     * @param e
     * @throws StackFehler
     */
    @Override
    public void push (E e) throws StackFehler {
        if (istVoll()) throw new StackFehler("stack is full");
        array[++top] = e;
    }

    /**
     * Removes the top element of the stack
     * @throws StackFehler
     */
    @Override
    public void pop() throws StackFehler {
        if (istLeer()) throw new StackFehler("tack is empty");
        array[top--] = null; // Element löschen
    }

    /**
     * Return the top element of the stack
     * @return Top element
     * @throws StackFehler
     */
    @Override
    public E top() throws StackFehler {
        if (istLeer()) throw new StackFehler("stack is empty");
        return array[top];
    }

    /**
     * Removes and returns the top element of the stack
      * @return Top element
     * @throws StackFehler
     */
    @Override
    public E popTop() throws StackFehler {
        E temp = top();
        pop();
        return temp;
    }

    /**
     * Removes k elements from the stack, stops when stack is empty
      * @param k
     */
    public void multiPop(int k) {
        while (k > 0) {
            if (istLeer()) { break;}
            pop();
            k--;
        }
    }

}
