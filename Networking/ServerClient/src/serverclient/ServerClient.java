package serverclient;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ServerClient {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        final int PORTS=12345;
        
        try {
            ServerSocket serverSocket = new ServerSocket(PORTS);
            while(true)
            {
                Socket socket = serverSocket.accept();
                
                BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                
                String fromClient = rd.readLine();
                System.out.println("Client says "+fromClient);
                
                System.out.println("Respond the client ");
                String strs = kb.nextLine();
                out.println(strs);
                break;
                
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
