package com.bikerentallog4j.model.services.exception;
/**     @author Lakshmi Chundi**/

public class BikeException  extends Exception {

	private static final long serialVersionUID = 6009821813727278428L;


	public BikeException(final String inMessage) 
	{
	    super(inMessage);
	}
	
	
	public BikeException(final String inMessage, final Throwable inNestedException) {
	    super(inMessage, inNestedException);
	}
}




