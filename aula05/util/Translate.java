import java.io.Serializable;

public class Translate implements Serializable {
    private String word;
    private Language language;
    private Status status;
    
    public Translate(String word, Language language) {
        this.word = word;
        this.language = language;
    }

    public Translate(String word, Status status) {
        this.word = word;
        this.status = status;
    }

    public String getWord() {
        return word;
    }

    public Language getLanguage() {
        return language;
    }

    public Status getStatus() {
        return status;
    }
}
