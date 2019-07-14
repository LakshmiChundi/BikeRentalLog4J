package com.bikerentallog4j.model.services.customerservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.domain.Customer;
import com.bikerentallog4j.model.services.exception.CustomerException;
import org.apache.log4j.Logger;

/**
 * @author Lakshmi Chundi
 * 
 * This Service class implements all the service methods required for Customer
 *
 */

public class CustomerServiceImpl implements ICustomerService, Serializable  {
	
	private static final long serialVersionUID = -1703744603120005994L;
                   static Logger logger = Logger.getLogger(CustomerServiceImpl.class);


	
	
	/* ADD CUSTOMER*/
	
	public Customer  addCustomer(BikeRentalComposite bikeRentalComposite) throws CustomerException {
		
		Customer customer = null;
			
		try {
		
	     	customer = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(CustomerException ce) {
			ce.printStackTrace();
		}
		
		return customer;
	}
	
	
	/* GET CUSTOMER*/

	public Customer getCustomer(BikeRentalComposite bikeRentalComposite) throws CustomerException {
		
		
		Customer customer = null;
			
		try {
			
			customer = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(CustomerException ce) {
			ce.printStackTrace();
		}
		
		return customer;
	
	}
	
	
	/* UPDATE CUSTOMER*/
	
	public String  updateCustomer(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws CustomerException {
		
		Customer customer = null;
			
		try {
			
			customer = this.fileReadAndWrtie(bikeRentalComposite2);
		
		} catch(CustomerException ce) {
			ce.printStackTrace();
		}
		
		return customer.getFirstName();
		
	} 
	/* DELETE CUSTOMER*/
	
	public String  deleteCustomer(BikeRentalComposite bikeRentalComposite) throws CustomerException {
		
		try {
			
			this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(CustomerException ce) {
			ce.printStackTrace();
		}
		return "Customer Deleted";
		
	}
	
	
	/*  COMMON FUNCTION TO READ AND WRITE THE BIKE RENTAL COMPOSITE INTO FIILE */
	@SuppressWarnings("rawtypes")
	Customer fileReadAndWrtie(BikeRentalComposite bikeRentalComposite)  throws CustomerException{
		ObjectInputStream oit = null;
		FileInputStream fin = null;
		Customer customer = null;
		FileOutputStream fout = null; 
        ObjectOutputStream oot = null; 
         
        
		try {
			
			fout = new FileOutputStream("config/properties.txt"); 
	        oot = new ObjectOutputStream(fout); 
	         
	          
	        //illustrating annotateClass(Class<?> cl) method 
	        
	        Map<String, Customer> customerHashTable = new Hashtable<String,Customer>();
	        
	        customerHashTable.put(bikeRentalComposite.getCustomer().getCustomerId(), bikeRentalComposite.getCustomer());
	               
	        //Write the specified object to the ObjectOutputStream 
	        oot.writeObject(customerHashTable); 
	          
	        //flushing the stream 
	        oot.flush(); 
	          
	        fin = new FileInputStream("config/properties.txt"); 
	        oit = new ObjectInputStream(fin); 
	        
			@SuppressWarnings("unchecked")
			Hashtable<String,Customer> htable = (Hashtable<String, Customer>)oit.readObject();
			
			for (Enumeration e = htable.keys(); e.hasMoreElements();) {
				Object obj = e.nextElement();
		        logger.info(" Values: " + htable.get(obj));
		        
		        customer = htable.get(obj);
		        
			}    
	        
			return customer;
			
	    } catch (FileNotFoundException fnfe) {
			logger.info("File containing registered users not found!");
			throw new CustomerException(
					"File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			logger.info("IOException while accessing file containing registered users!");
			throw new CustomerException(
					"IOException while accessing file containing registered users!",
					ioe);
		} catch (ClassNotFoundException cnfe) {
			logger.info("ClassNotFoundException while reading file containing registered users!");
			throw new CustomerException("ClassNotFoundException while reading file containing registered users!",cnfe);
		} finally {
			try {
				oot.close(); 
			    fout.close();
				fin.close();
				oit.close();
			} catch (IOException e) {
				// Can't do much here if exceptions occur, other then
				// logging
				e.printStackTrace();
			}
		}

	}

}
