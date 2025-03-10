import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {
    Scanner sc = new Scanner(System.in);
    Components components = new Components();
    HashMap<String, Command> commandmap = new HashMap<>();

    public void ConsoleStart() {

        MapLoader mapLoader = new MapLoader(components);
        mapLoader.loadMap();
        commandmap.put("move", new Movement(components));


        //-----//
        while (components.exit == false) {
            System.out.println("Enter command: ");
            String enterCommand = sc.nextLine();
            if (commandmap.containsKey(enterCommand)) {
                if (enterCommand.equals("move")) {
                    System.out.println("where?");
                    String enterCommand2 = sc.nextLine();
                    commandmap.get(enterCommand).execute(enterCommand2);
                }
            }
        }
    }
}
