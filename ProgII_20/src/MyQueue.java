import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


public class MyQueue<T> {

	List<T> ll = new LinkedList<T>();
	
	/**
	 * Enter element into queue
	 * @param t element
	 * @return success
	 */
	public boolean enter(T t) {
		try {
			ll.add(0, t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
//		return ll.add(t);
	}
	
	/**
	 * Remove first in queue
	 * @return first in queue
	 * @throws NoSuchElementException
	 */
	public T leave() throws NoSuchElementException {

		if (!isEmpty()) {
			return ll.remove(ll.size()-1);
		} else {
			throw new NoSuchElementException();
		}
		
	}
	
	/**
	 * @return is queue empty
	 */
	public boolean isEmpty() {
		return !(ll.size() > 0);
		
	}
	
	/**
	 * Get first element in queue without removing it
	 * @return first element
	 */
	public T front() {
		if (!isEmpty()) {
			return ll.get(ll.size()-1);
		} else {
			return null;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ll.toString();
	}
	
}
