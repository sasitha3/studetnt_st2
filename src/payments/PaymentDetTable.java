/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pavani
 */
public class PaymentDetTable extends AbstractTableModel {

    private static final String[] COLOUMN_NAMES = {"Reciept No", "Student ID", "Amount", "Year", "Semester", "Paid Date"};
    private static ArrayList<Payments> list;
    
    public PaymentDetTable(ArrayList<Payments> payList) {
        list=payList;
    }
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLOUMN_NAMES.length;
    }

    public String getColumnName(int columnIndex) {
        return COLOUMN_NAMES[columnIndex];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){
            case 0:
                return list.get(rowIndex).getRecieptNo();
            case 1:
                return list.get(rowIndex).getStudentID();
            case 2:
                return list.get(rowIndex).getAmount();
            case 3:
                return list.get(rowIndex).getYear();
            case 4:
                return list.get(rowIndex).getSemester();
            case 5:
                return list.get(rowIndex).getDate();
            case 6:
                return list.get(rowIndex).getAdminID();
            default:
                return "Error";
            
        }
    }
}
