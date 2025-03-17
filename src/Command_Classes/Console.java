package Command_Classes;

import Objects.Evidence;
import Objects.Inventory;

import java.util.HashMap;
import java.util.Scanner;

public class Console implements Runnable {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Command> commandmap = new HashMap<>();
    Components components = new Components();
    Inventory inventory = new Inventory();
    Evidence evidence = new Evidence();
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
            commandmap.get(command).execute();
            } else if(command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}
