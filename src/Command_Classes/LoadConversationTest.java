package Command_Classes;

import Objects.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Load conversation test.
 */
class LoadConversationTest {
    /**
     * The Components.
     */
    Components components = new Components();
    /**
     * The Load conversation.
     */
    LoadConversation loadConversation = new LoadConversation(components);

    /**
     * Loadperson.
     */
    @Test
    void loadperson() {
        Person person = new Person();
        person.name = "John";
        assertEquals(loadConversation.loadperson(person), "John" + " has been loaded");
    }
}