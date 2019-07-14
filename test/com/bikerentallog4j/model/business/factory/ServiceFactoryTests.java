package com.bikerentallog4j.model.business.factory;

import junit.framework.TestCase;

import org.junit.Test;
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import com.bikerentallog4j.model.services.reservebikeservice.IReserveBikeService;
import com.bikerentallog4j.model.services.reservebikeservice.ReserveBikeServiceImpl;
import com.bikerentallog4j.model.services.customerservice.ICustomerService;
import com.bikerentallog4j.model.services.bikerentservice.BikeRentServiceImpl;
import com.bikerentallog4j.model.services.bikerentservice.IBikeRentService;
import com.bikerentallog4j.model.services.bikeservice.BikeServiceImpl;
import com.bikerentallog4j.model.services.bikeservice.IBikeService;
import com.bikerentallog4j.model.services.customerservice.CustomerServiceImpl;
import org.apache.log4j.Logger;

/**
 * 
 * @author Lakshmi Chundi
 *
 */

public class ServiceFactoryTests extends TestCase {

	ServiceFactory serviceFactory;
	                   static Logger logger = Logger.getLogger(ServiceFactoryTests.class);


	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);
	}

	@Test
	public void testGetCustomerService() {
 		ICustomerService customerService;
		try {
			customerService = (ICustomerService )serviceFactory.getCustomerService(ICustomerService.NAME);
	  	    assertTrue(customerService instanceof CustomerServiceImpl);
	        logger.info("testGetCustomerService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}
	
	@Test               
	public void testGetBikerService() {
 		IBikeService bikeService;
		try {
			bikeService = (IBikeService)serviceFactory.getBikeService(IBikeService.NAME);
	  	    assertTrue(bikeService instanceof BikeServiceImpl);
	        logger.info("testGetBikeService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}
	
	@Test
	public void testGetReserveBikeService() {
 		IReserveBikeService reserveBikeService;
		try {
			reserveBikeService = (IReserveBikeService )serviceFactory.getReserveBikeService(IReserveBikeService.NAME);
	  	    assertTrue(reserveBikeService instanceof ReserveBikeServiceImpl);
	        logger.info("testGetReserveBikeService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	@Test
	public void testGetBikeRentalService() {
 		
		IBikeRentService bikerentalservice;
		try {
			 bikerentalservice = (IBikeRentService )serviceFactory.getBikeRentService(IBikeRentService.NAME);
	  	    assertTrue(bikerentalservice instanceof BikeRentServiceImpl);
	        logger.info("testGetReserveBikeService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}
}
