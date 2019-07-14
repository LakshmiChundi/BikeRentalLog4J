package com.bikerentallog4j.model.domain;

/** @author Lakshmi Chundi**/

import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class BikeWorkShop implements Serializable { 

	private static final long serialVersionUID = -7795326848260200076L;
	
	/** Bike ID For reference **/
	private String bikeID;
	
	/** Inspector ID to check  **/
	private String inspectorID;
	
	/** Bike out of service date **/
	private String outOfServiceStartDate;
	
	/** Bike out of service end date **/
	private String outOfServiceEndDate;
	
	/**Inspection report about bike  **/
	private String inspectionReport;
	
	/**maintaining the information about bike  **/
	private String maintenanceInfo;
	
	/**daily report about bike  **/
	private String dailyReports;
	
	/**Monthly report about bike  **/
	private String monthlyReports;
	
           static Logger logger = Logger.getLogger(BikeWorkShop.class);


	
	/** Getter and Setter Method**/
	
	public String getBikeID() {
		return bikeID;
	}
	public void setBikeID(String bikeID) {
		this.bikeID = bikeID;
	}
	public String getInspectorID() {
		return inspectorID;
	}
	public void setInspectorID(String inspectorID) {
		this.inspectorID = inspectorID;
	}
	public String getOutOfServiceStartDate() {
		return outOfServiceStartDate;
	}
	public void setOutOfServiceStartDate(String outOfServiceStartDate) {
		this.outOfServiceStartDate = outOfServiceStartDate;
	}
	public String outOfServiceEndDate() {
		return outOfServiceEndDate;
	}
	public void setOutOfServiceEndDate(String outOfServicEndeDate) {
		this.outOfServiceEndDate = outOfServicEndeDate;
	}
	public String getInspectionReport() {
		return inspectionReport;
	}
	public void setInspectionReport(String inspectionReport) {
		this.inspectionReport = inspectionReport;
	}
	public String getMaintenanceInfo() {
		return maintenanceInfo;
	}
	public void setMaintenanceInfo(String maintenanceInfo) {
		this.maintenanceInfo = maintenanceInfo;
	}
	public String getDailyReports() {
		return dailyReports;
	}
	public void setDailyReports(String dailyReports) {
		this.dailyReports = dailyReports;
	}
	public String getMonthlyReports() {
		return monthlyReports;
	}
	public void setMonthlyReports(String monthlyReports) {
		this.monthlyReports = monthlyReports;
	}
	
	
	/** Constructor**/
	
	public BikeWorkShop(String bikeID, String inspectorID, String outOfServiceStartDate, String outOfServicEndeDate,
			String inspectionReport, String maintenanceInfo, String dailyReports, String monthlyReports) {
		super();
		this.bikeID = bikeID;
		this.inspectorID = inspectorID;
		this.outOfServiceStartDate = outOfServiceStartDate;
		this.outOfServiceEndDate = outOfServicEndeDate;
		this.inspectionReport = inspectionReport;
		this.maintenanceInfo = maintenanceInfo;
		this.dailyReports = dailyReports;
		this.monthlyReports = monthlyReports;
	}
	
	/**Hash Code**/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bikeID == null) ? 0 : bikeID.hashCode());
		result = prime * result + ((dailyReports == null) ? 0 : dailyReports.hashCode());
		result = prime * result + ((inspectionReport == null) ? 0 : inspectionReport.hashCode());
		result = prime * result + ((inspectorID == null) ? 0 : inspectorID.hashCode());
		result = prime * result + ((maintenanceInfo == null) ? 0 : maintenanceInfo.hashCode());
		result = prime * result + ((monthlyReports == null) ? 0 : monthlyReports.hashCode());
		result = prime * result + ((outOfServiceEndDate == null) ? 0 : outOfServiceEndDate.hashCode());
		result = prime * result + ((outOfServiceStartDate == null) ? 0 : outOfServiceStartDate.hashCode());
		return result;
	}
	
	
	/** Equals**/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BikeWorkShop other = (BikeWorkShop) obj;
		if (bikeID == null) {
			if (other.bikeID != null)
				return false;
		} else if (!bikeID.equals(other.bikeID))
			return false;
		if (dailyReports == null) {
			if (other.dailyReports != null)
				return false;
		} else if (!dailyReports.equals(other.dailyReports))
			return false;
		if (inspectionReport == null) {
			if (other.inspectionReport != null)
				return false;
		} else if (!inspectionReport.equals(other.inspectionReport))
			return false;
		if (inspectorID == null) {
			if (other.inspectorID != null)
				return false;
		} else if (!inspectorID.equals(other.inspectorID))
			return false;
		if (maintenanceInfo == null) {
			if (other.maintenanceInfo != null)
				return false;
		} else if (!maintenanceInfo.equals(other.maintenanceInfo))
			return false;
		if (monthlyReports == null) {
			if (other.monthlyReports != null)
				return false;
		} else if (!monthlyReports.equals(other.monthlyReports))
			return false;
		if (outOfServiceEndDate == null) {
			if (other.outOfServiceEndDate != null)
				return false;
		} else if (!outOfServiceEndDate.equals(other.outOfServiceEndDate))
			return false;
		if (outOfServiceStartDate == null) {
			if (other.outOfServiceStartDate != null)
				return false;
		} else if (!outOfServiceStartDate.equals(other.outOfServiceStartDate))
			return false;
		return true;
	}
	
	/** toString**/
	
	@Override
	public String toString() {
		return "BikeWorkShop [bikeID=" + bikeID + ", inspectorID=" + inspectorID + ", outOfServiceStartDate="
				+ outOfServiceStartDate + ", outOfServiceEndDate=" + outOfServiceEndDate + ", inspectionReport="
				+ inspectionReport + ", maintenanceInfo=" + maintenanceInfo + ", dailyReports=" + dailyReports
				+ ", MonthlyReports=" + monthlyReports + "]";
	}
	
	/** validate all the bike work shop Input fields,if any field is empty returns the message **/
	
	
	public String validate()
	{
		
                
                BikeRentalLog4J.initializeLog4J();
                
                List< BikeWorkShop> bikeworkshopList = new ArrayList< BikeWorkShop>();
               BikeWorkShop bikeworkshopObj = new  BikeWorkShop(this.bikeID, this.inspectorID,this.outOfServiceStartDate,
                                                                this.outOfServiceEndDate, this.inspectionReport,this.maintenanceInfo,
                                                                 this.dailyReports,this.monthlyReports);
                
               bikeworkshopList.add(bikeworkshopObj);
                
                String returnValue = "";
		
                 for( BikeWorkShop bikeworkshop: bikeworkshopList) {
		
                     
                     
                     if(bikeworkshop.bikeID=="") 
		{
			logger.info(" BikeID Column is Empty");
			returnValue= "BikeID Column is Empty";
                        break;
		}
		
			
		if(bikeworkshop.inspectorID=="")
			
		{
			logger.info("InspectorID Column is Empty");
			returnValue="InspectorID Column is Empty";
                         break;
		}
			
		if(bikeworkshop.outOfServiceStartDate=="")
				
		{
			logger.info("OutOfServiceStartDate Column is Empty");
			returnValue="OutOfServiceStartDate Column is Empty";
                         break;
		}
		
		   if(bikeworkshop.outOfServiceEndDate=="")
		
		{
		        logger.info("OutOfServiceEndDate Column is Empty");
			returnValue="OutOfServiceEndDate Column is Empty";
                         break;
		}	
		
		if(bikeworkshop.inspectionReport=="")
				
		{
			logger.info("InspectionReport Column is Empty");
			returnValue="InspectionReport Column is Empty";
                         break;
		}
			
		if(bikeworkshop.maintenanceInfo=="")
			
		{
			logger.info("MaintenanceInfo column is empty");
			returnValue= "MaintenanceInfo Column is Empty";
                         break;
		}
			

		if(bikeworkshop.dailyReports=="")
				
		{
			logger.info("DailyReports Column is Empty");
			returnValue= "DailyReports Column is Empty";
                         break;
		}
			
		if(bikeworkshop.monthlyReports=="")
			
		{
			logger.info("MonthlyReports column is empty");
			returnValue= "MonthlyReports Column is Empty";
                         break;
		}
              
            }
                
                 if(returnValue != "") {
                    return returnValue;
                 }

                return "All the Bike Information is Validated";
        }
	
}
                 
         
