package com.bikerentallog4j.model.domain;

import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


/**  @author Lakshmi.Chundi  **/


public class Address implements Serializable{

	private static final long serialVersionUID = -7795326848260200076L;

	/** Customer houseNumber */
	
	private String houseNumber;

	/** Customer streetAddress */
	
	private String streetAddress;

	/** Customer city */
	
	private String city;

	/** Customer state */
	
	private String state;

	/** Customer zipCode */
	
	private String zipCode;
	
        static Logger logger = Logger.getLogger(Address.class);

	
	/**  Constructor  and  parameters **/
	
	
	public Address(String houseNumber, String streetAddress, String city, String state, String zipCode)
	{
            super();
            this.houseNumber = houseNumber;
            this.streetAddress = streetAddress;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            
	}
	
	/**
	 * @return the houseNumber
	 */
	
	public String getHouseNumber() {
		return houseNumber;
	}

	
	/**
	 * Sets the value houseNumber
	 */
	
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	
	/**
	 * @return the streetAddress
	 */
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	
	/**
	 * sets the streetAddress
	 */

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	/**
	 * @return the city
	 */
	
	
	public String getCity() {
		return city;
	}

	
	/**
	 * sets the city
	 */
	
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	
	
	public String getState() {
		return state;
	}

	/**
	 * sets the state
	 */
	
	
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipCode
	 */
	
	
    public String getZipCode() {
		return zipCode;
	}

    /**
	 * sets the zipCode
	 */
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
	/** toString Method **/

	@Override
	public String toString() {
		return "CustomerAddress [houseNumber=" + houseNumber + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + "]";
	}

	/** hash Method **/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	/** equals Method **/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}


	/** validate all the CustomerAddress Input fields,if any field is empty returns the message **/
	
	
        public String validateAddress()
	{
	        BikeRentalLog4J.initializeLog4J();
                
                List<Address> addressList = new ArrayList<Address>();
                Address addressObj = new Address(this.houseNumber, this.streetAddress, 
                                                 this.city, this.state, this.zipCode);
                
                addressList.add(addressObj);
                
                String returnValue = "";
                
                for(Address address: addressList) {
                    if(address.houseNumber=="") 
                    {
                            logger.info(" HouseNumber is Empty");
                            returnValue =  "HouseNumber is Empty";
                            break;
                    }

                    if(address.streetAddress=="")

                    {
                            logger.info(" StreetAddress is Empty");
                            returnValue =  "StreetAddress is Empty";
                            break;
                    }

                    if(address.city =="")

                    {
                            logger.info("City Name is Empty");
                            returnValue =  "City Name is Empty";
                            break;
                    }

                    if(address.state=="")		
                    {
                            logger.info(" State Name is Empty");
                            returnValue =  "State Name is Empty";
                            break;
                    }	

                    if(address.zipCode=="")

                    {
                            logger.info("zipCode is Empty");
                            returnValue =  "zipCode is Empty";
                            break;
                    }
                    
                   
                }
                
                if(returnValue != "") {
                    return returnValue;
                }
                
                return "All the Customer Information is Validated";
			
	}			
	
}
	
	
	

