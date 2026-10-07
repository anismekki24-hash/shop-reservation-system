import java.util.Scanner;

/**
 * Write a description of class ShopItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShopItem extends Shop
{
    private int cost;
    private String itemName, itemCode;

    /**
     * Constructor for objects of class ShopItem
     */
    public ShopItem()
    {}
    
    /**
     * Access itemName 
     */
    public String getItemName()
    {
        return itemName;
    }
    
    /**
     * Access itemCode 
     */
    public String getItemCode()
    {
        return itemCode;
    }
    
    /**
     * Access cost 
     */
    public int getCost()
    {
        return cost;
    }
    
    /**
     * Set itemName 
     */
    public void setItemName(String newItemName)
    {
        itemName = newItemName;
    }
    
    /**
     * Set itemCode 
     */
    public void setItemCode(String newItemCode)
    {
        itemCode = newItemCode;
    }
    
        /**
     * Set cost 
     */
    public void setCost(int newCost)
    {
        cost = newCost;
    }
    
    /**
     * Method printDetails
     */
    public void printDetails()
    {
         System.out.println("Tool name: " + itemName + "; code: " + itemCode + "; cost: " 
         + cost);
    }
    
    /**
     * Method readData
     */
    public void readData(Scanner fieldScanner)
    {
        fieldScanner.useDelimiter("\\s*,\\s*");
        if(fieldScanner.hasNext())
        {
            this.itemName = fieldScanner.next();
            this.itemCode = fieldScanner.next();
            this.cost = fieldScanner.nextInt();
        }
    }
}
