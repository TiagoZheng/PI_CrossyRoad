package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {

	GamePanel gp;
	public int worldX, worldY;
	public int speed;

	public BufferedImage chicken_right, chicken_left, vehicle_down, vehicle_up;
	public String direction;

	//For Collision
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48); //Default Solid Area
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;

	public Entity(GamePanel gp) { 
		this.gp= gp;
	}
	
	public void setAction() {}
	
	public void update() {
		
//		setAction();
		
		collisionOn= false;
		gp.collisionC.checkTile(this);
		
		// IF COLLISION IS FALSE, PLAYER CAN MOVE
		if (collisionOn == false) {

			switch(direction) {
			case "up": worldY -= speed; break;
			case "down": worldY += speed; break;
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
			}
			
		}
	
	}
	
	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		int screenX = worldX - gp.player.worldX +gp.player.screenX;
		int screenY = worldY - gp.player.worldY +gp.player.screenY;

		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {


			switch(direction) {
			case "up":
				image = vehicle_up;
				break;
			case "down":
				image = vehicle_down;
				break;

			}

			g2.drawImage(image ,screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}

}
