   package com.bikerentallog4j.model.services.factory;

import org.junit.Test;

import com.bikerentallog4j.model.services.bikerentservice.BikeRentServiceImpl;
import com.bikerentallog4j.model.services.bikerentservice.IBikeRentService;
import com.bikerentallog4j.model.services.bikeservice.BikeServiceImpl;
import com.bikerentallog4j.model.services.bikeservice.IBikeService;
import com.bikerentallog4j.model.services.bikeworkshopservice.BikeWorkShopServiceImpl;
import com.bikerentallog4j.model.services.bikeworkshopservice.IBikeWorkShopService;
import com.bikerentallog4j.model.services.customerservice.CustomerServiceImpl;
import com.bikerentallog4j.model.services.customerservice.ICustomerService;
import com.bikerentallog4j.model.services.reservebikeservice.IReserveBikeService;
import com.bikerentallog4j.model.services.reservebikeservice.ReserveBikeServiceImpl;

import junit.framework.TestCase;

import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.services.bikerentservices.BikeRentServiceImplTest;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author Lakshmi Chundi
 * 
 * ServiceFactoryTest will run all test cases of CustomerServiceImpl, BikeServiceImpl, ReserveBikeServiceImpl
 *
 */
public class ServiceFactoryTest extends TestCase {

	ServiceFactory serviceFactory;
        static Logger logger = Logger.getLogger(ServiceFactoryTest.class);


	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);
	}
	
	/*
	 * @Before public void setUp() throws Exception { serviceFactory =
	 * ServiceFactory.getInstance();
	 * 
	 * }
	 */

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
	public void testGetBikeService() {
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
	public void testGetBikeRentService() {
 		IBikeRentService bikeRentalService;
		try {
			bikeRentalService = (IBikeRentService )serviceFactory.getBikeRentService(IBikeRentService.NAME);
	  	    assertTrue(bikeRentalService instanceof BikeRentServiceImpl);
	        logger.info("test GetBikeRentalService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}


	@Test
	public void testGetBikeWorkShopService() {
 		
		IBikeWorkShopService bikeworkshopservice;
		try {
			bikeworkshopservice = (IBikeWorkShopService)serviceFactory.getBikeWorkShopService(IBikeWorkShopService.NAME);
	  	    assertTrue(bikeworkshopservice instanceof BikeWorkShopServiceImpl);
	        logger.info("testGetReserveBikeService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	
}

