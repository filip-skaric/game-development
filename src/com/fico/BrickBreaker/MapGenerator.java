package com.fico.BrickBreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {

	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator (int row, int col) {
		
		map = new int[row][col];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = 1;
			}
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	
	public void draw (Graphics2D g) {
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				
				if (map[i][j] > 0) {
					g.setColor(Color.BLACK);
					//80 is distance from x = 0 to the bricks
					//20 is distance from y = 0 to the bricks
					g.fillRect(j * brickWidth + 80, i * brickHeight + 20, brickWidth, brickHeight);
				
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.WHITE);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 20, brickWidth, brickHeight);
				}
			}
		}
	}
	
	public void setBrickValue (int value, int row, int col) {
		
		map[row][col] = value;
	}
}