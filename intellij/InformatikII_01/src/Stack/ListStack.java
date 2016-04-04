package Stack;

public class ListStack<E> implements Stack<E> {
    private Zelle<E> top; // Anker

    /**
     * Returns true if ArrayStack is empty
     * @return
     */
    @Override
    public boolean istLeer() {
        return top == null;
    }

    /**
     * Pushes element on top of the ArrayStack
     * @param e
     * @throws StackFehler
     */
    @Override
    public void push(E e) {

        Zelle<E> neueZelle = new Zelle<E>(e);
        neueZelle.next = top;
        top = neueZelle;
    }

    /**
     * Removes the top element of the stack
     * @throws StackFehler
     */
    @Override
    public void pop() throws StackFehler {
        if (istLeer()) throw new StackFehler("stack is empty");

        top = top.next;

    }

    /**
     * Return the top element of the stack
     * @return Top element
     * @throws StackFehler
     */
    @Override
    public E top() throws StackFehler {
        if (istLeer()) throw new StackFehler("stack is empty");
        return top.inhalt;
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