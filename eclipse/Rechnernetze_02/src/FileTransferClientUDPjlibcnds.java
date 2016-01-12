//package experiment2;

import java.net.*; // we use Sockets

public class FileTransferClientUDPjlibcnds {

    
    public static void main(String args[]) throws Exception{ 
        // Arguments: Server name & port & filename to transfer
        String srvName = args[0]; // server Name
        int srvPort = Integer.parseInt(args[1]); // server UDP port
        String filename = args[2]; // server Name

	    // Open special datagramm socket from jlibcnds library, do not change this
	    javax.net.DatagramSocket dtgSock;
        dtgSock = new javax.net.DatagramSocket();
        InetSocketAddress srvSockAddr = new InetSocketAddress(srvName, srvPort);
        dtgSock.connect(srvSockAddr);

        byte[] buf = new byte[8];

	    java.io.FileInputStream fr = new java.io.FileInputStream(filename);

	    int len; // number of bytes written from the file

	    while ((len=fr.read(buf,0,buf.length))!= -1){

	        DatagramPacket packet = new DatagramPacket(buf, len);
        	dtgSock.send(packet);
			System.out.print("*");
			Thread.sleep(100);
	    }
		
	    // Send an empty packet to the server to indicate end of file
        DatagramPacket packet = new DatagramPacket(buf, 0);
       	dtgSock.send(packet);
        dtgSock.close();	// Close the Socket
        fr.close();
        return;
    }
}
