import java.util.Scanner;

/**
 * Write a description of class Workwear here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Workwear extends Accessory
{
    private String manufacturingStandard, colour, size;

    /**
     * Constructor for objects of class Workwear
     */
    public Workwear()
    {
        super();
    }

    /**
     * Access manufacturingStandard 
     */
    public String getManufacturingStandard()
    {
        return manufacturingStandard;
    }
    
    /**
     * Access colour 
     */
    public String getColour()
    {
        return colour;
    }
    
    /**
     * Access size 
     */
    public String getSize()
    {
        return size;
    }
    
    /**
     * Set manufacturingStandard 
     */
    public void setUseByDate(String newUseByDate)
    {
         manufacturingStandard = newUseByDate;
    }
    
    /**
     * Set colour 
     */
    public void setColour(String newColour)
    {
         colour = newColour;
    }
    
    /**
     * Set size 
     */
    public void setSize(String newSize)
    {
         size = newSize;
    }
    
    /**
     * Method printDetails
     */
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("; manufacturingStandard: " + manufacturingStandard + "; colour :" 
        + colour + "; size: " + size);
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
            this.manufacturingStandard = fieldScanner.next();
            this.colour = fieldScanner.next();
            this.size = fieldScanner.next();
        }
    }
}
