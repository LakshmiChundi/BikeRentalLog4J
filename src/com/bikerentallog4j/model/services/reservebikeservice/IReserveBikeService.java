package com.bikerentallog4j.model.services.reservebikeservice;

/**
 * @author Lakshmi Chundi*/

import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.ReserveBike;
import com.bikerentallog4j.model.services.IService;
import com.bikerentallog4j.model.services.exception.ReserveBikeException;

public interface IReserveBikeService extends IService{
	
	public final String NAME = "IReserveBikeService";
	public ReserveBike booking(BikeRentalComposite bikeRentalComposite) throws ReserveBikeException;
    public ReserveBike modify(BikeRentalComposite bikeRentalComposite) throws ReserveBikeException;
    public ReserveBike cancel(BikeRentalComposite bikeRentalComposite1 , BikeRentalComposite bikeRentalComposite2) throws ReserveBikeException;

}