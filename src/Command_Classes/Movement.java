package Command_Classes;

import java.util.Scanner;

public class Movement extends Command {
    Components components;
    Scanner sc = new Scanner(System.in);

    public Movement(Components components) {
        this.components = components;
    }
    public void checkposition(){
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";
        System.out.println(yellow + "your position:" + components.roomlist.get(components.inroom).name + reset);
    }
    public void move() {
        System.out.println("in which room?");
        String roomname = sc.nextLine();
        Boolean found = false;
        for (int i = 0; i < components.roomlist.size(); i++) {
            if (components.roomlist.get(i).name.equals(roomname)) {
                if (components.inroom == i || components.inroom == i+1 || components.inroom == i-1) {
                    components.inroom = i;
                    found = true;
                }
            }
        }
        if (!found) {

            System.out.println("room not found");
        }
        checkposition();
    }
    @Override
    public void execute() {
move();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
