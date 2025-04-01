package Command_Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Guess murder test.
 */
class Guess_MurderTest {
    /**
     * The Guess murder.
     */
    Guess_Murder guessMurder = new Guess_Murder();

    /**
     * Regexcheck.
     */
    @Test
    void regexcheck() {
        assertEquals(guessMurder.regexcheck("John Pork"), true);
    }
}