package Command_Classes;

import java.util.Scanner;

public class Analyzing extends Command {
    Components components;
    Scanner sc = new Scanner(System.in);

    public Analyzing(Components components) {
        this.components = components;
    }

    public void analyze() {
        System.out.println("which item do you want to analyze?");
        String lookatitem = sc.nextLine();
        if (components.roomlist.get(components.inroom).items.containsKey(lookatitem)) {
            System.out.println(components.roomlist.get(components.inroom).items.get(lookatitem).info);
        }
    }

    @Override
    public void execute() {
analyze();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
