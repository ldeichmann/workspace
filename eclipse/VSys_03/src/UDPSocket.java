import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSocket {
	private static final int BUFSIZE = 508;
//	private static String host = "127.0.0.1";
	private static int serverPort = 50000;
	private InetAddress addr;
	private int port, port2;
	public DatagramSocket socket;
	
	public UDPSocket(InetAddress addr, int port, int port2) {
		
		try {
			this.addr = addr;
			this.port = port;
			this.port2 = port2;
			this.socket = new DatagramSocket(this.port2);
			this.socket.connect(this.addr, this.port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public UDPSocket() throws UnknownHostException {
//
//		this(InetAddress.getByName("127.0.0.1"), 50000);		
//		
//	}

	public void send(String s) {

		// Socket an anonymen Port binden
		try {
			byte data[] = s.getBytes();
			// Packet an Server senden
			DatagramPacket packetOut = new DatagramPacket(data, data.length, this.addr, this.port);
			this.socket.send(packetOut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	
	public String recieve(int maxBytes) {
		
		try {
			// paket empfangen
			DatagramPacket packetIn = new DatagramPacket(new byte[maxBytes], maxBytes);
			this.socket.receive(packetIn);
			String received = new String(packetIn.getData(), 0, packetIn.getLength());
			return received;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "";
	
	
	}
	
}
