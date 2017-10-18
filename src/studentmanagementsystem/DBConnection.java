/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pavani
 */
public class DBConnection {

    String url = "jdbc:mysql://localhost:3306/student";
    String username = "root";
    String password = "";
    public Connection con = null;
    public PreparedStatement pst = null;
    public ResultSet result = null;

    public DBConnection() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    
}
