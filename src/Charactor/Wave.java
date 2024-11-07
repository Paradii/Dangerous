package Charactor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Wave {
    public int speed,x,y;

    Timer timeMove;
    public Wave(int x,int y,int speed,JPanel page) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.move(page);
    }

    public void move(JPanel page) {
        this.timeMove = new Timer(220,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(x<=0) {
                    x = (int) (1000+(300+Math.random()*1000));
                }
                x -= 30;
                page.repaint();
            }
        });
        this.timeMove.start();
    }

    public class RandomImage {
        private BufferedImage image;
        private int x;
        private int y;

        public RandomImage(BufferedImage image, int x, int y) {
            this.image = image;
            this.x = x;
            this.y = y;
        }

        public BufferedImage getImage() {
            return image;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public RandomImage getRanImage() {
        String[] imageFiles = {
                "img/5.png",
                "img/6.png",
                "img/7.png",
                "img/8.png",
                "img/9.png",
                "img/10.png",
                "img/11.png"
        };

        Random rand = new Random();
        int randomIndex = rand.nextInt(imageFiles.length);

        // สร้างไฟล์ตามตำแหน่งที่สุ่มได้
        File file = new File(imageFiles[randomIndex]);

        BufferedImage image = null;
        try {
            image = ImageIO.read(file); // โหลดภาพตามตำแหน่งที่สุ่มได้
        } catch (IOException e) {
            e.printStackTrace(); // แสดงข้อผิดพลาดหากโหลดภาพไม่สำเร็จ
        }

        // สุ่มตำแหน่ง x และ y
        int x = 200 + rand.nextInt(1000); // x อยู่ในช่วง 100 ถึง 300
        int y = 20 + rand.nextInt(500); // แทนค่า 600 ด้วยขอบเขตสูงสุดของ y ที่ต้องการ

        // คืนค่า RandomImage ที่มีทั้ง BufferedImage และตำแหน่ง x, y
        return new RandomImage(image, x, y);
    }


}
