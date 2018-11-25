package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Floor extends MotionlessElement{
	
	private static final ISprite sprite = new Sprite('X',System.getProperty("user.dir") + "/src/main/java/Images/floor.png");
	
	Floor(){
		super(sprite, Permeability.BLOCKING);
	}
	

}
