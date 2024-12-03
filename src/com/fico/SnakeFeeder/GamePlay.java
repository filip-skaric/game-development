package com.fico.SnakeFeeder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private ImageIcon titleImage;
	private int [] snakeXLength = new int[750];
	private int [] snakeYLength = new int[750];
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon headRigth;
	private ImageIcon headLeft;
	private ImageIcon headUp;
	private ImageIcon headDown;
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	
	private ImageIcon tail;
	private int moves = 0;
	private int score = 0;
	
	
	public GamePlay() {

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		//titleImage = new ImageIcon("src/com/fico/SnakeFeeder/snake.jpg");
	}
	
	public void paint (Graphics g) {
		
		if (moves == 0) {//this means this is begging of the game
			
			snakeXLength [0] = 100;
			snakeXLength [1] = 75;
			snakeXLength [2] = 50;
			
			snakeYLength [0] = 100;
			snakeYLength [1] = 100;
			snakeYLength [2] = 100;
		}
		
        // Display title
		titleImage = new ImageIcon("src/com/fico/SnakeFeeder/resource/Title.png");
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
		
		//initial position of the head image
		headRigth = new ImageIcon("src/com/fico/SnakeFeeder/resource/head_right.png");
		Image scaledImageHeadRight = headRigth.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		// Ensure the image is fully loaded before drawing
		ImageIcon scaledIconHeadRight = new ImageIcon(scaledImageHeadRight); 
		g.drawImage(scaledIconHeadRight.getImage(), snakeXLength[0], snakeYLength[0], this);
		
		for (int i = 0; i < lengthOfSnake; i ++) {
			
			if ( (i == 0) && right ) {
				headRigth = new ImageIcon("src/com/fico/SnakeFeeder/resource/heaRight.png");
				headRigth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			
			if ( (i == 0) && left ) {
				headLeft = new ImageIcon("src/com/fico/SnakeFeeder/resource/headLeft.png");
				headLeft.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			
			if ( (i == 0) && down ) {
				headDown = new ImageIcon("src/com/fico/SnakeFeeder/resource/headDown.png");
				headDown.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			
			if ( (i == 0) && up ) {
				headUp = new ImageIcon("src/com/fico/SnakeFeeder/resource/headDownUp.png");
				headUp.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			
			if ( i != 0 ) {
				
				tail = new ImageIcon("src/com/fico/SnakeFeeder/resource/body.png");
				Image scaledImageTitle = tail.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
				// Ensure the image is fully loaded before drawing
				ImageIcon scaledIconTail = new ImageIcon(scaledImageTitle); 
				g.drawImage(scaledIconTail.getImage(), snakeXLength[i], snakeYLength[i], this);
			}
		}
		
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}