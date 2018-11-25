package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Corner extends MotionlessElement {
	private static final ISprite sprite = new Sprite('O',System.getProperty("user.dir") + "/src/main/java/Images/bone.png");
	
	Corner(){
		super(sprite, Permeability.BLOCKING);
	}
}
