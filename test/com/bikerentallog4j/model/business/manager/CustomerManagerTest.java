
/**
 * @author Lakshmi Chundi
 *
 */
package com.bikerentallog4j.model.business.manager;
import com.bikerentallog4j.model.business.manager.CustomerManager;
import org.junit.Test;
import junit.framework.TestCase;
import com.bikerentallog4j.model.domain.Customer;
import com.bikerentallog4j.model.services.manager.PropertyManager;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.customerservice.ICustomerService;
import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import org.apache.log4j.Logger;
/* Test Case for Customer Manager*/

public class CustomerManagerTest extends TestCase {

	private CustomerManager customerManager;
	private BikeRentalComposite bikerentalComposite;
	private Customer customer;
        static Logger logger = Logger.getLogger(CustomerManagerTest.class);

	
	
	protected void setUp() throws Exception {
		super.setUp();
		
		String propertyFileLocation = System.getProperty("prop_location");

		PropertyManager.loadProperties(propertyFileLocation);
		customerManager = CustomerManager.getInstance();
		
		customer = new Customer ("8951","Snowball way","Parker","Colarado","80134" ,"Lakshmi","Chundi","CustId1234567","Lakshmi@xyz.com","1234567","37");
		bikerentalComposite = new BikeRentalComposite();
		bikerentalComposite.setCustomer(customer);
                BikeRentalLog4J.initializeLog4J();
	}

	/**
	 * Test performAction method for RegisterCustomer
	 */
	@Test 
	public  void testPerformActionOnCustomer()
	{
		Customer action = customerManager.performActionCustomer(ICustomerService.NAME, bikerentalComposite);
		assertEquals(action.getAge(), bikerentalComposite.getCustomer().getAge());
		logger.info("Test Perform Action On Customer Passed");
	}

	@Test
	public  void testCustomerDetails() {
			Customer customer = CustomerManager.getCustomer(ICustomerService.NAME, bikerentalComposite);			
			assertEquals(customer.getAge(), bikerentalComposite.getCustomer().getAge());
			logger.info("Test Customer Details Passed");
	}

}
