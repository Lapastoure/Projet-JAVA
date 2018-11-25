package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import controller.IMobile;
import model.element.mobile.MyPlayer;
import model.element.motionless.MotionlessElementFactory;

public class Map extends Observable implements IMap{
	private int  width;
	
	private int  height;
	/** The on the map. */
	private IElement[][] onTheMap;
	private IMobile player;
	


	Map(ArrayList<Example> elementsBdd, int myPlayerStartX, int myPlayerStartY) throws IOException {
        super();
        this.loadBdd(elementsBdd);
        this.setPlayer(new MyPlayer(myPlayerStartX, myPlayerStartY, this));
        //this.loadFile(fileName);
        
        
	}
	
	private void loadFile(final String fileName) throws IOException {
		/*
//		System.out.println(System.getProperty("user.dir"));
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheMapXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
                //System.out.println(x + " : " + y + "  " + line.toCharArray().length);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    */}


	public final int getWidth() {
		return this.width;
	}


	private void setWidth(final int width) {
		this.width = width;
	}


	public final int getHeight() {
		return this.height;
	}


	private void setHeight(int height) {
		this.height = height;
	}
	

	private void setOnTheMapXY (IElement element, int x, int y) {
		this.onTheMap[x][y] = element;
	}
	
	public void setMobileHasChanged () {
		 this.setChanged();
	        this.notifyObservers();
	}
	
	public Observable getObservable () {
		return this;
		
	}
	

	
	
	 @Override
	    public final IElement getOnTheMapXY(final int x, final int y) {
	        return this.onTheMap[x][y];
	    }
	public void loadBdd(ArrayList<Example> elementsBdd) {
		this.setWidth(20);
		this.setHeight(11);
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		for( Example temp : elementsBdd) {
			if(temp.getIdSprite() == 1) {
				this.setOnTheMapXY(MotionlessElementFactory.createCorner(), temp.getX(), temp.getY());
			}else if(temp.getIdSprite() == 4) {
				this.setOnTheMapXY(MotionlessElementFactory.createWallHorizontal(), temp.getX(), temp.getY());
			} else if(temp.getIdSprite() == 9) {
				this.setOnTheMapXY(MotionlessElementFactory.createWallVertical(), temp.getX(), temp.getY());
			} else if (temp.getIdSprite() == 3) {
				this.setOnTheMapXY(MotionlessElementFactory.createGateClosed(), temp.getX(), temp.getY());
			} else if (temp.getIdSprite() == 2 ) {
				this.setOnTheMapXY(MotionlessElementFactory.createEnergyBubble(), temp.getX(), temp.getY());
			} else {
				this.setOnTheMapXY(MotionlessElementFactory.createFloor(), temp.getX(), temp.getY());	
			}
		}
	}

	public IMobile getPlayer() {
		return this.player;
	}

	public void setPlayer(IMobile player) {
		this.player = player;
	}
	
	
	
	
	
}
