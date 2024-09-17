import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Communication {
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Communication(Socket socket) {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("Erro ao criar comunicação");
            System.out.println(e.getMessage());
        }
    }

    public void send(Object object) {
        try {
            output.writeObject(object);
        } catch (Exception e) {
            System.out.println("Erro ao enviar os dados");
            System.out.println(e.getMessage());
        }
    }

    public Object receive() {
        try {
            return input.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao receber os dados");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
