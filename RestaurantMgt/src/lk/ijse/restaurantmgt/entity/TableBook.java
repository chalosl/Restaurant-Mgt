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
public class TableBook {
    private String tableId;
    private int  number_of_seats;

    public TableBook() {
    }

    public TableBook(String tableId, int number_of_seats) {
        this.tableId = tableId;
        this.number_of_seats = number_of_seats;
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
     * @return the number_of_seats
     */
    public int getNumber_of_seats() {
        return number_of_seats;
    }

    /**
     * @param number_of_seats the number_of_seats to set
     */
    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    @Override
    public String toString() {
        return "TableBook{" + "tableId=" + tableId + ", number_of_seats=" + number_of_seats + '}';
    }
    
    
    
}
