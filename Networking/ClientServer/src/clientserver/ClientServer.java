package clientserver;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class ClientServer {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        final String ID_ADRESS="127.0.0.1";
        final int PORT=12345;
        
        try {
            Socket socket = new Socket(ID_ADRESS, PORT);
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            System.out.println("Enter message :");
            String str=kb.nextLine();
            out.println(str);
            System.out.println("Client says "+str);
            
            String fromServer = rd.readLine();
            System.out.println("Server says "+fromServer);
            
            
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
