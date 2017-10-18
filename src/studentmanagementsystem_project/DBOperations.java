/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class DBOperations {
    
    String url = "jdbc:mysql://localhost:3306/student";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    
   boolean addStudent(StudentDetails sd) {
        try {
             System.out.println("Line 1");
                con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
             System.out.println("line 2");
                String query = "INSERT INTO studentdetails VALUES (?,?,?,?,?,?,?,?)";
             System.out.println("Line 3");
                pst = (PreparedStatement)con.prepareStatement(query);
             System.out.println("Line 4");
             
                pst.setString(1, sd.getStudentID());
                pst.setString(2, sd.getFirstName());
                pst.setString(3, sd.getLastName());
                pst.setInt(4, sd.getAge());
                pst.setString(8, sd.getCourse());
                pst.setString(5, sd.getAddress());
                pst.setString(6, sd.getTelephone());  
                pst.setString(7, sd.getEmail());
             
             pst.executeUpdate();
             System.out.println("Line 5");
             
             return true;
                   
             
             
        } catch(Exception e){
            System.out.print(e);
            return true;
                   
            
        } finally {
            try {
            if(pst != null){
                pst.close();
            }
            
            if(con != null){
                con.close();
            }
            
            } catch(Exception e){
                
            }
        }
        
    }
    
    boolean UpdateStudent(StudentDetails sd) {
        try {
             System.out.println("Line 1");
                con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
             System.out.println("line 2");
                String query = "UPDATE studentdetails SET FirstName = ? , LastName = ? , Age = ? , Address = ? , Telephone = ? , Email = ? , Course = ? WHERE StudentID = ' "+sd.getStudentID()+" ' " ;
             System.out.println("Line 3");
                pst = (PreparedStatement)con.prepareStatement(query);
             System.out.println("Line 4");
             
                pst.setString(1, sd.getFirstName());
                pst.setString(2, sd.getLastName());
                pst.setInt(3, sd.getAge());
                pst.setString(4, sd.getAddress());
                pst.setString(5, sd.getTelephone());  
                pst.setString(6, sd.getEmail());
                pst.setString(7, sd.getCourse());
             
             pst.executeUpdate();
             System.out.println("Line 5");
             
             return true;
                   
             
             
        } catch(Exception e){
            System.out.print(e);
            return true;
                   
            
        } finally {
            try {
            if(pst != null){
                pst.close();
            }
            
            if(con != null){
                con.close();
            }
            
            } catch(Exception e){
                
            }
        }
        
    }
    
}

//public boolean DeleteStudent(StudentDetails){
//          try {
//             System.out.println("Line 1");
//                con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
//             System.out.println("line 2");
//                String query = "UPDATE studentdetails SET FirstName = ? , LastName = ? , Age = ? , Address = ? , Telephone = ? , Email = ? , Course = ? WHERE StudentID = ' "+sd.getStudentID()+" ' " ;
//             System.out.println("Line 3");
//                pst = (PreparedStatement)con.prepareStatement(query);
//             System.out.println("Line 4");
//             
//                pst.setString(1, sd.getFirstName());
//                pst.setString(2, sd.getLastName());
//                pst.setInt(3, sd.getAge());
//                pst.setString(4, sd.getAddress());
//                pst.setString(5, sd.getTelephone());  
//                pst.setString(6, sd.getEmail());
//                pst.setString(7, sd.getCourse());
//             
//             pst.executeUpdate();
//             System.out.println("Line 5");
//             
//             return true;
//                   
//}