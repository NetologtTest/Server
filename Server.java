import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        System.out.println("Сервер стартовал");
        int port = 88888888;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    System.out.println("Новый контакт подключен");

                    final String name = in.readLine();

                    out.println(String.format("Привет %s, твой порт %d", name, clientSocket.getPort()));
                }

            }

        }
    }
}
