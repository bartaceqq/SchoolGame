package Objects;

public class Conversation {
    public  String text;
    public String evidence = null;

    @Override
    public String toString() {
        return "Conversation{" +
                "text='" + text + '\'' +
                ", evidence='" + evidence + '\'' +
                '}';
    }
}
