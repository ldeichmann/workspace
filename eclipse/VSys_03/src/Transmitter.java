import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Transmitter {

	public Transmitter(UDPSocket sock) {

		String s;

		System.out.print("Eingabe: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while ((s = br.readLine()) != null) {
				sock.send(s);
				System.out.print("Eingabe: ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sock.send("\u0004s");

	}


	public Transmitter() throws UnknownHostException {
		
//		this(new UDPSocket(InetAddress.getByName("127.0.0.1"), 50001, 50000));
		this(new UDPSocket(InetAddress.getByName("127.0.0.1"), 50001, 50000));
		
	}
	
	public static void main(String args[]) {
		
		try {
			Transmitter t = new Transmitter();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}


}
