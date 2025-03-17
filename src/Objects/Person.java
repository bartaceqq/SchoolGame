package Objects;

import java.util.ArrayList;

public class Person {

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String name;
    public int counter = 0;
    public ArrayList<Conversation> conversationlist = new ArrayList<>();
    String[] textstotalk;
}
