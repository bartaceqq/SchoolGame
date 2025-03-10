import java.io.BufferedReader;
import java.io.FileReader;

public class MapLoader extends Command {
    Components components;
    int counter = 0;
    public MapLoader(Components components) {
        this.components = components;
    }

    public void loadMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Map"));
            while (br.ready()) {
                int itemcounter = 0;
                int personcounter = 0;
                String line = br.readLine();
                String[] tokens = line.split("-");
                Room room = new Room();
                room.name = tokens[0];
                for (int i = 1; i < tokens.length; i++) {
                String[] letters = tokens[i].split("");
                if (letters[0].equals("/")) {
                    Item item = new Item();
                    if (letters[letters.length - 1].equals("+")) {
                        item.pickable = true;
                        item.name = tokens[i].substring(1, tokens[i].length() - 1); // Remove both '/' and '+'
                    } else {
                        item.name = tokens[i].substring(1); // Remove only '/'
                    }

                    room.items.put(itemcounter, item);
                    itemcounter++;
                } else if (letters[0].equals("*")) {
                Person person = new Person();
                person.name = tokens[0];
                room.poeple.put(personcounter, person);
                } else {
                    System.out.println("sign error");
                }
                }
            components.roomlist.put(counter, room);
                counter++;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(String name) {
loadMap();
    }

    @Override
    public Boolean exit() {
    return false;
    }
}
