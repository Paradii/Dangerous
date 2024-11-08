package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Display extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

//	public Display() {
//		removeContent();
//		this.setting();
//		Game game = new Game(this);
//		this.getContentPane().add(game);
//		game.requestFocus();
//	}

	private void setting() {
		this.setTitle("Dangerous!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		StartMenu startMenu = new StartMenu(this);
		this.getContentPane().add(startMenu);
//		Game gamePanel = new Game(this);
//		this.getContentPane().add(gamePanel);
		this.setVisible(true);
	}
	private void removeContent() {
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
	}


	public void endGame(long point) {
		removeContent();
		this.getContentPane().add(new Menu(point,this));
	}
	public void startGame(long point) {
		removeContent();
		Game gamePanel = new Game(this);
		this.getContentPane().add(gamePanel);
		gamePanel.requestFocus();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("restart")) {
			removeContent();
			Game game = new Game(this);
			this.getContentPane().add(game);
			game.requestFocus();
//		}
	}

	public static void main(String[] arg) {
		Display display = new Display();
		display.setting();
	}
}

