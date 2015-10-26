
public class Receiver {

	public Receiver(UDPSocket sock) {
		
		String s;
		
		while (!(s = sock.recieve(508)).equals("\u0004s")) {
			System.out.println(s);
		}
		
		
	}

	public Receiver() {
		
		this(new UDPSocket());
		
	}
	
	
	public static void main(String args[]) {
		
		Receiver t = new Receiver(); 
		
	}

}
