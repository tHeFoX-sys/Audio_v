import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Audio extends JOptionPane {
    //Extending using Inheritance the component J_Option_Pane from thr swing subclass
    private boolean ok = true;
    //variable flag type boolean encapsulating using OOP
    Audio(){

        while(ok) {
            showConfirmDialog(null, "Watch Dogs", "The Eye of the Predators", JOptionPane.YES_NO_OPTION);
            my_audio();//Function instance
            if(!isOk()){
                setOk(false);
                break;
                /*An easy way to "catch" all possible alerts.
                * Because if leave under a rock in programming there are alerts
                */
            }
        }
    }

    //Audio method projecting a wav file from Watch Dogs
    protected void my_audio () {
        try {
            File music = new File("music\\watch.wav");
            AudioInputStream sys = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.loop(Clip.LOOP_CONTINUOUSLY);//Continuous loop
            clip.open(sys);
            clip.start();

        } catch (Exception e) {
            throw new RuntimeException(e);
            //Catching all types of exceptions
        }
    }

    //Setters and Getters
    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
