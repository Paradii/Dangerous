package Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Dimension;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

import Charactor.*;
import Element.Element;
import Event.event;

public class Game extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;

	private static int speed = 50,whaleSize = 60 ,waveHeight = 50;
	private static int base=400,xStart = 1000;
	private long point = 0,lastPress=0;

	private Whale whale = new Whale(10,300,50);
	private Display display;
	private BufferedImage randomImage;

	private Wave[] waveSet = makeWave(1);


	public Game(Display display){
		this.display = display;
		this.setBounds(0,0,1000,600);
		this.addKeyListener(this);
		this.setLayout(null);
		System.out.println("sdada");
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(1000, 600));
	}

	@Override
	public void paint(Graphics g) {
		try {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			this.drawBackground(g2);

			g2.setFont(Element.getFont(30));
			g2.setColor(Color.white);
			g2.drawString("SCORE : "+point,275,42);

			g2.setColor(Color.RED);
			drawWhaleHealth(g2);
			g2.drawImage(whale.getWhaleImage(),whale.x,whale.y,300,300, null);

			for(Wave item : waveSet) {
				drawWave(item,g2);
			}
			this.point+=100;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void drawBackground(Graphics2D g2) throws IOException {
		g2.drawImage(ImageIO.read(new File("img/BG.png")),0,0,1000,600, null);
		g2.drawImage(ImageIO.read(new File("img/14.png")),0,base+10,1000,600, null);
	}

	private void drawWhaleHealth(Graphics2D g2) {
		try {
			g2.drawImage(ImageIO.read(new File("img/HP.png")),10,15, 30,30,null);
			g2.setStroke(new BasicStroke(18.0f));
			g2.setColor(new Color(241, 98, 69));
			g2.drawLine(60, 30,60+whale.health,30);
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(3.0f));
			g2.drawRect(50,20, 200,20);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Wave[] makeWave(int size) {
		Wave[] waveSet = new Wave[size];
		int far = 500;
		for(int i=0;i<size;i++) {
			waveSet[i] = new Wave(xStart+far,base,350,this);
			far+=500;
		}
		return waveSet;
	}

	private void drawWave(Wave wave, Graphics2D g2) throws IOException {
		Random rand = new Random();
		int x = rand.nextInt(800); // ค่าสุ่ม x ในช่วง 0 ถึง 800
		int y =  10 + rand.nextInt(550); // ค่าสุ่ม y ในช่วง base+10 ถึง base+210

		// วาดภาพที่ตำแหน่งสุ่ม x และ y
		g2.drawImage(ImageIO.read(new File("img/8.png")), x, y, 60, 60, null);
		try {
			g2.drawImage(ImageIO.read(new File("img/8.png")), x, y, 60, 60, null);
		} catch (IOException e) {
			e.printStackTrace(); // พิมพ์ข้อยกเว้นในคอนโซล หรือสามารถแสดงข้อความให้ผู้ใช้ทราบ
		}

//		Wave.RandomImage randomImageObject = wave.getRanImage(); // สร้างออบเจ็กต์ RandomImage
//		Image waveImage = randomImageObject.getImage(); // ดึง BufferedImage จาก RandomImage
//		int x = randomImageObject.getX();
//		int y = randomImageObject.getY();
//
//		// วาดภาพ wave ที่ตำแหน่งที่สุ่มได้
//		g2.drawImage(waveImage, x, (y - waveHeight), 40, waveHeight + 10, null);

		// ตรวจสอบการชน
		if (event.checkHit(whale, wave, whaleSize, waveHeight)) {
			g2.setColor(new Color(241, 98, 69));
			g2.fillRect(0, 0, 1000, 1000);
			whale.health -= 20;

			if (whale.health <= 0) {
				display.endGame(this.point);
				whale.health = new Whale().health;
				this.point = 0;
			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			whale.Up(this);
		} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			whale.Down(this);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
