/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.BookingTableDTO;

/**
 *
 * @author CHALO
 */
public interface BookingTableBO extends SuperBO {
    
    public boolean bookTable(BookingTableDTO bookTable)throws Exception;
    
    public boolean updateBooking(BookingTableDTO bookingTable)throws Exception;
    
    public BookingTableDTO searchTable(String tabelId)throws Exception;
    
    public boolean deleteBooking(String tableId)throws Exception;
    
    public ArrayList<BookingTableDTO>getAllBooking()throws Exception;
    
    public ArrayList<String>getAllTableIds()throws Exception;
            
    
}
