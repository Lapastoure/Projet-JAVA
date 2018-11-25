package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Gate_Opened extends MotionlessElement{

private static final ISprite sprite = new Sprite('P',System.getProperty("user.dir") + "/src/main/java/Images/gate_open.png");
	
Gate_Opened(){
	 super(sprite, Permeability.BLOCKING);
 }
}
