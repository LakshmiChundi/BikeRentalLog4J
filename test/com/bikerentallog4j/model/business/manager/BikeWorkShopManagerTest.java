package com.bikerentallog4j.model.business.manager;


import com.bikerentallog4j.model.business.manager.BikeWorkShopManager;
	 import org.junit.Test;
		import junit.framework.TestCase;
		import com.bikerentallog4j.model.services.manager.PropertyManager;
	    import com.bikerentallog4j.model.domain.BikeRentalComposite;
        import com.bikerentallog4j.model.domain.BikeWorkShop;
        import com.bikerentallog4j.model.services.bikeworkshopservice.IBikeWorkShopService;
import org.apache.log4j.Logger;

		/* Test Case for Customer Manager*/

	    public class BikeWorkShopManagerTest extends TestCase {	
			
	    	private BikeWorkShopManager bikeworkshopManager;
			private BikeRentalComposite bikerentalComposite;
			private BikeWorkShop bikeworkshop;
                                           static Logger logger = Logger.getLogger(BikeWorkShopManagerTest.class);

			
			
			protected void setUp() throws Exception {
				super.setUp();
				
				String propertyFileLocation = System.getProperty("prop_location");

				PropertyManager.loadProperties(propertyFileLocation);
				bikeworkshopManager = BikeWorkShopManager.getInstance();
				
				bikeworkshop= new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019","1/9/2019",
									   "Passed","Good","CustomerReport","BikeDamageReport");
				bikerentalComposite = new BikeRentalComposite();
				bikerentalComposite.setBikeworkshop(bikeworkshop);
			}

			/**
			 * Test performAction method for RegisterCustomer
			 */
			@Test 
			public void testPerformActionOnBikeRent()
			{
				BikeWorkShop action = bikeworkshopManager.performActionOnBikeWorkShop(IBikeWorkShopService.NAME,bikerentalComposite);
				assertEquals(action.getBikeID(), bikerentalComposite.getBikeworkshop().getBikeID());
				logger.info("Test Perform Action On Customer Passed");
			}

			@Test
			public final void testBikeRentDetails() {
				BikeWorkShop bikeworkshop = BikeWorkShopManager.getBikeWorkShop(IBikeWorkShopService.NAME,bikerentalComposite);			
					assertEquals(bikeworkshop.getBikeID(), bikerentalComposite.getBikeworkshop().getBikeID());
					logger.info("Test Customer Details Passed");
			}

		}


