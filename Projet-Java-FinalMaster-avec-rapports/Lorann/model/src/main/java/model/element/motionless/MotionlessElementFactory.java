package model.element.motionless;

import model.ISprite;
import model.Permeability;

public class MotionlessElementFactory extends MotionlessElement {
		



	public MotionlessElementFactory(ISprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}


	private static  final  WallVertical wallVertical = new WallVertical();
	
	private static final WallHorizontal wallHorizontal = new WallHorizontal();
	
	private static final Corner corner = new Corner();
	
	private static final Gate_Closed gate_closed = new Gate_Closed();
	
	private static final  Gate_Opened gate_open = new Gate_Opened();
	
	private static final  Floor floor = new Floor(); 
	
	private static final Loot loot = new Loot();
	
	private static final EnergyBubble energyBubble  = new EnergyBubble();
	
	//private static final Issou issou = new Issou();
	
	 private static MotionlessElement[]       motionlessElements  = {
			 wallVertical,
			 wallHorizontal,
			 corner,
			 gate_closed,
			 gate_open,
			 floor,
			 loot,
			 energyBubble
	 };
	
	public static MotionlessElement createWallVertical() {
		return wallVertical;
		
	}
	
	public static MotionlessElement createWallHorizontal() {
		return wallHorizontal;
		
	}
	
	public static MotionlessElement createGateClosed() {
		return gate_closed;
		
	}
	
	public static MotionlessElement createGateOpen() {
		return gate_open;
		
	}
	
	public static MotionlessElement createCorner() {
		return corner;
		
	}
	
	public static MotionlessElement createFloor() {
		return floor;
		
	}
	
	public static MotionlessElement createLoot() {
		return loot;	
	}
	
	public static MotionlessElement createEnergyBubble() {
		return energyBubble;
		
	}
	
	
	/*public MotionlessElement creatIssou(){
		return issou;
	}*/

	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
           if (motionlessElement.getSprite().getCharacter() == fileSymbol) {
                return motionlessElement;
            }
        }
		return null;   
	}
}