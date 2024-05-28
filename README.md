# Java-Socket-Programming
### Java Clint-Server connection: 

## Server Side java code: (EchoServer.java)

```java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        
        try {
            System.out.println("Waiting for clints....");
            ServerSocket ss = new ServerSocket(9806);
            Socket soc = ss.accept();
            System.out.println("Connection established");

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = in.readLine();
            System.out.println("Clint Says: "+ str);
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("Server says: "+ str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Clint side java code: (EchoClint.java)

```java
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
```

> Always run ser side code first and then run the clint side code into different terminal.
