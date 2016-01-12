import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DaytimeClient {
	private static final int BUFSIZE = 508;
	
	public static void callServer(InetAddress addr, DatagramPacket packetOut) {
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length != 4) {
			System.err.println("Usage: java DayTimeClient <host1> <host2> <port1> <port2>"); return;
		}
		String host1 = args[0];
		String host2 = args[1];
		int port1 = Integer.parseInt(args[2]);
		int port2 = Integer.parseInt(args[3]);
		// Socket an anonymen Port binden
		try (DatagramSocket socket = new DatagramSocket()){
			// leeres Packet an Server senden
			InetAddress addr;
			DatagramPacket packetOut;
			DatagramPacket packetIn;
			
			//host1
			addr = InetAddress.getByName(host1);
			packetOut = new DatagramPacket(new byte[1], 0, addr, port1);
			socket.send(packetOut);
			// Antwortpaket empfangen
			packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
			socket.receive(packetIn);
			String received = new String(packetIn.getData(), 0, packetIn.getLength());
			System.out.println(received);
			
			// host2
			addr = InetAddress.getByName(host2);
			packetOut = new DatagramPacket(new byte[1], 0, addr, port2);
			socket.send(packetOut);
			// Antwortpaket empfangen
			packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
			socket.receive(packetIn);
			received = new String(packetIn.getData(), 0, packetIn.getLength());
			System.out.println(received);
		}
	}
}