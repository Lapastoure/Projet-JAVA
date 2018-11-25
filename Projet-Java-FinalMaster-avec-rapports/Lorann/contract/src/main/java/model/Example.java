package model;

/**
 * <h1>The Class Example.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class Example {


    private int x;
    private int y;
    private int idSprite;


    public Example(int x, int y, int id) {
        super();
        this.setX(x);
        this.setIdSprite(id);
        this.setY(y);
         
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getIdSprite() {
		return idSprite;
	}

	public void setIdSprite(int idSprite) {
		this.idSprite = idSprite;
	}

}