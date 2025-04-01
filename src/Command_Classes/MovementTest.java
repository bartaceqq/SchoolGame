package Command_Classes;

import Objects.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {
    Components components;
    Movement movement;
    Inventory inventory;

    @BeforeEach
    void setUp() {
        components = new Components();
        inventory = new Inventory();
        movement = new Movement(components);

        // Load rooms, items, and conversations from files
        new MapLoad(components).execute();
        new InventoryLoad(inventory).execute();
        new LoadConversation(components).execute();
    }

    @Test
    void testMoveToGarage() {
        String result = movement.move("garage");
        assertTrue(result.contains("Your position: garage"), "not working");
    }
}
