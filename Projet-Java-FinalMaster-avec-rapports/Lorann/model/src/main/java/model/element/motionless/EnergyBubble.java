package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class EnergyBubble extends MotionlessElement {
	private static final ISprite sprite = new Sprite('B',System.getProperty("user.dir") + "/src/main/java/Images/crystal_ball.png");
	
	EnergyBubble(){
		super(sprite, Permeability.BLOCKING);
	}
}