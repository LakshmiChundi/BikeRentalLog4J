package com.bikerentallog4j.model.services.bikerentservice;

/**
* @author Lakshmi Chundi
* 
* 
*
*/

import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.BikeRent;
import com.bikerentallog4j.model.services.IService;
import com.bikerentallog4j.model.services.exception.BikeRentalException;

public interface IBikeRentService extends IService {
	
	public final String NAME = "IBikeRentService";
	
	public BikeRent addRent(BikeRentalComposite bikeRentalComposite) throws BikeRentalException;
    public BikeRent getRent(BikeRentalComposite bikeRentalComposite) throws BikeRentalException;
    public BikeRent updateRent(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws BikeRentalException;
    public String deleteRent(BikeRentalComposite bikeRentalComposite) throws BikeRentalException;
	
}


