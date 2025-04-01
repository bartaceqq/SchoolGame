package Command_Classes;

import Objects.Inventory;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The type Show inventory.
 */
public class ShowInventory extends Command {
    /**
     * The Inventory.
     */
    Inventory inventory;

    /**
     * Instantiates a new Show inventory.
     *
     * @param inventory the inventory
     */
    public ShowInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Show inventory string.
     *
     * @return the string
     */
    public String showInventory() {
        String output = ""; // To accumulate the result

        try (BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Inventory"))) {
            while (br.ready()) {
                String line = br.readLine();
                String[] splitted = line.split(",");
                output += "- " + splitted[0] + "\n"; // Append item name
                output += "  Info: " + splitted[2] + "\n"; // Append info about the item
                output += "  Interaction: " + splitted[1] + "\n"; // Append interaction
                output += "----------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }
        } catch (Exception e) {
            output += "Error loading inventory: " + e.getMessage() + "\n"; // Append error message
        }

        return output; // Return the accumulated result as a string
    }

    @Override
    public String execute() {
        return showInventory(); // Return the result from showInventory
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
