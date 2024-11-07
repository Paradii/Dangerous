package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Display extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public Display() {
		this.setting();
		this.getContentPane().add(new Game(this));
	}

	private void setting() {
		this.setTitle("Dangerous!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		Game gamePanel = new Game(this);
		this.getContentPane().add(gamePanel);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("restart")) {
			removeContent();
			Game game = new Game(this);
			this.getContentPane().add(game);
			game.requestFocus();
		}
	}

	public static void main(String[] arg) {
		Display display = new Display();


	}
}

