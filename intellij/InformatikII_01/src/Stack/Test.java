package Stack;

import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void testArrayStack_Create() throws Exception {
        Stack teststack = new ArrayStack(1);
        assertTrue(teststack.istLeer());
    }

    @org.junit.Test
    public void testArrayStack_InsertTeststring() throws Exception {
        System.out.println("ArrayStack Push String Test:");

        String example = "testArrayStack_InsertTeststring";
        Stack<Character> teststack = new ArrayStack<Character>(31);
        for (char ch: example.toCharArray()) {

            teststack.push(ch);
            System.out.println(ch);
        }
        assertFalse(teststack.istLeer());
        System.out.println("\n");
    }

    @org.junit.Test
    public void testArrayStack_RemoveTeststring() throws Exception {
        System.out.println("ArrayStack Get String Test:");

        String example = "testArrayStack_RemoveTeststring";
        Stack<Character> teststack = new ArrayStack<Character>(31);
        for (char ch: example.toCharArray()) {

            teststack.push(ch);
        }
        assertFalse(teststack.istLeer());
        while (!teststack.istLeer()) {

            System.out.println(teststack.popTop());
        }
        assertTrue(teststack.istLeer());
        System.out.println("\n");
    }

    @org.junit.Test
    public void testListStack_Create() throws Exception {
        Stack teststack = new ListStack();
        assertTrue(teststack.istLeer());
    }

    @org.junit.Test
    public void testListStack_InsertTeststring() throws Exception {
        System.out.println("ListStack Push String Test:");

        String example = "testListStack_InsertTeststring";
        Stack<Character> teststack = new ListStack<Character>();
        for (char ch: example.toCharArray()) {

            teststack.push(ch);
            System.out.println(ch);
        }
        assertFalse(teststack.istLeer());
        System.out.println("\n");
    }

    @org.junit.Test
    public void testListStack_RemoveTeststring() throws Exception {
        System.out.println("ArrayStack Get String Test:");

        String example = "testListStack_RemoveTeststring";
        Stack<Character> teststack = new ListStack<Character>();
        for (char ch: example.toCharArray()) {

            teststack.push(ch);
        }
        assertFalse(teststack.istLeer());
        while (!teststack.istLeer()) {

            System.out.println(teststack.popTop());
        }
        assertTrue(teststack.istLeer());
        System.out.println("\n");
    }

}