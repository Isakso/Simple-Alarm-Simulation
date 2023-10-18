import SecuritySystem.Detectors;

import java.util.*;

public class DoorDetector extends Room implements Detectors {
    private String result;
    boolean isDoorOrWindowOpen;

    public DoorDetector() {
    }

    public String openDoorDetected() {

        isDoorOrWindowOpen = true;

        for (String result : roomWithDoor()) {
            int randomInt = random().nextInt(roomWithDoor().size());
            return this.result = roomWithDoor().get(randomInt);
        }
        return result;
    }

    public boolean isDoorOrWindowOpen() {
        isDoorOrWindowOpen = random().nextBoolean();

        return isDoorOrWindowOpen;
    }

    public boolean randomWindow() {

        return random().nextBoolean();
    }

    public int openWindowDetected() {
        return random().nextInt(room().size());
    }

    public ArrayList<String> room() {
        return super.room();
    }

    // om ett fönster är krossas eller öppnas så är det inbrott
    public String getBrockenWindow() {

        if (randomWindow()) {
            return room().get(openWindowDetected()) + " fönster är krossad." + " Inbrott upptäckt i huset.";
        }
        return "Alla fönster ser ut brå." + " ";
    }

    public String openRandomDoor() {
        boolean randomdoor = random().nextBoolean();
        if (randomdoor) {

            return openDoorDetected() + " door är oppet." + " Inbrott är på gång" +
                    "\n" + "Larmet på Central enheten ljuder! ";
        }
        return " " + "Alla dörrarna är stängda!";
    }

    public ArrayList<String> roomWithDoor()// rum som har dörrar
    {
        return new ArrayList<>(Arrays.asList("Garage", "Vardagsrum", "Sovrum 1", "Sovrum 2", "Sovrum 3", "Sovrum 4", "Sovrum 5", "Hallen"));
    }

    @Override
    public String isTriggered() {

        if (isDoorOrWindowOpen() || randomWindow()) {
            return getBrockenWindow() + openRandomDoor();
        }
        return "Ingen Inbrott";

    }
}
