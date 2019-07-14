package com.bikerentallog4j.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bikerentallog4j.model.services.bikerentservices.BikeRentServiceImplTest;
import com.bikerentallog4j.model.services.bikeservice.BikeServiceImplTest;
import com.bikerentallog4j.model.services.bikeworkshop.BikeWorkShopServiceImplTest;
import com.bikerentallog4j.model.services.customerservice.CustomerServiceImplTest;
import com.bikerentallog4j.model.services.factory.ServiceFactoryTest;
import com.bikerentallog4j.model.services.reservebikeservice.ReserveBikeServiceImplTest;

/**
 * 
 * @author Lakshmi Chundi
 * 
* This AllServicesTests Class will run all 
// *
// */
@RunWith(Suite.class)
@SuiteClasses({ ServiceFactoryTest.class, BikeServiceImplTest.class, 
	CustomerServiceImplTest.class, ReserveBikeServiceImplTest.class,
	BikeRentServiceImplTest.class,BikeWorkShopServiceImplTest.class})
 	
public class AllServicesTests {

}
