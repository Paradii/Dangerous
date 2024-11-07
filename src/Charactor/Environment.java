package Charactor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Environment {
    public int x,y,startX,speed,eType;
    private Timer timeMove;
    public Environment(int x,int y,JPanel page,int eType,int speed) {
        this.x = x;
        this.y = y;
        this.startX = x;
        this.speed = speed;
        this.eType = eType;
        this.move(page);
    }

    public void move(JPanel page) {
        this.timeMove = new Timer(10,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(x  < 0) {
                    x = startX;
                }
                x -= speed;
                page.repaint();
            }
        });
        this.timeMove.start();
    }

    public void stop() {
        this.timeMove.stop();
    }


    public String getEvType(int eType){
        String[] EvType = new String[] {"img/Start.png","img/Again.png"};
        return EvType[eType];
    }


    public static BufferedImage getFourImg() {
        File file = new File("img/14.png");
        return getFourImg();
    }

}
