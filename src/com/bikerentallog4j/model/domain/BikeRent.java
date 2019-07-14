package com.bikerentallog4j.model.domain;



/** @author Lakshmi Chundi**/

import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class BikeRent implements Serializable {

	private static final long serialVersionUID = -7795326848260200076L;
  
	/**Bike ID to book  **/
        private String bikeID;
	
	/**Customer ID   **/
   private String customerID;
   
   /**Rent of the bike per hour to book  **/
   private  String  rentPerHour;
   
   /**Rent of the bike per day to book  **/
   private String rentPerDay;
  
   /**pick time of the bike **/
   private String  pickUpTime;
   
   /** drop off time of the bike **/
   private String  dropOffTime;
  
   /**pick up day of the bike **/
   private String  pickUpDay;
   
   /**drop off day of the bike **/
   private String  dropOffDay;
   
   /**Price for renting the bike**/
   private String price;

   static Logger logger = Logger.getLogger(BikeRent.class);

   
   /* Constructor*/


public BikeRent(String bikeID, String customerID, String rentPerHour, String rentPerDay, String pickUpTime,
		String dropOffTime, String pickUpDay, String dropOffDay, String price) {
	super();
	this.bikeID = bikeID;
	this.customerID = customerID;
	this.rentPerHour = rentPerHour;
	this.rentPerDay = rentPerDay;
	this.pickUpTime = pickUpTime;
	this.dropOffTime = dropOffTime;
	this.pickUpDay = pickUpDay;
	this.dropOffDay = dropOffDay;
	this.price = price;
}



/* Getter and setters*/



public String getBikeID() {
	return bikeID;
}



public void setBikeID(String bikeID) {
	this.bikeID = bikeID;
}



public String getCustomerID() {
	return customerID;
}



public void setCustomerID(String customerID) {
	this.customerID = customerID;
}



public String getRentPerHour() {
	return rentPerHour;
}



public void setRentPerHour(String rentPerHour) {
	this.rentPerHour = rentPerHour;
}



public String getRentPerDay() {
	return rentPerDay;
}



public void setRentPerDay(String rentPerDay) {
	this.rentPerDay = rentPerDay;
}



public String getPickUpTime() {
	return pickUpTime;
}



public void setPickUpTime(String pickUpTime) {
	this.pickUpTime = pickUpTime;
}



public String getDropOffTime() {
	return dropOffTime;
}



public void setDropOffTime(String dropOffTime) {
	this.dropOffTime = dropOffTime;
}

public String getPickUpDay() {
	return pickUpDay;
}



public void setPickUpDay(String pickUpDay) {
	this.pickUpDay = pickUpDay;
}



public String getDropOffDay() {
	return dropOffDay;
}



public void setDropOffDay(String dropOffDay) {
	this.dropOffDay = dropOffDay;
}


public String getPrice() {
	return price;
}



public void setPrice(String price) {
	this.price = price;
}


   

/* HashCode*/



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bikeID == null) ? 0 : bikeID.hashCode());
	result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
	result = prime * result + ((dropOffDay == null) ? 0 : dropOffDay.hashCode());
	result = prime * result + ((dropOffTime == null) ? 0 : dropOffTime.hashCode());
	result = prime * result + ((pickUpDay == null) ? 0 : pickUpDay.hashCode());
	result = prime * result + ((pickUpTime == null) ? 0 : pickUpTime.hashCode());
	result = prime * result + ((price == null) ? 0 : price.hashCode());
	result = prime * result + ((rentPerDay == null) ? 0 : rentPerDay.hashCode());
	result = prime * result + ((rentPerHour == null) ? 0 : rentPerHour.hashCode());
	return result;
}




/* Equals Code*/



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BikeRent other = (BikeRent) obj;
	if (bikeID == null) {
		if (other.bikeID != null)
			return false;
	} else if (!bikeID.equals(other.bikeID))
		return false;
	if (customerID == null) {
		if (other.customerID != null)
			return false;
	} else if (!customerID.equals(other.customerID))
		return false;
	if (dropOffDay == null) {
		if (other.dropOffDay != null)
			return false;
	} else if (!dropOffDay.equals(other.dropOffDay))
		return false;
	if (dropOffTime == null) {
		if (other.dropOffTime != null)
			return false;
	} else if (!dropOffTime.equals(other.dropOffTime))
		return false;
	if (pickUpDay == null) {
		if (other.pickUpDay != null)
			return false;
	} else if (!pickUpDay.equals(other.pickUpDay))
		return false;
	if (pickUpTime == null) {
		if (other.pickUpTime != null)
			return false;
	} else if (!pickUpTime.equals(other.pickUpTime))
		return false;
	if (price == null) {
		if (other.price != null)
			return false;
	} else if (!price.equals(other.price))
		return false;
	if (rentPerDay == null) {
		if (other.rentPerDay != null)
			return false;
	} else if (!rentPerDay.equals(other.rentPerDay))
		return false;
	if (rentPerHour == null) {
		if (other.rentPerHour != null)
			return false;
	} else if (!rentPerHour.equals(other.rentPerHour))
		return false;
	return true;
}



/* toString*/

@Override
public String toString() {
	return "BikeRental [bikeID=" + bikeID + ", customerID=" + customerID + ", rentPerHour=" + rentPerHour
			+ ", rentPerDay=" + rentPerDay + ", pickUpTime=" + pickUpTime + ", dropOffTime=" + dropOffTime
			+ ", pickUpDay=" + pickUpDay + ", dropOffDay=" + dropOffDay + ", price=" + price + "]";
}


/** validate all the Customer Input fields,if any field is empty returns the message **/

public String validate()
{
    
    
    
      BikeRentalLog4J.initializeLog4J();
                
                List< BikeRent> bikerentList = new ArrayList< BikeRent>();
                BikeRent bikerentObj = new  BikeRent(this.bikeID, this.customerID,this.rentPerHour,this.rentPerDay, 
                                        this.pickUpTime,this.dropOffTime,this.pickUpDay,this.dropOffDay,this.price);
                
                bikerentList.add(bikerentObj);
                
                String returnValue = "";
		
                
                 for( BikeRent bikerent: bikerentList) {
               
	
    
                        if(bikerent.bikeID=="") 
                          {
                          logger.info(" BikeID Column is Empty");
                          returnValue="Bike ID is Empty";
                          break;
                          }
	
		
                        if(bikerent.customerID=="")

                        {
                                logger.info("CustomerID Column is Empty");
                                returnValue="CustomerID Column is Empty";
                                break;
                        }

                        if(bikerent.rentPerHour=="")

                        {
                                logger.info("RentPerHour Column is Empty");
                               returnValue="RentPerHour Column is Empty";
                               break;
                        }

                           if(bikerent.rentPerDay=="")

                        {
                                logger.info("RentPerDay Column is Empty");
                                returnValue="RentPerDay Column is Empty";
                                break;
                        }	

                        if(bikerent.pickUpTime=="")

                        {
                                logger.info("PickUpTime Column is Empty");
                                returnValue="PickUpTime Column is Empty";
                                break;
                        }

                        if(bikerent.dropOffTime=="")

                        {
                               logger.info("Drop Off column is empty");
                               returnValue= "Drop Off Column is empty";
                               break;
                        }


                        if(bikerent.pickUpDay=="")

                        {
                                logger.info("PickUpTime Column is Empty");
                                returnValue="PickUpDay Column is Empty";
                                break;
                        }

                        if(bikerent.dropOffDay=="")

                        {
                                logger.info("Drop Off column is empty");
                               returnValue= "Drop Off Column is empty";
                               break;
                        }


                     if(bikerent.price=="")

                        {
                                logger.info("Price  Column is empty");
                                returnValue="Price Column is empty";
                                break;
                        }

                 }
                 
                 if(returnValue != "") {
                    return returnValue;
                 }

                return "All the Bike Information is Validated";
        }
	
}
	
                
		
		








	






	
	
	

