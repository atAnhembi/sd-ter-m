import java.net.Socket;
import java.util.HashMap;

public class Attendant extends Thread {
    // private Socket client;
    private Communication communication;

    public Attendant(Socket socket) {
        // client = socket;
        communication = new Communication(socket);
    }

    @Override
    public void run() {
        Translation received = (Translation) communication.receive();

        String resp = translate(received);

        Translation translationToSend;
        if(resp != null) {
            translationToSend = 
                new Translation(resp, Status.SUCCESS);
        } else {
            translationToSend = 
                new Translation(resp, Status.NOT_FOUND);
        }

        communication.send(translationToSend);
    }

    private String translate(Translation translate) {
        HashMap<String, String> dictionaryIngPort = new HashMap<>();

        dictionaryIngPort.put("red", "vermelho");
        dictionaryIngPort.put("blue", "azul");
        dictionaryIngPort.put("white", "branco");

        String trad = dictionaryIngPort.get(translate.getWord());

        return trad;
    }
}
