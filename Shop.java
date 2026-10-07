//import java.util.ArrayList;
import java.awt.FileDialog;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * Write a description of class Shop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shop
{
    // private ArrayList<ShopItem> itemList;
    // private ArrayList<Customer> customerList;
    private Map<String, ShopItem> itemsMap;
    private Map<String, Customer> customerMap;
    private Random randomGenerator;
    private Map<String, ShopItemReservation> itemReservationMap;
    private int reservationCounter;
    private Diary diary;
    
    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        // itemList = new ArrayList<>();
        // customerList = new ArrayList<>();
        itemsMap = new HashMap<>();
        customerMap = new HashMap<>();
        randomGenerator = new Random();
        diary = new Diary();
    }
    
    /**
     * Access randomGenerator
     */
    public Random getRandomGenerator()
    {
        return randomGenerator;
    }
    
    /**
     * Set randomGenerator
     */
    public void setRandomGenerator(Random newRandomGenerator)
    {
        randomGenerator = newRandomGenerator;
    }

    /**
     * Method storeItem
     */
    public void storeItem(ShopItem i)
    {
        // itemList.add(i);
        itemsMap.put(i.getItemCode(), i);
    }
    
    /**
     * Method storeCustomer
     */
    public void storeCustomer(Customer c)
    {
        if (c.getCustomerID() == "unknown")
        
        {
            String newID = generateCustomerID("AB-", 6);
            c.setCustomerID(newID);
        }
        customerMap.put(c.getCustomerID(), c);
    }
    
    /**
     * Method getItem
     */
    public ShopItem getItem(String id)
    {
        return itemsMap.get(id);
    }
    
    /**
     * Method getCustomer
     */
    public Customer getCustomer(String id)
    {
        return customerMap.get(id);    
    }
    
    /**
     * Method printAllTools
     */
    public void printAllTools()
    {
        for (ShopItem item : itemsMap.values())
        {
            item.printDetails();
            System.out.println("");
        }
    }
    
    /**
     * Method printAllCustomers
     */
    public void printAllCustomers()
    {
        for (Customer customer : customerMap.values())
        {
            customer.printDetails();
            System.out.println("");
        }
    }
    
    /**
     * Method readToolData
     */
    public void readToolData()
    {
        FileDialog f = new FileDialog((java.awt.Frame) null, "Select Tool Data File", FileDialog.LOAD);
        f.setVisible(true);
        String directoryPath = f.getDirectory();
        String filename = f.getFile();
        File fileObject = new File(directoryPath + filename);
        System.out.println("Reading file: " + directoryPath + filename);
        
        try 
        {
            Scanner lineScanner = new Scanner(fileObject);
            String typeOfData = "";
            
            while (lineScanner.hasNextLine()) {
                String lineOfText = lineScanner.nextLine().trim();
                
                if (lineOfText.startsWith("//")  || lineOfText.isEmpty()) 
                {
                    continue;
                }
                
                else if (lineOfText.startsWith("[")) {
                    
                    if (!typeOfData.contains("Electric") && !typeOfData.contains("Handtool")
                    && !typeOfData.contains("Perishable") && !typeOfData.contains("Workwear")) 
                    {
                        System.out.println("Warning: Unexpected flag encountered: " + typeOfData);
                    }
                }
                else 
                {
                    Scanner fieldScanner = new Scanner(lineOfText);
                    fieldScanner.useDelimiter("\\s*,\\s*");
                    
                    try 
                    {
                        if (typeOfData.contains("Electric")) 
                        {
                            ElectricTool eTool = new ElectricTool();
                            eTool.readData(fieldScanner);
                            //itemList.add(eTool);
                            itemsMap.put(eTool.getItemCode(), eTool);;
                            eTool.printDetails();
                        }
                        else if (typeOfData.contains("Handtool")) 
                        {
                            HandTool hTool = new HandTool();
                            hTool.readData(fieldScanner);
                            //itemList.add(hTool);
                            itemsMap.put(hTool.getItemCode(), hTool);
                            hTool.printDetails();
                        }
                        else if (typeOfData.contains("Perishable")) 
                        {
                            Perishable pItem = new Perishable();
                            pItem.readData(fieldScanner);
                            //itemList.add(pTool);
                            itemsMap.put(pItem.getItemCode(), pItem);
                            pItem.printDetails();
                        }
                        else if (typeOfData.contains("workwear")) 
                        {
                            Workwear wItem = new Workwear();
                            wItem.readData(fieldScanner);
                            //itemList.add(wTool);
                            itemsMap.put(wItem.getItemCode(), wItem);
                            wItem.printDetails();
                        }
                    } 
                    
                    catch (Exception e) 
                    {
                        throw e;
                    }
                    fieldScanner.close();
                }
            }
            lineScanner.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("The file could not be found.");
            e.printStackTrace();
        }
    }
    
    /**
     * Method readCustomerData
     */
    public void readCustomerData()
    {
        FileDialog f = new FileDialog((java.awt.Frame) null, "Select Tool Data File", FileDialog.LOAD);
        f.setVisible(true);
        String directoryPath = f.getDirectory();
        String filename = f.getFile();
        File fileObject = new File(directoryPath + filename);
        if (directoryPath == null || filename == null) 
        {
            return;
        }
        System.out.println("Reading file: " + directoryPath + filename);
        
        try 
        {
            Scanner lineScanner = new Scanner(fileObject);
            
            while (lineScanner.hasNextLine()) 
            {
                String lineOfText = lineScanner.nextLine().trim();
                
                if (lineOfText.startsWith("//") || lineOfText.isEmpty()) 
                {
                    continue;
                }

                Scanner fieldScanner = new Scanner(lineOfText);
                fieldScanner.useDelimiter("\\s*,\\s*");
                
                Customer c = new Customer();
                c.readData(fieldScanner);
                //customerList.add(c);
                customerMap.put(c.getCustomerID(), c);
                c.printDetails();
                
                fieldScanner.close();
            }
            lineScanner.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("The file could not be found.");
            e.printStackTrace();
        }
    }
    
    /**
     * Method generateCustomerID
     */
    private String generateCustomerID(String prefix, int digits) 
    {
        int maxLimit = (int) Math.pow(10, digits); 
        int randomNumber = randomGenerator.nextInt(maxLimit);
        String formattingRule = "%0" + digits + "d"; 
        String newID = prefix + String.format(formattingRule, randomNumber);
        return newID;
    }
    
    /**
     * Method writeCustomerData
     */
    public void writeCustomerData(String fileName) throws FileNotFoundException
    {
        PrintWriter pWriter = new PrintWriter(fileName);
        for (Customer c : customerMap.values())
        {
            // String lineOfOutput = c.getCustomerID() + " | " + c.getSurname() + " | " +
            // c.getFirstName() + " | " + c.getOtherInitials() + " | " + c.getTitle();
            // pWriter.println(lineOfOutput);
            c.printDetails();
        }
        pWriter.close();
    }
    
    /**
     * Method storeItemReservation
     */
    public void storeItemReservation(ShopItemReservation si)
    {
        itemReservationMap.put(si.getItemID(), si);
        diary.addReservation(si);
    }
    
    /**
     * Method generateReservationNo
     */
    private String generateReservationNo() 
    {
        String resNo = String.format("%06d", reservationCounter);
        reservationCounter++;
        return resNo;
    }
    
    /**
     * Method getItemReservation
     */
    private ShopItemReservation getItemReservation(String id)
    {
        return itemReservationMap.get(id);
    }
    
    /**
     * Method makeItemReservation
     */
    public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays)
    {
        if (!customerMap.containsKey(customerID)) 
        {
            System.out.println("Error: Customer ID " + customerID + " not found.");
            return false;
        }

        if (!itemsMap.containsKey(itemID)) 
        {
            System.out.println("Error: Item ID " + itemID + " not found.");
            return false;
        }
        
        java.util.Date desiredStartDate = DateUtil.convertStringToDate(startDate);
        for (int i = 0; i < noOfDays; i++)
        {
            java.util.Date checkDate = DateUtil.incrementDate(desiredStartDate, i);
            ShopItemReservation[] dailyReservations = diary.getReservations(checkDate);
            
            if (dailyReservations != null) 
            {
                for (ShopItemReservation existingRes : dailyReservations) 
                {
                    if (existingRes.getItemID().equals(itemID)) 
                    {
                        System.out.println("Error: Item " + itemID + " is already reserved on " + 
                                           DateUtil.convertDateToShortString(checkDate));
                        return false; 
                    }
                }
            }
        }

        ShopItemReservation si = new ShopItemReservation(generateReservationNo(), itemID,
                                                        customerID, startDate, noOfDays);
        storeItemReservation(si);
        System.out.println("Reservation successful! Reservation No: " + generateReservationNo());
        return true;
    }
    
    /**
     * Method printItemReservations
     */
    public void printItemReservations()
    {
        for (ShopItemReservation si : itemReservationMap.values())
        {
            si.printDetails();
            System.out.println("");
        }
    }
    
    /**
     * Method writeItemReservationData
     */
    public void writeItemReservationData(String fileName) throws FileNotFoundException
    {
        PrintWriter pWriter = new PrintWriter(fileName);
        for (ShopItemReservation si : itemReservationMap.values())
        {
            si.printDetails();
        }
        pWriter.close();
    }
    
    /**
     * Method readItemReservationData
     */
    public void readItemReservationData()
    {
        FileDialog f = new FileDialog((java.awt.Frame) null, "Select Tool Data File", FileDialog.LOAD);
        f.setVisible(true);
        String directoryPath = f.getDirectory();
        String filename = f.getFile();
        File fileObject = new File(directoryPath + filename);
        if (directoryPath == null || filename == null) 
        {
            return;
        }
        System.out.println("Reading file: " + directoryPath + filename);
        
        try 
        {
            Scanner lineScanner = new Scanner(fileObject);
            
            while (lineScanner.hasNextLine()) 
            {
                String lineOfText = lineScanner.nextLine().trim();
                Scanner fieldScanner = new Scanner(lineOfText);
                fieldScanner.useDelimiter("\\s*,\\s*");
                
                ShopItemReservation si = new ShopItemReservation();
                si.readData(fieldScanner);
                itemReservationMap.put(si.getItemID(), si);
                si.printDetails();
                
                fieldScanner.close();
            }
            lineScanner.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("The file could not be found.");
            e.printStackTrace();
        }
    }
    
    /**
     * Method printDiaryEntries
     */
    public void printDiaryEntries(String startDate, String endDate)
    {
        Date start = DateUtil.convertStringToDate(startDate);
        Date end = DateUtil.convertStringToDate(endDate);
        diary.printEntries(start, end);
    }
    
    /**
     * Method deleteItemReservation
     */
    private void deleteItemReservation(String reservationNo)
    {
        ShopItemReservation si = getItemReservation(reservationNo);
        if (si != null)
        {
            itemReservationMap.remove(si.getReservationNo(), si);
            diary.deleteReservation(si);
            System.out.println("Reservation " + reservationNo + " deleted.");
        }
        else
        {
            System.out.println("Error: Cannot find reservation. Check your details.");
        }
    }
}