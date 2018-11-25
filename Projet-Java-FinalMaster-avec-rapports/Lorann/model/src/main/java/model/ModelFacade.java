package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.IMobile;
import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

	private IMap map;
	private IMobile myPlayer;
	
    /**
     * Instantiates a new model facade.
     * @throws IOException 
     * @throws InterruptedException 
     * @throws SQLException 
     */
    public ModelFacade(ArrayList<Example> elementsBdd, final int myPlayerStartX, final int myPlayerStartY) throws IOException, InterruptedException, SQLException {
    	this.map = new Map(elementsBdd, myPlayerStartX, myPlayerStartY);
    	this.setMyPlayer();  
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    
    
    @Override
    public List<Example> getNiveau1() throws SQLException {
        return ExampleDAO.getNiveau1();
    }
    
    public IMobile getMyPlayer () {
		return this.myPlayer;
    	
    }
    
    private void setMyPlayer () {
		this.myPlayer = this.getMap().getPlayer();
    }
    
    public final IMap getMap () {
		return this.map;
    	
    }
    
    private void setMap (IMap map) {
    	this.map = map;
    }
    


}
