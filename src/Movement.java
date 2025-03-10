public class Movement extends Command {
    Components components;
    public Movement(Components components) {
        this.components = components;
    }
public void checkposition(){
    System.out.println("your position:");
    System.out.println(components.roomlist.get(components.inroom).name + ": inroom");
}
    public void move(String name) {
        System.out.println(components.roomlist.get(components.inroom).name + ": inroom");
        for (int i = 0; i < components.roomlist.size(); i++) {
            if (components.roomlist.get(i).name.equals(name)) {
                if (components.inroom == i || components.inroom == i+1 || components.inroom == i-1) {
                components.inroom = i;
                }
            } else {
                System.out.println("skibidi sracka nebyla nalezena");
            }
        }
        checkposition();
    }

    @Override
    public void execute( String name) {
        move(name);
    }

    @Override
    public Boolean exit() {
        return true;
    }
}
