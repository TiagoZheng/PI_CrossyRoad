package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class WorldGenerator {

	GamePanel gp;
	int[][] mapGen = new int[30][30];

	public WorldGenerator(GamePanel gp) {
		this.gp = gp;
	}

	/**
	 * 
	 *  Minha ideia criar o mapa atravez de um double array e depois coloca-lo num ficheiro txt
	 *  
	 *  A seguir ler o mapa criado
	 *  
	 *  Assim podiamos usar as probabilidades para criar cada coisa e colocar no array
	 * 
	 */


	public int[][] generateArrays() {

		//		int yLength = mapGen.length;
		//		int xLength = mapGen[0].length;
		//		
		//		for (int x = 0; x < 4; x++) {
		//			for (int y = 0; y < yLength; y++) {
		//				mapGen[x][y] = 6;
		//			}
		//		}


		int column;
		for (int row = 0; row < 30; row++) {
			for (column = 0; column < 30; column++) {
				mapGen[row][column] = (int) (Math.random() * 6);
				System.out.print(mapGen[row][column] + "\t");
			}
			System.out.println("");
		}
		return mapGen;

	}



	public void generateWorld() {

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter("test11.txt"));

			String str = "";
			
			for (int x = 0; x < mapGen.length; x++) {
				
				str = (Arrays.toString(mapGen[x]) + "\n").replaceAll("\\[", "").replaceAll("\\]","");
				writer.write(str);
				
//				if(x == mapGen.length)
//					writer.write(Arrays.toString(mapGen[x]));
			}			
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
