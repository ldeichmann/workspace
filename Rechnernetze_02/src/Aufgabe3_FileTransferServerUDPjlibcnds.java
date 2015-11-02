//package experiment2;

import java.net.*; // we use Sockets
import java.util.Arrays;

public class Aufgabe3_FileTransferServerUDPjlibcnds {

    
    public static void main(String args[]) throws Exception{
        // Arguments: port & filename
        int srvPort = Integer.parseInt(args[0]); // server UDP port
        String filename = args[1]; // file Name
        String comparisonFilename = args[2]; // file Name
        

	    // Open special datagramm socket from jlibcnds library, do not change this
	    javax.net.DatagramSocket dtgSock;
        dtgSock = new javax.net.DatagramSocket(srvPort);

        byte[] buf = new byte[8];
        byte[] inBuf = new byte[8];

//	    java.io.PrintWriter pw = new java.io.PrintWriter(filename);
//	    pw.close();
	    java.io.FileOutputStream fw = new java.io.FileOutputStream(filename);
	    DatagramPacket packet = new DatagramPacket(buf, buf.length);
	    
	    java.io.FileInputStream fr = new java.io.FileInputStream(comparisonFilename);
	    int len = 0;
	    int err = 0;
	    
	    
	    while (true){
		    dtgSock.receive(packet);
//		    System.out.print("*");
		    // if receive an empty packet will indicate end of file
//        	System.out.println(Arrays.toString(packet.getData()));
		
		    if (packet.getLength()==0) break;
//            fw.write(packet.getData(),0,packet.getLength());
            if ((len = fr.read(inBuf, 0, inBuf.length)) != -1) {
//            	System.out.println(Arrays.toString(inBuf));
            	int nerr = err;
            	err = err + Tools.countBitErrorsInByteArray(inBuf, packet.getData());
            	if (nerr < err ) {
                	System.out.print(new String(inBuf));
                	System.out.print(new String(packet.getData()));
                	System.out.println("---");
            	}
            }
		    //fw.flush();
	    }
	    fw.flush();
	    fw.close();
	    fr.close();
	    dtgSock.close();	// Close the Socket
	    System.out.println("");
	    System.out.println("Errors: " + err);
    }
}
