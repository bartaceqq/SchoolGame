package Command_Classes;

import java.io.BufferedReader;
import java.io.FileReader;

public class ShowEvidence extends Command {
    public void showevidence() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Evidence"))) {
            while (br.ready()) {
                String line = br.readLine();
                String yellow = "\u001B[33m";
                String reset = "\u001B[0m";
                System.out.println( yellow + line + reset );
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {
        showevidence();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
