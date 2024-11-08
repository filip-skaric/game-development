package com.fico.BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private boolean play = false;
	private  int score = 0;
	
	private int totalBrick = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXDir = -2;
	private int ballYDir = -4;
	
	private MapGenerator map;
	
	public GamePlay() {
		
		map = new MapGenerator(3, 7); //3 columns and 7 rows
		
		// Adds a key listener to the current object, allowing it to respond to key events
		addKeyListener(this);
		
		// Sets the focus on this component, allowing it to receive key events
		setFocusable(true);
		
		// Disables the default focus traversal keys (like Tab) for this component
		setFocusTraversalKeysEnabled(false);
		
		// Creates a new Timer object that triggers action events at specified intervals (defined by 'delay')
		timer = new Timer(delay, this);
		
		// Starts the timer, initiating the periodic execution of the actionPerformed method
		timer.start();
	}
	
	
	public void paint (Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(1, 1, 692, 592);
		
		map.draw((Graphics2D)g);
		
		//border around app :)
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(680, 0, 3, 592);
		
		//down is pedal properties
		g.setColor(Color.blue);
		g.fillRect(playerX, 550, 100, 8); //rect je rectangule
		
		//down is ball properties
		g.setColor(Color.green);
		g.fillOval(ballPosX, ballPosY, 20, 20); //20 is size of the ball
		
		g.dispose(); //release resources
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		timer.start();
		
		if (play) {
			
			//ball redirection by the pedal
			if (new Rectangle(ballPosX, ballPosY, 20, 23).intersects(new Rectangle(playerX, 550, 100, 8))) {
			
				ballYDir = -ballYDir;
			}
			
			for (int i = 0; i < map.map.length; i++) {
				for (int j = 0; j < map.map[0].length; j++) {
					

					if (map.map[i][j] > 0) {
						
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						
						Rectangle bricRect = new Rectangle(brickX, brickY, map.brickWidth, map.brickHeight);
						
						if (new Rectangle(ballPosX, ballPosY, 20, 23).intersects(bricRect)) {
							
							map.setBrickValue(0, i, j);
							totalBrick--;
							score += 5;
							
							if ( (ballPosX + 19 >= bricRect.x) || (ballPosX + 1 >= bricRect.width) ) {
								
								ballXDir = -ballXDir;
							} else {
								ballYDir = -ballYDir;
							}
						}
					}
				}
			}
				
			ballPosX += ballXDir;
			ballPosY += ballYDir;
			
			if (ballPosX < 0) {
				ballXDir = -ballXDir;
			}
			
			if (ballPosY < 0) {
				ballYDir = -ballYDir;
			}
			
			if (ballPosX > 670) {
				ballXDir = -ballXDir;
			}
		}
		
		repaint();//repaints update window
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerX >= 580) {
				playerX = 570;
			} else {
				moveRight();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX < 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
	}
	
	
	private void moveRight() {
		
		play = true;
		playerX += 20;
	}

	
	private void moveLeft() {

		play = true;
		playerX-= 20;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//samo da vidim da li ovo radi
}
