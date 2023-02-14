package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Car extends SuperObject {
	
	public OBJ_Car() {
		name = "Car";	
		try {	
			image = ImageIO.read(getClass().getResourceAsStream("/object/car.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	collision = true;
	}

}
