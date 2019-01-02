/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.model;

/**
 *
 * @author CHALO
 */
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String phonenumber;

    public CustomerDTO() {
    }

   

    public CustomerDTO(String customerId, String customerName, String phonenumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phonenumber = phonenumber;
    }

    /**
     * @return the customerID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerId(String customerID) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "customerId=" + customerId + ", customerName=" + customerName + ", phonenumber=" + phonenumber + '}';
    }
    

   
    
    
    
}
