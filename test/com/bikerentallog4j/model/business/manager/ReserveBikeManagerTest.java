/**
 * 
 */
/**
                  * @author supputuri
 *
 */
package com.bikerentallog4j.model.business.manager;


import com.bikerentallog4j.model.business.manager.ReserveBikeManager;
import org.junit.Test;

import junit.framework.TestCase;
import com.bikerentallog4j.model.domain.ReserveBike;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import com.bikerentallog4j.model.services.reservebikeservice.IReserveBikeService;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import org.apache.log4j.Logger;

/**
 * 
 * 
 *
 * 
 *
 */
public class ReserveBikeManagerTest extends TestCase {

	private ReserveBikeManager reserveBikeManager;
	private BikeRentalComposite bikerentalComposite;
	private ReserveBike reserveBike;
	                   static Logger logger = Logger.getLogger(ReserveBikeManagerTest.class);

	
	protected void setUp() throws Exception {
		super.setUp();
		
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);
		reserveBikeManager = ReserveBikeManager.getInstance();
		 
		
		bikerentalComposite = new BikeRentalComposite();
		reserveBike = new ReserveBike("BikeId1234567 ", "Mountain Bike", "Large","Blue","Yeti","BikeAvailable","3","Resr12345","$40");
		bikerentalComposite.setReserveBike(reserveBike);
	}

	
	/**
	 * Test performAction method for RegisterCustomer
	 */
	@Test 
	public final void testPerformActionOnReserveBike()
	{
		ReserveBike action = reserveBikeManager.performActionOnReserveBike(IReserveBikeService.NAME, bikerentalComposite);
		assertEquals(action.getReservationNumber(), bikerentalComposite.getReserveBike().getReservationNumber());
		logger.info("Test Perform Action On ReserveBike Passed");
	}
	
	/**
	 * Test register customer
	 *
	 */
	@Test
	public final void testReserveBikeDetails() {
			ReserveBike reserveBike = ReserveBikeManager.getBikeAvailability(IReserveBikeService.NAME, bikerentalComposite);			
			assertEquals(reserveBike.getbrand(), bikerentalComposite.getReserveBike().getbrand());
			logger.info("Test On ReserveBike Passed");
	}
}
