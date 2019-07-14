package com.bikerentallog4j.model.domain;

import com.bikerentallog4j.model.domain.BikeWorkShop;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class BikeWorkshopTest {
	
	BikeWorkShop bikeworkshopTest;
                                   static Logger logger = Logger.getLogger(BikeWorkshopTest.class);

		
	            /**
				 * Test for type Success
				 */

                        @Test
                        public void testSucess() {

                                 bikeworkshopTest = new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019", "1/9/2019", 
                                                                    "Passed","Good","CustomerReport","BikeDamageReport");
                                assertEquals( bikeworkshopTest .getBikeID(),"BikeID1234567");
                                logger.info("Test is success");
                                }

                                /**
                                 * Test  for BikeId Validate()
                                 */

                                @Test
                                public void bikeIDValidator() {

                                         bikeworkshopTest = new BikeWorkShop("","InspID1234567", "1/7/2019", "1/9/2019", 
                                                                 "Passed","Good","CustomerReport","BikeDamageReport");
                                         assertEquals("BikeID Column is Empty", bikeworkshopTest.validate());

                                }

                                /**
                                 * Test  for InspectorID  Validate()
                                 */


                        @Test
                        public void inspectorIDValidator() {

                                 bikeworkshopTest = new BikeWorkShop("BikeID1234567", "","1/7/2019", "1/9/2019", 
                                                       "Passed","Good","CustomerReport","BikeDamageReport");
                                  assertEquals("InspectorID Column is Empty", bikeworkshopTest.validate());
                        }


	/*** Test  for Out Of Service Start Date Validate() */

		@Test
		
		public void outOfServiceStartDateValidator() {
	
		 bikeworkshopTest = new BikeWorkShop("BikeID1234567","InspID1234567", "", "1/9/2019", 
                                             "Passed","Good","CustomerReport","BikeDamageReport");
                 assertEquals("OutOfServiceStartDate Column is Empty", bikeworkshopTest.validate());
		
	}
				/**
			 * Test  for OutOfService EndDate  Validate()
			 */

		@Test
		
		public void outOfServiceEndDateValidator() {
			bikeworkshopTest = new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019","", 
                                                "Passed","Good","CustomerReport","BikeDamageReport");
                         assertEquals("OutOfServiceEndDate Column is Empty", bikeworkshopTest.validate());

         }
		
			
			/** * Test  for InspectionReport Validate()*/
		@Test
		public void inspectionReportValidator() {
			
		bikeworkshopTest = new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019","1/9/2019", 
                                            "","Good","CustomerReport","BikeDamageReport");
		assertEquals("InspectionReport Column is Empty",bikeworkshopTest.validate());
			
		}
		
		/** * Test  for MaintenanceInfo Validate()*/

	@Test

                public void maintenanceInfoValidator() {

                bikeworkshopTest = new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019","1/9/2019", 
                                                "Passed","","CustomerReport","BikeDamageReport");
                assertEquals("MaintenanceInfo Column is Empty",bikeworkshopTest.validate());

                }
	
	/** * Test  for Daily Reports Validate()*/

		@Test
		
		public	void dailyReportsValidator() {
			
		bikeworkshopTest = new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019","1/9/2019", 
                                            "Passed","Good","","BikeDamageReport");
		assertEquals("DailyReports Column is Empty",bikeworkshopTest.validate());
			
		}

		/** * Test  for Monthly Reports Validate()*/

        @Test
		
                public void monthlyReportsValidator() {

                        bikeworkshopTest = new BikeWorkShop("BikeID1234567","InspID1234567", "1/7/2019","1/9/2019", 
                                                    "Passed","Good","CustomerReport","");
                        assertEquals("MonthlyReports Column is Empty",bikeworkshopTest.validate());

                        }


}
