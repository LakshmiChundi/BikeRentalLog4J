package com.bikerentallog4j.model.services.exception;

/**     @author Lakshmi Chundi**/

public class BikeWorkShopException extends Exception{


	private static final long serialVersionUID = 6009821813727278428L;


	public BikeWorkShopException(final String inMessage) 
	{
	    super(inMessage);
	}
	
	
	public BikeWorkShopException(final String inMessage, final Throwable inNestedException) {
	    super(inMessage, inNestedException);
	}
}


	

