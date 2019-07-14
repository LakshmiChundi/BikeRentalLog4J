/**
 * 
 */
/**
 * @author Lakshmi Chundi
 *
 */
package com.bikerentallog4j.model.business.manager;
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.Customer;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.exception.CustomerException;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.customerservice.ICustomerService;
            import org.apache.log4j.Logger;





public class CustomerManager extends ManagerSuperType {

	private static CustomerManager _instance;

static Logger logger = Logger.getLogger(CustomerManager.class);

	private CustomerManager() {
		
	}

	
	public static synchronized CustomerManager getInstance() {
		if (_instance == null) {
			_instance = new CustomerManager();
		}
		return _instance;
	}

	/**
	 * Generic method that all clients of this class can call to perform certain
	 * actions.
	 * 
	 * @param commandString
	 *            Holds the service name to be invoked *
	 * @param rentalComposite
	 *            Holds application specific domain state
	 * @return false if action failed true if action is successful
	 */
	
	@Override
	public Customer performActionCustomer(String commandString, BikeRentalComposite bikerentalComposite) {
		
		Customer action  ;
		
	action = getCustomer(commandString,bikerentalComposite);
		
		return action;
	}

	
	
	public static Customer getCustomer(String commandString,BikeRentalComposite bikerentalComposite)  {
		
		Customer customer = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ICustomerService icustomerservice;
		
		try {
			icustomerservice = (ICustomerService) serviceFactory.getCustomerService(commandString);
           			customer = icustomerservice.getCustomer(bikerentalComposite);
		} catch (ServiceLoadException e1) {
			logger.info("Get Customer FAILED"); // defaulting
																		
		} catch (CustomerException ce) {
			// TODO Auto-generated catch block
			ce.printStackTrace();
		}
		return customer;		

	}// end registerCustomer
	 
} // end class 