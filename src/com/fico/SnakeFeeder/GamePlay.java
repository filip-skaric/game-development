package com.fico.SnakeFeeder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePlay extends JPanel {

	private ImageIcon titleImage;
	
	public GamePlay() {

		//titleImage = new ImageIcon("src/com/fico/SnakeFeeder/snake.jpg");
	}
	
	public void paint (Graphics g) {
		
        // Display title
		titleImage = new ImageIcon("src/com/fico/SnakeFeeder/resource/title.png");
		Image scaledImage = titleImage.getImage().getScaledInstance(850, 75, Image.SCALE_SMOOTH);

		// Ensure the image is fully loaded before drawing
		ImageIcon scaledIcon = new ImageIcon(scaledImage); 
		g.drawImage(scaledIcon.getImage(), 25, 5, this);
		
		
		//display gameplay border
		g.setColor(Color.DARK_GRAY);
		g.drawRect(24, 74, 851, 577);
		
		//Display gameplay background
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
		
		g.dispose();
		
	}
}