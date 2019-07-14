
/**
 * 
 */
/**
 * @author Lakshmi Chundi
 *
 */
package com.bikerentallog4j.model.domain;

import java.io.Serializable;
import org.apache.log4j.Logger;


/** BikeWorkShop class for bike repairs and bike reports**/

public class BikeRentalComposite implements Serializable {
	
	private static final long serialVersionUID = 7336242047438288964L;
	private Customer customer;
	private ReserveBike reserveBike;
	private Address address;
	private Bike bike;
	private BikeRent bikeRent;
	private BikeWorkShop bikeworkshop;
           static Logger logger = Logger.getLogger(BikeRentalComposite.class);

	
	
	
	/**getter and setters for all domain classes**/

	
	public BikeWorkShop getBikeworkshop() {
		return bikeworkshop;
	}
	public void setBikeworkshop(BikeWorkShop bikeworkshop) {
		this.bikeworkshop = bikeworkshop;
	}
	public Bike getBike() {
		return bike;
	}
	public Bike setBike(Bike bike) {
		return this.bike = bike;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ReserveBike getReserveBike() {
		return reserveBike;
	}
	public void setReserveBike(ReserveBike reserveBike) {
		this.reserveBike = reserveBike;
	}
	public BikeRent getBikeRent() {
		return bikeRent;
	}
	
	public void setBikeRent(BikeRent bikeRent) {
		this.bikeRent = bikeRent;
	}
	
	/** HashCode**/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bike == null) ? 0 : bike.hashCode());
		result = prime * result + ((bikeRent == null) ? 0 : bikeRent.hashCode());
		result = prime * result + ((bikeworkshop == null) ? 0 : bikeworkshop.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((reserveBike == null) ? 0 : reserveBike.hashCode());
		return result;
	}
	
	/** Equals Method**/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BikeRentalComposite other = (BikeRentalComposite) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bike == null) {
			if (other.bike != null)
				return false;
		} else if (!bike.equals(other.bike))
			return false;
		if (bikeRent == null) {
			if (other.bikeRent != null)
				return false;
		} else if (!bikeRent.equals(other.bikeRent))
			return false;
		if (bikeworkshop == null) {
			if (other.bikeworkshop != null)
				return false;
		} else if (!bikeworkshop.equals(other.bikeworkshop))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (reserveBike == null) {
			if (other.reserveBike != null)
				return false;
		} else if (!reserveBike.equals(other.reserveBike))
			return false;
		return true;
	}
	
	/** to string**/
	 
	@Override
	public String toString() {
		return "BikeRentalComposite [customer=" + customer + ", reserveBike=" + reserveBike + ", address=" + address
				+ ", bike=" + bike + ", bikeRent=" + bikeRent + ", bikeworkshop=" + bikeworkshop + "]";
	}
	
	
	
}