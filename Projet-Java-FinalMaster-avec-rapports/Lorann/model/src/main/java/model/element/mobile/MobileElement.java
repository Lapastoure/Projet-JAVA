package model.element.mobile;

import java.awt.Point;

import controller.IMobile;
import model.IMap;
import model.IModelFacade;
import model.ISprite;
import model.Permeability;
import model.element.Element;
import showboard.IBoard;

public abstract class MobileElement extends Element implements IMobile{
	private boolean alive = true;
	private IBoard board;
	private IMap map;
	private Point   position;
	private IModelFacade modelFacade;
	public int x;
	public int Y;
	
	
	MobileElement(final ISprite sprite, final IMap map , final Permeability permeability) {
		super(sprite, permeability);
		System.out.println("il y a une map : " + this.map.toString() ); 
        this.position = new Point();
       
	}

	MobileElement(final int x, final int y, final ISprite sprite, final IMap map, final Permeability permeability){
		super(sprite,permeability);
		this.setX(x);
		this.setY(y);
		
	}
	
protected void die() {
    	  this.alive = false;
 
	}
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}
	@Override
	public void moveUp() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}
	@Override
	public void moveDown () {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}
	
	public void doNothing () {
		this.setHasMoved();
	}
	
	 private void setHasMoved() {
	        this.getMap().setMobileHasChanged();
	}
	
	
	public void moveUL () {
		this.setHasMoved();
	}
	
	public void moveUR () {
		this.setHasMoved();
	}
	
	public void moveDL () {
		this.setHasMoved();
	}
	
	public void moveDR () {
		this.setHasMoved();
	}
	

	
	
	
    
    public void setX (int x) {
    	 this.x = x;
       //  if (this.isCrashed()) {
        
    }
    
    public void setY (int y) {
    	this.Y = y;
    	//this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
    //if (this.isCrashed()) {
        //}
    }
    
    public IMap getMap () {
    	if (this.modelFacade.getMap() == null) {
    		System.out.println("null");
    		return this.modelFacade.getMap();
    	}
    	
    	System.out.println("not null");
    	return null;
    }
    
    private void setMap(IMap map) {
    	this.map = map;
    }
    
    public boolean isAlive () {
		return alive;
    	
    }
    
    public Point getPosition (){
    	return this.position;
    	
    }
    
    public void setPosition (Point position) {
    	this.position = position;
    }
    
    protected IBoard getBoard () {
		return this.board;
    	
    }
    

	public void moveLeft() {
		this.setX(this.getX() - 1);
		
	}


	public boolean isCrashed() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
	
}
