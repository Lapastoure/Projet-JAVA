package model;
import java.sql.SQLException;
import java.util.List;

import controller.IMobile;


/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel{

	
	IMap getMap();
	

    IMobile getMyPlayer();

    List<Example>getNiveau1() throws SQLException;
}
