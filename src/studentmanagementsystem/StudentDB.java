/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Pavani
 */
public class StudentDB {

    ArrayList<Student> getStudent() {
        DBConnection db = new DBConnection();
        String query = "SELECT * FROM studentdetails";
        ArrayList<Student> list=new ArrayList<Student>();
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);
            db.result=db.pst.executeQuery();
            while(db.result.next()){
                Student stu=new Student();
                stu.setStudentID(db.result.getString(1));
                stu.setFname(db.result.getString(2));
                stu.setLname(db.result.getString(3));
                stu.setAge(db.result.getInt(4));
                stu.setAddress(db.result.getString(5));
                stu.setTelephoneNumber(db.result.getInt(6));
                stu.setEmail(db.result.getString(7));
                stu.setCourse(db.result.getString(8));
                list.add(stu);
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
    
   public boolean searchStudent(String studentId,Student st){
         DBConnection db = new DBConnection();
        String query = "SELECT * from studentdetails where studentID='"+studentId+"'";
        try {
            db.pst = (PreparedStatement) db.con.prepareStatement(query);


            System.out.println("Line 2");
            db.result=db.pst.executeQuery();//execute the sql query and insert the value to the DB table
             while(db.result.next()){
                
                st.setStudentID(db.result.getString(1));
                st.setFname(db.result.getString(2));
                st.setLname(db.result.getString(3));
                st.setAge(db.result.getInt(4));
               st.setAddress(db.result.getString(5));
                st.setTelephoneNumber(db.result.getInt(6));
                st.setEmail(db.result.getString(7));
                st.setCourse(db.result.getString(8));
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
}
