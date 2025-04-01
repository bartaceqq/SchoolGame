package Command_Classes;

import Objects.Evidence;
import Objects.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Interact test.
 */
class InteractTest {
    /**
     * The Components.
     */
    Components components = new Components();
    /**
     * The Inventory.
     */
    Inventory inventory = new Inventory();
    /**
     * The Evidence.
     */
    Evidence evidence = new Evidence();
    /**
     * The Interact.
     */
    Interact interact = new Interact(components, inventory, evidence);

    /**
     * Interactwith.
     */
    void interactwith(){
        assertEquals(interact.execute(),"Item not found in this room.\n");
    }

    /**
     * Execute.
     */
    @Test
    void execute() {
        interactwith();
    }

    /**
     * Exit.
     */
    @Test
    void exit() {
    }
}