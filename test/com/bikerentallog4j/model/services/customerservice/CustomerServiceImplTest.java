package com.bikerentallog4j.model.services.customerservice;

import com.bikerentallog4j.model.services.customerservice.CustomerServiceImpl;
import com.bikerentallog4j.model.services.customerservice.ICustomerService;
import org.junit.Test;
import junit.framework.TestCase;
import com.bikerentallog4j.model.services.exception.CustomerException;
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.Customer;
import com.bikerentallog4j.model.services.bikerentservices.BikeRentServiceImplTest;
import com.bikerentallog4j.model.services.factory.ServiceFactory;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import org.apache.log4j.Logger;


/**
 * 
 * @author Lakshmi Chundi
 * 
 * CustomerServiceImplTest will run all test cases of CustomerServiceImpl
 *
 */
public class CustomerServiceImplTest extends TestCase {

	 private ServiceFactory serviceFactory;
	 private Customer customer;
	 private BikeRentalComposite bikeRentalComposite = new BikeRentalComposite();
         static Logger logger = Logger.getLogger(CustomerServiceImplTest.class);

	
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
		serviceFactory = new ServiceFactory();
		customer = new Customer("8951","Snowball way","Parker","Colarado","80134" ,"Lakshmi","Chundi","CustId1234567","Lakshmi@xyz.com","1234567","37");
		bikeRentalComposite.setCustomer(customer);
		
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);
	}
	

	@Test
	public void testAddCustomer() {
		
		try {	
			CustomerServiceImpl customerServiceImpl = (CustomerServiceImpl)serviceFactory.getCustomerService(ICustomerService.NAME);
			assertEquals(customer.getCustomerId(),customerServiceImpl.addCustomer(bikeRentalComposite).getCustomerId());
			logger.info("Test Add Customer PASSED");
			
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail("Customer Service Exception");
		}	
	}
	
	@Test
	public void testGetCustomer() {
		
		try {	
			CustomerServiceImpl customerServiceImpl = (CustomerServiceImpl)serviceFactory.getCustomerService(ICustomerService.NAME);
			assertEquals(customer.getAge(),customerServiceImpl.getCustomer(bikeRentalComposite).getAge());
			logger.info("Test Get Customer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail("Customer Service Exception");
		}
	
	}
			
	@Test
	public void testUpdateCustomer() {
		try {
			CustomerServiceImpl customerServiceImpl = (CustomerServiceImpl)serviceFactory.getCustomerService(ICustomerService.NAME);
			assertEquals(customer.getFirstName(),customerServiceImpl.updateCustomer(bikeRentalComposite,bikeRentalComposite));
			logger.info("Test Update Customer PASSED");
		}catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail("CustomerService Exception");

		}
	}
	
	@Test
	public void testDeleteCustomer() {
		try {
			CustomerServiceImpl customerServiceImpl = (CustomerServiceImpl)serviceFactory.getCustomerService(ICustomerService.NAME);
			assertEquals("Customer Deleted",customerServiceImpl.deleteCustomer(bikeRentalComposite));
			logger.info("Test Delete Customer PASSED");
		}catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail("CustomerService Exception");
	
		}
	}


}