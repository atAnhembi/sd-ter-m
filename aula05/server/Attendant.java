import java.net.Socket;
import java.util.HashMap;

public class Attendant extends Thread {
    private Socket client;
    private Communication communication;

    public Attendant(Socket socket) {
        client = socket;
        communication = new Communication(socket);
    }

    @Override
    public void run() {
        Translate translateReceived = (Translate) communication.receive();

        String resp = translate(translateReceived);

        Translate translateToSend;
        if(resp != null) {
            translateToSend = 
                new Translate(resp, Status.SUCCESS);
        } else {
            translateToSend = 
                new Translate(resp, Status.NOT_FOUND);
        }

        communication.send(translateToSend);
    }

    private String translate(Translate translate) {
        HashMap<String, String> dictionaryIngPort = new HashMap<>();

        dictionaryIngPort.put("red", "vermelho");
        dictionaryIngPort.put("blue", "azul");
        dictionaryIngPort.put("white", "branco");

        String trad = dictionaryIngPort.get(translate.getWord());

        return trad;
    }
}
