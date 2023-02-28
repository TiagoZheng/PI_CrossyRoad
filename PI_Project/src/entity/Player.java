package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;

	public final int screenX;
	public final int screenY;

	public Player (GamePanel gp, KeyHandler keyH) {

		this.gp = gp;
		this.keyH = keyH;

		//PLAYER LOCATION ON SCREEN (FIXED)
		screenX = gp.screenWidth/2 - 20;
		screenY = gp.screenHeight/2;

		//Collision Area
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16; 
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultX = solidArea.y;
				
		solidArea.width = 32;
		solidArea.height = 32;

		setDefaultValue();
		getPlayerImage();
	}

	public void setDefaultValue() {
		// PLAYER POSITION IN WORLD MAP
		worldX = 2 * gp.tileSize;
		worldY = 2 * gp.tileSize;

		speed = 4;
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

			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (collisionOn == false) {

				switch(direction) {
				case "up": 
					if(worldY > 0) 
						worldY -= speed;
					break;
				case "down":		
					if(worldY < gp.worldHeight - gp.tileSize)
						 worldY += speed;
					break;
				
				case "left": 
					if(worldX > 0) {
						worldX -= speed;
					}
					break;
					
				case "right":
					if(worldX < gp.worldWidth - (gp.tileSize + 1*gp.tileSize)) { //TODO
						worldX += speed;
					}
					break;

				}
			}
		}
	}
	
	public void pickUpObject(int i) {
		
		if (i != 999) {
			
			// DELETES THE OBJECT WE TOUCH
			gp.obj[i] = null;
		}
	}

	public void draw(Graphics2D g2) {
		//		g2.setColor(Color.WHITE);
		//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);

		BufferedImage image = null;

		switch(direction) {
		case "up":
			image = chicken_left;
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
