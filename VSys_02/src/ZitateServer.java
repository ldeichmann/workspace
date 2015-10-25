import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ZitateServer {
	private static final int BUFSIZE = 508;
	private static final String zitateFile = System.getProperty("user.home") + "/Documents/zitate.txt";
	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.err.println("Usage: java DayTimeServer <port>");
			return;
		}
		int port = Integer.parseInt(args[0]);
		// Socket an anonymen Port binden
		while (true) {
			try (DatagramSocket socket = new DatagramSocket(port)){
				// paket empfangen
				DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
				socket.receive(packetIn);
				String received = new String(packetIn.getData(), 0, packetIn.getLength());
//				System.out.println(received);
				// quote antworten
				byte data[];
				if (received.length() == 0) {
					System.out.println("Random");
					data = getQuote(0).getBytes();
				} else {
					System.out.println("Not random");
					data = getQuote(Integer.parseInt(received)).getBytes();
				}
				DatagramPacket packetOut = new DatagramPacket(data, data.length, packetIn.getAddress(), packetIn.getPort());
				socket.send(packetOut);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getQuote(int num) {
		if (num == 0) {
			Path path = Paths.get(zitateFile);
			try {
				
				int lineCount = (int) Files.lines(path).count();
				num = 1 + (int)(Math.random()*(lineCount/2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(zitateFile));
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < (num-1)*2; ++i)
            	  br.readLine();
            
            sb.append(br.readLine());
            sb.append(System.lineSeparator());
            sb.append(br.readLine());
            
            br.close();
            return sb.toString();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "IO Error";
        }
		
	}
	
}