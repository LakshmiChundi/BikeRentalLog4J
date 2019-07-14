package com.bikerentallog4j.model.services.bikeservice;

/**@author Lakshmi Chundi     */
import com.bikerentallog4j.model.domain.Bike;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.IService;
import com.bikerentallog4j.model.services.exception.BikeException;

public interface IBikeService extends IService {
	
	
	public final String NAME = "IBikeService";
    public Bike add(BikeRentalComposite bikeRentalComposite) throws BikeException;
    public Bike get(BikeRentalComposite bikeRentalComposite) throws BikeException;
    public Bike update(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws BikeException;
    public String delete(BikeRentalComposite bikeRentalComposite) throws BikeException;
	
    
}



	
	