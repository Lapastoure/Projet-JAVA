package controller;

import java.awt.Point;

import model.IElement;
import showboard.IPawn;

public interface IMobile extends IPawn, IElement {

	void moveRight();

	void moveUp();

	void moveDown();

	void moveLeft();

	void doNothing();

	void moveUL();

	void moveUR();

	void moveDL();

	void moveDR();

	@Override
	int getX();

	@Override
	int getY();

	boolean isAlive();

	Point getPosition();

	boolean isHit();

}
