import java.util.HashMap;

public class Components extends Command {
    HashMap<Integer, Room> roomlist = new HashMap<>();
    int inroom = 0;
    Boolean exit = false;
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

    @Override
    public void execute(String name) {
    printroomsthings();
    }

    @Override
    public Boolean exit() {
return false;
    }
}
