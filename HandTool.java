import java.util.Scanner;

/**
 * Write a description of class HandTool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HandTool extends Tool
{
    private boolean sharpenable;

    /**
     * Constructor for objects of class HandTool
     */
    public HandTool()
    {
       super();
    }
    
    /**
     * Access sharpenable 
     */
    public boolean getSharpenable()
    {
        return sharpenable;
    }
    
    /**
     * Set sharpenable 
     */
    public void setSharpenable(boolean newSharpenable)
    {
        sharpenable = newSharpenable;
    }

    /**
     * Method readData
     */
    @Override
    public void readData(Scanner fieldScanner)
    {
        super.readData(fieldScanner);
        if (fieldScanner.hasNext())
        {
            this.sharpenable = fieldScanner.nextBoolean();
        }
    }
    
    /**
     * Method printDetails
     */
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("; Sharpenable: " + sharpenable);
    }
}