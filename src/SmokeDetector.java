import SecuritySystem.Detectors;
import java.util.Random;

public class SmokeDetector implements Detectors  {
    boolean isSmokeDetected;
    boolean randomizedDetection;
    @Override
    public boolean trigger() {
        if(getRandomizedDetection()) {
            return isSmokeDetected;
        }
        return !isSmokeDetected;
    }
    public boolean getRandomizedDetection() {
         Random random = new Random();
         this.randomizedDetection= random.nextBoolean();
         return  randomizedDetection;
    }
    @Override
    public String isTriggered() {
        if(trigger()) {
          return "Brand Upptäckts" + getRoom().activateSprinkler();
        }
        //isSmokeDetected = false;
        return "Ingen Brand Upptäckt";
    }
    public Room getRoom()
    {
        return new Room();
    }
}
