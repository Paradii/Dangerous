package Charactor;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Whale {
    public int x=100,y=450,whaleSize=400;
    private int upHeight = 20;
    public int health = 180;
    private long point = 0;

    public Whale(int x,int y,int whaleSize) {
        this.x = x;
        this.y = y;
        this.whaleSize = whaleSize;
    }

    public Whale() {

    }

    public void Up(JPanel game) {
        if (y - upHeight >= 0) {  // ตรวจสอบขอบบน
            this.y -= upHeight;
        } else {
            this.y = 0;  // ถ้าเกินขอบบน ให้ยึดขอบบน
        }
    }

    public void Down(JPanel game) {
        int panelHeight = game.getHeight();  // ความสูงของหน้าต่างเกม
        if (y + whaleSize + upHeight <= panelHeight) {  // ตรวจสอบขอบล่าง
            this.y += upHeight;
        } else {
            this.y = panelHeight - whaleSize;  // ถ้าเกินขอบล่าง ให้ยึดขอบล่าง
        }
    }

    public BufferedImage getWhaleImage() {
        BufferedImage b = null;
        try {
            File file = new File("img/Whale.png");
            b = ImageIO.read(file); // โหลดภาพวาฬจากไฟล์
        } catch (IOException e) {
            e.printStackTrace(); // แสดงข้อผิดพลาดหากโหลดภาพไม่สำเร็จ
        }
        return b; // คืนค่า BufferedImage ของภาพวาฬ
    }


}
