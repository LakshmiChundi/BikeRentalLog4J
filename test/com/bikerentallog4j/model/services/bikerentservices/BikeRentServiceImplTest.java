package com.bikerentallog4j.model.services.bikerentservices;

import org.junit.Test;
import junit.framework.TestCase;
import com.bikerentallog4j.model.services.bikerentservice.BikeRentServiceImpl;
import com.bikerentallog4j.model.services.bikerentservice.IBikeRentService;
import com.bikerentallog4j.model.services.exception.BikeRentalException;
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.BikeRent;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import org.apache.log4j.Logger;


/**
 * 
 * @author Lakshmi Chundi
 * 
 * CustomerServiceImplTest will run all test cases of CustomerServiceImpl
 *
 */
public class BikeRentServiceImplTest extends TestCase {

	 private ServiceFactory serviceFactory;
	 private BikeRent bikerent;
	 private BikeRentalComposite bikeRentalComposite = new BikeRentalComposite();
                                    static Logger logger = Logger.getLogger(BikeRentServiceImplTest.class);


	
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
		serviceFactory = new ServiceFactory();
		bikerent = new BikeRent("BikeID1234567 ","CustId1234567", "$35", "$100", "10AM","3PM","6/20/2018", "6/20/2018","$45");
		bikeRentalComposite.setBikeRent(bikerent);
		
          String propertyFileLocation = System.getProperty("prop_location");

       	PropertyManager.loadProperties(propertyFileLocation);
	}
	

	@Test
	public void testAddRent() {
		
		try {	
			BikeRentServiceImpl bikeRentServiceImpl = (BikeRentServiceImpl)serviceFactory.getBikeRentService(IBikeRentService.NAME);
			assertEquals(bikerent.getCustomerID(),bikeRentServiceImpl.addRent(bikeRentalComposite).getCustomerID());
			logger.info("Test Add Rent PASSED");
			
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeRentalException bre) {
			bre.printStackTrace();
			fail("BikeRental Exception");
		}	
	}
	
	@Test
	public void testGetRent() {
		
		try {	
			BikeRentServiceImpl bikeRentServiceImpl = (BikeRentServiceImpl)serviceFactory.getBikeRentService(IBikeRentService.NAME);
			assertEquals(bikerent.getPrice(),bikeRentServiceImpl.getRent(bikeRentalComposite).getPrice());
			logger.info("Test Get Rent PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeRentalException bre) {
			bre.printStackTrace();
			fail("BikeRental Exception");
		}
	
}
			
	@Test
	public void testUpdateRent() {
		try {
			BikeRentServiceImpl bikeRentServiceImpl = (BikeRentServiceImpl)serviceFactory.getBikeRentService(IBikeRentService.NAME);
			assertEquals(bikerent.getDropOffDay(),bikeRentServiceImpl.updateRent(bikeRentalComposite,bikeRentalComposite).getDropOffDay());
			logger.info("Test Update Rent PASSED");
		}catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeRentalException bre) {
			bre.printStackTrace();
			fail("BikeRental Exception");

		}
	}
	
	@Test
	public void testDeleteRent() {
		try {
			BikeRentServiceImpl bikeRentServiceImpl = (BikeRentServiceImpl)serviceFactory.getBikeRentService(IBikeRentService.NAME);
			assertEquals(bikerent.getDropOffTime(),bikeRentServiceImpl.updateRent(bikeRentalComposite,bikeRentalComposite).getDropOffTime());
			logger.info("Test Delete Rent PASSED");
		}catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeRentalException bre) {
			bre.printStackTrace();
			fail("BikeRental Exception");
	
		}
	}


}