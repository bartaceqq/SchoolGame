package Command_Classes;

import Objects.Evidence;
import Objects.Inventory;

import java.util.Scanner;

public class Interact extends Command {
    Components components;
    Inventory inventory;
    Evidence evidence;
    Scanner sc = new Scanner(System.in);
    public Interact(Components components, Inventory inventory, Evidence evidence) {
    this.components = components;
this.inventory = inventory;
this.evidence = evidence;
    }

    private void interact(){
        System.out.println("Which itemm do you want to interact with ?");
        String pickupitem = sc.nextLine();
        if(components.roomlist.get(components.inroom).items.containsKey(pickupitem)){
            if (components.roomlist.get(components.inroom).items.get(pickupitem).pickable == true) {
                String yellow = "\u001B[33m";
                String reset = "\u001B[0m";
                System.out.println(yellow + components.roomlist.get(components.inroom).items.get(pickupitem).interaction + reset);
                inventory.inventorylist.put((components.roomlist.get(components.inroom).items.get(pickupitem).name),components.roomlist.get(components.inroom).items.get(pickupitem));
                inventory.addtofile(components.roomlist.get(components.inroom).items.get(pickupitem).name,components.roomlist.get(components.inroom).items.get(pickupitem).interaction, components.roomlist.get(components.inroom).items.get(pickupitem).info );
                evidence.checkforevidence(null);

                components.roomlist.get(components.inroom).items.remove(pickupitem);
            } else {
                String yellow = "\u001B[33m";
                String reset = "\u001B[0m";
                System.out.println(yellow + components.roomlist.get(components.inroom).items.get(pickupitem).interaction + reset);
                evidence.checkforevidence(components.roomlist.get(components.inroom).items.get(pickupitem).interaction);
                components.roomlist.get(components.inroom).items.remove(pickupitem);
            }
        }
    }
    @Override
    public void execute() {
interact();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
