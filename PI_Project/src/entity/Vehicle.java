package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Vehicle extends Entity{

	GamePanel gp;
	
	public Vehicle(GamePanel gp) {
		this.gp = gp;
		
		setDefaultValue();
		getImage();
	}

	public void setDefaultValue() {
		worldX = 170;
		worldY = 700;
		speed = 8;
		direction = "up";
	}
	
	public void getImage() {
		try {
			 vehicle_down = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_down.png"));
			 vehicle_up = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_up.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
//		if(direction == "up") {
//			worldY -= speed;
//			if(worldY < -60) {
//				worldY = -60;
//				worldX -= 50;
//				direction = "down";
//			}
//		} else if(direction == "down") {
//			worldY += speed;
//			if(worldY > gp.screenHeight) {
//				worldY = gp.screenHeight + 20;
//				worldX += 50;
//				direction = "up";
//			}
//		}
	}
	
	public void setX(int x) {
		this.worldX = x;
		
		worldY = -60;
		direction = "down";
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.WHITE);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "down":
			image = vehicle_down;
			break;
		case "up":
			image = vehicle_up;
			break;
		}
		
		g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
	}

	
//	Fazer uma classe Road(int lanes) para criar uma faixa de rodagem com n vias de trânsito?
//	Cada mapa/nível tem várias Road intercaladas por terrenos com árvores e pedras
//		como obstáculos(criar classe para os terrenos?)
//	O nível mais difícil podia ser só uma Road (sem terrenos pelo meio)
	
	
}
