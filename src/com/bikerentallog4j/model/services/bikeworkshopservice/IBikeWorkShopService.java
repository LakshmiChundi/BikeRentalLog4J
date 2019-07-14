package com.bikerentallog4j.model.services.bikeworkshopservice;


/**     @author Lakshmi Chundi**/

import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.BikeWorkShop;
import com.bikerentallog4j.model.services.IService;
import com.bikerentallog4j.model.services.exception.BikeWorkShopException;


	public interface IBikeWorkShopService extends IService {
		
		public final String NAME = "IBikeWorkShopService";
		
		public BikeWorkShop getReport(BikeRentalComposite bikeRentalComposite) throws BikeWorkShopException;
	    public  BikeWorkShop addReport(BikeRentalComposite bikeRentalComposite) throws BikeWorkShopException;
	    public String updateReport(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws BikeWorkShopException;
	    public String delete(BikeRentalComposite bikeRentalComposite) throws  BikeWorkShopException;
		
	}


