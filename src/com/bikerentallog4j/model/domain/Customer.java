package com.bikerentallog4j.model.domain;


/**  @author Lakshmi.Chundi  **/
import static com.bikerentallog4j.model.domain.ReserveBike.logger;
import com.bikerentallog4jsample.driver.BikeRentalLog4J;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public class Customer extends Address implements Serializable {

	private static final long serialVersionUID = 6140865583289083659L;

	/** Customer firstName */
	private String firstName;
	
	/** Customer lastName */
	private String lastName;
	
	/** Customer Identification Number */
	private String customerID;
	
	/** Customer Email Address*/
	private String emailID;
	
	/** Customer Mobile Number */
	private String mobileNumber;
	
	/** Customer Age**/
	private String age;
        
        static Logger logger = Logger.getLogger(Customer.class);


        /**  Constructor  and  parameters **/
	
	public Customer(String houseNumber, String streetAddress, String city, String state, String zipCode, String firstName,
		String lastName, String customerID, String emailID, String mobileNumber, String age)
	{
	    super(houseNumber, streetAddress, city, state, zipCode);
            this.firstName = firstName;
            this.lastName = lastName;
            this.customerID = customerID;
            this.emailID = emailID;
            this.mobileNumber = mobileNumber;
            this.age = age;
        }

	/** getter and Setters **/
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
            return firstName;
	}
	
	/**
	 * Sets the value firstName
	 */
	
	public void setFirstName(String firstName) {
            this.firstName = firstName;
	}   
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
            return lastName;
	}

	/**
	 * @param lastName
	 * Sets the lastName
	 */
	public void setLastName(String lastName) {
            this.lastName = lastName;
	}
 
	/**
	 * @return the customer Identification number
	 */

	public String getCustomerId() {
            return customerID;
	}

	/**
	 * @param customerId
	 * Sets the lastName
	 */
	public void setCustomerId(String customerID) {
            this.customerID = customerID;
	}


	/**
	 * @return the customer emailID
	 */
	public String getemailID() {
            return emailID;
	}
	
	/**
	 * @param emailID
	 * Sets the emailID
	 */
	public void setemailID(String emailID) {
            this.emailID = emailID;
	}

	/**
	 * @return the customer MobileNumber
	 */
	
	public String getMobileNumber() {
            return mobileNumber;
	}
	
	/**
	 * @param customer MobileNumber
	 * Sets the customer MobileNumber
	 */
	 
	
	public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
	}
	
	/**
	 * @return the customer age
	 */
	public String getAge() {
            return age;
	}
	/**
	 * sets the customer age
	 */
	public void setAge(String age) {
            this.age = age;
	}


	/**  toString method  **/
	@Override
	public String toString() {
            return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", customerID=" + customerID
                            + ", emailID=" + emailID + ", mobileNumber=" + mobileNumber + ", age=" + age + "]";
	}
	
	/**  hashCode method  **/
	@Override
	public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((age == null) ? 0 : age.hashCode());
            result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
            result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
            result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
            result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
            result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
            return result;
	}

	
	/** equals method **/
	@Override
	public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Customer other = (Customer) obj;
            if (age == null) {
                    if (other.age != null)
                            return false;
            } else if (!age.equals(other.age))
                    return false;
            if (customerID == null) {
                    if (other.customerID != null)
                            return false;
            } else if (!customerID.equals(other.customerID))
                    return false;
            if (emailID == null) {
                    if (other.emailID != null)
                            return false;
            } else if (!emailID.equals(other.emailID))
                    return false;
            if (firstName == null) {
                    if (other.firstName != null)
                            return false;
            } else if (!firstName.equals(other.firstName))
                    return false;
            if (lastName == null) {
                    if (other.lastName != null)
                            return false;
            } else if (!lastName.equals(other.lastName))
                    return false;
            if (mobileNumber == null) {
                    if (other.mobileNumber != null)
                            return false;
            } else if (!mobileNumber.equals(other.mobileNumber))
                    return false;
            return true;
	}

	/** validate all the Customer Input fields,if any field is empty returns the message **/
	
	public String validate()
	{
            
              BikeRentalLog4J.initializeLog4J();
               
                
                ArrayList<Customer> customerlist = new ArrayList<Customer>();
                  
                if(customerlist.containsAll(customerlist));
                {
             
                    Iterator iterator= customerlist.iterator();

                   while (iterator.hasNext())
                {
                    logger.info(customerlist.iterator());
                   
                }
                
          
	
            if(this.firstName=="") 
            {
                    logger.info(" Fisrt Name is Empty");
                    return "Fisrt Name is Empty";
            }


            if(this.lastName=="")

            {
                    logger.info("Last Name is Empty");
                    return  "Last Name is Empty";
            }

            if(this.customerID =="")

            {
                    logger.info("Customer Id is Empty");
                    return "Customer Id is Empty";
            }

            if(this.emailID=="")		
            {
                    logger.info("emailID  is Empty");
                    return "emailID is Empty";
            }	

            if(this.mobileNumber=="")

            {
            logger.info(" Mobile Number is Empty");
                    return  "Mobile Number is Empty";
            }

            if(this.age=="")

            {
                    logger.info("Age column is empty");
                    return "Age column is empty";
            }
          
            
        }
            return "All the Customer Information is Validated";	
	}
}	
	