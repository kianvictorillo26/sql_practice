
package testapp.pkg2e;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestAPP2E {
    
    //Connection Method to SQLITE
    public static Connection connectDB() {
  
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:test.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    
    
    

    
    public static void main(String[] args) {
        connectDB();
              Scanner sc = new Scanner(System.in);
        
        

        System.out.println("FIRST NAME: ");
        String fn = sc.nextLine();
        
        System.out.println("LAST NAME: ");
        String ln = sc.nextLine();
        System.out.println("EMAIL: ");
        String ems = sc.nextLine();
        System.out.println("STATUS: ");
        String sts = sc.nextLine();
        
        String sql = " INSERT INTO Students (s_fname, s_lname,  s_email, s_status) VALUES ( ?,?,?,?)";
        
        
        try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement(sql);
                pst.setString (1, fn);
                pst.setString (2, ln);
                pst.setString (3, ems);
                pst.setString (4, sts);
                pst.executeUpdate();
             System.out.println("Succesfully inserted");
                
        }catch(SQLException e){
                 System.out.println(" connection error" +e);
                 
                 }
        }
    }


                 
                 
                 
            
            
                
                
     
        
        
        
        
        
        
   
    

