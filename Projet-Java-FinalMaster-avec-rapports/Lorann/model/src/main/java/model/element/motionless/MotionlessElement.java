package model.element.motionless;

import model.IMotionlessElement;
import model.ISprite;
import model.Permeability;
import model.element.Element;

public abstract class MotionlessElement extends Element implements IMotionlessElement {
	
	public MotionlessElement (ISprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}

	
}
