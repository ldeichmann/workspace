package lexer;

import org.junit.rules.ExpectedException;

import static lexer.Postfix_Tokens.evalPostfix;
import static org.junit.Assert.*;

public class PostfixTest {

    // Object used for Exception Testing
    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Test
    public void testPostfix_test_add() throws Exception {
        assertTrue(evalPostfix("3 7 + \n") == 10);
    }

    @org.junit.Test
    public void testPostfix_test_sub() throws Exception {
        assertTrue(evalPostfix("3 7 - \n") == -4);
    }

    @org.junit.Test
    public void testPostfix_test_mul() throws Exception {
        assertTrue(evalPostfix("3 7 * \n") == 21);
    }

    @org.junit.Test
    public void testPostfix_test_div() throws Exception {
        assertTrue(evalPostfix("16 4 / \n") == 4);
    }

    @org.junit.Test
    public void testPostfix_test_mix() throws Exception {
        assertTrue(evalPostfix("3 7 - 4 * # \n") == 16);
    }

    @org.junit.Test
    public void testPostfix_test_pow_01() throws Exception {
        assertTrue(evalPostfix("3 # 3 8 4 / 2 ^ * 9 - + \n") == 0);
    }

//    @org.junit.Test
//    public void testPostfix_Error() throws Exception {
//        thrown.expect(Error.class);
//        thrown.expectMessage("invalid character: v");
//        evalPostfix("v");
//    }

//    @org.junit.Test
//    public void testPostfix_missing_newline() throws Exception {
//        assertTrue(evalPostfix("3 # 3 8 4 / 2 ^ * 9 - +") == -1);
//    }

    @org.junit.Test
    public void testPostfix_pow_test02() throws Exception {
        assertTrue(evalPostfix("6 2 - 2 ^ 7 2 # * + \n") == 2);
    }

    @org.junit.Test
    public void testPostfix_pow_test03() throws Exception {
        assertTrue(evalPostfix("2 4 + 2 ^ 2 4 + / \n") == 6);
    }

}