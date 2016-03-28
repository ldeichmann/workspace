package binarytree;

import java.util.*;

public class BinBaum<E> implements Iterable<E> {

    /*
     * Wurzel des BinBaums
     */
    private Knoten<E> wurzel;

    public enum Order {
        PREORDER, POSTORDER, INORDER, LEVELORDER
    }

    /*
     * Order des Baumes in welcher dieser ausgegeben wird
     *
     * @Default : Preorder
     */
    private Order order = Order.PREORDER;

    public BinBaum() {
        this.wurzel = null;
    }

    public BinBaum(Knoten<E> knoten) {
        this.wurzel = knoten;
    }

    public BinBaum(BinBaum elternBaum) {
        if (!elternBaum.istleer()) {
            this.wurzel = new Knoten(elternBaum.wurzel);
        }
    }

    /*
     * Methode zum Ausgeben von Order
     */
    public Order getOrder() {
        return order;
    }

    /*
     * Methode zum Setzen von Order
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /*
     * Methode zum Ueberpruefen ob der BinBaum leer ist
     */
    boolean istleer() {
        return istleer(wurzel);
    }

    /*
    * Methode zum uberpruefen ob alle Werte unter dem Knoten leer sind
    */
    boolean istleer(Knoten<E> k) {
        if (k.inhalt == null)
            return true;
        else
            return false;
    }


    public int anzKnoten() {
        return anzKnoten(this.wurzel);
    }

    /*
     * Methoden zur Bestimmung der Anzahl der Knoten unter dem angegebenen
     * Knoten
     */
    int anzKnoten(Knoten<E> k) {
        if (k == null)
            return 0;
        return 1 + anzKnoten(k.links) + anzKnoten(k.rechts);
    }

    /*
     * Methode zum Bestimmen der Anzahl der Blätter des Baumes
    */
    int anzahlBlaetter() {
        return anzahlBlaetter(wurzel);
    }

    /*
     * Methode zum Bestimmen der Anzahl der Blaetter unter dem angegebenen
     * Knoten
     * Rekursive Aufrufe: Komplexitaet O(n)
     */
    int anzahlBlaetter(Knoten<E> k) {
        if (k == null)
            return 0;
        if (k.links == null && k.rechts == null)
            return (anzahlBlaetter(k.links) + anzahlBlaetter(k.rechts) + 1);
        return (anzahlBlaetter(k.links) + anzahlBlaetter(k.rechts));
    }

    /*
     * Methode zum Bestimmen der Anzahl der inneren Knoten des BinBaums
     */
    int anzahlinnereKnoten() {
        return anzahlinnereKnoten(this.wurzel);
    }

    /*
     * Methode zum Bestimmen der Anzahl der inneren Knoten unter dem
     * angegebenen Knoten
     * Rekursiver Aufruf: Komplexitaet O(n)
     */
    int anzahlinnereKnoten(Knoten<E> k) {
        if (k == null)
            return 0;
        if (k.links != null || k.rechts != null)
            return (anzahlinnereKnoten(k.links) + anzahlinnereKnoten(k.rechts) + 1);
        return (anzahlinnereKnoten(k.links) + anzahlinnereKnoten(k.rechts));
    }


    public int hoehe() {
        return hoehe(this.wurzel);
    }

    /*
     * Methode zum Bestimmen der Hoehe unter dem angegebenen Knoten
     */
    int hoehe(Knoten<E> k) {
        if (k == null)
            return -1;
        return 1 + Math.max(hoehe(k.links), hoehe(k.rechts));
    }

    int anzKnotenMitEinemKind() {
        return anzKnotenMitEinemKind(wurzel);
    }

    int anzKnotenMitEinemKind(Knoten<E> k) {
        if (k == null)
            return 0;
        if ((k.links == null && k.rechts != null) || (k.links != null && k.rechts == null))
            return (anzKnotenMitEinemKind(k.links) + anzKnotenMitEinemKind(k.rechts) + 1);
        return (anzKnotenMitEinemKind(k.links) + anzKnotenMitEinemKind(k.rechts));
    }

    /*
    * Methode zum Einfuegen des Baumes in eine Liste in PreOrder
    */
    void preOrder(Knoten<E> k, List<E> liste) {
        if (k != null) {
            liste.add(k.inhalt);
            preOrder(k.links, liste);
            preOrder(k.rechts, liste);
        }
    }

    /*
     * Methode zum Einfuegen des Baumes in eine Liste in InOrder
     */
    void inOrder(Knoten<E> k, List<E> liste) {
        if (k != null) {
            inOrder(k.links, liste);
            liste.add(k.inhalt);
            inOrder(k.rechts, liste);
        }
    }

    /*
     * Methode zum Einfuegen des Baumes in eine Liste in PostOrder
     */
    void postOrder(Knoten<E> k, List<E> liste) {
        if (k != null) {
            postOrder(k.links, liste);
            postOrder(k.rechts, liste);
            liste.add(k.inhalt);
        }
    }


    /*
     * Methode zum Einfuegen des Baumes in eine Liste in LevelOrder
     * Komplexitaet: O(n) ,da die Datenmenge der Schleife mit der Liste waechst
     */
    void levelOrder(List<E> liste) {
        Queue<Knoten<E>> level = new LinkedList<>();
        level.add(wurzel);
        while (!level.isEmpty()) {
            Knoten<E> node = level.poll();
            liste.add(node.inhalt);
            if (node.links != null)
                level.add(node.links);
            if (node.rechts != null)
                level.add(node.rechts);
        }
    }



    /*
     * Iterator des Baumes
     *
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<E> iterator() {
        List<E> liste = new ArrayList<E>();
        switch (order) {
            case PREORDER:
                preOrder(wurzel, liste);
                break;
            case POSTORDER:
                postOrder(wurzel, liste);
                break;
            case INORDER:
                inOrder(wurzel, liste);
                break;
            case LEVELORDER:
                levelOrder(liste);
                break;
        }
        return liste.iterator();
    }


    /*
     * Methode zum Ausgeben des BinBaumes (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : this)
            sb.append(e + " ");
        return sb.toString();
    }
}
