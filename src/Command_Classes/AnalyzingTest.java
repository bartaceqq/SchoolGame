package Command_Classes;

import Objects.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Analyzing test.
 */
class AnalyzingTest {
    /**
     * The Components.
     */
    Components components;
    /**
     * The Analyzing.
     */
    Analyzing analyzing;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        components = new Components();
        analyzing = new Analyzing(components);

        // Load necessary data
        new MapLoad(components).execute();
        new InventoryLoad(new Inventory()).execute();
        new LoadConversation(components).execute();
    }

    /**
     * Test analyze gun.
     */
    @Test
    void testAnalyzeGun() {
        String result = analyzing.analyze("gun");
        assertEquals("there is a blood on the gun",result);
    }
}
