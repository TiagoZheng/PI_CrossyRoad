package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	KeyHandler keyH;

	public final int screenX;
	public final int screenY;


	public Player (GamePanel gp, KeyHandler keyH) {

		super(gp); 
		this.keyH = keyH;

		//PLAYER LOCATION ON SCREEN (FIXED)
		screenX = gp.screenWidth/2;
		screenY = gp.screenHeight/2;

		//Collision Area
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16; 
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultX = solidArea.y;

		solidArea.width = 20;
		solidArea.height = 20;

		setDefaultValue();
		getPlayerImage();
	}

	public void setDefaultValue() {
		// PLAYER POSITION IN WORLD MAP
		worldX = 2 * gp.tileSize;
		worldY = 7 * gp.tileSize;


		speed = gp.tileSize;
//		speed = 4;
		
		direction = "chicken_right";
	}

	public void getPlayerImage() {
		try {

			chicken_right = ImageIO.read(getClass().getResourceAsStream("/player/chicken_right.png"));
			chicken_left = ImageIO.read(getClass().getResourceAsStream("/player/chicken_left.png"));

		}catch(IOException e) {

			e.printStackTrace();
		}

	}

	public void update() {
		if (keyH.upPressed == true ||  keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

			
			if(keyH.upPressed == true)
				direction = "up";
			else if (keyH.downPressed == true) 
				direction = "down";
			else if (keyH.leftPressed == true) 
				direction = "left";
			else if (keyH.rightPressed == true) 
				direction = "right";

			// CHECK TILE COLLISION
			collisionOn = false;
			gp.collisionC.checkTile(this);

			// CHECK OBJECT COLLISION
			int objIndex = gp.collisionC.checkObject(this, true);
			pickUpObject(objIndex);
			
			//CHECK VIHECLE COLLISION
			int vehicleIndex = gp.collisionC.checkEntity(this, gp.vehicles);
			interactVehicle (vehicleIndex);
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (collisionOn == false) {
				
				switch(direction) {
				case "up": 
					if(worldY > 0) {
						worldY -= speed;
						keyH.upPressed = false;
					}

					break;

				case "down":		
					if(worldY < gp.worldHeight - gp.tileSize) {
						worldY += speed;
						keyH.downPressed = false;
					}
					break;

				case "left": 
					if(worldX > 0) {
						worldX -= speed;
						keyH.leftPressed = false;
					}
					break;

				case "right":
					if(worldX < gp.worldWidth - 2*gp.tileSize) { //TODO
						worldX += speed;
						keyH.rightPressed = false;
					}
					break;

				}
			}
		}
	}

	//When touches anything does something
	public void pickUpObject(int i) {

		if (i != 999) {

			String objectName = gp.obj[i].name;

			switch(objectName) {
			case "Car":
				//GAME OVER STOPS GAME
				gp.gameThread = null;
				
			case "Coin":
				gp.obj[i] = null;
			}
		}
	}


	public void interactVehicle(int i ) {
		if (i != 999) {
			
			//PLAYER COLLISION ONTO CAR GAME OVER!
//			System.out.println("GAME OVER!");
//			gp.gameThread=null;
			
			gp.vehicles[i]=null;
		}
	}
	
	public void draw(Graphics2D g2) {

		BufferedImage image = chicken_right;

		switch(direction) {
		case "up":
			image = chicken_right;
			break;
		case "down":
			image = chicken_right;
			break;
		case "left":
			image = chicken_left;
			break;
		case "right":
			image = chicken_right;
			break;
		}

		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
