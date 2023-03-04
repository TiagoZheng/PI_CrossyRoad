package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Coin extends SuperObject {
	
	public OBJ_Coin() {
		name = "Coin";	
		try {	
			coin = ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
			coin1 = ImageIO.read(getClass().getResourceAsStream("/object/coin1.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	collision = true;
	}

	public void update() {
	}
}
