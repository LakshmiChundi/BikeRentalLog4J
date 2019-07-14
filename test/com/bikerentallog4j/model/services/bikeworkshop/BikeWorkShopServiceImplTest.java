package com.bikerentallog4j.model.services.bikeworkshop;





import org.junit.Test;
import junit.framework.TestCase;

import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.BikeWorkShop;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.bikeworkshopservice.BikeWorkShopServiceImpl;
import com.bikerentallog4j.model.services.bikeworkshopservice.IBikeWorkShopService;
import com.bikerentallog4j.model.services.exception.BikeWorkShopException;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author Lakshmi Chundi
 * 
 * BikeServiceImplTest will run all test cases of BikeServiceImpl
 *
 */

public class BikeWorkShopServiceImplTest extends TestCase {

	 private ServiceFactory serviceFactory;
	 private BikeWorkShop bikeworkshop;
	 private BikeRentalComposite bikeRentalComposite = new BikeRentalComposite();
                                             static Logger logger = Logger.getLogger(BikeWorkShopServiceImplTest.class);

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
       serviceFactory = new ServiceFactory();

       bikeworkshop = new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019", "1/9/2019", 
       								    "Passed","Good","CustomerReport","BikeDamageReport");
		
		bikeRentalComposite.setBikeworkshop(bikeworkshop);
		
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);

	}
	@Test
	public void testGetReport() {
		try {
			BikeWorkShopServiceImpl bikeworkshopServiceImpl = (BikeWorkShopServiceImpl)serviceFactory.getBikeWorkShopService(IBikeWorkShopService.NAME);
			assertEquals(bikeworkshop.getBikeID(),bikeworkshopServiceImpl.getReport(bikeRentalComposite).getBikeID());
			System.out.println("Test Get Reports PASSED");
		
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeWorkShopException e) {
			e.printStackTrace();
			fail("Bike Service Exception");
		}	
	
	}

	@Test
	public void testAddReport() {
		try {
			BikeWorkShopServiceImpl bikeworkshopServiceImpl = (BikeWorkShopServiceImpl)serviceFactory.getBikeWorkShopService(IBikeWorkShopService.NAME);
			assertEquals(bikeworkshop.getBikeID(),bikeworkshopServiceImpl.addReport(bikeRentalComposite).getBikeID());
	logger.info("Test Add Reports PASSED");
		
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeWorkShopException e) {
			e.printStackTrace();
			fail("Bike Service Exception");
		}	
	
	}
	@Test
	public void testUpdateReport() {
		try {
			BikeWorkShopServiceImpl bikeworkshopServiceImpl = (BikeWorkShopServiceImpl)serviceFactory.getBikeWorkShopService(IBikeWorkShopService.NAME);
			assertEquals(bikeworkshop.getBikeID(),bikeworkshopServiceImpl.updateReport(bikeRentalComposite,bikeRentalComposite));
			logger.info("Test Update Reports PASSED");
		
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (BikeWorkShopException e) {
			e.printStackTrace();
			fail("Bike Service Exception");
		}	
	}	
		@Test
		public void testDelete() {
			try {
				BikeWorkShopServiceImpl bikeworkshopServiceImpl = (BikeWorkShopServiceImpl)serviceFactory.getBikeWorkShopService(IBikeWorkShopService.NAME);
					assertEquals(bikeworkshop.getBikeID(),bikeworkshopServiceImpl.updateReport(bikeRentalComposite,bikeRentalComposite));
					logger.info("Test Bike Reports deleted PASSED");
				
			}catch (ServiceLoadException e) {
				e.printStackTrace();
				fail("ServiceLoadException");
			} catch (BikeWorkShopException e) {
				e.printStackTrace();
				fail("CustomerService Exception");
		
			}
		}
	}
	


