/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pavani
 */
public class StudentDetails extends AbstractTableModel{
    
    private static final String[] COLUMN_NAME={"Student ID","First Name","Last Name","Age","Address","Telephone","Email","Course"};
    private static ArrayList<Student> list;

    public StudentDetails(ArrayList<Student> stList) {
        list=stList;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }
    
    
    public String getColumnName(int columnIndex) {
        return COLUMN_NAME[columnIndex];
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getStudentID();
            case 1:
                return list.get(rowIndex).getFname();
            case 2:
                return list.get(rowIndex).getLname();
            case 3:
                return list.get(rowIndex).getAge();
            case 4:
                return list.get(rowIndex).getAddress();
            case 5:
                return list.get(rowIndex).getTelephoneNumber();
             case 6:
                return list.get(rowIndex).getEmail();
            case 7:
                return list.get(rowIndex).getCourse();
            default:
                return "Error";
            
        }
    }
    
}
