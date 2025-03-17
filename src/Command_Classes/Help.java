package Command_Classes;

public class Help extends Command {
    public void help(){
        String red = "\u001B[31m";
        String reset = "\u001B[0m";
        System.out.println(red + "showroomitems" + reset);
        System.out.println(red + "move" + reset);
        System.out.println(red + "interact" + reset);
        System.out.println(red + "showinventory" + reset);
        System.out.println(red + "analyze" + reset);
        System.out.println(red + "connectevidence" + reset);
        System.out.println(red + "showevidence" + reset);
        System.out.println(red + "talk" + reset);
    }


    @Override
    public void execute() {
help();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
