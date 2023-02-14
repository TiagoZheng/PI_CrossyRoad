package main;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		window.setResizable(false);
		window.setTitle("Chicken Cross");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		// TODO MAKE GENERATE A MAP BEFORE STARTING THE GAME
		gamePanel.generateWorld();
		gamePanel.setupGame();
		gamePanel.startGameThread();
		System.out.println("Git test");
	}

}
