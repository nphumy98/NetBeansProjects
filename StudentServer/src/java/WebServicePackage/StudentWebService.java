/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServicePackage;

import BeanPackage.Gender;
import BeanPackage.Student;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author MY PHU NGUYEN
 */
@WebService(serviceName = "StudentWebService")
public class StudentWebService {
    /**
     * This is a sample web service operation
     */
        private ArrayList<Student> studentList;
         // The driverURL to contain the Database Driver
        private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        private final String dbURL = "jdbc:derby://localhost:1527/DMSDB;" + 
                  "create=true;user=dms;password=dms2018";
        private final String tableName="Student_DB";

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @WebMethod(operationName = "initList")
    public int initList() throws Exception
    {
        this.studentList = new ArrayList<Student>();
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
                int studentID= rs.getInt("studentID"); //read studentID
                String name= rs.getString("name"); //read student  Name
                int age= rs.getInt("age");// read student age
                Gender gender= Gender.valueOf(rs.getString("gender"));
                //create Student Object
                Student aStudent= new Student(studentID, name, age,gender);
                //add Student to studentList
                studentList.add(aStudent);
                System.out.println("one student has been added");
            }               
        }
        else //if studentDB table not exist
        {
           System.out.println("table is not existed");
            // Step 4: Creating a new STUDENTDB table in DMSDB
            String sqlQuery = "CREATE TABLE "+tableName + " (studentID INT PRIMARY KEY," +
            " name VARCHAR(20), age INT, gender VARCHAR(20))";
            int resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 0)
            System.out.println("Student Table is created");
            // Step 5: Inserting a record in the Student table in DMSDB
            sqlQuery = "INSERT INTO "+ tableName +" VALUES" +
            "(1, 'Minh',18, 'Male')," +
            "(2, 'Huyen',20, 'Female')," +
            "(3, 'Duc',19, 'Male')," +
            "(4, 'Nghia',45, 'Male'),"+
            "(5, 'Thuan',26, 'Female'),"+
            "(6, 'Hai',7, 'Male')";
            resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 6)
            System.out.println("6 records are insterted in Student Table");
            //add data
            initialiseStudentList();
        }
        //close connection
        connection.close();
        return this.studentList.size();
    }
    
     @WebMethod(operationName = "makeStudent")
    public Student makeStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        return aStudent;
    }
    
     @WebMethod(operationName = "addStudent")
    public int addStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        studentList.add(aStudent);
        return studentList.size();
    }
    
    @WebMethod(operationName = "getStudentList")
    public ArrayList<Student> getStudentList()
    {
        return this.studentList;
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
    
    private void initialiseStudentList()
    {
        studentList.add(new Student("Minh",18, Gender.Male));
        studentList.add(new Student("Huyen",20, Gender.Female));
        studentList.add(new Student("Duc",19, Gender.Male));
        studentList.add(new Student("Nghia",45, Gender.Male));
        studentList.add(new Student("Thuan",26, Gender.Female));
        studentList.add(new Student("Hai",7, Gender.Male));
    }
}
