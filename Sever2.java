import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Sever2 {


    public static void main(String[] args) {
        String host = "localhost";
        int port = 88888888;
        try (Socket clientSocket = new Socket(host, port); PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Pavyk");

            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}