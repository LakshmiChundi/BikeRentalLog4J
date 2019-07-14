package com.bikerentallog4j.model.domain;



import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bikerentallog4j.model.domain.Address;
import org.apache.log4j.Logger;


public class AddressTest {

	Address customeraddress;
        static Logger logger = Logger.getLogger(AddressTest.class);

	/**
	 * Success Test for Customer House Number
	 */
	@Test
	public void testHouseNumber() {
		
	    customeraddress = new Address("8951","Snowball way","Parker","Colarado","80134");
	    assertEquals (customeraddress.getHouseNumber(),"8951");
	    logger.info("testHousenumber is  Sucess");
	}
	

	
	/**
	 * Test  for Customer House Number  Validate()
	 */
	@Test
	public void HouseNumberValidator() {
		
            customeraddress = new Address("","Snowball way","Parker","Colarado","80134");
            assertEquals("HouseNumber is Empty",customeraddress.validateAddress());
		
	}
	
	
	/**
	 * Test  for Customer Street Address Validate()
	 */
	
	@Test
	public void StreetAddressValidator() {
		
            customeraddress = new Address("8951","","Parker","Colarado","80134");
            assertEquals("StreetAddress is Empty",customeraddress.validateAddress());
		
	}

	
	/**
	 * Test  for Customer City  Validate()
	 */

	@Test
	public void CityNameValidator() {
		
            customeraddress = new Address("8951 ","Snowball way","","Colarado","80134");
            assertEquals("City Name is Empty",customeraddress.validateAddress());
		
	}

	/**
	 * Test  for Customer State Validate()
	 */
	
	@Test
	public void StateValidator() {
		
            customeraddress = new Address("8951 ","Snowball way","Parker","","80134");
            assertEquals("State Name is Empty",customeraddress.validateAddress());
		
	}
	
	/**
	 * Test  for Customer Zip code Validate()
	 */

	@Test
	public void ZipCodeValidator() {
		
            customeraddress = new Address("8951 ","Snowball way","Parker","Colarado","");
            assertEquals("zipCode is Empty",customeraddress.validateAddress());
		
	}


}
