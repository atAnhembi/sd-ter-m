import java.io.Serializable;

public class Translation implements Serializable {
    private String word;
    private Language language;
    private Status status;
    
    public Translation(String word, Language language) {
        this.word = word;
        this.language = language;
    }

    public Translation(String word, Status status) {
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
