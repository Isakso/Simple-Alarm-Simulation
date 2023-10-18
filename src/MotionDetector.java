import SecuritySystem.Detectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class MotionDetector implements Detectors {
    boolean isMotionDetected = false;
    // Alla rum där rörelsedetektor är installerat
    public ArrayList<String> motionDetector() {
        return new ArrayList<>(Arrays.asList("Hallen", "Vardagsrummet", "Poolområdetsbaksidan"));
    }
    public String getMotionArea(){
        if(trigger()) {
            Random rand = new Random();
            for (String i : motionDetector()) {
                int randomInt = rand.nextInt(motionDetector().size());
                i = motionDetector().get(randomInt);
                return i;
            }
        }
        return "Otydligt Område";
    }
    public boolean IsRandomMotionDetected(){
        Random ran = new Random();
        isMotionDetected = ran.nextBoolean();
        return isMotionDetected;
    }
    public boolean trigger()
    {
        if(IsRandomMotionDetected())
        {
            this.isMotionDetected = true;
        }
        return isMotionDetected;
    }
    @Override
    public String isTriggered() {
        if(!IsRandomMotionDetected()) {
            return "Ingen rörelse i området";
        }
        return "Rörelse upptäckt i" + " " + getMotionArea() +"\n" + "Sirenerna på Central enheten ljuder";
    }

}
