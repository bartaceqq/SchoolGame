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

    public String loadConversation() {
        String output = ""; // To accumulate the result

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
                    output += "Loaded person: " + person.name + "\n"; // Add to output

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

            // Synchronize conversations with people in rooms
            for (int i = 0; i < components.roomlist.size(); i++) {
                for (int j = 0; j < components.roomlist.get(i).poeple.size(); j++) {
                    Person roomPerson = components.roomlist.get(i).poeple.get(j);
                    if (intextpersonlist.containsKey(roomPerson.name)) {
                        roomPerson.conversationlist = intextpersonlist.get(roomPerson.name).conversationlist;
                        output += "Conversations loaded for " + roomPerson.name + "\n"; // Add to output
                    }
                }
            }

        } catch (Exception e) {
            output += "Error loading conversations: " + e.getMessage() + "\n"; // Add error to output
        }

        return output; // Return the accumulated output as a string
    }

    @Override
    public String execute() {
        return loadConversation(); // Return the result from loadConversation
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
