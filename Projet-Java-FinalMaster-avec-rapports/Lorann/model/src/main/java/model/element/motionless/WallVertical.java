package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class WallVertical extends MotionlessElement{
	   
	   private static final ISprite sprite = new Sprite('|',System.getProperty("user.dir") + "/src/main/java/Images/vertical_bone.png");
	  
	
WallVertical(){
	super(sprite,Permeability.BLOCKING);
}
}
