package model;

import java.util.Observable;

import controller.IMobile;

public interface IMap {
	int getWidth ();
	
	int getHeight ();
	
	IElement getOnTheMapXY (int x, int y);
	
	void setMobileHasChanged ();
	
	Observable getObservable ();

	IMobile getPlayer();
	
} 
