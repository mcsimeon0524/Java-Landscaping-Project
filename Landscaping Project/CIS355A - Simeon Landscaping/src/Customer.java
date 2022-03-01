
import java.text.DecimalFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mat
 */
public class Customer
{
    //attributes
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String yardType;
    private double length;
    private double width;
    private double totalCost;
    
    //Constructors 
    public Customer()
    {
        customerID = 0;
        customerName = "n/a";
        customerAddress = "n/a";
        yardType = "n/a";
        length = 0.0;
        width = 0.0;
        totalCost = 0.0;
    }

    public Customer(int customerID, String customerName, String customerAddress, String yardType, double length, double width, double totalCost)
    {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.yardType = yardType;
        this.length = length;
        this.width = width;
        this.totalCost = totalCost;
    }
    
    //behaviors
    @Override
    public String toString()
    {
        return customerName; // Only show the Customer's name
    }
    
    public String getDetails()
    {
        DecimalFormat fmt = new DecimalFormat ("$#,##0.00");
        String output = customerName + "\n";
        output +=  customerAddress + "\n";
        output += "Type: " + yardType + "\n";
        output += "Width " + width + "\n";
        output += "Length: " + length + "\n";
        output += "Total Cost: " + fmt.format(totalCost);
        
        return output;
    }

    // getters and setters
    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerAddress()
    {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress)
    {
        this.customerAddress = customerAddress;
    }

    public String getYardType()
    {
        return yardType;
    }

    public void setYardType(String yardType)
    {
        this.yardType = yardType;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }
    
    
}

