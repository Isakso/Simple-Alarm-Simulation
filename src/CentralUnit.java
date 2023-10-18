import SecuritySystem.Detectors;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class CentralUnit {

    static {

        int userInput;
        Scanner scanner = new Scanner(System.in);
        boolean runMenu = true;
        boolean systemRunning = true;


        MotionDetector motionDetector = new MotionDetector();
        DoorDetector doorDetector = new DoorDetector();
        SmokeDetector smokeDetector = new SmokeDetector();
        Random rand = new Random();

        ArrayList<Detectors> detectors = new ArrayList<>(Arrays.asList(motionDetector, smokeDetector, doorDetector));


        while (runMenu) {

            System.out.println("\n" + ".......Current Menu............");
            System.out.println(" 1: Simulera MotionDetector");
            System.out.println(" 2: Simulera Brand");
            System.out.println(" 3: Simulera Inbrott");
            System.out.println(" 4: Gör ett random simulation");
            System.out.println(" 5: Toggle alarm");
            System.out.println(" 6: See Status");
            System.out.println(" 7: End System");

            System.out.println(" Välja ett alternative: ");
            System.out.println("-------------------------------");
            // try catch block ifall userInput inte är integer

            try {
                String menuMessage;
                userInput = Integer.parseInt(scanner.next());
                switch (userInput) {
                    case 1:
                        if (systemRunning) {
                            menuMessage = "MotionDetector Simulerat";
                            System.out.println("CentralUnit aktiv och" + " " + menuMessage);
                            System.out.println(detectors.get(0).isTriggered());
                        } else {
                            System.out.println("Systemet är av. Välj 5 att köra igång!");
                        }
                        break;
                    case 2:
                        if (systemRunning) {
                            menuMessage = "Brand System Simulerat";
                            System.out.println(menuMessage);
                            System.out.println(detectors.get(1).isTriggered());
                        } else {
                            System.out.println("Systemet är av. Välj 5 att köra igång!" );
                        }
                        break;
                    case 3:
                        if (systemRunning) {
                            menuMessage = "Inbrott Simulerat";
                            System.out.println(menuMessage);
                            System.out.println(detectors.get(2).isTriggered());
                        } else {
                            System.out.println("Systemet är av. Välj 5 att köra igång!");
                        }
                        break;

                    case 4:
                        if (systemRunning) {
                            System.out.println("Random Simulation Aktiverad");
                            int randomDetector = rand.nextInt(detectors.size());
                            System.out.println(detectors.get(randomDetector).isTriggered());

                        } else {
                            System.out.println("Systemet är av. Välj 5 att köra igång!");
                        }
                        break;
                    case 5:
                        if (systemRunning) {
                            menuMessage = "Nu är larm av";
                            systemRunning = false;
                        } else {
                            menuMessage = "Nu är larm på gång";
                            systemRunning = true;
                        }
                        System.out.println(menuMessage);
                        break;

                    case 6:
                        if (systemRunning) {
                            menuMessage = "System är på gång";
                            System.out.println(menuMessage);
                        } else {
                            menuMessage = " System Av";
                            System.out.println("Nu är" + " " + menuMessage);
                        }
                        break;
                    case 7:
                        runMenu = false;
                        break;

                    default:
                        System.out.println("Selection out of Range, try again");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input not an Integer!Enter Integer on Menu");

            }
        }
    }

}
