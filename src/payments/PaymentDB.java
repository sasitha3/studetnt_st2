/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import studentmanagementsystem.DBConnection;

/**
 *
 * @author Pavani
 */
public class PaymentDB {

    String query = null;

    int addPayments(Payments emp) {
        DBConnection db = new DBConnection();
        String query = "INSERT INTO payments VALUE(?,?,?,?,?,?,?,?)";
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);

            db.pst.setString(1, emp.getRecieptNo());//add values to the sql query
            db.pst.setString(2, emp.getStudentID());//add values to the sql query
            db.pst.setDouble(3, emp.getAmount());//add values to the sql query
            db.pst.setInt(4, emp.getYear());//add values to the sql query
            db.pst.setInt(5, emp.getSemester());//add values to the sql query
            db.pst.setString(6, emp.getDate());//add values to the sql query
            db.pst.setString(7, emp.getAdminID());//add values to the sql query
            db.pst.setBoolean(8, false);//add values to the sql query
            System.out.println("Line 2");
            db.pst.executeUpdate();//execute the sql query and insert the value to the DB table
            return 0;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("gotError");
                return 1;
            }//get the error code and check whethere the primary key is duplicate and return 1
            else {
                System.out.println(e);
            }//else print the exception 

        } finally {
            try {
                if (db.con != null) {
                    db.con.close();

                }
                if (db.pst != null) {
                    db.pst.close();
                }
            } catch (Exception e) {
            }
        }//close connection for in check payment log  methid
        return -1;

    }

    boolean searchPayments(String sID, int year, int semester, Payments pay) {
        DBConnection db = new DBConnection();
        String query = "SELECT * FROM payments WHERE studentID='" + sID + "' AND year=" + year + " AND semester=" + semester;
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            db.result = db.pst.executeQuery();
            while (db.result.next()) {


                pay.setRecieptNo(db.result.getString(1));
                pay.setStudentID(db.result.getString(2));//add values to the sql query
                pay.setAmount(db.result.getDouble(3));//add values to the sql query
                pay.setYear(db.result.getInt(4));//add values to the sql query
                pay.setSemester(db.result.getInt(5));//add values to the sql query
                pay.setDate(db.result.getString(6));//add values to the sql query
                pay.setAdminID(db.result.getString(7));//add values to the sql query
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                if (db.con != null) {
                    db.con.close();

                }
                if (db.pst != null) {
                    db.pst.close();
                }
            } catch (Exception e) {
            }
        }//close connection for in check payment log  methid
        return false;

    }

    int checkPaymentSemester(String studentID, int year, int semester) {
        DBConnection db = new DBConnection();
        String query = "SELECT studentID,year,semester FROM payments";
        try {



            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            db.result = db.pst.executeQuery();

            while (db.result.next()) {
                if (studentID.equals(db.result.getString(1))) {
                    if (year == db.result.getInt(2) && semester == db.result.getInt(3)) {
                        return 0;
                    }
                }//the student ID 
            }
            return 1;//the user name does not provided already exists in the db

        } catch (Exception e) {
            System.out.println(e);
            return 2;
        } finally {
            try {
                if (db.con != null) {
                    db.con.close();

                }
                if (db.pst != null) {
                    db.pst.close();
                }
            } catch (Exception e) {
            }


        }
    }

}
