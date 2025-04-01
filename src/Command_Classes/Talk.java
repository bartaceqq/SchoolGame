package Command_Classes;

import Objects.Evidence;

import java.util.Scanner;

/**
 * The type Talk.
 */
public class Talk extends Command {
    /**
     * The Components.
     */
    Components components;
    /**
     * The Evidence.
     */
    Evidence evidence;
    /**
     * The Sc.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Instantiates a new Talk.
     *
     * @param components the components
     * @param evidence   the evidence
     */
    public Talk(Components components, Evidence evidence) {
        this.components = components;
        this.evidence = evidence;
    }

    /**
     * Talk string.
     *
     * @return the string
     */
    public String talk() {
        String output = new String(); // To accumulate the result
        System.out.println("Which person you want to talk with?");
        String answer = sc.nextLine();

        for (int i = 0; i < components.roomlist.get(components.inroom).poeple.size(); i++) {
            if (components.roomlist.get(components.inroom).poeple.get(i).name.equals(answer)) {
                components.roomlist.get(components.inroom).poeple.get(i).counter = 0;
                while (true) {

                    try {
                        String yellow = "\u001B[33m";
                        String reset = "\u001B[0m";

                        System.out.println( yellow + (components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter).text)  + (reset));

                        System.out.println("Press Enter to see the next message...\n");
                        sc.nextLine();

                        if (components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter).evidence != null) {
                            evidence.checkforevidence(components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter).evidence);
                        }

                        if ((components.roomlist.get(components.inroom).poeple.get(i).conversationlist.get(components.roomlist.get(components.inroom).poeple.get(i).counter + 1)) == null) {
                            break;
                        } else {
                            components.roomlist.get(components.inroom).poeple.get(i).counter++;
                        }
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        }

        return output.toString(); // Return the accumulated conversation
    }

    @Override
    public String execute() {
        return talk(); // Return the result from talk method
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
