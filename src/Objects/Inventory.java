package Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Inventory {
     public HashMap<String, Item> inventorylist = new HashMap<>();
     public void addtofile(String name, String interaction, String info){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/Save_Files/Inventory", true))) {
            Boolean found = false;
            String line = "";
            line+= name + "," + interaction + "," + info;
            BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Inventory"));
            while (br.ready()) {
                String readLine = br.readLine();
                if(readLine.contains(name)){
                    found = true;
                    break;
                }
            }
            if(!found) {
                bw.write(line);
                bw.newLine();
            }
        }catch (Exception e){
            
        }
     }
}
