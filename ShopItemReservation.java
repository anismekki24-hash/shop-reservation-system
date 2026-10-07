import java.util.Date;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.*;

/**
 * Write a description of class ShopItemReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShopItemReservation
{
    private String reservationNo, itemID, customerID;
    private Date startDate;
    private int noOfDays;
    
    /**
     * Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation(String reservationNo, String itemID, String customerID, 
    String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    /**
     * Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation() 
    {
        
    }
    
    /**
     * Access reservationNo 
     */
    public String getReservationNo() 
    { 
        return reservationNo; 
    }
    
    /**
     * Access itemID 
     */
    public String getItemID() 
    { 
        return itemID; 
    }
    
    /**
     * Access customerID 
     */
    public String getCustomerID() 
    {
        return customerID; 
    }
    
    /**
     * Access startDate 
     */
    public Date getStartDate() 
    { 
        return startDate; 
    }
    
    /**
     * Access noOfDays 
     */
    public int getNoOfDays() 
    { 
        return noOfDays; 
    }
    
    /**
     * Set reservationNo 
     */
    public void setReservationNo(String newReservationNo)
    {
        reservationNo = newReservationNo;
    }
    
    /**
     * Set itemID 
     */
    public void setItemID(String newItemID)
    {
        itemID = newItemID;
    }
    
    /**
     * Set customerID 
     */
    public void setCustomerID(String newCustomerID)
    {
        customerID = newCustomerID;
    }
    
    /**
     * Set startDate 
     */
    public void setStartDate(Date newStartDate)
    {
        startDate = newStartDate;
    }
    
    /**
     * Set noOfDays 
     */
    public void setNoOfDays(int newNoOfDays)
    {
        noOfDays = newNoOfDays;
    }
    
    /**
     * Method printDetails
     */
    public void printDetails()
    {
         System.out.println("reservationNo: " + reservationNo + "; itemID: " + itemID + "; customerID: " 
         + customerID + "; startDate: " + DateUtil.convertDateToShortString(startDate) + "; noOfDays : " + noOfDays);
    }
    
    /**
     * Method readData
     */
    public void readData(Scanner fieldScanner)
    {
        fieldScanner.useDelimiter("\\s*,\\s*");
        if(fieldScanner.hasNext())
        {
            this.reservationNo = fieldScanner.next();
            this.itemID = fieldScanner.next();
            this.customerID = fieldScanner.next();
            this.startDate = DateUtil.convertStringToDate(fieldScanner.next());
            this.noOfDays = fieldScanner.nextInt();
        }
    }
    
    /**
     * Method writeData
     */
    public void writeData(PrintWriter pWriter)
    {
        pWriter.println(reservationNo + ", " + itemID + ", " + customerID + ", " + 
                        DateUtil.convertDateToShortString(startDate) + ", " + noOfDays);
    }
    
    /**
     * Method toString
     */
    @Override
    public String toString() 
    {
        return "reservationNo: " + reservationNo + "; itemID: " + itemID + "; customerID: " 
         + customerID;
    }
}
