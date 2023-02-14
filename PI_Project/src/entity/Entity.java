package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage chicken_right, chicken_left, vehicle_down, vehicle_up;
	public String direction;
	
	//For Collision
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
}
