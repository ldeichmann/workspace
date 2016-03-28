package binarytree;

class TelEintrag {
    String name;
    String nr;

    TelEintrag(String s, String n) {
        name = s;
        nr = n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( " + this.name + ":  " + this.nr + " )" + "\n");
        return sb.toString();
    }
}