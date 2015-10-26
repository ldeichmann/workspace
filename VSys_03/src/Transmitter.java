import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


	public Transmitter() {
		
		this(new UDPSocket());
		
	}
	
	public static void main(String args[]) {
		
		Transmitter t = new Transmitter(); 
		
	}


}
