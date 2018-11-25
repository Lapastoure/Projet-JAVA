package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerFacade;
import model.Example;
import model.ModelFacade;
import model.dao.ExampleDAO;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {
	
	private static final int myPlayerStartX = 0 ;
	private static final int myPlayerStartY = 0 ;


	public static void main(final String[] args) throws SQLException, IOException, InterruptedException {
		ArrayList<Example> elementsBdd = ExampleDAO.getNiveau1();
		ModelFacade modelFacade = new ModelFacade(elementsBdd ,myPlayerStartX, myPlayerStartY);
		ViewFacade viewFacade = new ViewFacade(modelFacade, modelFacade.getMap(), modelFacade.getMyPlayer());
		ControllerFacade controller = new ControllerFacade(viewFacade, modelFacade);
		viewFacade.setControllerFacade(controller);
		viewFacade.setOrderPerformer(controller.getOrderPerformer());
		
		controller.play();			
	
		
		try {
		controller.start();       
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
	}
}
