package com.bikerentallog4j.model.services.bikeworkshopservice;
/**
 * @author Lakshmi Chundi
 * 
 * This Service class implements all the service methods required for Customer
 *
 */
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
import com.bikerentallog4j.model.domain.BikeWorkShop;
import com.bikerentallog4j.model.services.exception.BikeWorkShopException;
import org.apache.log4j.Logger;
   

/**This Service class implements all the service methods required for BikeWorkShop
 */

public  class BikeWorkShopServiceImpl implements IBikeWorkShopService, Serializable{

	
	private static final long serialVersionUID = -1703744603120005994L;
                  static Logger logger = Logger.getLogger(BikeWorkShopServiceImpl.class);


	
	/* Get Reports*/
	
	public BikeWorkShop  getReport(BikeRentalComposite bikeRentalComposite) throws BikeWorkShopException {
		
		BikeWorkShop bikeworkshop = null;
			
		try {
		
			bikeworkshop = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(BikeWorkShopException bre) {
			bre.printStackTrace();
		}
		
		return bikeworkshop;
	}
	
	
	/*  ADD Reports*/

	public BikeWorkShop  addReport(BikeRentalComposite bikeRentalComposite) throws BikeWorkShopException  {
		
		
		BikeWorkShop bikeworkshop = null;
			
		try {
			
			bikeworkshop = this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(BikeWorkShopException bre) {
			bre.printStackTrace();
		}
		
		return bikeworkshop;
	
	}
	
	
	/* UPDATE Reports*/
	
	public String  updateReport(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws BikeWorkShopException  {
		
		BikeWorkShop bikeworkshop = null;
			
		try {
			
			bikeworkshop = this.fileReadAndWrtie(bikeRentalComposite2);
		
		} catch(BikeWorkShopException bre) {
		   bre.printStackTrace();
		}
		
		return bikeworkshop.getBikeID();
		
	} 
	/* DELETE */
	
	public String  delete(BikeRentalComposite bikeRentalComposite) throws BikeWorkShopException {
		
		try {
			
			this.fileReadAndWrtie(bikeRentalComposite);
		
		} catch(BikeWorkShopException bre) {
			bre.printStackTrace();
		}
		return "Reports Deleted";
		
	}
	
	
	/*  COMMON FUNCTION TO READ AND WRITE THE BIKE RENTAL COMPOSITE INTO FIILE */
	@SuppressWarnings("rawtypes")
	
	BikeWorkShop fileReadAndWrtie(BikeRentalComposite bikeRentalComposite)  throws BikeWorkShopException{
		ObjectInputStream oit = null;
		FileInputStream fin = null;
		BikeWorkShop bikeworkshop=null;
		FileOutputStream fout = null; 
        ObjectOutputStream oot = null; 
         
        
		try {
			
			fout = new FileOutputStream("config/properties.txt"); 
	        oot = new ObjectOutputStream(fout); 
	         
	          
	        //illustrating annotateClass(Class<?> cl) method 
	        
	        Map<String, BikeWorkShop> bikeworkshopHashTable = new Hashtable<String,BikeWorkShop>();
	        
	        bikeworkshopHashTable.put(bikeRentalComposite.getBikeworkshop().getBikeID(),bikeRentalComposite.getBikeworkshop());
	               
	        //Write the specified object to the ObjectOutputStream 
	        oot.writeObject(bikeworkshopHashTable); 
	          
	        //flushing the stream 
	        oot.flush(); 
	          
	        fin = new FileInputStream("config/properties.txt"); 
	        oit = new ObjectInputStream(fin); 
	        
			@SuppressWarnings("unchecked")
			Hashtable<String,BikeWorkShop> htable = (Hashtable<String, BikeWorkShop>)oit.readObject();
			
			for (Enumeration e = htable.keys(); e.hasMoreElements();) {
				Object obj = e.nextElement();
		        logger.info(" Values: " + htable.get(obj));
		        
		        bikeworkshop = htable.get(obj);
		        
			}    
	        
			return bikeworkshop;
			
	    } catch (FileNotFoundException fnfe) {
			logger.info("File containing registered users not found!");
			throw new BikeWorkShopException(
					"File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			logger.info("IOException while accessing file containing registered users!");
			throw new BikeWorkShopException(
					"IOException while accessing file containing registered users!",
					ioe);
		} catch (ClassNotFoundException cnfe) {
			logger.info("ClassNotFoundException while reading file containing registered users!");
			throw new BikeWorkShopException(
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


	
