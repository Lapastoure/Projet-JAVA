package controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IController {

	public void  play() throws SQLException, IOException, InterruptedException;
     IOrderPerformer getOrderPerformer ();
     public void setStackOrder(Order order); 
     public Order getStackOrder(); 
     
    
}
