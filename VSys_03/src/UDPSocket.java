import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSocket {
	private static final int BUFSIZE = 508;
	private static String host = "127.0.0.1";
	private static int port = 50000;
	
	public void send(String s) {

		// Socket an anonymen Port binden
		try (DatagramSocket socket = new DatagramSocket()){
			byte data[] = s.getBytes();
			// leeres Packet an Server senden
			InetAddress addr = InetAddress.getByName(host);
			DatagramPacket packetOut = new DatagramPacket(data, data.length, addr, port);
			socket.send(packetOut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	
	public String recieve(int maxBytes) {
		
		try (DatagramSocket socket = new DatagramSocket(port)){
			// paket empfangen
			DatagramPacket packetIn = new DatagramPacket(new byte[maxBytes], maxBytes);
			socket.receive(packetIn);
			String received = new String(packetIn.getData(), 0, packetIn.getLength());
//			System.out.println(received);
			return received;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "";
	
	
	}
	
}
