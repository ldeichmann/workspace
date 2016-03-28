package binarytree;

import static org.junit.Assert.*;


public class BinBaumTest {

    @org.junit.Test
    public void testanzahlKnoten() {
        Knoten<TelEintrag> ferdi = new Knoten<TelEintrag>(new TelEintrag(
                "Ferdi", "66 23 10"));
        Knoten<TelEintrag> fritz = new Knoten<TelEintrag>(new TelEintrag(
                "Fritz", "26 28 87"), ferdi, null);
        Knoten<TelEintrag> gitte = new Knoten<TelEintrag>(new TelEintrag(
                "Gitte", "37 37 92"));
        Knoten<TelEintrag> gerd = new Knoten<TelEintrag>(new TelEintrag("Gerd",
                "24 78 56"), fritz, gitte);
        Knoten<TelEintrag> eva = new Knoten<TelEintrag>(new TelEintrag("Eva",
                "45 28 87"), null, gerd);
        Knoten<TelEintrag> xaver = new Knoten<TelEintrag>(new TelEintrag(
                "Xaver", "72 63 63"));
        Knoten<TelEintrag> ulrich = new Knoten<TelEintrag>(new TelEintrag(
                "Ulrich", "78 37 73"), null, xaver);
        Knoten<TelEintrag> hans = new Knoten<TelEintrag>(new TelEintrag("Hans",
                "16 17 28"), eva, ulrich);
        BinBaum<TelEintrag> telBaum = new BinBaum<TelEintrag>(hans);
        //Ueberpruefen mit Blaetter + innere Knoten
        assertEquals(8,telBaum.anzKnoten());
    }
    @org.junit.Test
    public void testhoehe(){
        BinBaum<Character> buchstabenBaum = new BinBaum<Character>(
                new Knoten<Character>('B', new Knoten<Character>('A', null,
                        new Knoten<Character>('B')), new Knoten<Character>('U',
                        new Knoten<Character>('M', new Knoten<Character>('E',
                                new Knoten<Character>('E'),
                                new Knoten<Character>('I',
                                        new Knoten<Character>('I'),
                                        new Knoten<Character>('L'))),
                                new Knoten<Character>('S',
                                        new Knoten<Character>('P'), null)),
                        null)));
        assertEquals(5,buchstabenBaum.hoehe());
    }

    @org.junit.Test
    public void testanzBlaetter(){
        BinBaum<String> opBaum = new BinBaum<String>(new Knoten<String>("-",
                new Knoten<String>("+/-", new Knoten<String>("12"), null),
                new Knoten<String>("-", new Knoten<String>("*",
                        new Knoten<String>("3"), new Knoten<String>("( )^2",
                        new Knoten<String>("-",
                                new Knoten<String>("7"),
                                new Knoten<String>("5")), null)),
                        new Knoten<String>("9"))));
        assertEquals(5,opBaum.anzahlBlaetter());
    }

    @org.junit.Test
    public void testinnereKnoten(){
        BinBaum<String> opBaum = new BinBaum<String>(new Knoten<String>("-",
                new Knoten<String>("+/-", new Knoten<String>("12"), null),
                new Knoten<String>("-", new Knoten<String>("*",
                        new Knoten<String>("3"), new Knoten<String>("( )^2",
                        new Knoten<String>("-",
                                new Knoten<String>("7"),
                                new Knoten<String>("5")), null)),
                        new Knoten<String>("9"))));
        assertEquals(6,opBaum.anzahlinnereKnoten());
    }

    @org.junit.Test
    public void testLevelOrder(){
        BinBaum<Character> buchstabenBaum = new BinBaum<Character>(
                new Knoten<Character>('B', new Knoten<Character>('A', null,
                        new Knoten<Character>('B')), new Knoten<Character>('U',
                        new Knoten<Character>('M', new Knoten<Character>('E',
                                new Knoten<Character>('E'),
                                new Knoten<Character>('I',
                                        new Knoten<Character>('I'),
                                        new Knoten<Character>('L'))),
                                new Knoten<Character>('S',
                                        new Knoten<Character>('P'), null)),
                        null)));
        buchstabenBaum.setOrder(BinBaum.Order.LEVELORDER);
        assertEquals("B A U B M E S E I P I L " , buchstabenBaum.toString());
    }

    @org.junit.Test
    public void testCopyTreeLevelOrder(){
        BinBaum<Character> buchstabenBaum = new BinBaum<Character>(
                new Knoten<Character>('B', new Knoten<Character>('A', null,
                        new Knoten<Character>('B')), new Knoten<Character>('U',
                        new Knoten<Character>('M', new Knoten<Character>('E',
                                new Knoten<Character>('E'),
                                new Knoten<Character>('I',
                                        new Knoten<Character>('I'),
                                        new Knoten<Character>('L'))),
                                new Knoten<Character>('S',
                                        new Knoten<Character>('P'), null)),
                        null)));
        BinBaum<Character> buchstabenBaumCopy = new BinBaum<Character>(buchstabenBaum);
        buchstabenBaumCopy.setOrder(BinBaum.Order.LEVELORDER);
        assertEquals("B A U B M E S E I P I L " , buchstabenBaumCopy.toString());

    }

    @org.junit.Test
    public void testanzKnotenMitEinemKind(){
        BinBaum<Character> buchstabenBaum = new BinBaum<Character>(
                new Knoten<Character>('B', new Knoten<Character>('A', null,
                        new Knoten<Character>('B')), new Knoten<Character>('U',
                        new Knoten<Character>('M', new Knoten<Character>('E',
                                new Knoten<Character>('E'),
                                new Knoten<Character>('I',
                                        new Knoten<Character>('I'),
                                        new Knoten<Character>('L'))),
                                new Knoten<Character>('S',
                                        new Knoten<Character>('P'), null)),
                        null)));
        assertEquals(3, buchstabenBaum.anzKnotenMitEinemKind());
    }

}