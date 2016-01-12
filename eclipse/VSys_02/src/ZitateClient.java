import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ZitateClient {
	private static final int BUFSIZE = 508;
	public static void main(String[] args) throws Exception {
		if (args.length != 4) {
			System.err.println("Usage: java DayTimeClient <host1> <port2> <host2> <port2>"); return;
		}
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		// Socket an anonymen Port binden
		try (DatagramSocket socket = new DatagramSocket()){
			// leeres Packet an Server senden
			InetAddress addr = InetAddress.getByName(host);
			DatagramPacket packetOut = new DatagramPacket(new byte[1], 0, addr, port);
			socket.send(packetOut);
			// Antwortpaket empfangen
			DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
			socket.receive(packetIn);
			String received = new String(packetIn.getData(), 0, packetIn.getLength());
			System.out.println(received);

			host = args[2];
			port = Integer.parseInt(args[3]);

			addr = InetAddress.getByName(host);
			packetOut = new DatagramPacket(new byte[1], 0, addr, port);
			socket.send(packetOut);
			// Antwortpaket empfangen
			packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
			socket.receive(packetIn);
			received = new String(packetIn.getData(), 0, packetIn.getLength());
			System.out.println(received);
		}
	}
}