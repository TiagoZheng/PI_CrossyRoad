package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;

import tile.Tile;


public class WorldGenerator {

	GamePanel gp;
	int[][] mapGen;

	public WorldGenerator(GamePanel gp) {
		mapGen = new int[gp.maxWorldRow][gp.maxWorldCol];
		this.gp = gp;
	}

	public int[][] generateArrays() {
		
		Random r = new Random();

		//create random roads
		for (int col = 0; col < gp.maxWorldCol; col++) {
			int randomNumber = r.nextInt(2);
			mapGen[0][col] = randomNumber;	
			
			//row incrementa col fica igual
			/*
			 * 		col0		col1	 	col2
			 * row0 [0,0]		[0,1]		[0,2]
			 * row1 [1,0]		[1,1]		[1,2]
			 * row2 [2,0]		[2,1]		[2,2]
			 */
			
		}
		
		//funcao para meter os tiles certos nas estradas
		roadFunction();
		
		//fill mapGen
		for (int col = 0; col < gp.maxWorldCol; col++) {
			for (int row = 0; row < gp.maxWorldRow; row++) {
				mapGen[row][col] = mapGen[0][col];
			}
		}
		
		return mapGen;
	}

	private void roadFunction() {
		
//		for (int col = 0; col < gp.maxWorldCol; col++) {
//			if(mapGen[0][col] == 1) {
//				if (col == 0) {
//					if (mapGen[0][col+1] != 1)
//						mapGen[0][col] = 5;
//					else
//						mapGen[0][col] = 2;
//				} 
//				else if (mapGen[0][col-1] == 0) {
//					if (col+1 < gp.maxWorldCol-1 && mapGen[0][col+1] == 0)
//						mapGen[0][col] = 5;
//					else
//						mapGen[0][col] = 2;
//				} 
//			}
			
			
//			if (col+1<gp.maxWorldCol-1 && mapGen[0][col+1] == 0){
//				mapGen[0][col] = 4;
//			}
//		}			
//		tile[1] = lane
//		tile[2] = firstLane
//		tile[3] = lane
//		tile[4] = lastLane
//		tile[5] = singleLane		

	}

	public void generateWorld() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(gp.path));
			String str = "";

			for (int x = 0; x < gp.maxWorldCol; x++) {
				// if column is grass 
				if(mapGen[0][x] == 0) 
					generateTrees(x);
				
			}

			//Takes square brackets out
			for (int x = 0; x < gp.maxWorldRow; x++) {
				str = (Arrays.toString(mapGen[x]) + "\n").replaceAll("\\[", "").replaceAll("\\]", "");
				writer.write(str);

			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateTrees(int position) {
		Random r = new Random();

		//number of trees to add in each column
		int r1 = r.nextInt((int)(gp.maxWorldRow/1.5));
		int numTrees = r1;

		while(numTrees > 0) {
			//adds a tree in random height position
			int r2 = r.nextInt(gp.maxWorldRow);
			
//			int r3 = r.nextInt(4)+6;
//			mapGen[r2][x] = r3;
			
			mapGen[r2][position] = 6;
			
			numTrees--;
		}
	}
}
