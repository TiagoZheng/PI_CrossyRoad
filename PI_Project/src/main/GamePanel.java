package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import entity.Vehicle;
import object.SuperObject;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{

	//SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;

	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768 pixel
	public final int screenHeight = tileSize * maxScreenRow; // 576 pixel

	//WORLD SETTINGS
	public final int maxWorldCol = 60;
	public final int maxWorldRow = 15;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	//FPS
	int FPS = 60;

	String path = "res/maps/testnovo5.txt";
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	public Thread gameThread;
	
	public CollisionCheck collisionC = new CollisionCheck(this);
	public AssetSetter aSetter = new AssetSetter(this);
	
	// ENTITY AND OBJECT
	public Entity vehicle[] = new Entity[50];
	public SuperObject obj[] = new SuperObject[45];
	public Player player = new Player(this, keyH);
	
	public WorldGenerator generator = new WorldGenerator(this);


	//Set Player's default Position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 16;

	// Set Vehicle's default Position
	int vehicleX = 200;
	int vehicleY = 700;
	int vehicleSpeed = 16;



	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true); // IF SET TO TRUE, all the drawing from this component will be done in an offscreen painting buffer
		this.addKeyListener(keyH);
		this.setFocusable(true); //This GamePanel can be "focused" to receive key input.
		generateWorld();
//		vehicle2.setX(380);
	}

	public void generateWorld() {

		generator.generateArrays();
		generator.generateWorld();
		tileM.loadMap(path);

	}

	// BEFORE GAME STARTS (SEE MAIN)
	public void setupGame() {
		aSetter.setObject();
		aSetter.setVehicle();
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000/FPS; // 0.0166666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {

			// 1 UPDATE: update information such as character positions
			update();

			// 2 DRAW: draw on the screen with the updated information 
			repaint(); //is the paintComponent

			try {

				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;

				if(remainingTime < 0 ) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);

				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update() {
		player.update();
		
		for(int i = 0; i <vehicle.length;i++) {
			if(vehicle[i]!=null) {
				vehicle[i].update();
			}
		}
	}

	public void paintComponent(Graphics g) { // GRAPHICS: A class with functions to draw objects on screen

		super.paintComponent(g); // When using paintComponent type this line

		Graphics2D g2 = (Graphics2D)g; //Change Graphics g to Graphics2D

		// TILE
		tileM.draw(g2);

		// OBJECT
		for (int i = 0; i < obj.length; i++) { 
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//VEHICLE
		for(int i =0; i < vehicle.length; i++) {
			if(vehicle[i]!= null) {
				vehicle[i].draw(g2);
			}
		}

		// PLAYER
		player.draw(g2);
//		vehicle.draw(g2);
//		vehicle2.draw(g2);

		g2.dispose();
	}
}
