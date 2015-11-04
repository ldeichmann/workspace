import java.net.InetAddress;
import java.net.UnknownHostException;

public class Receiver {

	public Receiver(UDPSocket sock) {
		
		String s;
		
		while (!(s = sock.recieve(508)).equals("\u0004s")) {
			System.out.println(s);
		}
		
		
	}

	public Receiver() throws UnknownHostException {
		
		this(new UDPSocket(InetAddress.getByName("127.0.0.1"), 50000, 50001));
		
	}
	
	
	public static void main(String args[]) {
		
		try {
			Receiver t = new Receiver();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
