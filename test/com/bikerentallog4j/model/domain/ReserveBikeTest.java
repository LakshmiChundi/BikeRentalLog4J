package com.bikerentallog4j.model.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bikerentallog4j.model.domain.ReserveBike;
import static com.bikerentallog4j.model.domain.ReserveBike.logger;
import org.apache.log4j.Logger;

public class ReserveBikeTest {

	ReserveBike reserveBikeTest;
                                   static Logger logger = Logger.getLogger(ReserveBikeTest.class);

	
	/**
	 * Test for BikeAvailability Success
	 */

	@Test
	public void testBikeAvailabilitySucess() {
		
		reserveBikeTest = new ReserveBike("BikeId1234567 ", "Mountain Bike", "Large","Blue","Yeti","BikeAvailable","3","Resr12345","$40");
		logger.info("testBikeAvailabilty is success");
	        assertEquals("All Values are Validated",reserveBikeTest.validateReserve());
	    
	}
	

	/**
	 * Test  for BikeAvailability Validate()
	 */
	@Test
	public void testBikeAvailability() {
		
		reserveBikeTest = new ReserveBike("BikeId1234567 ", "Mountain Bike", "Large","Blue","Yeti","","3","Resr12345","$40");
	    assertEquals("Bike Available",reserveBikeTest.validateReserve());
	    		
	   
	}
	
	/**
	 * Test  for NumberOfBikes Validate()
	 */
	@Test
	public void testNumberofBikes() {
		
		reserveBikeTest = new ReserveBike("BikeId1234567 ", "Mountain Bike", "Large","Blue","Yeti","BikeAvailable","","Resr12345","$40");
	    assertEquals("Number Of Bikes Column is Empty",reserveBikeTest.validateReserve());
	    		
	   
	}
	
	/**
	 * Test  for ReservationNumber Validate()
	 */
	@Test
	public void testReservationNumber() {
		
		reserveBikeTest = new ReserveBike("BikeId1234567 ", "Mountain Bike", "Large","Blue","Yeti","bikeAvailable","3","","$40");
	    assertEquals("Bike Not Reserved",reserveBikeTest.validateReserve());
	    		
	   
	}
	
	/**
	 * Test  for BikeFare Validate()
	 */

	@Test
	public void  testBikeFare() {
		
		reserveBikeTest = new ReserveBike("BikeId1234567 ", "Mountain Bike", "Large","Blue","Yeti","BikeAvailable","3","Resr12345","");
	        assertEquals("The Fare Column is Empty",reserveBikeTest.validateReserve());
	    		
	   
	}


}