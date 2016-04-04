package Stack;

import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Test {

    // Object used for Exception Testing
    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     ** ArrayStack Tests
     **/

    /**
     * Test stack creation
     */
    @org.junit.Test
    public void testArrayStack_Create() throws StackFehler {
        Stack teststack = new ArrayStack(1);
        assertTrue(teststack.istLeer());

        thrown.expect(StackFehler.class);
        thrown.expectMessage("stack is empty");
        teststack.top(); // execution will never get past this line
    }

    /**
     * Test stack overflow
     */
    @org.junit.Test
    public void testArrayStack_Overflow() throws StackFehler {
        Stack<Character> teststack = new ArrayStack<Character>(1);
        assertTrue(teststack.istLeer());

        teststack.push('a');

        thrown.expect(StackFehler.class);
        thrown.expectMessage("stack is full");
        teststack.push('z'); // execution will never get past this line
    }

    /**
     * Test stack push
     */
    @org.junit.Test
    public void testArrayStack_InsertTeststring() throws Exception {
        String example = "testArrayStack_InsertTeststring";
        Stack<Character> teststack = new ArrayStack<Character>(31);
        for (char ch: example.toCharArray()) {

            teststack.push(ch);
            assertTrue(teststack.top() == ch);
        }
        assertFalse(teststack.istLeer());
    }

    /**
     * Test stack popTop
     */
    @org.junit.Test
    public void testArrayStack_RemoveTeststring() throws Exception {
        String example = "testArrayStack_RemoveTeststring";
        Stack<Character> teststack = new ArrayStack<Character>(31);

        for (char ch: example.toCharArray()) {
            teststack.push(ch);
        }

        StringBuilder out = new StringBuilder();
        while (!teststack.istLeer()) {
            out.append(teststack.popTop());
        }
        assertTrue(out.reverse().toString().equals(example));
    }

    /**
     * Test Multipop
     */
    @org.junit.Test
    public void testArrayStack_multipop() throws StackFehler {
        Stack<Integer> teststack = new ArrayStack<Integer>(10);
        int i;
        for (i = 0; i < 10; i++) {
            teststack.push(i);
        }
        for (i = 9; i > 6; i--) {
            teststack.pop();
        }
        assertTrue(teststack.top() == 6);

    }

    /**
     * ListStack Tests
     */

    /**
     * Test stack creation
     */
    @org.junit.Test
    public void testListStack_Create() throws StackFehler {
        Stack teststack = new ListStack();
        assertTrue(teststack.istLeer());

        thrown.expect(StackFehler.class);
        teststack.top(); // execution will never get past this line
    }

    /**
     * Test stack push
     */
    @org.junit.Test
    public void testListStack_InsertTeststring() throws Exception {
        String example = "testListStack_InsertTeststring";
        Stack<Character> teststack = new ListStack<Character>();
        for (char ch: example.toCharArray()) {

            teststack.push(ch);
            assertTrue(teststack.top() == ch);
        }
        assertFalse(teststack.istLeer());
    }

    /**
    * Test stack popTop
    */
    @org.junit.Test
    public void testListStack_RemoveTeststring() throws Exception {
        String example = "testListStack_RemoveTeststring";
        Stack<Character> teststack = new ListStack<Character>();
        for (char ch: example.toCharArray()) {
            teststack.push(ch);
        }

        StringBuilder out = new StringBuilder();
        while (!teststack.istLeer()) {
            out.append(teststack.popTop());
        }
        assertTrue(out.reverse().toString().equals(example));

    }


    /**
     * Test Multipop
     */
    @org.junit.Test
    public void testListStack_multipop() throws StackFehler {
        Stack<Integer> teststack = new ListStack<Integer>();
        int i;
        for (i = 0; i < 10; i++) {
            teststack.push(i);
        }
        for (i = 9; i > 6; i--) {
            teststack.pop();
        }
        assertTrue(teststack.top() == 6);

    }

}