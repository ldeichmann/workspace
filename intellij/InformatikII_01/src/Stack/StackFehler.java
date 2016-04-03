package Stack;

class StackFehler extends RuntimeException {
    String message;
    StackFehler(String m) {
        super(m); // needed so we can expect a message in junit
        message = m;
        System.out.println(m);
    }
}