package Command_Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Guess_Murder extends Command {
    Scanner sc = new Scanner(System.in);

    public String guess() {
            String result = new String();
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
                            result += ("Already tried this name\n");
                        } else if (guess.equals("debil")) {

                            result += ("You guessed the murder and won\n");
                            System.exit(0);
                            break;

                        } else {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Save_Files/Guessed", true));
                            bw.write(guess);
                            bw.newLine();
                            bw.flush();
                            bw.close();
                            result += ("Didn't guess right\n");
                            if (count == 2) {
                                result +=("Game Over\n");
                                System.exit(0);
                            }
                            break;
                        }
                    } else {
                        result += ("Wrong format");
                    }
                }
            } else {
                result += ("Too many guesses");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Override
    public String execute() {
        return guess(); // Return the result of guess
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
