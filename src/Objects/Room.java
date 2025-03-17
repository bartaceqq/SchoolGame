package Objects;

import java.util.HashMap;

public class Room {
   public String name;
    public HashMap<String, Item> items = new HashMap<>();
    public HashMap<Integer, Person> poeple = new HashMap<>();
}
