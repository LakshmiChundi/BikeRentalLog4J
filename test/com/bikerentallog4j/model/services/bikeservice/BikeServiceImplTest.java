package com.bikerentallog4j.model.services.bikeservice;

import org.junit.Test;
import junit.framework.TestCase;

import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.Bike;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.bikeservice.IBikeService;
import com.bikerentallog4j.model.services.exception.BikeException;
import com.bikerentallog4j.model.services.bikeservice.BikeServiceImpl;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author Lakshmi Chundi
 * 
 * BikeServiceImplTest will run all test cases of BikeServiceImpl
 *
 */

public class BikeServiceImplTest extends TestCase {

	 private ServiceFactory serviceFactory;
	 private Bike bike;
	 private BikeRentalComposite bikeRentalComposite = new BikeRentalComposite();
         static Logger logger = Logger.getLogger(BikeServiceImplTest.class);
         
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
       serviceFactory = new ServiceFactory();

		bike = new Bike("ID1234567","Mountain Bike", "Large", "Blue", "Yeti");
		
		bikeRentalComposite.setBike(bike);
		
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);
	}
	

	@Test
	public void testAddBike() {
		try {
			BikeServiceImpl bikeServiceImpl = (BikeServiceImpl)serviceFactory.getBikeService(IBikeService.NAME);
			assertEquals(bike.getID(),bikeServiceImpl.add(bikeRentalComposite).getID());
			logger.info("Test Add Bike PASSED");
		
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeException e) {
			e.printStackTrace();
			fail("Bike Service Exception");
		}	
	}

	
	@Test
	public void testGetBike() {
		
		try 
		{	
			BikeServiceImpl bikeServiceImpl = (BikeServiceImpl)serviceFactory.getBikeService(IBikeService.NAME);
			assertEquals(bike.getcolor(),bikeServiceImpl.get(bikeRentalComposite).getcolor());
			logger.info("Test Get Bike PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeException e) {
			e.printStackTrace();
			fail("Bike Service Exception");
		}	
		
	}
	
	@Test
	public void testUpdateBike() {
		
		try {
			
			BikeServiceImpl bikeServiceImpl = (BikeServiceImpl)serviceFactory.getBikeService(IBikeService.NAME);
			assertEquals(bike.getbrand(),bikeServiceImpl.update(bikeRentalComposite,bikeRentalComposite).getbrand());
		logger.info("Test Update Bike PASSED");
			
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeException e) {
			e.printStackTrace();
			fail("Bike Service Exception");
		}	
		
	}
	
	@Test
	public void testDeleteBike() {
		
		try {
			BikeServiceImpl bikeServiceImpl = (BikeServiceImpl)serviceFactory.getBikeService(IBikeService.NAME);
			assertEquals("Bike Deleted", bikeServiceImpl.delete(bikeRentalComposite));
			logger.info("Test Delete Bike PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeException e) {
			e.printStackTrace();
			fail("Bike Service Exception");
		}	
		
		
	}
}
	
	
	


