package com.bikerentallog4j.model.business.manager;
    
import com.bikerentallog4j.model.business.manager.BikeRentManager;
    import org.junit.Test;
	import junit.framework.TestCase;
	import com.bikerentallog4j.model.services.manager.PropertyManager;
    import com.bikerentallog4j.model.domain.BikeRent;
    import com.bikerentallog4j.model.domain.BikeRentalComposite;
    import com.bikerentallog4j.model.services.bikerentservice.IBikeRentService;
import org.apache.log4j.Logger;

	/* Test Case for Customer Manager*/

	public class BikeRentManagerTest extends TestCase {

		private BikeRentManager bikerentManager;
		private BikeRentalComposite bikerentalComposite;
		private BikeRent bikerent;
		static Logger logger = Logger.getLogger(BikeRentManagerTest.class);

		
		protected void setUp() throws Exception {
			super.setUp();
			
			String propertyFileLocation = System.getProperty("prop_location");

			PropertyManager.loadProperties(propertyFileLocation);
			bikerentManager = BikeRentManager.getInstance();
			
			bikerent= new BikeRent ("BikeID1234567 ","CustId1234567", "$35", "$100", "10AM","3PM","6/20/2018", "6/20/2018","$45");
			bikerentalComposite = new BikeRentalComposite();
			bikerentalComposite.setBikeRent(bikerent);
		}

		/**
		 * Test performAction method for RegisterCustomer
		 */
		@Test 
		public void testPerformActionOnBikeRent()
		{
			BikeRent action = bikerentManager.performActionOnBikeRent(IBikeRentService.NAME, bikerentalComposite);
			assertEquals(action.getPrice(), bikerentalComposite.getBikeRent().getPrice());
			logger.info("Test Perform Action On Customer Passed");
		}

		@Test
		public final void testBikeRentDetails() {
			BikeRent bikerent = BikeRentManager.getBikeRent(IBikeRentService.NAME, bikerentalComposite);			
				assertEquals(bikerent.getPrice(), bikerentalComposite.getBikeRent().getPrice());
				logger.info("Test Customer Details Passed");
		}

	}


