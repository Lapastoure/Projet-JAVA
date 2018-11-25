package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Loot extends MotionlessElement {

	private static final ISprite sprite = new Sprite('B',System.getProperty("user.dir") + "/src/main/java/Images/purse.png");
	
	Loot(){
		super(sprite,Permeability.BLOCKING);
	}
}
