/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetest3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MY PHU NGUYEN
 */
public class StudentBean {
    private ArrayList<Student> StudentList;
    // The driverURL to contain the Database Driver
      private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
    // The dbURL to contain the Database URL
      private final String dbURL = "jdbc:derby://localhost:1527/DMSDB;" + 
                "create=true;user=dms;password=dms2018";
      private final String tableName="DITMEMAY";
      
    public StudentBean() throws SQLException, ClassNotFoundException
    {
        //Create StudentList
        StudentList= new ArrayList<Student>();
        //Create Connection
        Connection connection= connectDatabaseSchema();
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        //if connect sucessfully
     
        //if studentDB table exist 
        if (isTableExisting(tableName,connection))
        {
            System.out.println("table existed");
            //Reading records from Student Table
            ResultSet rs=statement.executeQuery("SELECT * FROM "+tableName);

            while(rs.next())
            {
                int studentID= rs.getInt("StID"); //read studentID
                String firstName= rs.getString("firstName"); //read student first Name
                String lastName= rs.getString("lastName");// read student last Name
                //create Student Object
                Student aStudent= new Student(studentID, firstName, lastName);
                //add Student to studentList
                StudentList.add(aStudent);
                System.out.println("one student has been added");
            }               
        }
        else //if studentDB table not exist
        {
             System.out.println("table is not existed");
            // Step 4: Creating a new STUDENTDB table in DMSDB
            String sqlQuery = "CREATE TABLE "+tableName + " (StID INT PRIMARY KEY," +
            " firstName VARCHAR(20), lastName VARCHAR(20))";
            int resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 0)
            System.out.println("Student Table is created");
            // Step 5: Inserting a record in the Student table in DMSDB
            sqlQuery = "INSERT INTO "+ tableName +" VALUES" +
            "(1, 'Bob', 'Nilson')," +
            "(2, 'Nicholas', 'Jose')," +
            "(3, 'Minh', 'Nguyen')," +
            "(4, 'Zetting', 'Luo'),"+
            "(5, 'Michal', 'Kovac'),"+
            "(6, 'Karoline', 'Wang')";
            resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 6)
            System.out.println("6 records are insterted in Student Table");
            //add to the ArrayList of StudentList
            initialiseStudentList();
        }
         //close connection
        connection.close();
    }
      
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void addStudent(Student aStudent) throws ClassNotFoundException, SQLException {
        this.StudentList.add(aStudent);
         //Create Connection
        Connection connection= connectDatabaseSchema();
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        String sqlQuery = "INSERT INTO "+ tableName +" VALUES (" + 
                aStudent.getStudentID()+" ,'"+aStudent.getFirstName()+"','"+aStudent.getLastName()+"')";
        statement.executeUpdate(sqlQuery);
        System.out.println("Student has been added");
        //close connection
        connection.close();
    }
    
    public void removeStudent(Student aStudent) throws ClassNotFoundException, SQLException
    {
        this.StudentList.remove(aStudent);
         //Create Connection
        Connection connection= connectDatabaseSchema();
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        String sqlQuery = "DELETE FROM "+ tableName +" WHERE StID="+aStudent.getStudentID();
        statement.executeUpdate(sqlQuery);
        System.out.println("Student has been removed");
        //close connection
        connection.close();
    }
    
    public Student retrieveStudentInformation(int studentID) throws ClassNotFoundException, SQLException
    {
        //Create Connection
        Connection connection= connectDatabaseSchema();
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM "+tableName+" WHERE StID="+studentID;
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        // Step 7: Reading data from the ResultSet
        while(resultSet.next()){
            System.out.println(resultSet.getString(1) + "\t"
                    + resultSet.getString(2) + "\t"
                    + resultSet.getString(3));
        }
        //close connection
        connection.close();
        return null;
    }
    
    //this method is to check if the table Student already exist in the database
     private static boolean isTableExisting(String tableName, Connection theConnection) throws SQLException
    {
        DatabaseMetaData theMetaData = theConnection.getMetaData();
        
        ResultSet existingTable = theMetaData.getTables(null, null, tableName.toUpperCase(), null);
        
        if(existingTable.next())
        {
                return true;
        }
        return false;
    }
     
     private Connection connectDatabaseSchema() throws ClassNotFoundException, SQLException
     {

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);
            // Network Driver both will work with this example.
            // You can use any one of them
            //Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Step 2: Connecting to sample Database in Java DB
            Connection connection = DriverManager.getConnection(dbURL);
            System.out.println("Database is connected...");
            return connection;
     }
     
     private void initialiseStudentList()
     {
         StudentList.add(new Student(1, "Bob", "Nilson"));
         StudentList.add(new Student(2, "Nicholas", "Jose"));
         StudentList.add(new Student(3, "Minh", "Nguyen"));
         StudentList.add(new Student(4, "Zetting", "Luo"));
         StudentList.add(new Student(5, "Michal", "Kovac"));
         StudentList.add(new Student(6, "Karoline", "Wang"));
     }
     
     //getter and setter

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }
     
}
