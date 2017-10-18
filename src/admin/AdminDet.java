/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author Pavani
 */
public class AdminDet {
    
    public static String adminIDLog;//check admin loggin 

    private String regID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String paymentPW;

    /**
     * @return the regID
     */
    public String getRegID() {
        return regID;
    }

    /**
     * @param regID the regID to set
     */
    public void setRegID(String regID) {
        this.regID = regID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the paymentPW
     */
    public String getPaymentPW() {
        return paymentPW;
    }

    /**
     * @param paymentPW the paymentPW to set
     */
    public void setPaymentPW(String paymentPW) {
        this.paymentPW = paymentPW;
    }
    AdminDB admin = new AdminDB();

    public AdminDet adminDetails(String userName) {
        AdminDet ad = new AdminDet();

        return admin.adminDetais(ad, userName);

    }
}
