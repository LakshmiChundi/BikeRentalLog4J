package com.bikerentallog4j.model.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.bikerentallog4j.model.domain.Customer;
import org.apache.log4j.Logger;

public class CustomerTest  {
	
	Customer customer;
        static Logger logger = Logger.getLogger(CustomerTest.class);

	/**
	 * Success Test for Customer firstName
	 */
	@Test
	public void testCustomerSucess() {
		
                customer = new Customer("8951","Snowball way","Parker","Colarado","80134" ,"Lakshmi","Chundi","CustId1234567",
                                        "Lakshmi@xyz.com","1234567","37");
                assertEquals(customer.getFirstName(),"Lakshmi");
                logger.info("TestCustomerSuccess is Success");
	}
	
	
	/**
	 * Test  for Customer firstName Validate()
	 */
	
	@Test
	public void firstNameValidator() {
		
		customer = new Customer( "8951","Snowball way","Parker","Colarado","80134","","Chundi",
                                         "CustId1234567","Lakshmi@xyz.com","1234567","37");
		assertEquals("Fisrt Name is Empty",customer.validate());
		
	}
	
	/**
	 * Test for Customer lastName Validate()
	 */
	@Test
	public void lastNameValidator() {
		
		customer = new Customer("8951","Snowball way","Parker","Colarado","80134",
                                        "Lakshmi","","CustId1234567","Lakshmi@xyz.com","1234567","37");
		assertEquals("Last Name is Empty",customer.validate());
		
	}

	/**
	 * Test  for customerId Validate()
	 */

	@Test
	public void customerIDValidator() {
		
		customer = new Customer("8951","Snowball way","Parker","Colarado","80134",
                                        "Lakshmi","Chundi","","Lakshmi@xyz.com","1234567","37");
		assertEquals("Customer Id is Empty",customer.validate());
		
	}

	/**
	 * Test  for Customer emailID Validate()
	 */
	@Test
	public void emailIDValidator() {
		
		customer = new Customer("8951","Snowball way","Parker","Colarado","80134",
                                        "Lakshmi","Chundi","CustId1234567","","1234567","37");
		assertEquals("emailID is Empty",customer.validate());
		
	}

	/**
	 * Test  for Customer mobileNumber Validate()
	 */
	@Test
	public void mobileNumberValidator() {
		
		customer = new Customer("8951","Snowball way","Parker","Colarado","80134",
                                        "Lakshmi","Chundi","CustId1234567","Lakshmi@xyz.com","","37");
		assertEquals("Mobile Number is Empty",customer.validate());
		
	}
	/**
	 * Test  for Customer mobileNumber Validate()
	 */
	@Test
	public void ageValidator() {
		customer = new Customer("8951","Snowball way","Parker","Colarado","80134",
                                         "Lakshmi","Chundi","CustId1234567","Lakshmi@xyz.com","1234567","");
		assertEquals("Age column is empty",customer.validate());
		
	}

}
