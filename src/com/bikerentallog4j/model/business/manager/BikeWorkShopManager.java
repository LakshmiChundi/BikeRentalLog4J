package com.bikerentallog4j.model.business.manager;
	
/**
	 * @author Lakshmi Chundi
	 *
	 */
	
	import com.bikerentallog4j.model.business.exception.ServiceLoadException;
	import com.bikerentallog4j.model.domain.BikeWorkShop;
    import com.bikerentallog4j.model.domain.BikeRentalComposite;
    import com.bikerentallog4j.model.services.bikeworkshopservice.IBikeWorkShopService;
    import com.bikerentallog4j.model.services.exception.BikeWorkShopException;
    import com.bikerentallog4j.model.services.factory.ServiceFactory;
            import org.apache.log4j.Logger;




/** BikeWorkShopManager class**/
    
	public class  BikeWorkShopManager extends ManagerSuperType {

		private static BikeWorkShopManager _instance;

static Logger logger = Logger.getLogger(BikeWorkShopManager.class);

		private  BikeWorkShopManager() {
			// construct object . . .	
		}

		
		public static synchronized BikeWorkShopManager getInstance() {
			if (_instance == null) {
				_instance = new  BikeWorkShopManager();
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
		
		public  BikeWorkShop performActionOnBikeWorkShop(String commandString, BikeRentalComposite bikerentalComposite) {
			
			BikeWorkShop  action  ;
			
		  action = getBikeWorkShop(commandString,bikerentalComposite);
			
			return action;
		}
		

		public static BikeWorkShop getBikeWorkShop(String commandString,BikeRentalComposite bikerentalComposite)  {
			
			BikeWorkShop bikeworkshop=null;
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			IBikeWorkShopService ibikeworkshopservice;
			
			try {
				ibikeworkshopservice = (IBikeWorkShopService) serviceFactory.getBikeWorkShopService(commandString);
				bikeworkshop = ibikeworkshopservice.getReport(bikerentalComposite);
			} catch (ServiceLoadException e1) {
				logger.info("Get BikeRental FAILED"); // defaulting
																			
			} catch (BikeWorkShopException bre) {
				// TODO Auto-generated catch block
				bre.printStackTrace();
			}
			return bikeworkshop;		

		}



}

