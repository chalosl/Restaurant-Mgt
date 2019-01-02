/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.entity;

/**
 *
 * @author CHALO
 */
public class Customer {
    private String customerId;
    private String customerName;
    private String phonenumber;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String phoneNUmber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phonenumber = phoneNUmber;
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
    public void setCustomerID(String customerID) {
        this.customerId = customerID;
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
     * @return the phoneNUmber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phoneNUmber to set
     */
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", phonenumber=" + phonenumber + '}';
    }

    public void setPhonenumber(String phoneNUmber) {
        this.phonenumber = phonenumber;
    }
    

    
    
}
