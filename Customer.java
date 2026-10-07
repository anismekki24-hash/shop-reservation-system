import java.util.Scanner;
import java.io.*;
import java.util.Random;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    private String customerID, surname, firstName, otherInitials, title;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String customerID, String surname, String firstName, String otherInitials,
                    String title)
    {
        this.customerID = "unknown" ;
        this.surname = surname ;
        this.firstName = firstName ;
        this.otherInitials = otherInitials ;
        this.title = title ;
    }
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        this.customerID = "unknown" ;
    }
    
    /**
     * Access customerID 
     */
    public String getCustomerID()
    {
        return customerID;
    }
    
    /**
     * Access surname 
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * Access firstName 
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Access otherInitials 
     */
    public String getOtherInitials()
    {
        return otherInitials;
    }
    
    /**
     * Access title 
     */
    public String getTitle()
    {
        return title;
    }

    
    /**
     * Set customerID 
     */
    public void setCustomerID(String newCustomerID)
    {
        customerID = newCustomerID;
    }
    
    /**
     * Set surname 
     */
    public void setSurname(String newSurname)
    {
        surname = newSurname;
    }
    
    /**
     * Set firstName 
     */
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }
    
    /**
     * Set otherInitials 
     */
    public void setOtherInitials(String newOtherInitials)
    {
        otherInitials = newOtherInitials;
    }
    
    /**
     * Set title 
     */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    
    /**
     * Method printDetails
     */
    public void printDetails()
    {
        System.out.println("customerID: " + customerID + "; surname: " + surname  + "; firstName:" + firstName
          + "; otherInitials:" + otherInitials + "; title:" + title);
    }
    
    /**
     * Method readData
     */
    public void readData(Scanner fieldScanner)
    {
        if(fieldScanner.hasNext())
        {
            this.customerID = fieldScanner.next();
            this.surname = fieldScanner.next();
            this.firstName = fieldScanner.next();
            this.otherInitials = fieldScanner.next();
            this.title = fieldScanner.next();
        }
    }
    
    /**
     * Method writeData
     */
    public void writeData(PrintWriter pWriter) 
    {
        pWriter.println(customerID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title);
    }
}
