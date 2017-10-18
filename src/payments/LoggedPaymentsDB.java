/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import com.mysql.jdbc.PreparedStatement;
import studentmanagementsystem.DBConnection;

/**
 *
 * @author Pavani
 */
public class LoggedPaymentsDB {

    DBConnection db = new DBConnection();
    String query = null;

    void addLog(String id) {
        query = "insert into loggedpay(AdminId,date,time) values('" + id + "', CURRENT_DATE( ) , CURRENT_TIME( ))";//change the getDate later
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            db.pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
