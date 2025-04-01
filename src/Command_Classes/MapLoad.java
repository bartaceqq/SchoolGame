package Command_Classes;

import Command_Classes.Command;
import Command_Classes.Components;
import Objects.Item;
import Objects.Person;
import Objects.Room;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The type Map load.
 */
public class MapLoad extends Command {
    /**
     * The Counter.
     */
    int counter = 0;
    /**
     * The Components.
     */
    Components components;

    /**
     * Instantiates a new Map load.
     *
     * @param components the components
     */
    public MapLoad(Components components) {
        this.components = components;
    }

    /**
     * Load map string.
     *
     * @return the string
     */
    public String loadMap() {
        String output = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Save_Files/Map"));
            while (br.ready()) {
                int personcounter = 0;
                String line = br.readLine();
                String[] tokens = line.split("-");
                Room room = new Room();
                room.name = tokens[0];
                int endinginter = 1;
                for (int i = 1; i < tokens.length; i++) {
                    String[] letters = tokens[i].split("");
                    if (letters[0].equals("/")) {
                        Item item = new Item();
                        String inter = "";
                        String info = "";

                        if (letters[1].equals("{")) {
                            int adder = 2;

                            while (adder < letters.length && !letters[adder].equals("}")) {
                                inter += letters[adder];
                                adder++;
                            }
                            endinginter = adder;
                        }

                        item.interaction = inter;

                        if (endinginter + 1 < letters.length && letters[endinginter + 1].equals("(")) {
                            int adder = endinginter + 2;
                            // Collect everything between the parentheses
                            while (adder < letters.length && !letters[adder].equals(")")) {
                                info += letters[adder];
                                adder++;
                            }
                            endinginter = adder;
                        }

                        item.info = info;
                        String name = "";
                        if (letters[letters.length - 1].equals("+")) {
                            item.pickable = true;
                        } else {
                            item.pickable = false;
                        }
                        int counter = 0;
                        for (int j = 0; j < letters.length; j++) {
                            if (letters[j].equals(")")) {
                                counter = j;
                            }
                        }

                        for (int j = counter + 1; j < letters.length; j++) {
                            name += letters[j];
                        }
                        String namesplit[] = name.split("");
                        if (namesplit[namesplit.length - 1].equals("+")) {
                            name = "";
                            for (int j = 0; j < namesplit.length - 1; j++) {
                                name += namesplit[j];
                            }
                        }
                        item.name = name;
                        room.items.put(item.name, item);

                    } else if (letters[0].equals("*")) {
                        Person person = new Person();
                        person.name = tokens[i].substring(1); // Fix: Remove '*' from the person name
                        room.poeple.put(personcounter, person); // Add person to room
                        personcounter++; // Increment person counter
                    } else {
                        output += "Sign error in map file at room " + room.name + "\n";
                    }
                }
                components.roomlist.put(counter, room);
                output += "Room " + room.name + " loaded successfully.\n";
                counter++;
            }
        } catch (Exception e) {
            output += "Error loading map: " + e.getMessage() + "\n";
        }

        return output; // Return the accumulated output as a string
    }

    @Override
    public String execute() {
        return loadMap(); // Return the result from loadMap
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
