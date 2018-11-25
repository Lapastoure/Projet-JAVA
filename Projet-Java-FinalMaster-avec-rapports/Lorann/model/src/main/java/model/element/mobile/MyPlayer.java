package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.element.Sprite;

public class MyPlayer extends MobileElement {

	private static final Permeability PERMEABILITY = Permeability.BLOCKING;
	private Point position;
	private Boolean alive = true;

	static Sprite[] LorannSprite = {
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_b.png"),
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_bl.png"),
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_l.png"),
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_ul.png"),
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_u.png"),
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_ur.png"),
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_r.png"),
			new Sprite('l', System.getProperty("user.dir") + "/src/main/java/Images/lorann_br.png") };

	public MyPlayer(final int x, final int y, final IMap map) throws IOException {
		super(x, y, LorannSprite[2], map, PERMEABILITY.BLOCKING);
		this.setX(x);
		this.setY(y);
		LorannSprite[0].loadImage();
		LorannSprite[1].loadImage();
		LorannSprite[2].loadImage();
		LorannSprite[3].loadImage();
		LorannSprite[4].loadImage();
		LorannSprite[5].loadImage();
		LorannSprite[6].loadImage();
		LorannSprite[7].loadImage();

	}

	protected void die() {
		super.die();
	}

	public void moveRight() {
		super.moveRight();
		this.setSprite(LorannSprite[6]);
	}

	public void moveLeft() {
		super.moveLeft();
		this.setSprite(LorannSprite[2]);
	}

	public void moveUp() {
		super.moveUp();
		this.setSprite(LorannSprite[4]);
	}

	public void moveDown() {
		super.moveDown();
		this.setSprite(LorannSprite[0]);
	}

	public void moveUL() {
		super.moveUL();
		this.setSprite(LorannSprite[3]);
	}

	public void moveUR() {
		super.moveUR();
		this.setSprite(LorannSprite[5]);
	}

	public void moveDL() {
		super.moveDL();
		this.setSprite(LorannSprite[1]);
	}

	public void moveDR() {
		super.moveDR();
		this.setSprite(LorannSprite[7]);
	}

	@Override
	public boolean isHit() {
		return this.isHit();
	}

}