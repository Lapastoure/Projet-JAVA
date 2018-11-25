package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class WallHorizontal extends MotionlessElement{
  
	  private static final ISprite sprite = new Sprite('-',System.getProperty("user.dir") + "/src/main/java/Images/horizontal_bone.png");
	  
		
	  WallHorizontal(){
	  super(sprite, Permeability.BLOCKING);
	  }
}
