package Objects;

import Command_Classes.Interact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Evidence {
    int maxnum = 0;
    Boolean allow = true;
    Inventory inventory;
    Boolean checked = false;


    public void checkforevidence(String interaction) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Inventory"))) {
            while (br.ready()) {
                String line = br.readLine();
                String[] splitted = line.split(",");

                BufferedReader br1 = new BufferedReader(new FileReader("src/Save_Files/Connection"));
                while (br1.ready()) {
                    String line1 = br1.readLine();
                    String[] splitted1 = line1.split("-");

                    if (splitted[0].equals(splitted1[0])) {
                        boolean allow = true;
                        int smthg = 0;

                        BufferedReader br2 = new BufferedReader(new FileReader("src/Save_Files/Evidence"));
                        if (br2.ready()) {
                            checked = true;
                        } else {
                            checked = false;
                        }

                        while (br2.ready()) {
                            String line2 = br2.readLine();
                            String[] splitted2 = line2.split("/");
                            if (splitted1[1].equals(splitted2[1])) {
                                smthg = Integer.parseInt(splitted2[0]);
                                allow = false; // Prevent duplicate evidence
                            }
                        }
                        br2.close(); // Close the reader to avoid resource leaks

                        maxnum = Math.max(smthg, maxnum); // Ensure maxnum is updated correctly

                        if (allow) {
                            maxnum++; // Increment only when adding new evidence
                            String writer = maxnum + "/" + splitted1[1];

                            BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/Save_Files/Evidence", true));

                                bw1.write(writer);
                                bw1.newLine();

                            bw1.close(); // Ensure data is written properly
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {


            if (!interaction.equals(null)) {
                int counter = 0;
                Boolean same = false;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Save_Files/Evidence", true))) {
                    BufferedReader br1 = new BufferedReader(new FileReader("src/Save_Files/Evidence"));
                    while (br1.ready()) {
                        counter++;
                        String line1 = br1.readLine();
                        String[] splitted1 = line1.split("/");
                        if (splitted1[1].equals(interaction)) {
                            same = true;
                        }
                    }
                    if (!same) {
                        bw.write((counter + 1) + "/" + interaction);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e) {
        }
    }

}
