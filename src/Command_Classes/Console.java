package Command_Classes;

import Objects.Evidence;
import Objects.Inventory;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The type Console.
 */
public class Console implements Runnable {
    /**
     * The Sc.
     */
    Scanner sc = new Scanner(System.in);
    /**
     * The Commandmap.
     */
    HashMap<String, Command> commandmap = new HashMap<>();
    /**
     * The Components.
     */
    Components components = new Components();
    /**
     * The Inventory.
     */
    Inventory inventory = new Inventory();
    /**
     * The Evidence.
     */
    Evidence evidence = new Evidence();

    /**
     * Createcommands.
     */
    public void createcommands(){
        commandmap.put("showroomitems", new ShowRoomItems(components));

        commandmap.put("move", new Movement(components));
        commandmap.put("interact", new Interact(components, inventory, evidence));
        commandmap.put("showinventory", new ShowInventory(inventory));
        commandmap.put("analyze", new Analyzing(components));
        commandmap.put("connectevidence", new ConnectEvidence(components, evidence));
        commandmap.put("showevidence", new ShowEvidence());
        commandmap.put("talk", new Talk(components, evidence));
        commandmap.put("help", new Help());
        commandmap.put("guess", new Guess_Murder());


    }

    @Override
    public void run() {
        new MapLoad(components).execute();
        new InventoryLoad(inventory).execute();
        new LoadConversation(components).execute();
        System.out.println(components.roomlist.get(components.inroom).poeple.get(0).conversationlist);
        createcommands();
        while(true){
            System.out.print("Enter command: \n >>");
            String command = sc.nextLine();
            if(commandmap.containsKey(command)){
                System.out.println(commandmap.get(command).execute());
            } else if(command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}
