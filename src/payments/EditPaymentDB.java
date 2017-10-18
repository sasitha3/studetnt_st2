/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import studentmanagementsystem.DBConnection;

/**
 *
 * @author Pavani
 */
public class EditPaymentDB {

    String query = null;

    boolean editPayments(Payments emp) {
        DBConnection db = new DBConnection();
        String query = "UPDATE payments SET recieptNo=?,studentID=?,amount=?,year=?,semester=?,paidDate=?,adminID=?,edited=?"
                + " WHERE recieptNo='" + emp.getRecieptNo() + "'";
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);

            db.pst.setString(1, emp.getRecieptNo());//add values to the sql query
            db.pst.setString(2, emp.getStudentID());//add values to the sql query
            db.pst.setDouble(3, emp.getAmount());//add values to the sql query
            db.pst.setInt(4, emp.getYear());//add values to the sql query
            db.pst.setInt(5, emp.getSemester());//add values to the sql query
            db.pst.setString(6, emp.getDate());//add values to the sql query
            db.pst.setString(7, emp.getAdminID());//add values to the sql query
            db.pst.setBoolean(8, true);//add values to the sql query
            System.out.println("Line 2");
            db.pst.executeUpdate();//execute the sql query and insert the value to the DB table
            return true;
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

    boolean addEditedPayments(Payments emp) {
        DBConnection db = new DBConnection();
        String query = "INSERT INTO editedpayments VALUE(?,?,?,?,?,?,?,?,CURRENT_DATE( ),CURRENT_TIME())";
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);

            db.pst.setInt(1, 0);//add values to the sql query
            db.pst.setString(2, emp.getRecieptNo());//add values to the sql query
            db.pst.setString(3, emp.getStudentID());//add values to the sql query
            db.pst.setDouble(4, emp.getAmount());//add values to the sql query
            db.pst.setInt(5, emp.getYear());//add values to the sql query
            db.pst.setInt(6, emp.getSemester());//add values to the sql query
            db.pst.setString(7, "2010-01-1");//add values to the sql query
            db.pst.setString(8, "okBabe");//add values to the sql query

            System.out.println("Line 2");
            db.pst.executeUpdate();//execute the sql query and insert the value to the DB table
            return true;
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

    ArrayList<Payments> getPaid(String sId) {
        DBConnection db = new DBConnection();
        String query = "SELECT * FROM payments where studentID='"+sId+"'";
        ArrayList<Payments> list = new ArrayList<Payments>();
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            db.result = db.pst.executeQuery();
            while (db.result.next()) {
                Payments pay = new Payments();
                
                pay.setRecieptNo(db.result.getString(1));
                pay.setStudentID(db.result.getString(2));//add values to the sql query
                pay.setAmount(db.result.getDouble(3));//add values to the sql query
                pay.setYear(db.result.getInt(4));//add values to the sql query
                pay.setSemester(db.result.getInt(5));//add values to the sql query
                pay.setDate(db.result.getString(6));//add values to the sql query
                pay.setAdminID(db.result.getString(7));//add values to the sql query
                
                list.add(pay);
            }
            return list;

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
        return null;
    }
    
     boolean deletePayments(String rcpt_id,Payments emp) {
        DBConnection db = new DBConnection();
        String query = "DELETE FROM payments "
                + " WHERE recieptNo='" +rcpt_id+ "'";
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            System.out.println("Line 2");
            if(addEditedPayments(emp)){
                db.pst.executeUpdate();
                return true;
            }else{
                return false;
            }
            //execute the sql query and insert the value to the DB table
            
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
}
//db.addEditedPayments(list.get(payTable.getSelectedRow()));