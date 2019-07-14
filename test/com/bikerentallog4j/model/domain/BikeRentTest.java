package com.bikerentallog4j.model.domain;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bikerentallog4j.model.domain.BikeRent;
import org.apache.log4j.Logger;

 public class BikeRentTest 
 {
	
	 BikeRent bikeRentTest;
         
                                    static Logger logger = Logger.getLogger(BikeRentTest.class);

		
		/**
		 * Test for type Success
		 */

		@Test
		public void testSucess() {
			
			bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "$35", "$100", "10AM","3PM","6/20/2018", "6/20/2018","$45");
		    assertEquals(bikeRentTest .getPrice(),"$45");
		    logger.info("Test is success");
		}
 		
	
		
		/**
		 * Test  for identificationNumber Validate()
		 */

		@Test
		public void bikeIDValidator() {
			
			bikeRentTest= new BikeRent("","CustId1234567", "$35","$100","10AM","3PM","6/20/2018", "6/20/2018","$45");
			assertEquals("Bike ID is Empty", bikeRentTest.validate());
			
		}
		
		/**
		 * Test  for type Validate()
		 */

		
		@Test
		public void customerIDValidator() {
			
			bikeRentTest = new BikeRent("BikeID1234567", "","$35","$100","10AM","3PM","6/20/2018","6/20/2018","$45");
			assertEquals("CustomerID Column is Empty",bikeRentTest.validate());
			
		}


	/**
	 * Test  for size Validate()
	 */

	@Test
	public void rentPerHourValidator() {
		bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "", "$100","10AM","3PM","6/20/2018","6/20/2018","$45");
		assertEquals("RentPerHour Column is Empty",bikeRentTest.validate());
		
	}
		
		/**
		 * Test  for color Validate()
		 */


	@Test
	public void rentPerDayValidator() {
		bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "35","","10AM","3PM","6/20/2018","6/20/2018","$45");
		assertEquals("RentPerDay Column is Empty",bikeRentTest.validate());
		
	}
		
		/**
		 * Test  for brand Validate()
		 */


	@Test
	public void pickUpTimeValidator() {
		bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "35","$100","","3PM","6/20/2018","6/20/2018","$45");
		assertEquals("PickUpTime Column is Empty",bikeRentTest.validate());
		
	}



	@Test
	public void dropOffTimeValidator() {
		bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "35","$100","10AM","","6/20/2018","6/20/2018","$45");
		assertEquals("Drop Off Column is empty",bikeRentTest.validate());
		
	}


	@Test
	public void pickUpDateValidator() {
		bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "35","$100","10AM","3PM","","6/20/2018","$45");
		assertEquals("PickUpDay Column is Empty",bikeRentTest.validate());
		
	}
	
	
	@Test
	public void dropOffDateValidator() {
		bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "35","$100","10AM","3PM","6/20/2018","","$45");
		assertEquals("Drop Off Column is empty",bikeRentTest.validate());
		
	}
	
	
	@Test
	public void priceValidator() {
		bikeRentTest = new BikeRent("BikeID1234567 ","CustId1234567", "35","$100","10AM","3PM","6/20/2018","6/20/2018","");
		assertEquals("Price Column is empty",bikeRentTest.validate());
		
	}
 }


