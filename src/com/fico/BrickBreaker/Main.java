package com.fico.BrickBreaker;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame obj = new JFrame();
		GamePlay gamePlay = new GamePlay();
		obj.setBounds(10, 10, 700, 600); //this are dimension of the app
		obj.setTitle("Brick Breaker"); //title
		obj.setResizable(false); //not resizable
		obj.setVisible(true); 
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when press close in app
	}
}