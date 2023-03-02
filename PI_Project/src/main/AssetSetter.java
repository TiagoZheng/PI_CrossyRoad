package main;

import entity.Vehicle;
import object.OBJ_Car;

public class AssetSetter {

	GamePanel gp;
	WorldGenerator wg;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;

	}

	public void setObject() {


	}

	public void setVehicle() {
		
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
		
		gp.vehicle[0] = new Vehicle(gp);
		gp.vehicle[0].worldX = 2 * gp.tileSize;
		gp.vehicle[0].worldY = 2 * gp.tileSize;
		
		
	}
	
}
