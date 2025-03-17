package Command_Classes;

import Objects.Evidence;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Talk extends Command {
    Components components;
    Evidence evidence;
    Scanner sc = new Scanner(System.in);

    public Talk(Components components, Evidence evidence) {
        this.components = components;
        this.evidence = evidence;
    }

    public void talk() {
        System.out.println("Which person you want to talk with?");
        String answer = sc.nextLine();
        for (int i = 0; i < components.roomlist.get(components.inroom).poeple.size(); i++) {
            if (components.roomlist.get(components.inroom).poeple.get(i).name.equals(answer)) {
                components.roomlist.get(components.inroom).poeple.get(i).counter = 0;
                while (true) {

                    try {
                        String yellow = "\u001B[33m";
                        String reset = "\u001B[0m";

                        System.out.println( yellow + (components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter).text) + reset);
                        System.out.println("Press Enter to see the next message...");
                        sc.nextLine();
                        if (((components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter).evidence) != null)){
                            evidence.checkforevidence(((components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter).evidence)));
                        }
                        if ((components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter + 1)).equals(null)) {
                            break;
                        } else {
                            components.roomlist.get(components.inroom).poeple.get(i).counter++;
                        }
                    }catch (Exception e){
                        break;
                    }
                }
            }
        }

    }


    @Override
    public void execute() {
        talk();
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
