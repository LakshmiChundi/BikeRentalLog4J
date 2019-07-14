package com.bikerentallog4j.model.services.exception;


/**     @author Lakshmi Chundi**/
public class ReserveBikeException  extends Exception {

	private static final long serialVersionUID = 6009821813727278428L;


	public ReserveBikeException(final String inMessage) {
	    super(inMessage);
	}
	
	
	public ReserveBikeException(final String inMessage, final Throwable inNestedException) {
	    super(inMessage, inNestedException);
	}
}

