/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import java.util.StringTokenizer;

/**
 *
 * @author Pavani
 */
public class Payments {
    
    
    

    private String recieptNo;
    private String studentID;
    private double amount;
    private int year;
    private int semester;
    
    private String adminID;
    
    
    private String date;
    /**
     * @return the recieptNo
     */
    public String getRecieptNo() {
        return recieptNo;
    }

    /**
     * @param recieptNo the recieptNo to set
     */
    public void setRecieptNo(String recieptNo) {
        this.recieptNo = recieptNo;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

   

    /**
     * @return the adminID
     */
    public String getAdminID() {
        return adminID;
    }

    /**
     * @param adminID the adminID to set
     */
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    /**
     * @return the dateYear
     */
    

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param dateDate the dateDate to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    String dateSetter(String tTime){
        
        String date = null,year = null,month = null,paidDate,countd=null;
        int numberOfTokens;
        StringTokenizer dates=new StringTokenizer(tTime," ");
        numberOfTokens=dates.countTokens();
        System.out.println(dates.countTokens());
        for(int i=0;i<numberOfTokens;i++){
            countd=dates.nextToken();
            
            try{
            if(i==1){
                month=countd;
                System.out.println("Month= "+month);
            }else if(i==2){
                date=countd;
                System.out.println("Date= "+date);
            }else if(i==5){
                year=countd;
                System.out.println("Year= "+year);
            }
            }catch(Exception e){
            System.out.println(e);
        }
            
        }
        
        paidDate=year+"-"+monthNumber(month) +"-"+date;
        System.out.println("Date--D "+paidDate);
        
        return paidDate;
    }
    int monthNumber(String date){
        if(date.equals("Jan")){
            return 1;
        }else if(date.equals("Feb")){
            return 2;
        }else if(date.equals("Mar")){
            return 3;
        }else if(date.equals("Apr")){
            return 4;
        }else if(date.equals("May")){
            return 5;
        }else if(date.equals("Jun")){
            return 6;
        }else if(date.equals("Jul")){
            return 7;
        }else if(date.equals("Aug")){
            return 8;
        }else if(date.equals("Sep")){
            return 9;
        }else if(date.equals("Oct")){
            return 10;
        }else if(date.equals("Nov")){
            return 11;
        }else if(date.equals("Dec")){
            return 12;
        }else{
            return -999;
        }
    
    }
    
}
