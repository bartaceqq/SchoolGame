package Command_Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class Guess_MurderTest {
    Guess_Murder guessMurder = new Guess_Murder();
    @Test
    void regexcheck() {
        assertEquals(guessMurder.regexcheck("John Pork"), true);
    }
}