package com.bikerentallog4j.model.services.customerservice;

/**     @author Lakshmi Chundi**/

import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.Customer;
import com.bikerentallog4j.model.services.IService;
import com.bikerentallog4j.model.services.exception.CustomerException;

public interface ICustomerService extends IService {
	
	public final String NAME = "ICustomerService";
	
	public Customer addCustomer(BikeRentalComposite bikeRentalComposite) throws CustomerException;
    public Customer getCustomer(BikeRentalComposite bikeRentalComposite) throws CustomerException;
    public String updateCustomer(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws CustomerException;
    public String deleteCustomer(BikeRentalComposite bikeRentalComposite) throws CustomerException;
	
}

