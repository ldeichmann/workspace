//package experiment2;

import java.net.*; // we use Sockets
import java.util.Arrays;

public class Aufgabe6_FileTransferClientUDPjlibcnds {

    
    public static void main(String args[]) throws Exception{ 
        // Arguments: Server name & port & filename to transfer
        String srvName = args[0]; // server Name
        int srvPort = Integer.parseInt(args[1]); // server UDP port
        String filename = args[2]; // file Name

	    // Open special datagramm socket from jlibcnds library, do not change this
	    javax.net.DatagramSocket dtgSock;
        dtgSock = new javax.net.DatagramSocket();
        InetSocketAddress srvSockAddr = new InetSocketAddress(srvName, srvPort);
        dtgSock.connect(srvSockAddr);
        dtgSock.setSoTimeout(500);

        byte[] buf = new byte[8];
        byte[] currBit = new byte[1];
        currBit[0] = 0;
        int loss = 0;

	    java.io.FileInputStream fr = new java.io.FileInputStream(filename);

	    int len; // number of bytes written from the file

	    while ((len = fr.read(buf, 0, buf.length)) != -1) {

			while (true) {
				try {
			        DatagramPacket packet = new DatagramPacket(Tools.concatByteArrays(buf, currBit), buf.length + currBit.length);
		        	dtgSock.send(packet);
			        DatagramPacket packetIn = new DatagramPacket(buf, len);
					System.out.print("*");
					dtgSock.receive(packetIn);
					currBit[0] = (currBit[0] == (byte) 0) ? (byte) 1 : (byte) 0;
 					break;
				} catch (Exception e) {
					loss++;
				}
			}
			Thread.sleep(100);
			Arrays.fill(buf, (byte) 0);
	    }
		
	    // Send an empty packet to the server to indicate end of file
        DatagramPacket packet = new DatagramPacket(buf, 0);
       	dtgSock.send(packet);
		Thread.sleep(500);
        dtgSock.close();	// Close the Socket
        fr.close();
        System.out.println("");
        System.out.println("Lost " + loss + " packets.");
	    System.exit(0);
    }
}
