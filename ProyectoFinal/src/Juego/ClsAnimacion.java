package Juego;

import java.awt.Dimension;
import java.util.TimerTask;
import java.util.Timer;

public class ClsAnimacion extends javax.swing.JLabel {

    private Timer tiempo;
    private TimerTask task;
    private int speed = 99;
    private int frame = 0;
    boolean run = false;
    String url;

    public ClsAnimacion(Dimension d) {
        this.setSize(d);
    }

    public void setImage(int n) {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(url + n + ".PNG")));
    }

    public void setVelocidad(int v) {
        this.speed = v;
    }

    public void startAnimation() {
        frame=0;
        run = true;
        tiempo = new Timer();        
        task = new TimerTask() {
            
            public void run() {
                frame++;
                if (frame <= 22) {
                    setImage(frame);
                    if(frame==22){
                        setImage(23);
                    }
                } 
            }
        };
        tiempo.schedule(task, 0, speed);
    }

    public void stopAnimation() {
        tiempo.cancel();
        task.cancel();
        run = false;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
