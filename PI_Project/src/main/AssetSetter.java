package main;

import object.OBJ_Car;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Car();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 23 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Car();
		gp.obj[1].worldX = 12  * gp.tileSize;
		gp.obj[1].worldY = 50 * gp.tileSize;
	}

}
