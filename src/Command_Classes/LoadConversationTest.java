package Command_Classes;

import Objects.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadConversationTest {
    Components components = new Components();
    LoadConversation loadConversation = new LoadConversation(components);
    @Test
    void loadperson() {
        Person person = new Person();
        person.name = "John";
        assertEquals(loadConversation.loadperson(person), "John" + " has been loaded");
    }
}