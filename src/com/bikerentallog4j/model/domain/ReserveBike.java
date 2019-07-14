package com.bikerentallog4j.model.domain;

import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;


/**  @author Lakshmi.Chundi  **/

public class ReserveBike extends Bike {
	
	private static final long serialVersionUID = 4298098611155913926L;

	/** Bike Availability */
	private String bikeAvailability;
	
	/** Number of Bikes */
	private String numberofBikes;
	
	/** Bike Reservation number */
	private String reservationNumber;
    
        private boolean available;
        
	/** Bike Fare */
	private String fare;
        
        
         
        static Logger logger = Logger.getLogger(ReserveBike.class);

	/** Constructor **/
    public ReserveBike(String identificationNumber, String type, String size, String color, String brand,
    		String bikeAvailability, String numberofBikes, String reservationNumber, String fare) {
		
    	super(identificationNumber, type, size, color, brand);
    	this.bikeAvailability =bikeAvailability;
    	this.numberofBikes =numberofBikes;
    	this.reservationNumber=reservationNumber;
    	this.fare=fare;
	
	}
    
    
    /**
	 * @return the Bike Availability
	 */
	public String getBikeAvailability() {
		return bikeAvailability;
	}
	
	
	/**
	 * Sets Bike Availability
	 */
	public void setBikeAvailability(String bikeAvailability) {
		this.bikeAvailability = bikeAvailability;
	}

        public boolean available() {
		return available;
	}
	/**
	 * @param available The available to set.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
        
        
        
        
	/**
	 * @return Number Of Bikes
	 */
	public String getNumberofBikes() {
		return numberofBikes;
	}


	/**
	 * Sets Number of Bikes
	 */
	public void setNumberofBikes(String numberofBikes) {
		this.numberofBikes = numberofBikes;
	}

	/**
	 * @return the Bike Reservation Number
	 */

	public String getReservationNumber() {
		return reservationNumber;
	}


	/**
	 * Sets Bike Reservation Number
	 */
	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}


	/**
	 * @return the Bike Fare
	 */
	public String getFare() {
		return fare;
	}


	/**
	 * Sets Bike Fare
	 */
	public void setFare(String fare) {
		this.fare = fare;
	}


	/**
	 * Overriding hashCode() for ReserveBike Class
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bikeAvailability == null) ? 0 : bikeAvailability.hashCode());
		result = prime * result + ((fare == null) ? 0 : fare.hashCode());
		result = prime * result + ((numberofBikes == null) ? 0 : numberofBikes.hashCode());
		result = prime * result + ((reservationNumber == null) ? 0 : reservationNumber.hashCode());
		return result;
	}


	/**
	 * Overriding equals() for ReserveBike Class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReserveBike other = (ReserveBike) obj;
		if (bikeAvailability == null) {
			if (other.bikeAvailability != null)
				return false;
		} else if (!bikeAvailability.equals(other.bikeAvailability))
			return false;
		if (fare == null) {
			if (other.fare != null)
				return false;
		} else if (!fare.equals(other.fare))
			return false;
		if (numberofBikes == null) {
			if (other.numberofBikes != null)
				return false;
		} else if (!numberofBikes.equals(other.numberofBikes))
			return false;
		if (reservationNumber == null) {
			if (other.reservationNumber != null)
				return false;
		} else if (!reservationNumber.equals(other.reservationNumber))
			return false;
		return true;
	}


	/**
	 * Overriding toString() for ReserveBike Class
	 */
	@Override
	public String toString() {
		return "ReserveBike [bikeAvailability=" + bikeAvailability + ", numberofBikes=" + numberofBikes
				+ ", reservationNumber=" + reservationNumber + ", fare=" + fare + "]";
	}

	
	
	/** validate all the Reserve Bike Input fields, if any field is empty returns the message **/
	
        public String validateReserve() {
		
                BikeRentalLog4J.initializeLog4J();
               
                
                ArrayList<ReserveBike> availablelist = new ArrayList<ReserveBike>();
                  
                if(availablelist.containsAll(availablelist));
                {
             
                    Iterator iterator= availablelist.iterator();

                   while (iterator.hasNext())
                {
                    logger.info(availablelist.iterator());
                   
                }
                
                if(this.bikeAvailability=="") 
		{
			logger.info("Bike Available");
			return "Bike Available";
		}
		
			
		if(this.numberofBikes=="")
			
		{
			logger.info("Number Of Bikes Column is Empty");
			return "Number Of Bikes Column is Empty";
		}
			
		if(this.reservationNumber =="")	
		{
			logger.info("Bike Not Reserved");
			return "Bike Not Reserved";
		}
		
		if(this.fare=="")		
		{
			logger.info("The Fare Column is Empty");
			return "The Fare Column is Empty";
		}	
		         
                }
               
                return "All Values are Validated";
        }
}

                   
               
        
        
        
