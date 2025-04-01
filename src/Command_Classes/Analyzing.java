package Command_Classes;

import java.util.Scanner;

/**
 * The type Analyzing.
 */
public class Analyzing extends Command {
    /**
     * The Components.
     */
    Components components;
    /**
     * The Sc.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Instantiates a new Analyzing.
     *
     * @param components the components
     */
    public Analyzing(Components components) {
        this.components = components;
    }

    /**
     * Analyze string.
     *
     * @param lookatitem the lookatitem
     * @return the string
     */
    public String analyze(String lookatitem) {
        String output = "";

        if (components.roomlist.get(components.inroom).items.containsKey(lookatitem)) {
            return (components.roomlist.get(components.inroom).items.get(lookatitem).info);
        } else {
            return "item not founf or is not in room";
        }
    }

    @Override
    public String execute() {
        System.out.println("which item do you want to analyze?");
        return analyze(sc.nextLine());
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
