package Command_Classes;

import java.io.StringReader;

/**
 * The type Help.
 */
public class Help extends Command {

    /**
     * Help string.
     *
     * @return the string
     */
    public String help() {
        String red = "\u001B[31m";
        String reset = "\u001B[0m";
        String result = new String();

        result += (red) +("showroomitems") + (reset) + ("\n");
        result += (red) +("move") + (reset) + ("\n");
        result += (red) +("interact") + (reset) + ("\n");
        result += (red) +("showinventory") + (reset) + ("\n");
        result += (red) +("analyze") + (reset) + ("\n");
        result += (red) +("connectevidence") + (reset) + ("\n");
        result += (red) +("showevidence") + (reset) + ("\n");
        result += (red) +("talk") + (reset) + ("\n");

        return result.toString();
    }

    @Override
    public String execute() {
        return help(); // Return the result of help
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
