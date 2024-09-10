import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int PORT = 9876;
        ServerSocket serverSocket = null;
        Socket socketClient = null;
        Scanner scanner = null;

        // criação do socket e binding
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor disponível na porta " + PORT);
        } catch (Exception e) {
            System.out.println("Erro no binding: " + e.getMessage());
            return;
        }

        // conexão com o client
        try {
            System.out.println("Aguardando o cliente...");
            socketClient = serverSocket.accept();
            System.out.println("Conectado ao cliente");
            scanner = new Scanner(socketClient.getInputStream());
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o cliente");
            System.out.println(e.getMessage());
            return;
        }

        // comunicação
        try {
            String message = scanner.nextLine();
            System.out.println("Recebida a mensagem do cliente:");
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Erro na comunicação");
            System.out.println(e.getMessage());
        }

        // desconexão
        try {
            System.out.println("Encerrando o servidor");
            scanner.close();
            socketClient.close();
            serverSocket.close();
        } catch (Exception e) {

        }
    }
}
