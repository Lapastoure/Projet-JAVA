package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Gate_Closed extends MotionlessElement
{
	private static final ISprite sprite = new Sprite('P',System.getProperty("user.dir") + "/src/main/java/Images/gate_closed.png");
	
	Gate_Closed(){
	 super(sprite, Permeability.BLOCKING);
 }
}
