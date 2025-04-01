package Command_Classes;

import Objects.Evidence;
import Objects.Inventory;

import java.util.Scanner;

/**
 * The type Interact.
 */
public class Interact extends Command {
    /**
     * The Components.
     */
    Components components;
    /**
     * The Inventory.
     */
    Inventory inventory;
    /**
     * The Evidence.
     */
    Evidence evidence;
    /**
     * The Sc.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Instantiates a new Interact.
     *
     * @param components the components
     * @param inventory  the inventory
     * @param evidence   the evidence
     */
    public Interact(Components components, Inventory inventory, Evidence evidence) {
        this.components = components;
        this.inventory = inventory;
        this.evidence = evidence;
    }

    private String interact() {
        StringBuilder result = new StringBuilder();

        String pickupitem = sc.nextLine();

        if (components.roomlist.get(components.inroom).items.containsKey(pickupitem)) {
            if (components.roomlist.get(components.inroom).items.get(pickupitem).pickable) {
                String yellow = "\u001B[33m";
                String reset = "\u001B[0m";
                result.append(yellow).append(components.roomlist.get(components.inroom).items.get(pickupitem).interaction).append(reset).append("\n");

                inventory.inventorylist.put(components.roomlist.get(components.inroom).items.get(pickupitem).name, components.roomlist.get(components.inroom).items.get(pickupitem));
                inventory.addtofile(components.roomlist.get(components.inroom).items.get(pickupitem).name, components.roomlist.get(components.inroom).items.get(pickupitem).interaction, components.roomlist.get(components.inroom).items.get(pickupitem).info);
                evidence.checkforevidence(null);

                components.roomlist.get(components.inroom).items.remove(pickupitem);
            } else {
                String yellow = "\u001B[33m";
                String reset = "\u001B[0m";
                result.append(yellow).append(components.roomlist.get(components.inroom).items.get(pickupitem).interaction).append(reset).append("\n");

                evidence.checkforevidence(components.roomlist.get(components.inroom).items.get(pickupitem).interaction);
                components.roomlist.get(components.inroom).items.remove(pickupitem);
            }
        } else {
            result.append("Item not found in this room.\n");
        }

        return result.toString();
    }

    @Override
    public String execute() {
        System.out.println("Which item do you want to interact with ?");
        return interact(); // Return the result of interact
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
