import java.io.*;
import java.net.Socket;

public class EchoClint {
    public static void main(String[] args) {
        
        try {
            System.out.println("Clint Sterted");
            
            Socket soc = new Socket("localhost", 9806);
            BufferedReader userin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a string:");
            String str = userin.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
