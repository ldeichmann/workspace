package binarytree;

public class Knoten<E> {

    public Knoten<E> links, rechts,oben;
    public E inhalt;

    public Knoten(E el) {
        inhalt = el;
    }

    public Knoten(E el, Knoten<E> li, Knoten<E> re) {
        inhalt = el;
        links = li;
        rechts = re;
    }

    public Knoten(Knoten<E> k) {
        this.inhalt = k.inhalt;
        if (k.links != null) {
            this.links = new Knoten(k.links);
        }
        if (k.rechts != null) {
            this.rechts = new Knoten(k.rechts);
        }
    }
}

