package com.bikerentallog4j.model.business.manager;

	/**
	 * @author Lakshmi Chundi
	 *
	 */
	
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.BikeRent;
    import com.bikerentallog4j.model.domain.BikeRentalComposite;
    import com.bikerentallog4j.model.services.bikerentservice.IBikeRentService;
    import com.bikerentallog4j.model.services.exception.BikeRentalException;
    import com.bikerentallog4j.model.services.factory.ServiceFactory;
    import org.apache.log4j.Logger;




	public class  BikeRentManager extends ManagerSuperType {

		private static BikeRentManager _instance;
                   static Logger logger = Logger.getLogger(BikeRentManager.class);

		
		private  BikeRentManager() {
			// construct object . . .
		}

		
		public static synchronized BikeRentManager getInstance() {
			if (_instance == null) {
				_instance = new  BikeRentManager();
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
		
		public  BikeRent performActionOnBikeRent(String commandString, BikeRentalComposite bikerentalComposite) {
			
	       BikeRent action  ;
			
		  action = getBikeRent(commandString,bikerentalComposite);
			
			return action;
		}
		
		
		
		public static BikeRent getBikeRent(String commandString,BikeRentalComposite bikerentalComposite)  {
			
			BikeRent bikerent = null;
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			IBikeRentService ibikerentalservice;
			
			try {
				ibikerentalservice = (IBikeRentService) serviceFactory.getBikeRentService(commandString);
				bikerent = ibikerentalservice.getRent(bikerentalComposite);
			} catch (ServiceLoadException e1) {
				logger.info("Get BikeRental FAILED"); // defaulting
																			
			} catch (BikeRentalException bre) {
				// TODO Auto-generated catch block
				bre.printStackTrace();
			}
			return bikerent;		

		}



}