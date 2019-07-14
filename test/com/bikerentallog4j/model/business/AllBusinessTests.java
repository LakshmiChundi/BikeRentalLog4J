package com.bikerentallog4j.model.business;
/**@author Lakshmi Chundi **/
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bikerentallog4j.model.business.manager.BikeManagerTest;
import com.bikerentallog4j.model.business.manager.BikeRentManagerTest;
import com.bikerentallog4j.model.business.manager.BikeWorkShopManagerTest;
import com.bikerentallog4j.model.business.manager.CustomerManagerTest;
import com.bikerentallog4j.model.business.manager.ReserveBikeManagerTest;
//import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import junit.framework.TestCase;



@RunWith(Suite.class)
@SuiteClasses({CustomerManagerTest.class, BikeManagerTest.class, ReserveBikeManagerTest.class,
	          BikeWorkShopManagerTest.class,BikeRentManagerTest.class})
public class AllBusinessTests {
    

}
