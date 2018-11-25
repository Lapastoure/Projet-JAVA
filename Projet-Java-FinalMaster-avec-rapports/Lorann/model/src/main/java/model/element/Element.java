package model.element;

import java.awt.Image;

import model.IElement;
import model.ISprite;
import model.Permeability;

public abstract class Element implements IElement{
	
	private ISprite sprite;
	
	private Permeability permeability;

	private int x = 17 ;

	private int y= 5 ;
	
   //private IMap map;
	
	public Element(ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.permeability = permeability;
		
	}
	
	public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

	

/*	public Element(ISprite sprite, IMap map, Permeability permeability) {
		this.setSprite(sprite);
		this.setMap(map);
		this.setPermeability(permeability);
		// TODO Auto-generated constructor stub
	}*/



/*	private void setMap(IMap map) {
		this.map = map;
		// TODO Auto-generated method stub
		
	}*/



	public final ISprite getSprite() {
		return this.sprite;
	}

	protected final void setSprite(ISprite sprite) {
		this.sprite = sprite;
	}

	public final Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	
	public Image getImage () {
		return this.getSprite().getImage();
	}
	
	
}
