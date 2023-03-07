package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Vehicle extends Entity{

	private int color;
	private Random r = new Random();

	public Vehicle(GamePanel gp) {
		super(gp);

//		direction = "down";
		speed = 10;
		color = r.nextInt(3)+1;
		
		getVehicleImage();

	}
	
	String type;
	
//	public Vehicle(GamePanel gp, String type) {
//		super(gp);
//		
//		this.type = type;
//		
//		direction = "down";
//		speed = 10;
//		
//		
//		getVehicleImage();
//		
//
//	}

	public void getVehicleImage() {
		
		
		
		try {
			
			switch(color) {
			case 1:
				vehicle_down = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_"+ "red" + "_down.png"));
				vehicle_up = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_"+ "red" + "_up.png"));
				break;
			case 2:
				vehicle_down = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_"+ "blue" + "_down.png"));
				vehicle_up = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_"+ "blue" + "_up.png"));
				break;
			case 3:
				vehicle_down = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_"+ "green" + "_down.png"));
				vehicle_up = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_"+ "green" + "_up.png"));
				break;
			}
			
			
//			switch(type) {
//			case "Car":
//				vehicle_down = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_down.png"));
//				vehicle_up = ImageIO.read(getClass().getResourceAsStream("/vehicle/car_up.png"));
//				break;
//			case "Bus": 
//				vehicle_down = ImageIO.read(getClass().getResourceAsStream("/vehicle/bus.png"));
//				vehicle_up = ImageIO.read(getClass().getResourceAsStream("/vehicle/bus.png"));
//				break;
//			}

		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	
	public void update() {
		
		collisionOn= false;
		gp.collisionC.checkPlayer(this);
		
		
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
