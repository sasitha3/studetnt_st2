/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.mysql.jdbc.PreparedStatement;
import studentmanagementsystem.DBConnection;

/**
 *
 * @author Pavani
 */
public class AdminDB {

    String query = null;//queries

    public boolean checkPaymentLog(String adminID, String pw,String uName) {
        DBConnection dbcon = new DBConnection();//create connection
        query = "select paymentPW from admin where adminID='" + adminID + "'AND username='"+uName+"'";//query
        System.out.println("no error 0");//debug 
        try {
            dbcon.pst = (PreparedStatement) dbcon.con.prepareStatement(query);//execute query
            dbcon.result = dbcon.pst.executeQuery();//put results to a variable
            System.out.println("no error 1");//debug
            while (dbcon.result.next()) {
                System.out.println("no error 2");//debug
                if (pw.equals(dbcon.result.getString(1))) {
                    System.out.println("no error 3");//debug
                    return true;
                }//check whethere the values is equal with given value
            }//get selected values from data base
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (dbcon.con != null) {
                    dbcon.con.close();

                }
                if (dbcon.pst != null) {
                    dbcon.pst.close();
                }
            } catch (Exception e) {
            }
        }//close connection for in check payment log  methid
        return false;
    }
    public boolean checkLog(String username, String pw) {
        DBConnection dbcon = new DBConnection();//create connection
        query = "select password from admin where username='" + username + "'";//query
        System.out.println("no error 0");//debug 
        try {
            dbcon.pst = (PreparedStatement) dbcon.con.prepareStatement(query);//execute query
            dbcon.result = dbcon.pst.executeQuery();//put results to a variable
            System.out.println("no error 1");//debug
            while (dbcon.result.next()) {
                System.out.println("no error 2");//debug
                if (pw.equals(dbcon.result.getString(1))) {
                    System.out.println("no error 3");//debug
                    return true;
                }//check whethere the values is equal with given value
            }//get selected values from data base
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (dbcon.con != null) {
                    dbcon.con.close();

                }
                if (dbcon.pst != null) {
                    dbcon.pst.close();
                }
            } catch (Exception e) {
            }
        }//close connection for in check payment log  methid
        return false;
    }

    boolean addAdmin(AdminDet ad) {
        DBConnection db = new DBConnection();
        query = "INSERT INTO admin VALUE(?,?,?,?,?,?,?)";
        try {



            db.pst = (PreparedStatement) db.con.prepareStatement(query);

            db.pst.setString(1, ad.getRegID());//add values to the sql query
            db.pst.setString(2, ad.getFirstName());//add values to the sql query
            db.pst.setString(3, ad.getLastName());//add values to the sql query
            db.pst.setString(4, ad.getUsername());//add values to the sql query
            db.pst.setString(5, ad.getPassword());//add values to the sql query
            db.pst.setString(6, ad.getPaymentPW());//add values to the sql query
            db.pst.setString(7, "0-0-0");
            System.out.println("Admin Line 1: " + ad.getPaymentPW());
            db.pst.executeUpdate();//execute the sql query and insert the value to the DB table
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (db.con != null) {
                    db.con.close();

                }
                if (db.pst != null) {
                    db.pst.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }


        }

    }

    int checkUsernameAndID(String username, String adminID) {
        DBConnection db = new DBConnection();
        query = "SELECT username,adminID FROM admin";
        try {

            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            db.result = db.pst.executeQuery();

            while (db.result.next()) {
                if (adminID.equals(db.result.getString(2))) {
                    if (username.equals(db.result.getString(1))) {
                        return 0; //the user name provided already exists in the db
                    }
                    return 1;
                }
            }
            return 2;//the user name does not provided already exists in the db

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

    void updateAdmin(String username) {
        DBConnection db = new DBConnection();
        query = "UPDATE admin set lastLog =CURRENT_DATE() WHERE username='" + username + "'";
        try {

            db.pst = (PreparedStatement) db.con.prepareStatement(query);

            

            db.pst.executeUpdate();//execute the sql query and insert the value to the DB table

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
                System.out.println(e);
            }
        }
    }
    
    AdminDet adminDetais(AdminDet ad,String username){
        DBConnection db = new DBConnection();
        query = "SELECT adminID,username,fname FROM admin where username='"+username+"'";
        try {

            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            db.result = db.pst.executeQuery();

            while (db.result.next()) {
                ad.setRegID(db.result.getString(1));
                ad.setUsername(db.result.getString(2));
                ad.setFirstName(db.result.getString(3));
            }
               return ad;
           

        } catch (Exception e) {
            System.out.println(e);
            return null;
            
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
