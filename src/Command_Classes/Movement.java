package Command_Classes;

import java.util.Scanner;

public class Movement extends Command {
    Components components;
    Scanner sc = new Scanner(System.in);

    public Movement(Components components) {
        this.components = components;
    }

    public String checkPosition() {
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";
        return yellow + "Your position: " + components.roomlist.get(components.inroom).name + reset;
    }

    public String move(String ss) {
        StringBuilder result = new StringBuilder();
        Boolean found = false;

        for (int i = 0; i < components.roomlist.size(); i++) {
            if (components.roomlist.get(i).name.equals(ss)) {
                if (components.inroom == i || components.inroom == i + 1 || components.inroom == i - 1) {
                    components.inroom = i;
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            result.append("Room not found\n");
        }

        result.append(checkPosition()); // Add position details
        return result.toString(); // Return the result as a string
    }

    @Override
    public String execute() {
        System.out.println("In which room?");
        return move(sc.nextLine()); // Return the result of move
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
