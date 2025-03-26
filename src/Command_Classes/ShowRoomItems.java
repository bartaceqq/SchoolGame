package Command_Classes;

import Objects.Item;
import Objects.Room;

public class ShowRoomItems extends Command {
    Components components;
    public ShowRoomItems(Components components) {
        this.components = components;
    }

    public String showitemsinroom() {
        String output = "";

        if (components.roomlist.containsKey(components.inroom)) {
            Room currentRoom = components.roomlist.get(components.inroom);
            output += "Items in " + currentRoom.name + ":\n";

            // Loop through all items in the room and append their details
            for (Item item : currentRoom.items.values()) {
                output += "- " + item.name + "\n"; // Append item name
                output += "  Pickable: " + item.pickable + "\n"; // Append pickable status
                output += "  Info: " + item.info + "\n"; // Append info about the item
                output += "  Interaction: " + item.interaction + "\n"; // Append interaction text
            }
        } else {
            output += "No items in this room.\n";
        }

        return output; // Return the accumulated string
    }

    @Override
    public String execute() {
        return showitemsinroom(); // Return the result from showitemsinroom
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
