package com.bikerentallog4j.model.domain;

import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**  @author Lakshmi.Chundi  **/

public class Bike implements Serializable {

	private static final long serialVersionUID = 2566299005384892658L;

	/** Bike Identification number */
	private String ID;
	
	/** Bike Type like Mountain bike ,road bike*/
	private String type;
	
	/** Bike Size like Small, Medium, Large */
	private String size;
	
	/** Color Of the Bike */
	private String color;
	
	/** Company or brand name of the Bike */
	private String brand;
	
	        static Logger logger = Logger.getLogger(Bike.class);

	/** Constructor **/
	
	public Bike(String ID, String type, String size, String color, String brand) {
		super();
		this.ID = ID;
		this.type = type;
		this.size = size;
		this.color = color;
		this.brand = brand;
		
	}
	
	
	/**
	 * @return the Bike Identification
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Sets Bike Identification
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	/**
	 * @return the Bike Type
	 */
	
	public String gettype() {
		return type;
	}
	
	/**
	 * Sets the Bike Type
	 */
	public void settype(String type) {
		this.type = type;
	}
	
	/**
	 * @return the Bike Size
	 */
	public String getsize() {
		return size;
	}
	
	/**
	 * Sets the Bike Size
	 */
	public void setsize(String size) {
		this.size = size;
	}
	
	/**
	 * @return the Bike Color
	 */
	
	public String getcolor() {
		return color;
	}
	
	/**
	 * Sets the Bike Color
	 */
	
	public void setcolor(String color) {
		this.color = color;
	}
	
	/**
	 * @return the Bike Brand
	 */
	
	public String getbrand() {
		return brand;
	}
	
	
	/**
	 * Sets the Bike Brand
	 */
	public void setbrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Overriding hashCode() for Bike Class
	 */
	
	@Override
	public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((brand == null) ? 0 : brand.hashCode());
            result = prime * result + ((color == null) ? 0 : color.hashCode());
            result = prime * result + ((ID == null) ? 0 : ID.hashCode());
            result = prime * result + ((size == null) ? 0 : size.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());

            return result;
	}
	
	/**
	 * Overriding equals() for Bike Class
	 */
	
	@Override
	public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Bike other = (Bike) obj;
            if (brand == null) {
                    if (other.brand != null)
                            return false;
            } else if (!brand.equals(other.brand))
                    return false;
            if (color == null) {
                    if (other.color != null)
                            return false;
            } else if (!color.equals(other.color))
                    return false;
            if (ID == null) {
                    if (other.ID != null)
                            return false;
            } else if (!ID.equals(other.ID))
                    return false;
            if (size == null) {
                    if (other.size != null)
                            return false;
            } else if (!size.equals(other.size))
                    return false;
            if (type == null) {
                    if (other.type != null)
                            return false;
            } else if (!type.equals(other.type))
                    return false;

            return true;
	}
	
	/**
	 * Overriding toString for Bike Class
	 */

	@Override
	public String toString() {
		return "Bike [ID=" + ID + ", type=" + type + ", size=" + size + ", color=" + color
				+ ", brand=" + brand + "]";
	}
	
	/** validate all the Bike Input fields, if any field is empty returns the message **/

	public String validateBike() {
		
                BikeRentalLog4J.initializeLog4J();
                
                List<Bike> bikeList = new ArrayList<Bike>();
                Bike bikeObj = new Bike(this.ID, this.type, 
                                        this.size, this.color, this.brand);
                
                bikeList.add(bikeObj);
                
                String returnValue = "";
		
                
                 for(Bike bike: bikeList) {
               
                     
                    if(bike.ID == "") 
                    {
                            logger.info("ID Is Empty");
                            returnValue = "ID Is Empty";
                            break;
                    }


                    if(bike.type == "")	
                    {
                            logger.info("type Field Is Empty");
                            returnValue = "type Field Is Empty";
                            break;
                    }   

                    if(bike.size == "")		
                    {
                            logger.info("Size Of the Bike Field is Empty");
                            returnValue = "Size Of the Bike Field is Empty";
                            break;
                    }

                    if(bike.color == "")		
                    {
                            logger.info("color Field Is Empty");
                            returnValue = "color Field Is Empty";
                            break;
                    }	

                    if(bike.brand == "")		
                    {
                            logger.info("brand Field Is Empty");
                            returnValue = "brand Field Is Empty";
                            break;
                    }
			
                }	
                 if(returnValue != "") {
                    return returnValue;
                 }

                return "All the Customer Information is Validated";
        }
	
}
	