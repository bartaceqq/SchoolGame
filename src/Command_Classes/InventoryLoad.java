package Command_Classes;

import Objects.Inventory;
import Objects.Item;

import java.io.BufferedReader;
import java.io.FileReader;

public class InventoryLoad extends Command {
    Inventory inventory;

    public InventoryLoad(Inventory inventory) {
        this.inventory = inventory;
    }

    public void inventoryLoad() {
        try(BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Inventory"))) {
             while (br.ready()) {
                 String line = br.readLine();
                 String[] parts = line.split(",");
                 Item item = new Item();
                 item.name = parts[0];
                 item.interaction = parts[1];
                 item.info = parts[2];
                 System.out.println(item);
                 inventory.inventorylist.put(item.name, item);
             }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void execute() {
        inventoryLoad();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
