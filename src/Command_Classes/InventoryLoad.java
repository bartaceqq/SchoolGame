package Command_Classes;

import Objects.Inventory;
import Objects.Item;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The type Inventory load.
 */
public class InventoryLoad extends Command {
    /**
     * The Inventory.
     */
    Inventory inventory;

    /**
     * Instantiates a new Inventory load.
     *
     * @param inventory the inventory
     */
    public InventoryLoad(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Inventory load string.
     *
     * @return the string
     */
    public String inventoryLoad() {
        String output = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Inventory"))) {
            while (br.ready()) {
                String line = br.readLine();
                String[] parts = line.split(",");
                Item item = new Item();
                item.name = parts[0];
                item.interaction = parts[1];
                item.info = parts[2];
                output += "Loaded item: " + item.name + "\n"; // Append item info
                inventory.inventorylist.put(item.name, item);
            }
        } catch (Exception e) {
            output += "Error loading inventory: " + e.getMessage() + "\n"; // Append error message
        }

        return output; // Return the accumulated output as a string
    }

    @Override
    public String execute() {
        return inventoryLoad(); // Return the result from inventoryLoad
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
