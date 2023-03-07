package main;

import java.util.Random;

import entity.Vehicle;
import object.OBJ_Coin;

public class AssetSetter {

	GamePanel gp;
	WorldGenerator wg;
	
	int nCoins = 0;
	int nVehicles = 0;
	int speedtest = 1;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;

	}

	public void setObject() {

		gp.obj[0] = new OBJ_Coin();
		gp.obj[0].worldX = 3 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
	}
	
	public void setCoin(int position) {
		Random r = new Random();
		
		OBJ_Coin coin = new OBJ_Coin();
		coin.worldX = position * gp.tileSize;
		coin.worldY = r.nextInt(gp.maxWorldRow)*gp.tileSize;
		gp.obj[nCoins] = coin;
		nCoins++;
	}
	
	public void setCoins() {
		for (int x = 0; x < gp.maxWorldCol; x++)
			if(gp.generator.mapGen[0][x] == 1)
				setCoin(x);
	}
	
	public void setVehicle(int position) {
		
		Random r = new Random();
		Vehicle v = new Vehicle(gp);
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
