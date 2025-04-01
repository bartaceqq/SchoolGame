package Command_Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Help test.
 */
class HelpTest {
    /**
     * The Help.
     */
    Help help = new Help();
    /**
     * The Red.
     */
    String red = "\u001B[31m";
    /**
     * The Reset.
     */
    String reset = "\u001B[0m";

    /**
     * Help.
     */
    @Test
    void help() {
        assertEquals(help.help(), (red) +("showroomitems") + (reset) + ("\n") +(red) +("move") + (reset) + ("\n")+ (red) +("interact") + (reset) + ("\n")+ (red) +("showinventory") + (reset) + ("\n")+ (red) +("analyze") + (reset) + ("\n")+ (red) +("connectevidence") + (reset) + ("\n")+ (red) +("showevidence") + (reset) + ("\n")+ (red) +("talk") + (reset) + ("\n"));


    }
}