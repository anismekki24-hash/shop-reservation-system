import java.util.Scanner;

/**
 * Write a description of class ElectricTool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ElectricTool extends Tool
{
    private boolean rechargeable;
    private String power;
    
    /**
     * Constructor for objects of class ElectricTool
     */
    public ElectricTool()
    {
        super();
    }
    
    /**
     * Access rechargeable 
     */
    public boolean getRechargeable()
    {
        return rechargeable;
    }

    /**
     * Access power 
     */
    public String getPower()
    {
        return power;
    }
    
    /**
     * Set rechargeable 
     */
    public void setRechargeable(boolean newRechargeable)
    {
        rechargeable = newRechargeable;
    }
    
    /**
     * Set power 
     */
    public void setPower(String newPower)
    {
        power = newPower;
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
            this.rechargeable = fieldScanner.nextBoolean();
            this.power = fieldScanner.next();
        }
    }
    
    /**
     * Method printDetails
     */
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("; Rechargeable: " + rechargeable + "; Power :" + power);
    }
}
