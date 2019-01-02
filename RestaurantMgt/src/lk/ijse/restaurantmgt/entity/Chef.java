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
public class Chef {
    private String chefId;
    private String chefName;
    private int phoneNumber;
    private String address;
    

    public Chef() {
    }

    public Chef(String chefId, String chefName, int phoneNumber, String address) {
        this.chefId = chefId;
        this.chefName = chefName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * @return the chefId
     */
    public String getChefId() {
        return chefId;
    }

    /**
     * @param chefId the chefId to set
     */
    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    /**
     * @return the chefName
     */
    public String getChefName() {
        return chefName;
    }

    /**
     * @param chefName the chefName to set
     */
    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Chef{" + "chefId=" + chefId + ", chefName=" + chefName + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }

    
       
}
