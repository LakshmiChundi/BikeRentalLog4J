package com.bikerentallog4j.model.services.reservebikeservice;

import org.junit.Test;

import junit.framework.TestCase;

import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.ReserveBike;
import com.bikerentallog4j.model.services.bikerentservices.BikeRentServiceImplTest;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import com.bikerentallog4j.model.services.reservebikeservice.IReserveBikeService;
import com.bikerentallog4j.model.services.reservebikeservice.ReserveBikeServiceImpl;
import com.bikerentallog4j.model.services.exception.ReserveBikeException;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import org.apache.log4j.Logger;

/**
 * 
 * @author Lakshmi Chundi
 * 
 * ReserveBikeServiceImplTest will run all test cases of ReserveBikeServiceImpl
 *
 */
public class ReserveBikeServiceImplTest extends TestCase {

	 private ServiceFactory serviceFactory;
	 private ReserveBike reserveBike;
	 private BikeRentalComposite bikeRentalComposite = new BikeRentalComposite();
                                             static Logger logger = Logger.getLogger(ReserveBikeServiceImplTest.class);

	
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
		serviceFactory = new ServiceFactory();
		reserveBike = new ReserveBike("BikeId1234567 ", "Mountain Bike", "Large","Blue","Yeti","BikeAvailable","3","Resr12345","$40");
		bikeRentalComposite.setReserveBike(reserveBike);
		String propertyFileLocation = System.getProperty("prop_location");
		PropertyManager.loadProperties(propertyFileLocation);

	}
	
	@Test
	public void testBookingBike() {
		
		try {
			IReserveBikeService reserveBikeServiceImpl = (ReserveBikeServiceImpl)serviceFactory.getReserveBikeService(IReserveBikeService.NAME);
			assertEquals(reserveBike.getBikeAvailability(),reserveBikeServiceImpl.booking(bikeRentalComposite).getBikeAvailability());
			logger.info("Test Booking Reservation PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (ReserveBikeException rbe) {
			rbe.printStackTrace();
			fail("ReserveBike Exception");
		}
		
	}
	
	@Test
	public void testModifyBooking() {
		
		try {
			IReserveBikeService reserveBikeServiceImpl = (ReserveBikeServiceImpl)serviceFactory.getReserveBikeService(IReserveBikeService.NAME);
			assertEquals(reserveBike.getNumberofBikes(),reserveBikeServiceImpl.modify(bikeRentalComposite).getNumberofBikes());
			logger.info("Test Modify Booking Reservation PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (ReserveBikeException rbe) {
			rbe.printStackTrace();
			fail("ReserveBike Exception");
		}
		
	}
	
	@Test
	public final void   testCancelBooking() {
		try {
			IReserveBikeService reserveBikeServiceImpl = (ReserveBikeServiceImpl)serviceFactory.getReserveBikeService(IReserveBikeService.NAME);
			assertEquals(reserveBike.getReservationNumber(),reserveBikeServiceImpl.cancel(bikeRentalComposite,bikeRentalComposite).getReservationNumber());
			logger.info("Test Cancel Booking Reservation PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (ReserveBikeException rbe) {
			rbe.printStackTrace();
			fail("ReserveBike Exception");
		}
					
	}
}
		
		
		