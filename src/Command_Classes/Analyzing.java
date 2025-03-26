package Command_Classes;

import java.util.Scanner;

public class Analyzing extends Command {
    Components components;
    Scanner sc = new Scanner(System.in);

    public Analyzing(Components components) {
        this.components = components;
    }

    public String analyze() {
        String output = "";
        System.out.println("which item do you want to analyze?");
        String lookatitem = sc.nextLine();
        if (components.roomlist.get(components.inroom).items.containsKey(lookatitem)) {
           return (components.roomlist.get(components.inroom).items.get(lookatitem).info);
        } else {
            return "item not founf or is not in room";
        }
    }

    @Override
    public String execute() {
return analyze();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
