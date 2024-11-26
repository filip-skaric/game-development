
package com.fico.BrickBreaker;

import javax.swing.JFrame;

/**
 * The Main class is the entry point for the Brick Breaker game application.
 * It sets up the main game window and initializes the game play.
 */
public class Main {

    /**
     * The main method sets up the JFrame for the Brick Breaker game.
     * It configures the window properties and adds the GamePlay component.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
    	
    	JFrame obj = new JFrame(); // Creates a new JFrame object for the game window
        GamePlay gamePlay = new GamePlay(); // Creates a new GamePlay object which contains the game logic
        obj.setBounds(10, 10, 700, 600); // Sets the position and size of the window
        obj.setTitle("Brick Breaker"); // Sets the title of the window
        obj.setResizable(true); // Allows the window to be resizable
        obj.setVisible(true); // Makes the window visible
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensures the application exits when the window is closed
    }
}
