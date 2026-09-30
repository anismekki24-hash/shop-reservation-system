import java.util.Scanner;

/**
 * Write a description of class Perishable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Perishable extends Accessory
{
    private int volume;
    private boolean isIrritant;
    private String useByDate;

    /**
     * Constructor for objects of class Perishable
     */
    public Perishable()
    {
        super();    
    }
    
    /**
     * Access volume 
     */
    public int getVolume()
    {
        return volume;
    }
    
    /**
     * Access isIrritant 
     */
    public boolean isIrritant()
    {
        return isIrritant;
    }
    
    /**
     * Access useByDate 
     */
    public String getUseByDate()
    {
        return useByDate;
    }
    
    /**
     * Set volume 
     */
    public void setVolume(int newVolume)
    {
         volume = newVolume;
    }
    
    /**
     * Set isIrritant 
     */
    public void setIrritant(boolean newIrritant)
    {
         isIrritant = newIrritant;
    }
    
    /**
     * Set useByDate 
     */
    public void setUseByDate(String newUseByDate)
    {
         useByDate = newUseByDate;
    }
    
    /**
     * Method printDetails
     */
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("; isIrritant: " + isIrritant + "; useByDate :" + useByDate +
        "; volume: " + volume);
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
            this.isIrritant = fieldScanner.nextBoolean();
            this.useByDate = fieldScanner.next();
            this.volume = fieldScanner.nextInt();
        }
    }
}
