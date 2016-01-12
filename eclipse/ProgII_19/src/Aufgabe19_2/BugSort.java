package Aufgabe19_2;

import java.util.List;

/**
 * Die Klasse BugSort soll diverse Sortieralgorithmen bereitstellen. Aktuell
 * wird nur der Binaersort Algorithmus angeboten.
 * 
 * @author Nane Kratzke
 */
public class BugSort<T extends Comparable<T>> {

	/**
	 * Sortiert eine Liste von Werten nach dem Binaersort Algorithmus.
	 * 
	 * @param list
	 *            Zu sortierende Liste (list != null)
	 * @return Aufsteigend sortierte Liste
	 */
	public List<T> binSort(final List<T> list) {
		return binSort(list, true);
	}

	/**
	 * Sortiert eine Liste von Werten nach dem Binaersort Algorithmus
	 * aufsteigend oder absteigend.
	 * 
	 * @param list Zu sortierende Liste (list != null)
	 * @param asc Soll aufsteigend oder absteigend sortiert werden
	 * @return Aufsteigend sortierte Liste (wenn asc == true)
	 *         Absteigend sortierte Liste (wenn asc == false)
	 */
	public List<T> binSort(final List<T> list, boolean asc) {
		BugTree<T> bintree = new BugTree<T>(list);
		return asc ? bintree.ascending() : bintree.descending();
	}
}
