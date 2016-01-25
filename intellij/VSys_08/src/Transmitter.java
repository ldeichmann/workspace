import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

/**
 * Created by lukas on 1/25/16.
 */
public class Transmitter {

    public static void main(String args[]) throws Exception {
        try {
            Receiver a = (Receiver) Naming.lookup("rmi://localhost:1099/Receiver");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null) {
                a.receive(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
