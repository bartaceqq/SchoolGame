package Command_Classes;

import Objects.Conversation;
import Objects.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class LoadConversation extends Command {
    Components components;
    HashMap<String, Person> intextpersonlist = new HashMap<>();

    public LoadConversation(Components components) {
        this.components = components;
    }

    public void loadConversation() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Conversations"));
            Person person = null;

            while (br.ready()) {
                String line = br.readLine().trim(); // Trim any extra spaces or newlines

                if (line.startsWith("*")) { // New person


                    if (person != null) {
                        intextpersonlist.put(person.name, person);
                    }
                    person = new Person();
                    person.name = line.substring(1); // Remove the '*' character

                } else if (line.startsWith("-")) { // Conversation text
                    if (person != null) {
                        String text = line.substring(1).trim();
                        if (text.contains("/")) {
                            String[] halfed = text.split("/");
                            Conversation c = new Conversation();
                            c.text = halfed[0];
                            c.evidence = halfed[1];
                            person.conversationlist.add(c);
                        } else {
                            Conversation c = new Conversation();
                            c.text = text;
                            c.evidence = null;
                            person.conversationlist.add(c);
                        }
                    }
                }
            }
            if (person != null) {
                intextpersonlist.put(person.name, person);
            }
            for (int i = 0; i < components.roomlist.size(); i++) {
                for (int j = 0; j < components.roomlist.get(i).poeple.size(); j++) {
                    Person roomPerson = components.roomlist.get(i).poeple.get(j);
                    if (intextpersonlist.containsKey(roomPerson.name)) {
                        roomPerson.conversationlist = intextpersonlist.get(roomPerson.name).conversationlist;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {
        loadConversation();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
