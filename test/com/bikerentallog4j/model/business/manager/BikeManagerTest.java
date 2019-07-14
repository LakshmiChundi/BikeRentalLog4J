/**
 * 
 */
/**
 * @author Lakshmi
 *
 */
package com.bikerentallog4j.model.business.manager;


import org.junit.Test;
import junit.framework.TestCase;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import com.bikerentallog4j.model.domain.Bike;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.bikeservice.IBikeService;
import org.apache.log4j.Logger;



/**
 * 
 * @author 
 * 
 *
 */

public class BikeManagerTest extends TestCase {

	private BikeManager bikeManager;
	private BikeRentalComposite bikerentalComposite;
	private Bike bike;
	static Logger logger = Logger.getLogger(BikeManagerTest.class);

	
protected void setUp() throws Exception {
		super.setUp();
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);
		bikeManager = BikeManager.getInstance();
		bikerentalComposite = new BikeRentalComposite();
		bike = new Bike("ID1234567","Mountain Bike", "Large", "Blue", "Yeti");
		bikerentalComposite.setBike(bike);
	}

	
	/**
	 * Test performAction method for RegisterCustomer
	 */
	
	@Test 
	public final void testPerformActionOnBike()
	{
		Bike action = bikeManager.performActionOnBike(IBikeService.NAME, bikerentalComposite);
		assertEquals(action.getbrand(),bikerentalComposite.getBike().getbrand());
		logger.info("Test Perform Action On Customer Passed");
	}
	
	/**
	 * Test register customer
	 *
	 */
	@Test
	public final void testBikeDetails() {
			Bike bike = BikeManager.getBike(IBikeService.NAME, bikerentalComposite);			
			assertEquals(bike.getbrand(), bikerentalComposite.getBike().getbrand());
			logger.info("Test Bike Details Passed");
	}
}

		





