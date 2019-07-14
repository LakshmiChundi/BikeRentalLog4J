package com.bikerentallog4j.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.bikerentallog4j.model.business.exception.PropertyFileNotFoundException;
import com.bikerentallog4jsample.driver.BikeRentalLog4J;

import org.apache.log4j.Logger;

/**
 * @author Lakshmi Chundi
 **/

public class PropertyManager
{
	private static Properties properties;
        static Logger logger = Logger.getLogger(PropertyManager.class);

 
	/**
	 * 
	 * @param propertyFileLocation
	 * @throws PropertyFileNotFoundException
	 */
	public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException
	{
	    properties = new Properties();
            
            BikeRentalLog4J.initializeLog4J();
	    FileInputStream fis = null;
	    try
	    {
	      fis = new FileInputStream(propertyFileLocation);
	      properties.load(fis);
     
	      logger.info("Property file successfully loaded from location: " + propertyFileLocation);
	      logger.info("Property Contents: " + properties.toString());

	    }
	    catch (FileNotFoundException fnfe) 
		 {
	    	logger.info("Property file not found.");
	    	throw new PropertyFileNotFoundException ("Property File cannot be found.", fnfe);
		 }
	    catch (IOException ioe) 
	    {
	    	logger.info("IOException while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("IOException while loading Properties file.", ioe);	    	
	    }
	    catch (Exception excp) 
	    {
	    	logger.info("Exception while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("Exception while loading Properties file.", excp);	    	
	    }
		finally
		{
			if (fis != null)
			{	
			   try {
 			    fis.close();
			   } catch (IOException e) {
				
				e.printStackTrace();
			   }
		    }	
		}	    
	} //end loadProperties()

	
	/*
	 * This methods returns the Value for the passed key.
	 * 
	 * @param key - key whose value needs to be returned
	 * @return String - value for the passed key
	 */
    static public String getPropertyValue (String key)
    {
    	return properties.getProperty(key);
    }
} // end class PropertyManager