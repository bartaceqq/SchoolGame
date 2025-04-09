import Command_Classes.Console;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        System.out.println("all available rooms: " +
                "\ncrime_scene\n" +
                "\n" +
                "butcher_shop\n" +
                "\n" +
                "victims_house\n" +
                "\n" +
                "park\n" +
                "\n" +
                "alley\n" +
                "\n" +
                "morgue\n" +
                "\n" +
                "police_station\n" +
                "\n" +
                "bank\n" +
                "\n" +
                "tavern\n" +
                "\n" +
                "clocktower");
        console.run();
    }
}