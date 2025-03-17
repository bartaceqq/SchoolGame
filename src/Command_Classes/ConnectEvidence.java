package Command_Classes;

import Objects.Evidence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConnectEvidence extends Command {
    Components components;
    Evidence evidence;
    Scanner sc = new Scanner(System.in);
    ArrayList<String> evidences = new ArrayList<>();

    public ConnectEvidence(Components components, Evidence evidence) {
        this.components = components;
        this.evidence = evidence;
    }

    public void connectEvidence() {
        try {
            String tex1 = "";
            String tex2 = "";
            String realevidence = "";
            System.out.println("Choose evidence 1 (number)");
            String choice = sc.nextLine();
            int number1 = Integer.parseInt(choice);
            System.out.println("Choose evidence 2 (number)");
            String choice2 = sc.nextLine();
            int number2 = Integer.parseInt(choice2);

            BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Evidence"));
            ArrayList<String> evidences = new ArrayList<>();
            while (br.ready()) {
                String line = br.readLine();
                String[] split = line.split("/");
                evidences.add(line); // Store the full line
            }
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader("src/Save_Files/Evidence"));
            while (br2.ready()) {
                String line = br2.readLine();
                String[] split = line.split("/");
                if (split[0].equals(String.valueOf(number1))) tex1 = split[1];
                if (split[0].equals(String.valueOf(number2))) tex2 = split[1];
            }
            br2.close();

            BufferedReader br3 = new BufferedReader(new FileReader("src/Save_Files/Evidence-Connect"));
            while (br3.ready()) {
                String line = br3.readLine();
                String[] split = line.split("/");
                if ((split[0].equals(tex1) && split[1].equals(tex2)) || (split[0].equals(tex2) && split[1].equals(tex1))) {
                    realevidence = split[2];
                }
            }
            br3.close();

            if (!realevidence.isEmpty()) {
                evidences.removeIf(e -> e.startsWith(number1 + "/") || e.startsWith(number2 + "/")); // Remove old evidence
                evidences.add("1/" + realevidence); // Add the new connected evidence
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Save_Files/Evidence", false));
            int number = 1;
            for (String ev : evidences) {
                bw.write(number + "/" + ev.substring(ev.indexOf("/") + 1));
                bw.newLine();
                number++;
            }

            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void execute() {
        connectEvidence();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
