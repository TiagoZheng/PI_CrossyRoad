package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class WorldGenerator {

	GamePanel gp;
	int[][] mapGen;

	public WorldGenerator(GamePanel gp) {
		mapGen = new int[gp.maxWorldRow][gp.maxWorldCol];
		this.gp = gp;
	}

	public int[][] generateArrays() {

		for (int col = 0; col < gp.maxWorldCol; col++) {
			int randomNumber = (int) (Math.random() * 2);
			mapGen[0][col] = randomNumber;	

			//row incrementa col fica igual
			/*
			 * 		col0		col1	 	col2
			 * row0 [0,0]		[0,1]		[0,2]
			 * row1 [1,0]		[1,1]		[1,2]
			 * row2 [2,0]		[2,1]		[2,2]
			 */

			for (int row = 0; row < gp.maxWorldRow; row++) {
				mapGen[row][col] =randomNumber;

			}
		}

		return mapGen;

	}

	public void generateWorld() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(gp.path));
			String str = "";

			for (int x = 0; x < gp.maxWorldCol; x++) {
				System.out.println("this is x: " + x);
				// if column is grass 
				if(mapGen[0][x] == 0) {

					Random r = new Random();

					System.out.println("true" + x);
					//number of trees to add in each column
					int r1 = r.nextInt(gp.maxWorldRow);
					System.out.println("r1 number of trees : " + r1);
					int numTrees = r1;

					while(numTrees > 0) {
						//adds a tree in random height position
						int r2 = r.nextInt(gp.maxWorldRow);
						System.out.println("r2 where: "  + r2);
						mapGen[r2][x] = 6;
						numTrees--;
					}

				} else { // column is a road
					System.out.println("this is road");
				}
			}
			for (int x = 0; x < gp.maxWorldRow; x++) {
				str = (Arrays.toString(mapGen[x]) + "\n").replaceAll("\\[", "").replaceAll("\\]", "");
				writer.write(str);

			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
