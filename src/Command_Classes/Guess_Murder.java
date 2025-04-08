package Command_Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Guess murder.
 */
public class Guess_Murder extends Command {
    /**
     * The Sc.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Guess string.
     *
     * @return the string
     */
    public String guess() {
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Guessed"))) {
            int count = 0;
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

                    if (guess == null || guess.isEmpty()) {
                        System.out.println("no input");
                        continue;  // Restart the loop
                    }

                    boolean valid = regexcheck(guess);
                    if (!valid) {
                        System.out.println("Wrong format");
                        continue;  // Restart the loop without executing further
                    }

                    if (namelist.contains(guess)) {
                        System.out.println("Already tried this name.");
                    } else if (guess.equals("John Pork")) {
                        System.out.println("You guessed the murder and won!");
                        System.exit(0);
                    } else {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Save_Files/Guessed", true))) {
                            bw.write(guess);
                            bw.newLine();
                        }
                        System.out.println("Didn't guess right.");
                        if (count == 2) {
                            System.out.println("Game Over");
                            System.exit(0);
                        }
                    }
                }
            } else {
                System.out.println("Too many guesses.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Regexcheck boolean.
     *
     * @param guessik the guessik
     * @return the boolean
     */
    public boolean regexcheck(String guessik) {
        return guessik.matches("[A-Za-z]+ [A-Za-z]+");
    }

    @Override
    public String execute() {
        return guess();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
