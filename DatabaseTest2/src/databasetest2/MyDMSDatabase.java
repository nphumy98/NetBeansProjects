/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetest2;

/**
 *
 * @author MY PHU NGUYEN
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

public class MyDMSDatabase {
    public static void main(String [] args)
            throws SQLException, ClassNotFoundException {
        // The driverURL to contain the Database Driver
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/DMSDB;" + 
                "create=true;user=dms;password=dms2018";
        // Creating SQL query string
        String sqlQuery;
        ResultSet resultSet;
        int resultDB;
        
        // Step 1: Loading the drivers for JAVA DB
        Class.forName(driverURL);
        // Network Driver both will work with this example.
        // You can use any one of them
        //Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        // Step 2: Connecting to sample Database in Java DB
        Connection connection = DriverManager.getConnection(dbURL);
        System.out.println("Database is created...");
        
        // Step 3: Creating the SQL Statement
        Statement statement = connection.createStatement();
        
        // Step 4: Creating a new Student table in DMSDB
        sqlQuery = "CREATE TABLE STUDENT " + "(StID INT PRIMARY KEY," +
                " firstName VARCHAR(20), lastName VARCHAR(20))";
        resultDB = statement.executeUpdate(sqlQuery);
        if(resultDB == 0)
            System.out.println("Student Table is created");
        
        // Step 5: Inserting a record in the Student table in DMSDB
        sqlQuery = "INSERT INTO STUDENT VALUES" +
                "(1, 'David', 'Citizen')," +
                "(2, 'John', 'Keats')," +
                "(3, 'William', 'Blake')," +
                "(4, 'Leonardo', 'Davinci')";
        resultDB = statement.executeUpdate(sqlQuery);
        if(resultDB == 4)
            System.out.println("4 records are insterted in Student Table");
        
        // Step 6: Reading records from Student Table
        sqlQuery = "Select * from STUDENT";
        resultSet = statement.executeQuery(sqlQuery);

        // Step 7: Reading data from the ResultSet
        while(resultSet.next()){
            System.out.println(resultSet.getString(1) + "\t"
                    + resultSet.getString(2) + "\t"
                    + resultSet.getString(3));
        }
        
        // Step 6: close connection
        statement.close();
        connection.close();
    }
}

