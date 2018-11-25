package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IController;
import controller.IMobile;
import controller.IOrderPerformer;
import controller.Order;
import model.IMap;
import model.IModel;
import showboard.BoardFrame;
/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements KeyListener, IView, Runnable {

	private int view;
	
	private BoardFrame boardFrame;
	
	private static final int SQUARE_SIZE = 32;
	
	private IMap map;
	
	private IMobile myPlayer;
	
	private IOrderPerformer orderPerformer;
	
	private Rectangle closeView;
	
	private IController controllerFacade;
	
	private IModel modelFacade;
	   /**
     * Instantiates a new view facade.
	 * @param modelFacade 
     */
    public ViewFacade(IModel modelFacade, final IMap map, final IMobile myPlayer ) throws IOException {
    	this.setView(SQUARE_SIZE);
    	this.setMyPlayer(myPlayer);
    	this.setMap(map);
    	this.getMyPlayer().getSprite().loadImage();
    	this.setCloseView(new Rectangle(0, 0 ,this.getMap().getWidth(), this.getMap().getHeight()));
    	boardFrame = new BoardFrame();
        SwingUtilities.invokeLater(this);
    	
    }

	public final void run() {
		 final BoardFrame boardFrame = new BoardFrame("Lorann");
	        boardFrame.setSize(new Dimension(this.getMap().getWidth()*48, this.getMap().getHeight()*48));
	        boardFrame.setDisplayFrame(this.closeView);
	        boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
	        boardFrame.setHeightLooped(true);
	        boardFrame.addKeyListener(this);
	        boardFrame.setFocusable(true);
	        boardFrame.setFocusTraversalKeysEnabled(false);
	        boardFrame.addPawn(this.getMyPlayer());

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y) ;
                
               
            }
            this.getOnTheMapXY().getObservable().addObserver(this.boardFrame.getObserver());
            boardFrame.addPawn(this.getMyPlayer());
        }
        
  //      boardFrame.setSize(this.closeView.height*SQUARE_SIZE, this.closeView.width*SQUARE_SIZE);
    //  boardFrame.setDimension(new Dimension(this.getMyPlayer().getX(),this.getMyPlayer().getY()));
        

      //  this.getMap().getObservable().addObserver(boardFrame.getObserver());
       
    
        boardFrame.setVisible(true);    
    }
    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public void printMap(final String map) {
    	 JOptionPane.showMessageDialog(null, map);
    } 
    
/*   public final void show(final int yStart) {
        int y = yStart % this.getMap().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                if ((x == this.getMyPlayer().getX()) && (y == yStart)) {
                    System.out.print(this.getMyPlayer());
                } else {
                    System.out.print(this.getMap().getOnTheMapXY(x, y));
                }
            }
            y = (y + 1) % this.getMap().getHeight();
            System.out.print("\n");
        }
    }*/

  
    public void keyTyped (KeyEvent keyEvent) {
    	
    }
    
  /*  public final void keyPressed(final KeyEvent keyEvent) {
        try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
    
    public void keyReleased(KeyEvent keyEvent) {
    	
    }
    
	public int getView() {
		return this.view;
	}

	public void setView(final int view) {
		this.view = view;
	}

	public IMap getMap() {
		return this.map;
	}

	public void setMap(final IMap map) {
		this.map = map;
		
	}

	public IMobile getMyPlayer() {
		return this.myPlayer;
		
	}

	public void setMyPlayer(final IMobile myPlayer) {
		this.myPlayer = myPlayer;
	}
	
	public IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	public void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	public Rectangle getCloseView() {
		return this.closeView;
	}

	public void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}
	
	 public Order keyCodeToUserOrder(final int keyCode) {
	        Order userOrder;
	        switch (keyCode) {
	            case KeyEvent.VK_D:
	                userOrder = Order.RIGHT;
	                break;
	            case KeyEvent.VK_Q:
	                userOrder = Order.LEFT;
	                break;
	            case KeyEvent.VK_Z:
	                userOrder = Order.UP;
	                break;
	            case KeyEvent.VK_S:
	                userOrder = Order.DOWN;
	                break;
	            default:
	                userOrder = Order.NOP; 
	                break;	             
	        }
	        
	        this.controllerFacade.setStackOrder(userOrder);
	        System.out.println(this.controllerFacade.getStackOrder());
			return userOrder;
	    }

	public IController getControllerFacade() {
		return controllerFacade;
	}

	public void setControllerFacade(IController controllerFacade) {
		this.controllerFacade = controllerFacade;
	}

	
	public void keyPressed(final KeyEvent e) {
		try {
		this.getOrderPerformer().orderPerform(this.keyCodeToUserOrder(e.getKeyCode()));
		}
		catch(final IOException exception) {
		exception.printStackTrace();
		}	
	}
	
    public void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }	
    
    public IMap getOnTheMapXY() {
    	return this.map;
    }
}