package faustLinkedList;

class Zelle<E> {
	E inhalt;
	Zelle<E> next;

	Zelle(E e, Zelle<E> rest) {
		inhalt = e;
		next = rest;
	}
}