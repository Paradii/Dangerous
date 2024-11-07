package Game;

import Element.EleLabel;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JPanel {
    private Image backgroundImage;
    private Image logoImage;

    public StartMenu(Display display) {
        try {
            // Load the background and logo images
            backgroundImage = new ImageIcon("img/Home.png").getImage();
            logoImage = new ImageIcon("img/Dangerous.png").getImage();

            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);

            // Create a button with an image
            JButton imageButton = new JButton(new ImageIcon("img/Start.png"));
            imageButton.setBounds(400, 300, 200, 200); // Adjust position and size as needed
            imageButton.setBorderPainted(false);       // Remove the button border
            imageButton.setContentAreaFilled(false);   // Remove button background
            imageButton.setFocusPainted(false);        // Remove focus border on the button
            imageButton.setOpaque(false);              // Make it transparent

            // Add an action listener for the button (optional)
            imageButton.addActionListener(e -> {
                display.startGame(0);
            });

            // Add the button to the panel
            this.add(imageButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image to fill the panel
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Draw the logo image in the center of the panel
        if (logoImage != null) {
            int x = (getWidth() - logoImage.getWidth(this)) / 2;
            int y = (getHeight() - logoImage.getHeight(this)) / 2;
            g.drawImage(logoImage, x, y, this);
        }
    }
}
