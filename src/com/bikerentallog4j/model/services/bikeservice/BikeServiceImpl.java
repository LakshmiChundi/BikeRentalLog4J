package com.bikerentallog4j.model.services.bikeservice;

import java.io.Serializable;

import com.bikerentallog4j.model.domain.Bike;
import com.bikerentallog4j.model.services.bikeservice.IBikeService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import com.bikerentallog4j.model.domain.BikeRentalComposite;
import com.bikerentallog4j.model.services.exception.BikeException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * @author Lakshmi Chundi
 * 
 * This Service class implements all the service methods required for Bike
 *
 */

public  class BikeServiceImpl implements  IBikeService , Serializable{

	private static final long serialVersionUID = -4990006635447580113L;
        static Logger logger = Logger.getLogger(BikeServiceImpl.class);
        
	/*ADD BIKE*/
        public Bike  add(BikeRentalComposite bikeRentalComposite) throws BikeException {
	
		Bike bike=null;
		
		try {
		
	     	bike = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(BikeException be) {
			be.printStackTrace();
		}
		
		return bike;
	}
	
	 /* Get Bike */
	
	public Bike get(BikeRentalComposite bikeRentalComposite) throws BikeException{
	
		Bike bike=null;
		
		try {
		
	     	bike = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(BikeException be) {
			be.printStackTrace();
		}
		
		return bike;
	}
		
	 /* UPDATE  Bike */	
	
	public Bike  update(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws BikeException {
		
		Bike bike=null;
			
		try {
			
			bike = this.fileReadAndWrtie(bikeRentalComposite2);
		
		} catch(BikeException be) {
			be.printStackTrace();
		}
		
		
		return bike;
		
	}
	
	
	
	/* DELETE Bike*/

	public String delete(BikeRentalComposite bikeRentalComposite) throws BikeException {
		
		@SuppressWarnings("unused")
		Bike bike=null;
			
		try {
			
			bike = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(BikeException be) {
			be.printStackTrace();
		}
		return "Bike Deleted";
		
	}
	
	/*  COMMON FUNCTION TO READ AND WRITE THE BIKE RENTAL COMPOSITE INTO FIILE */
	@SuppressWarnings("rawtypes")
	Bike fileReadAndWrtie(BikeRentalComposite bikeRentalComposite)  throws BikeException{
		ObjectInputStream oit = null;
		FileInputStream fin = null;
		Bike bike = null;
		FileOutputStream fout = null;
		ObjectOutputStream oot = null;
		
		try {
			
			fout = new FileOutputStream("config/properties.txt"); 
	        oot = new ObjectOutputStream(fout); 
	         
	          
	        //illustrating annotateClass(Class<?> cl) method 
	        
	        Map<String, Bike> bikeHashTable = new Hashtable<String,Bike>();
	        
	     bikeHashTable.put(bikeRentalComposite.getBike().getID(), bikeRentalComposite.getBike());
	        
	          
	        //Write the specified object to the ObjectOutputStream 
	        oot.writeObject(bikeHashTable); 
	          
	        //flushing the stream 
	        oot.flush(); 
	          
	        fin = new FileInputStream("config/properties.txt"); 
	        oit = new ObjectInputStream(fin);  
			
			@SuppressWarnings("unchecked")
			Hashtable<String,Bike> htable = (Hashtable<String, Bike>)oit.readObject();
			for (Enumeration e = htable.keys(); e.hasMoreElements();) {
				Object obj = e.nextElement();
		        logger.info(" Values: " + htable.get(obj));
		        
		        bike = htable.get(obj);
		        
			}    
	        
			return bike;
			
	    } catch (FileNotFoundException fnfe) {
			logger.info("File containing registered users not found!");
			throw new BikeException(
					"File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			logger.info("IOException while accessing file containing registered users!");
			throw new BikeException(
					"IOException while accessing file containing registered users!",
					ioe);
		} catch (ClassNotFoundException cnfe) {
			logger.info("ClassNotFoundException while reading file containing registered users!");
			throw new BikeException(
					"ClassNotFoundException while reading file containing registered users!",
					cnfe);
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
	

