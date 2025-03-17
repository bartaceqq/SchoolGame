package Command_Classes;

import Objects.Item;
import Objects.Room;

public class ShowRoomItems extends Command {
    Components components;
    public ShowRoomItems(Components components) {
        this.components = components;
    }

    public void showitemsinroom() {
        if (components.roomlist.containsKey(components.inroom)) {
            Room currentRoom = components.roomlist.get(components.inroom);
            System.out.println("Items in " + currentRoom.name + ":");

            // Loop through all items in the room and print their details
            for (Item item : currentRoom.items.values()) {
                System.out.println("- " + item.name); // Print item name
                System.out.println("  Pickable: " + item.pickable); // Print pickable status
                System.out.println("  Info: " + item.info); // Print info about the item
                System.out.println("  Interaction: " + item.interaction); // Print interaction text
            }
        } else {
            System.out.println("No items in this room.");
        }
    }
    @Override
    public void execute() {
showitemsinroom();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
