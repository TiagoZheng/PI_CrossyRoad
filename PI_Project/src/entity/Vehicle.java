package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Vehicle extends Entity{
	
	public Vehicle(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 10;
		getCarImage();
		
	}

	public void getCarImage() {
		try {

			vehicle_down = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_down.png"));
			vehicle_up = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_up.png"));

		}catch(IOException e) {

			e.printStackTrace();
		}

	}
	
	public void update() {
		if(direction == "down") {
			if(worldY < gp.maxWorldRow*gp.tileSize) {
				 worldY += speed;
			} else {
				worldY = -gp.tileSize;
			}
		} else {
			if(worldY > - gp.tileSize) {
				 worldY -= speed;
			} else {
				worldY = gp.maxWorldRow*gp.tileSize;
			}
		}
		
		
	}
		
}
