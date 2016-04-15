package ExprTree;

import lexer.Token;

public abstract class Node {

    private Token token;

    public Node() {
        ;
    }

    public Node(Token token) {
        this.setToken(token);
    }

    public String toString() {
        return getToken().toString();
    }

    public Token getToken() {
        return token;
    }

    private void setToken(Token token) {
        this.token = token;
    }

}
