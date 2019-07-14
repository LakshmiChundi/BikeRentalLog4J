/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikerentallog4jsample.driver;
import java.io.FileInputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * @author Chundi Lakshmi
 */
public class BikeRentalLog4J {
    
    public BikeRentalLog4J()
	{}
	//static Logger log = Logger.getLogger("com.bikerentallog4j");
    static Logger logger = Logger.getLogger(BikeRentalLog4J.class);

    /**
     * @param args the command line arguments
     */
    
    public static void initializeLog4J() {
        FileInputStream sf = null;

        try{

          String log4jConfigFileLocation = System.getProperty("log4j_prop_location");

          if (log4jConfigFileLocation != null)
          { 
            // Initialize Properties for components
            PropertyConfigurator.configure(log4jConfigFileLocation);
            logger.info("Successfully configured log4j");      
          }
          else
          {
            logger.info("log4j configuration file location not set. Passed in value is: " + log4jConfigFileLocation + ".");
            throw new RuntimeException ("log4j configuration file location not set.");         
          }
        }
        catch(RuntimeException rte)
        {
          logger.error("Failed to configure log4j");     
        }
    
    }
}
