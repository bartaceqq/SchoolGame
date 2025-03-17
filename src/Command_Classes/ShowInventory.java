package Command_Classes;

import Objects.Inventory;

import java.io.BufferedReader;
import java.io.FileReader;

public class ShowInventory extends Command {
    Inventory inventory;

    public ShowInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void showInventory() {
        try(BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Inventory"))) {
            while (br.ready()) {
                String line = br.readLine();
                String splitted[] = line.split(",");
                System.out.println("- " + splitted[0]); // Print item
                System.out.println("  Info: " + splitted[2]); // Print info about the item
                System.out.println("  Interaction: " + splitted[1]);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void execute() {
       showInventory();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
