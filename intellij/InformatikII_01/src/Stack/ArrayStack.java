package Stack;

public class ArrayStack<E> implements Stack<E>{
    private E[] array;
    private int top;

    ArrayStack (int size) {
        array = (E[]) new Object[size];
        top = -1;
    }

    @Override
    public boolean istLeer() { return top == -1;}

    private boolean istVoll() { return top+1 == array.length;}

    @Override
    public void push (E e) throws StackFehler {
        if (istVoll()) throw new StackFehler("stack is full");
        array[++top] = e;
    }

    @Override
    public void pop() throws StackFehler {
        if (istLeer()) throw new StackFehler("tack is empty");
        array[top--] = null; // Element löschen
    }

    @Override
    public E top() throws StackFehler {
        if (istLeer()) throw new StackFehler("stack is empty");
        return array[top];
    }

    @Override
    public E popTop() throws StackFehler {
        E temp = top();
        pop();
        return temp;
    }

    public void multiPop(int k) {

        while (k > 0) {
            if (istLeer()) { break;}
            pop();
            k--;

        }

    }

}
