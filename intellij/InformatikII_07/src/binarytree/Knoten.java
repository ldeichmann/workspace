package binarytree;

class Knoten<E> {

    Knoten<E> links, rechts,oben;
    E inhalt;

    Knoten(E el) {
        inhalt = el;
    }

    Knoten(E el, Knoten<E> li, Knoten<E> re) {
        inhalt = el;
        links = li;
        rechts = re;
    }

    Knoten(Knoten<E> k) {
        this.inhalt = k.inhalt;
        if (k.links != null) {
            this.links = new Knoten(k.links);
        }
        if (k.rechts != null) {
            this.rechts = new Knoten(k.rechts);
        }
    }
}

