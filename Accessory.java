package pkg;
import java.util.Scanner;

/**
 * Write a description of class Accessory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Accessory extends ShopItem
{
    private boolean isRecyclable;
    
    /**
     * Constructor for objects of class Accessory
     */
    public Accessory()
    {
        super();
    }
    
    /**
     * Access isRecyclable 
     */
    public boolean getIsRecyclable()
    {
        return isRecyclable;
    }
    
    /**
     * Set isRecyclable 
     */
    public void setIsRecyclable(boolean newIsRecyclable)
    {
         isRecyclable = newIsRecyclable;
    }
    
    /**
     * Method printDetails
     */
    @Override
    public void printDetails()
    {
         super.printDetails();
         System.out.println("; isRecyclable: " + isRecyclable);
    }
    
    /**
     * Method readData
     */
    @Override
    public void readData(Scanner fieldScanner)
    {
        if(fieldScanner.hasNext())
        {
            this.isRecyclable = fieldScanner.nextBoolean();
            super.readData(fieldScanner);
        }
    }
}