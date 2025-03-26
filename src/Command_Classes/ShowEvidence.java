package Command_Classes;

import java.io.BufferedReader;
import java.io.FileReader;

public class ShowEvidence extends Command {

    public String showEvidence() {
        String output = new String(); // To accumulate the result
        try (BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Evidence"))) {
            while (br.ready()) {
                String line = br.readLine();
                String yellow = "\u001B[33m";
                String reset = "\u001B[0m";
               output += yellow + line + reset + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString(); // Return the accumulated evidence as a string
    }

    @Override
    public String execute() {
        return showEvidence(); // Return the result from showEvidence method
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
