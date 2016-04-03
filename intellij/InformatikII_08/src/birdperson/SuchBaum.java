package birdperson;


import binarytree.BinBaum;
import binarytree.Knoten;


public class SuchBaum<E extends Comparable<E>> extends BinBaum<E> implements SortedSet<E> {

    private int size;
    private Knoten<E> wurzel;

    //Konstruktor
    public SuchBaum() {
        this.wurzel = null;
        this.size = 0;
    }


    @Override
    public E findMin() {
        Knoten<E> k = findMin(wurzel);
        return k == null ? null : k.inhalt;
    }

    private Knoten<E> findMin(Knoten<E> k) {
        if (k == null)
            return k;
        while (k.links != null)
            k = k.links;
        return k;
    }

    @Override
    public E findMax() {
        Knoten<E> k = findMax(wurzel);
        return k == null ? null : k.inhalt;
    }

    private Knoten<E> findMax(Knoten<E> k) {
        if (k == null)
            return k;
        while (k.rechts != null)
            k = k.rechts;
        return k;
    }

    /*
    * Sucht den nächst gößeren Wert im Baum
    */
    Knoten<E> successor(Knoten<E> k) {
        if (k == null)
            return k;
        if (k.rechts != null)
            return findMin(k.rechts);
        Knoten<E> vater = k.oben;
        while ((vater != null) && (vater.rechts == k)) {
            k = vater;
            vater = k.oben;
        }
        return vater;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.wurzel == null;
    }

    @Override
    public boolean contains(E e) {
        Knoten<E> k = getMatch(e, wurzel);
        if (k == null) return false;
        return k.inhalt == e ? true : false;
    }

    @Override
    public boolean add(E e) {
        if (this.isEmpty()) {
            this.wurzel = new Knoten<E>(e);
            size++;
            return true;
        } else {
            return add(e, wurzel);
        }
    }

    public boolean add(E e, Knoten<E> k) {
        if (e.compareTo(k.inhalt) == 0) {
            return false;
        }
        if (e.compareTo(k.inhalt) < 0) {
            if (k.links == null) {
                k.links = new Knoten<E>(e);
                size++;
                return true;
            } else
                return add(e, k.links);
        } else if (k.rechts == null) {
            k.rechts = new Knoten<E>(e);
            size++;
            return true;
        } else {
            return add(e, k.rechts);
        }
    }

    @Override
    public boolean remove(E e) {
        if (getMatch(e) == e) {
            remove(new Knoten<E>(e));
            return true;
        } else
            return false;    }

    private boolean remove(Knoten<E> k) {

        if (k == null)
            return false;
        if (k.links == null || k.rechts == null) {
            loesche01(k);
            size--;
            return true;
        } else {
            loesche2(k);
            size--;
            return true;
        }

    }

    void loesche01(Knoten<E> sohn) {
        // Bestimme den Enkel - kann null sein
        Knoten<E> enkel = (sohn.links == null) ? sohn.rechts : sohn.links;
        // sohn hat keinen Vater also soll die Wurzel gelöscht werden
        if (sohn == wurzel) {
            wurzel = enkel;
            if (wurzel != null)
                wurzel.oben = null;
            return;
        }
        // Ab hier ist klar: Vater existiert
        Knoten<E> vater = sohn.oben;
        // Verbinde Vater zum Enkel
        if (vater.links == sohn)
            vater.links = enkel;
        else
            vater.rechts = enkel;
        // Verbinde Enkel zum Vater
        if (enkel != null)
            enkel.oben = vater;
    }

    void loesche2(Knoten<E> k) {
        Knoten<E> min = findMin(k.rechts);
        k.inhalt = min.inhalt; // Kopiere Inhalt nach oben
        loesche01(min);
    }

    @Override
    public void clear() {
        this.wurzel = null;
    }

    @Override
    public E getMatch(E e) {
        Knoten<E> result = getMatch(e, this.wurzel);
        if (result == null) return null;
        return result.inhalt;
    }

    /*
     *
     */
    private Knoten<E> getMatch(E e, Knoten<E> k) {
        if (k == null)
            return null;
        if (e.compareTo(k.inhalt) == 0)
            return k;
        if (e.compareTo(k.inhalt) < 0)
            return getMatch(e, k.links);
        else
            return getMatch(e, k.rechts);
    }

    public String toString() { // TODO stupid shitty toString nonsense
        StringBuilder ausgabe = new StringBuilder();
        Knoten<E> k = findMin(wurzel);
        while (k != null) {
            ausgabe.append(k.inhalt + "\n");
            k = successor(k);
        }
        return ausgabe.toString();
    }
}