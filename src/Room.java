import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public  class Room extends SmokeDetector {
    private String randomRoom;
    public ArrayList<String> room() { // Alla rum i huset
        return new ArrayList<>(Arrays.asList("Garage", "Vardagsrum", "Köket", "Sovrum 1", "Sovrum 2", "Sovrum 3", "Sovrum 4", "Sovrum 5", "Hallen"));
    }
    public Random random()

    {
        return new Random();
    }// random metod
    public String getRandomRoom() {
        int numberOfElements = 1;
        for (int i = 0; i < numberOfElements; i++) {
           int randomInt = random().nextInt(room().size());
           randomRoom = room().get(randomInt);
        }
        return randomRoom;
    }
   public String activateSprinkler() {
        return "Brand i " + getRandomRoom() + "\n" + "Sprinkler aktiverat i" +" "+ randomRoom +
        "\n" + "Sirenerna på Central enheten ljuder";
  }

}
