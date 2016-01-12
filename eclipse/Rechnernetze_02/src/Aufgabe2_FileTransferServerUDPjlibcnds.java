

import java.net.*; // we use Sockets

public class Aufgabe2_FileTransferServerUDPjlibcnds {

    
    public static void main(String args[]) throws Exception{
        // Arguments: port & filename
        int srvPort = Integer.parseInt(args[0]); // server UDP port
        String filename = args[1]; // server Name
        int expectedFrames = Integer.parseInt(args[2]);
        int receivedFrames = 0;

	    // Open special datagramm socket from jlibcnds library, do not change this
	    javax.net.DatagramSocket dtgSock;
        dtgSock = new javax.net.DatagramSocket(srvPort);

        byte[] buf = new byte[4000];

//	    java.io.PrintWriter pw = new java.io.PrintWriter(filename);
//	    pw.close();
	    java.io.FileOutputStream fw = new java.io.FileOutputStream(filename);
	    DatagramPacket packet = new DatagramPacket(buf, buf.length);

	    while (true){
		    dtgSock.receive(packet);
		    // if receive an empty packet will indicate end of file
		    if (packet.getLength()==0) break;

		    System.out.print("*");
		    receivedFrames++;
            fw.write(packet.getData(),0,packet.getLength());
		    //fw.flush();
	    }
	    fw.flush();
	    fw.close();
	    dtgSock.close();	// Close the Socket
	    System.out.println("");
	    System.out.println("--- ");
	    System.out.println("We were supposed to recieve " + expectedFrames + ", we got " + receivedFrames);
	    System.out.println("Our loss was: " + Math.round(100.0 - (((double) receivedFrames/ (double) expectedFrames)*100.0)) + "%");
	    System.exit(0);
    }
}
