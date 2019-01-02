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
public class BookingTable {
    private String tableId;
    private String customerId;
    private String date;
    private String time;

    public BookingTable() {
    }

    public BookingTable(String tableId, String customerId, String date, String time) {
        this.tableId = tableId;
        this.customerId = customerId;
        this.date = date;
        this.time = time;
    }

    /**
     * @return the tableId
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * @param tableId the tableId to set
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BookingTable{" + "tableId=" + tableId + ", customerId=" + customerId + ", date=" + date + ", time=" + time + '}';
    }

   

    
    
    
}
