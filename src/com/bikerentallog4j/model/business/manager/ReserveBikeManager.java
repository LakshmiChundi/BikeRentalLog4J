/**
 * 
 */
/**
 * @author Lakshmi Chundi
 *
 */
package com.bikerentallog4j.model.business.manager;
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.ReserveBike;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.exception.ReserveBikeException;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.reservebikeservice.IReserveBikeService;
import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import org.apache.log4j.Logger;




public class ReserveBikeManager extends ManagerSuperType {

	private static ReserveBikeManager _instance;
        static Logger logger = Logger.getLogger(ReserveBikeManager.class);


	private ReserveBikeManager() {
		// construct object . . .
	}

	/** @return 
	 * 
	 * ReserveBikeManager instance */
	
	public static synchronized ReserveBikeManager getInstance() {
		if (_instance == null) {
			_instance = new ReserveBikeManager();
		}
		return _instance;
	}

	/**
	 * 
	 * @param commandString
	 *        Holds the service name to be invoked *
	 * @param BikerentalComposite
	 *            Holds application specific domain state
	 */
	
	@Override
	public ReserveBike performActionOnReserveBike(String commandString, BikeRentalComposite bikerentalComposite) {
		
		ReserveBike action;;
		
		action = getBikeAvailability(commandString,bikerentalComposite);
		
		return action;
	}

	/*
	 * 
	 * 
	 *  ResreveBike 
	 *
	 */
	

	public static ReserveBike getBikeAvailability(String commandString,BikeRentalComposite bikerentalComposite) {
		
		ReserveBike reserveBike = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		
		  BikeRentalLog4J.initializeLog4J();
		IReserveBikeService ireservebikeservice;
		
		try {
			ireservebikeservice = (IReserveBikeService) serviceFactory.getCustomerService(commandString);
			reserveBike = ireservebikeservice.booking(bikerentalComposite);
		} catch (ServiceLoadException e1) {
			logger.info("Get Bike Failed"); // defaulting
																		
		} catch (ReserveBikeException rbe) {
		logger.info("Reserve Bike Failed");
		}
		return reserveBike;
	
	
	} 
}