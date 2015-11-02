//package experiment2;

import java.net.*; // we use Sockets
import java.util.Arrays;

public class Aufgabe6_FileTransferServerUDPjlibcnds {

    
    public static void main(String args[]) throws Exception{
        // Arguments: port & filename
        int srvPort = Integer.parseInt(args[0]); // server UDP port
        String filename = args[1]; // file Name
        

	    // Open special datagramm socket from jlibcnds library, do not change this
	    javax.net.DatagramSocket dtgSock;
        dtgSock = new javax.net.DatagramSocket(srvPort);

        byte[] buf = new byte[9];

//	    java.io.PrintWriter pw = new java.io.PrintWriter(filename);
//	    pw.close();
	    java.io.FileOutputStream fw = new java.io.FileOutputStream(filename);
	    DatagramPacket packet = new DatagramPacket(buf, buf.length);
	    
	    int err = 0;
	    int currBit = 0;
	    
	    while (true){
		    dtgSock.receive(packet);
		    if (packet.getLength()==0) break;
//		    System.out.println("analysis: " + Arrays.toString(packet.getData()));
//			System.out.println("currBit " + currBit);

		    System.out.println(packet.getData()[8] + " " + (byte) currBit);
	    	if (packet.getData()[8] == (byte) currBit) {
	    		System.out.println("new packet, sending ack");
			    DatagramPacket packetOut = new DatagramPacket(buf, 0, packet.getAddress(), packet.getPort());
			    dtgSock.send(packetOut);
	            fw.write(packet.getData(), 0, packet.getLength() - 1);
	            currBit = (currBit == 0) ? 1 : 0;
	    	} else {
	    		System.out.println("old packet, sending ack");
			    DatagramPacket packetOut = new DatagramPacket(buf, 0, packet.getAddress(), packet.getPort());
			    dtgSock.send(packetOut);
			    err++;
	    	}

//		    DatagramPacket packetOut = new DatagramPacket(buf, 0);
//		    dtgSock.send(packetOut);
//            fw.write(packet.getData(),0,packet.getLength());
	    }
	    fw.flush();
	    fw.close();
	    dtgSock.close();	// Close the Socket
	    System.out.println("");
	    System.out.println("Errors: " + err);
	    System.out.println("--- ");
    }
}
