package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

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
	
	public void setAction() {
		
//		Random random = new Random();
//		int i = random.nextInt(100)+1; // pick up a number from 1 to 100
//		
//		if(i < 100) {
			direction = "down";
//		}
	}
		
}
