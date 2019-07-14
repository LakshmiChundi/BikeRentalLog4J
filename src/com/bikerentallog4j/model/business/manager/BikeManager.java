
package com.bikerentallog4j.model.business.manager;
/** @author Lakshmi Chundi */
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.Bike;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.exception.BikeException;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.bikeservice.IBikeService;
import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import org.apache.log4j.Logger;


public class BikeManager extends ManagerSuperType {

	private static BikeManager _instance;

	private BikeManager() {
		// construct object . . .
	}
        static Logger logger = Logger.getLogger(BikeManager.class);
        
	/** @return BikeManager instance */
	public static synchronized BikeManager getInstance() {
		if (_instance == null) {        
			_instance = new BikeManager();
		}
		return _instance;
	}
/*                                        */

	@Override
	public Bike performActionOnBike(String commandString, BikeRentalComposite bikerentalComposite) {
	
		Bike action;
		action=getBike(commandString,bikerentalComposite);
		return action;
			
	}
	
	
	public static Bike getBike(String commandString,BikeRentalComposite bikerentalComposite)  {
		
	        Bike bike=null;
                BikeRentalLog4J.initializeLog4J();

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		
		IBikeService ibikeservice  ;
		
		try {
			ibikeservice = (IBikeService) serviceFactory.getBikeService(commandString);
			 
			bike=ibikeservice.get(bikerentalComposite);
		
		} catch (ServiceLoadException e1) {
			logger.info("Get Bike Failed"); // defaulting
																		
		} catch (BikeException be) {
			// TODO Auto-generated catch block
			be.printStackTrace();
		}
		return  bike;
	}
	
}