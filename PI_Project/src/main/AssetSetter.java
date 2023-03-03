package main;

import java.util.Random;

import entity.Vehicle;

public class AssetSetter {

	GamePanel gp;
	WorldGenerator wg;
	
	int nVehicles = 0;
	int speedtest = 1;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;

	}

	public void setObject() {


	}
	
	public void setVehicle(int position) {

//		int count = 0;
//
//		for (int x = 0; x < gp.maxWorldCol; x++) {
//			// if column is road 
//			if(gp.generator.mapGen[0][x] == 1) {
//				//Adds a car
//				gp.vehicle[count]= new Vehicle(gp);
//				gp.vehicle[count].worldX = x * gp.tileSize;
//				gp.vehicle[count].worldY = 0 * gp.tileSize;
//				count++;
//			}
//		}
		
		Random r = new Random();
		Vehicle v = new Vehicle(gp, "Car");
		v.worldX = position * gp.tileSize;
		
		if(r.nextBoolean()) {
			v.direction = "down";
			v.worldY = 2 * gp.tileSize;	
		} else {
			v.direction = "up";
			v.worldY = gp.maxWorldRow * gp.tileSize;	
		}
		
//		v.speed = r.nextInt(5)+1;
		v.speed = speedtest;
		speedtest++;
		
		gp.vehicles[nVehicles] = v;
		nVehicles++;
	}

	public void setVehicles() {
		for (int x = 0; x < gp.maxWorldCol; x++)
			if(gp.generator.mapGen[0][x] == 1)
				setVehicle(x);	
	}
	
}
