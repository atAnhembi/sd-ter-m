import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 4567;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Aguardando cliente...");
                Socket client = serverSocket.accept();
                
                Attendant attendant = new Attendant(client);
                attendant.start();
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
