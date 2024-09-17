import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final int PORT = 4567;
        final String serverName = "localhost";
        Socket socket = null;
        Translation request, response;
        Communication communication;
        try {
            socket = new Socket(serverName, PORT);
            communication = new Communication(socket);

            request = new Translation("red", Language.ING_PORT);
            communication.send(request);

            response = (Translation) communication.receive();
            System.out.println("Recebido: " + response.getWord());

        } catch (Exception e) {
            System.out.println("Erro:"+ e.getMessage()) ;
        }

    }
}
