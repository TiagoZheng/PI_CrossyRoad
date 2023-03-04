package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {

	public BufferedImage image, coin, coin1;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0,0,40,40);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	public int count = 0;


	public void draw(Graphics2D g2, GamePanel gp) {

		int screenX = worldX - gp.player.worldX +gp.player.screenX;
		int screenY = worldY - gp.player.worldY +gp.player.screenY;

		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

			if (count < 10) {
				g2.drawImage(coin ,screenX, screenY, gp.tileSize, gp.tileSize, null);
				count++;
			} else if (count < 20){
				g2.drawImage(coin1 ,screenX, screenY, gp.tileSize, gp.tileSize, null);
				count++;
			} else {
				count =0;
			}
		}
	}
}
