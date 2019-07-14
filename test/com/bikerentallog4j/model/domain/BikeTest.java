package com.bikerentallog4j.model.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.bikerentallog4j.model.domain.Bike;
import org.apache.log4j.Logger;

public class BikeTest {
	
		Bike bikeTest;
                
                                           static Logger logger = Logger.getLogger(BikeTest.class);

		
		/**
		 * Test for type Success
		 */

		@Test
		public void testtypeSucess() {
			
			bikeTest = new Bike("identificationNumber1234567 ", "Mountain Bike", "Large", "Blue", "Yeti");
		    assertEquals(bikeTest.gettype(),"Mountain Bike");
		    logger.info("testtype is success");
		}
		
	
		/**
		 * Test  for identificationNumber Validate()
		 */

		@Test
		public void identificationNumberValidator() {
			
			bikeTest = new Bike("", "Mountain Bike", "Large", "Blue", "Yeti");
			assertEquals("ID Is Empty", bikeTest.validateBike());
			
		}
		
		/**
		 * Test  for type Validate()
		 */

		
		@Test
		public void typeValidator() {
			
			bikeTest = new Bike("identificationNumber1234567", "", "Large", "Blue", "Yeti");
			assertEquals("type Field Is Empty",bikeTest.validateBike());
			
		}


		/**
		 * Test  for size Validate()
		 */

		@Test
		public void sizeValidator() {
			
			bikeTest = new Bike("identificationNumber1234567 ", "Mountain Bike", "", "Blue", "Yeti");
			assertEquals("Size Of the Bike Field is Empty",bikeTest.validateBike());
			
		}
		
		/**
		 * Test  for color Validate()
		 */


		@Test
		public void colorValidator() {
			
			bikeTest = new Bike("identificationNumber1234567 ", "Mountain Bike", "Large", "", "Yeti");
			assertEquals("color Field Is Empty",bikeTest.validateBike());
			
		}
		
		/**
		 * Test  for brand Validate()
		 */


		@Test
		public void brandValidator() {
			
			bikeTest = new Bike("identificationNumber1234567 ", "Mountain Bike", "Large", "Blue", "");
			assertEquals("brand Field Is Empty",bikeTest.validateBike());
			
		}
	}
