package Command_Classes;

import Objects.Evidence;
import Objects.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InteractTest {
    Components components = new Components(); 
        Inventory inventory = new Inventory();
        Evidence evidence = new Evidence();
    Interact interact = new Interact(components, inventory, evidence);
    void interactwith(){
        assertEquals(interact.execute(),"Item not found in this room.\n");
    }
    @Test
    void execute() {
        interactwith();
    }

    @Test
    void exit() {
    }
}