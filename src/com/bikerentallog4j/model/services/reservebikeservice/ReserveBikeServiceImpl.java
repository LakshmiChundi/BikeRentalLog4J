package com.bikerentallog4j.model.services.reservebikeservice;

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
import com.bikerentallog4j.model.domain.ReserveBike;
import com.bikerentallog4j.model.services.exception.ReserveBikeException;

import org.apache.log4j.Logger;

/**
 * @author Lakshmi Chundi
 * 
 * This Service class implements all the service methods required for ReserveBike
 *
 */
public class ReserveBikeServiceImpl implements IReserveBikeService {

    
                       static Logger logger = Logger.getLogger(ReserveBikeServiceImpl.class);

	public ReserveBike booking(BikeRentalComposite bikeRentalComposite) {
		
		
		ReserveBike reserveBike = null;
		
		try {
		
			reserveBike = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(ReserveBikeException rbe) {
			rbe.printStackTrace();
		}
	
		return reserveBike;
	}
	
	
	public ReserveBike modify(BikeRentalComposite bikeRentalComposite) {
		
		ReserveBike reserveBike = null;
		
		try {
		
			reserveBike = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(ReserveBikeException rbe) {
			rbe.printStackTrace();
		}
		
		
		return reserveBike;
		
	}
	
	public ReserveBike cancel(BikeRentalComposite bikeRentalComposite1, BikeRentalComposite bikeRentalComposite2) {
		
		ReserveBike reserveBike = null;
		
		try {
		
			reserveBike = this.fileReadAndWrtie(bikeRentalComposite1);
		
		} catch(ReserveBikeException rbe) {
			rbe.printStackTrace();
		}
		
		
		return reserveBike;
		
	}
	
	@SuppressWarnings("rawtypes")
	ReserveBike fileReadAndWrtie(BikeRentalComposite bikeRentalComposite)  throws ReserveBikeException {
		ObjectInputStream oit = null;
		FileInputStream fin = null;
		ReserveBike reserveBike = null;
		FileOutputStream fout = null; 
        ObjectOutputStream oot = null; 
		
		try {
			
			fout = new FileOutputStream("config/properties.txt"); 
	        oot = new ObjectOutputStream(fout); 
	         
	          
	        //illustrating annotateClass(Class<?> cl) method 
	        
	        Map<String, ReserveBike> customerHashTable = new Hashtable<String,ReserveBike>();
	        
	        customerHashTable.put(bikeRentalComposite.getReserveBike().getID(), bikeRentalComposite.getReserveBike());
	        
	          
	        //Write the specified object to the ObjectOutputStream 
	        oot.writeObject(customerHashTable); 
	          
	        //flushing the stream 
	        oot.flush(); 
	             
	        fin = new FileInputStream("config/properties.txt"); 
	        oit = new ObjectInputStream(fin); 
	        
			
			@SuppressWarnings("unchecked")
			Hashtable<String,ReserveBike> htable = (Hashtable<String, ReserveBike>)oit.readObject();
			
	        
			for (Enumeration e = htable.keys(); e.hasMoreElements();) {
				Object obj = e.nextElement();
		        logger.info(" Values: " + htable.get(obj));
		        
		        reserveBike = htable.get(obj);
		        
			}    
	        
			return reserveBike;
			
	    } catch (FileNotFoundException fnfe) {
			logger.info("File containing registered users not found!");
			throw new ReserveBikeException(
					"File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
		logger.info("IOException while accessing file containing registered users!");
			throw new ReserveBikeException(
					"IOException while accessing file containing registered users!",
					ioe);
		} catch (ClassNotFoundException cnfe) {
logger.info("ClassNotFoundException while reading file containing registered users!");
			throw new ReserveBikeException(
					"ClassNotFoundException while reading file containing registered users!",
					cnfe);
		} finally {
			try {
				fout.close(); 
		        oot.close();
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

