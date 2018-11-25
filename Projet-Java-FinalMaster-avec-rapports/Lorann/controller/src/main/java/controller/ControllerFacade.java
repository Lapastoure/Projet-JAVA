package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.IModel;
import view.IView;


/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderPerformer {
//	private static final int     speed = 300;
    /** The view. */
    private IView  view;

    /** The model. */
    private IModel model;
    
	private Order stackOrder; 

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        this.SetIView(view);
        this.setIModel(model);
        //this.getStackOrder();
    }

    private void SetIView(final IView view) {
    	this.view = view;
		// TODO Auto-generated method stub
		
	}

	private void setIModel(final IModel model) {
		// TODO Auto-generated method stub
		this.model = model;
	}

	
	

	/**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        //this.getView().printMap(this.getModel().getExampleById(1).toString());

      //  this.getView().printMap(this.getModel().getExampleByName("Example 2").toString());

    	//final List<Example> examples = this.getModel().getNiveau1();
        final StringBuilder message = new StringBuilder();
       /* for (final Example example : examples) {
            message.append(example);
            message.append('\n');
            System.out.println(example);
            
        }*/
      //  this.getView().printMap(message.toString());
       
    }

    public final void play() throws InterruptedException {
    	while (this.getModel().getMyPlayer().isAlive() ){
    		this.setStackOrder(Order.LEFT);
    		System.out.println("yo" + "    " + getStackOrder());
    		switch (this.getStackOrder()) {
                case RIGHT:
                	System.out.println("yo" + "  " + getStackOrder());
                    this.getModel().getMyPlayer().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyPlayer().moveLeft();
                    break;
                case NOP:
                default:
                    this.getModel().getMyPlayer().doNothing();
                    break;
            }
            this.clearStackOrder();
            this.getModel().getMap().setMobileHasChanged();
            if (this.getModel().getMyPlayer().isAlive()) {
                this.getModel().getMyPlayer().moveDown();
               
            }
        }
        this.getView().displayMessage("GAME OVER !");
    }
    
    public Order getStackOrder() {
		return this.stackOrder;
	}

    public void setStackOrder(Order order) {
    	this.stackOrder = order;
    }
	/**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
   
	 
    
	public IOrderPerformer getOrderPerformer() {
		// TODO Auto-generated method stub
		return this;
	}

	

	@Override
	public void orderPerform(Order order) throws IOException {
		// TODO Auto-generated method stub
		this.setStackOrder(order);
	}
	
	private void clearStackOrder() {
        this.stackOrder = Order.NOP;
    }
	
}
