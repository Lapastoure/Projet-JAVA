package model.element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.ISprite;

public class Sprite implements ISprite {

	private BufferedImage image;

	private String ImageName;

	private boolean ImageLoaded;

	private char character;

	public Sprite(final char character) {
		this(character, "noimage.jpg");
	}

	public Sprite(char character, String ImageName) {
		this.setCharacter(character);
		this.setImageName(ImageName);
		try {
			this.setImage(ImageIO.read(new File(this.getImageName())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getImageName() {
		return this.ImageName;
	}

	public void setImageName(final String ImageName) {
		this.ImageName = ImageName;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	private void setImage(final BufferedImage image) {
		this.image = image;
	}
	
	public void loadImage() {
		try {
			this.setImage(ImageIO.read(new File(this.getImageName())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public final boolean isImageLoaded() {
		if (this.image == null) {
			return false;
		} else {
			return ImageLoaded ;
			
		}
	}
	
	public void setImageLoaded(final boolean isImageLoaded) {
		this.ImageLoaded = isImageLoaded;
	}

	public char getCharacter() {
		return this.character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}
}
