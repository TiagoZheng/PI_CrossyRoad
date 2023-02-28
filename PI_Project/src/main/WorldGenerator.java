package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class WorldGenerator {

	GamePanel gp;
	int[][] mapGen = new int[30][30];

	public WorldGenerator(GamePanel gp) {
		this.gp = gp;
	}
	
	public int[][] generateArrays() {

		//		int column;
		//		for (int row = 0; row < 30; row++) {
		//			for (column = 0; column < 30; column++) {
		//				mapGen[row][column] = (int) (Math.random() * 6);
		//				System.out.print(mapGen[row][column] + "\t");
		//			}
		//			System.out.println("");
		//		}
		//		return mapGen;

		int column = 0;
		for (int row = 0; row < 30; row++) {
			
			int randomNumber = (int) (Math.random() * 2);
			mapGen[row][column] = randomNumber;	
			
			for (int x = 0; x < 30; x++) {
				mapGen[x][column] =randomNumber;
				
			}
			column++;
		}
//		int count=0;
//		int[][] oi = new int[10][10];
//		for (int x = 0; x <10; x++) {
//			for (int y = 0;y <10;y++) {
//				oi[y][x]=count;
//				System.out.println(Arrays.toString(oi[x]));
//				count++;
//			}
//			
//		}
		
//		System.out.println("");

		return mapGen;

	}

	public void generateWorld() {

		try {
		
			BufferedWriter writer = new BufferedWriter(new FileWriter(gp.path));
			String str = "";

			for (int x = 0; x < mapGen.length; x++) {
				
				// if column is grass 
				if(mapGen[0][x] == 0) {
					
					Random r = new Random();
					
					//number of trees to add in each column
					int numTrees = r.nextInt( gp.maxWorldRow/2 );
					
					while(numTrees > 0) {
						//adds a tree in random height position
						mapGen[r.nextInt(gp.maxWorldRow)][x] = 6;
						numTrees--;
					}
				} else { // column is a road
					
				}

				str = (Arrays.toString(mapGen[x]) + "\n").replaceAll("\\[", "").replaceAll("\\]", "");
				writer.write(str);
				
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
