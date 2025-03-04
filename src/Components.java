import java.util.HashMap;

public class Components {
    HashMap<Integer, Room> roomlist = new HashMap<>();
    int inroom = 0;
    public void printroomsthings(){
        System.out.println(" ITEMS: ");
        for (int i = 0; i <roomlist.get(inroom).items.size(); i++) {
            System.out.println(roomlist.get(inroom).items.get(i));
        }
        System.out.println(" PEOPLE: ");
        for (int i = 0; i <roomlist.get(inroom).poeple.size(); i++) {
            System.out.println(roomlist.get(inroom).poeple.get(i));
        }
    }
}
