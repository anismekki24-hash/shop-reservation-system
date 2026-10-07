import java.util.Scanner;

/**
 * Write a description of class Tool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tool extends ShopItem
{
    private int timesBorrowed, power, weight;
    private boolean onLoan;

    // /**
     // * Constructor for objects of class Tool
     // */
    // public Tool(String toolName,  String toolCode, int timesBorrowed, boolean onLoan, int cost, int weight)
    // {
        // this.toolName = toolName;
        // this.toolCode = toolCode;
        // this.timesBorrowed = timesBorrowed;
        // this.onLoan = onLoan;
        // this.cost = cost;
        // this.weight = weight;
    // }
    
    /**
     * Default Constructor for class Tool
     */
    public Tool()
    {
        super();
    }
    
    /**
     * Access timesBorrowed 
     */
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }
    
    /**
     * Access onLoan 
     */
    public boolean getOnLoan()
    {
        return onLoan;
    }
    
    /**
     * Access weight 
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Set timesBorrowed 
     */
    public void setTimesBorrowed(int newTimesBorrowed)
    {
        timesBorrowed = newTimesBorrowed;
    }
    
    /**
     * Set onLoan 
     */
    public void setOnLoan(boolean newOnLoan)
    {
        onLoan = newOnLoan;
    }
    
    /**
     * Set weight 
     */
    public void setweight(int newWeight)
    {
        weight = newWeight;
    }
    
    /**
     * Method printDetails
     */
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("; timesBorrowed: " + timesBorrowed + "; onLoan: " + onLoan  + "; weight:" + weight);
    }
    
    /**
     * Method readData
     */
    @Override
    public void readData(Scanner fieldScanner)
    {
        super.readData(fieldScanner);
        if(fieldScanner.hasNext())
        {
            this.timesBorrowed = fieldScanner.nextInt();
            this.onLoan = fieldScanner.nextBoolean();
            this.weight = fieldScanner.nextInt();
        }
    }
}