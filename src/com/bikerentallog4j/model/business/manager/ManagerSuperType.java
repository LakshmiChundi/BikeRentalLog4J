package com.bikerentallog4j.model.business.manager;
/**@author Lakshmi Chundi**/

import com.bikerentallog4j.model.business.exception.PropertyFileNotFoundException;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import com.bikerentallog4j.model.domain.Bike;
import com.bikerentallog4j.model.domain.BikeRent;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.BikeWorkShop;
import com.bikerentallog4j.model.domain.Customer;
import com.bikerentallog4j.model.domain.ReserveBike;
import org.apache.log4j.Logger;

public abstract class  ManagerSuperType {

	private static final Customer customer = null;
	private static final Bike bike = null;
	private static final ReserveBike reservebike = null;
	private static final BikeRent bikerental=null;
	private static final BikeWorkShop bikeworkshop=null;
        static Logger logger = Logger.getLogger(ManagerSuperType.class);

	
	
	
	/** Perform action**/
	
	public Customer performActionCustomer(String commandString, BikeRentalComposite bikerentalComposite) {
		// TODO Auto-generated method stub
		return customer;
	}
	
	public Bike performActionOnBike(String commandString, BikeRentalComposite bikerentalComposite) {
		// TODO Auto-generated method stub
		return bike;
	}
	
	public ReserveBike performActionOnReserveBike(String commandString, BikeRentalComposite bikerentalComposite) {
		// TODO Auto-generated method stub
		return reservebike;
	}
	
	public BikeRent performActionOnBikeRent(String commandString, BikeRentalComposite bikerentalComposite) {
		
		// TODO Auto-generated method stub
		return bikerental;
	}
	
    public BikeWorkShop performActionOnBikeWorkShop(String commandString, BikeRentalComposite bikerentalComposite) {
		
		// TODO Auto-generated method stub
		return bikeworkshop;
	}
	
    
    
    /** Throws FileNot Found Exception**/
	
	public static void loadProperties () throws PropertyFileNotFoundException
	{
		
		String propertyFileLocation = System.getProperty("prop_location");
		
        if (propertyFileLocation != null)
        { 
          
      // PropertyManager class load it up
          PropertyManager.loadProperties(propertyFileLocation);
        }
        else
        {
          logger.info("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
          throw new PropertyFileNotFoundException ("Property file location not set", null);         
        }
    	
    	
	} //end loadProperties


}
