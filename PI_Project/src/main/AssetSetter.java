package main;

import object.OBJ_Car;

public class AssetSetter {

	GamePanel gp;
	WorldGenerator wg;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;

	}

	public void setObject() {

		int count = 0;

		for (int x = 0; x < gp.maxWorldCol; x++) {
			// if column is road 
			if(gp.generator.mapGen[0][x] == 1) {
				//Adds a car
				gp.obj[count]= new OBJ_Car();
				gp.obj[count].worldX = x * gp.tileSize;
				gp.obj[count].worldY = 0 * gp.tileSize;
				count++;
			}
		}

	}

}
