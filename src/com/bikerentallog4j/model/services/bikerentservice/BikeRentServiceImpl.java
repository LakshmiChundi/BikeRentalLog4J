package com.bikerentallog4j.model.services.bikerentservice;

/**
* @author Lakshmi Chundi
* 
* This Service class implements all the service methods required for BikeRent
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
    import com.bikerentallog4j.model.domain.BikeRent;
    import com.bikerentallog4j.model.domain.BikeRentalComposite;
	import com.bikerentallog4j.model.services.exception.BikeRentalException;
import org.apache.log4j.Logger;

	

	public class BikeRentServiceImpl  implements IBikeRentService, Serializable  {
		
		private static final long serialVersionUID = -1703744603120005994L;

		   static Logger logger = Logger.getLogger(BikeRentServiceImpl.class);

		
		/* Add Rent*/
		
		public BikeRent   addRent(BikeRentalComposite bikeRentalComposite) throws BikeRentalException {
			
			BikeRent bikerent = null;
				
			try {
			
				bikerent = this.fileReadAndWrtie(bikeRentalComposite);
			
			} catch( BikeRentalException  bre) {
				bre.printStackTrace();
			}
			
			return bikerent;
		}
		
		/* Get Rent Details*/
		
				public  BikeRent getRent(BikeRentalComposite bikeRentalComposite) throws BikeRentalException {
					
					BikeRent bikerent = null;
					
					try {
					
						bikerent = this.fileReadAndWrtie(bikeRentalComposite);
					
					} catch( BikeRentalException  bre) {
						bre.printStackTrace();
					}
					
					return bikerent;
				}
				
				/* UPDATE RENT*/
				
				public BikeRent  updateRent(BikeRentalComposite bikeRentalComposite1,BikeRentalComposite bikeRentalComposite2) throws BikeRentalException {
					

					BikeRent bikerent = null;
					
					try {
					
						bikerent = this.fileReadAndWrtie(bikeRentalComposite1);
					
					} catch( BikeRentalException  bre) {
						bre.printStackTrace();
					}
					
					return bikerent;
				}
				
				/* DELETE */
				
				@SuppressWarnings("unused")
				
				public String  deleteRent(BikeRentalComposite bikeRentalComposite) throws BikeRentalException {
					
                                    BikeRent bikerent = null;
					
					try {
					
						bikerent = this.fileReadAndWrtie(bikeRentalComposite);
					
					} catch( BikeRentalException  bre) {
						bre.printStackTrace();
					}
					
					return "Deleted Rent";

		
				}
		
		/*  COMMON FUNCTION TO READ AND WRITE THE BIKE RENTAL COMPOSITE INTO FIILE */
	@SuppressWarnings("rawtypes")
	BikeRent fileReadAndWrtie(BikeRentalComposite bikeRentalComposite)  throws BikeRentalException{
		ObjectInputStream oit = null;
		FileInputStream fin = null;
		BikeRent bikerent = null;
		FileOutputStream fout = null; 
        ObjectOutputStream oot = null; 
	         
	        
			try {
				
				fout = new FileOutputStream("config/properties.txt"); 
		        oot = new ObjectOutputStream(fout); 
		         
		          
		        //illustrating annotateClass(Class<?> cl) method 
		        
		        Map<String, BikeRent> bikerentHashTable = new Hashtable<String,BikeRent>();
		        
		        bikerentHashTable.put(bikeRentalComposite.getBikeRent().getCustomerID(), bikeRentalComposite.getBikeRent());
		        
		          
		        //Write the specified object to the ObjectOutputStream 
		        oot.writeObject(bikerentHashTable); 
		          
		        //flushing the stream 
		        oot.flush(); 
		          
		        fin = new FileInputStream("config/properties.txt"); 
		        oit = new ObjectInputStream(fin); 
		        
				@SuppressWarnings("unchecked")
				Hashtable<String,BikeRent> htable = (Hashtable<String, BikeRent>)oit.readObject();
				
				for (Enumeration e = htable.keys(); e.hasMoreElements();) {
					Object obj = e.nextElement();
			        logger.info(" Values: " + htable.get(obj));
			        
			       bikerent= htable.get(obj);
			        
				}    
		        
				return bikerent;
				
		    } catch (FileNotFoundException fnfe) {
				logger.info("File containing registered users not found!");
				throw new BikeRentalException(
						"File containing registered users not found!", fnfe);
			} catch (IOException ioe) {
				logger.info("IOException while accessing file containing registered users!");
				throw new BikeRentalException(
						"IOException while accessing file containing registered users!",
						ioe);
			} catch (ClassNotFoundException cnfe) {
				logger.info("ClassNotFoundException while reading file containing registered users!");
				throw new BikeRentalException(
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


