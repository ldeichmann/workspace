import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue<String> myq = new MyQueue<String>();

		myq.enter("Max Mustermann");
		myq.enter("Maren Musterfrau");
		myq.enter("Tessa Loniki");
		myq.enter("Hans Hampelmann");

		System.out.println("Initiale Warteschlange: " + myq);
		System.out.println("Erster in der Warteschlange: " + myq.front());
		System.out.println("");
		int i = 1;
		
		while (!myq.isEmpty()) {
			if ((new Random()).nextInt(10) < 5) {
				System.out.println("Verarbeite Kunde: " + myq.leave());
			}
			System.out.println("Verbleibende Warteschlange: " + myq);
			System.out.println("");
			if ((new Random()).nextInt(10) < 4) {
				String newKunde = "Karl König " + i++;
				System.out.println("Ankunft eines neuen Kunden: " + newKunde);
				myq.enter(newKunde);
			}

		}

		System.out.println("Noch jemand in der Warteschlange? " + myq.front());
	}
}
