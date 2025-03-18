package Command_Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Guess_Murder extends Command {
    Scanner sc = new Scanner(System.in);

    public void guess() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Guessed"))) {


            String yellow = "\u001B[33m";
            String reset = "\u001B[0m";
            int count = 0;
            Boolean nomatch = false;
            ArrayList<String> namelist = new ArrayList<>();
            while (br.ready()) {
                namelist.add(br.readLine());
                count++;
            }
            if (count < 3) {
                while (true) {
                    System.out.println("Write your guess: ");
                    String guess = sc.nextLine();
                    if (guess.equals("exit")) {
                        break;
                    }
                    if (guess.matches("[Aa-zZ]+[ ][Aa-zZ]+")) {

                        if (namelist.contains(guess)) {
                            System.out.println("already tried this name");
                        } else if (guess.equals("debil")) {

                            System.out.println("You guessed the murder and won");
                            System.exit(0);
                            break;

                        } else {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Save_Files/Guessed", true));
                            bw.write(guess);
                            bw.newLine();
                            bw.flush();
                            bw.close();
                            System.out.println("didnt guessed right");
                            if (count == 2) {
                                System.out.printf("Game Over");
                                System.exit(0);
                            }
                            break;
                        }
                    } else {
                        System.out.println("Wrong format");
                    }
                }
            } else {
                System.out.println("too many guesses");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {
        guess();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}


