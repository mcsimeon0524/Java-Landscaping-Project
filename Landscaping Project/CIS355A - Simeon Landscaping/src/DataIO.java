import java.sql.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mat
 */
public class DataIO
{
    // constants
    private final String DATABASE_NAME = "cis355a";
    private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final String USER_NAME = "root";
    private final String PASSWORD = "devry123";
    
    // behaviors
    public void add(Customer cust) throws ClassNotFoundException, SQLException
    {
        // check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        // add record
        String strSQL = "INSERT INTO landscape (CustomerName, CustomerAddress, "
                + "LandscapeType, YardLength, YardWidth, LandscapeCost) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setString(1, cust.getCustomerName());
        pstmt.setString(2, cust.getCustomerAddress());
        pstmt.setString(3, cust.getYardType());
        pstmt.setDouble(4, cust.getLength());
        pstmt.setDouble(5, cust.getWidth());
        pstmt.setDouble(6, cust.getTotalCost());
        
        // execute the prepared statement
        pstmt.execute();
        
        // close the connection
        conn.close();
    }
    
    public void delete(int customerID) throws SQLException
    {
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        // delete the record
        String SQL = "DELETE FROM landscape WHERE CustomerID = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, customerID);
        pstmt.execute();
        
        // close the database;
        conn.close();
    }
    
    public ArrayList<Customer> getList() throws SQLException 
    {
        // create the Arraylist so we have something to return
        ArrayList<Customer> list = new ArrayList<Customer>();
        
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        Statement statement = conn.createStatement();
        String SQL = "Select * FROM landscape";
        ResultSet rs = statement.executeQuery(SQL);
        
        while (rs.next())
        {
            // create Customer object and load the attributes
            Customer client = new Customer();
            client.setCustomerID(rs.getInt(1));
            client.setCustomerName(rs.getString(2));
            client.setCustomerAddress(rs.getString(3));
            client.setYardType(rs.getString(4));
            client.setLength(rs.getDouble(5));
            client.setWidth(rs.getDouble(5));
            client.setTotalCost(rs.getDouble(7));
            
            // add the Customer object to our list
            list.add(client);
            
        }
        
        //close the database connection
        conn.close();
            
        // return the Arraylist
        return list;
    }
}
