/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.BookingTableDAO;
import lk.ijse.restaurantmgt.entity.BookingTable;

/**
 *
 * @author CHALO
 */
public class BookingTableDAOImpl implements BookingTableDAO{

    @Override
    public boolean save(BookingTable bookingTable) throws Exception {
        return CrudUtil.executeUpdate("insert into bookingdetail values(?,?,?,?)",bookingTable.getTableId(),bookingTable.getCustomerId(),bookingTable.getDate(),bookingTable.getTime())>0;
    }

    @Override
    public boolean update(BookingTable bookingTable) throws Exception {
       return CrudUtil.executeUpdate("update bookingdetail set customerId=?,date=?,time=? where tableId=? ",bookingTable.getCustomerId(),bookingTable.getDate(),bookingTable.getTime(),bookingTable.getTableId())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("delete from bookingdetail where  tableId=? ",id)>0;
    }

    @Override
    public BookingTable search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from bookingdetail where tableId=? ",id);
        if(rst.next()){
            return new BookingTable(rst.getString("tableId"),rst.getString("customerId"),rst.getString("date"),rst.getString("time"));
        }
        return null;
    }

    @Override
    public ArrayList<BookingTable> getAll() throws Exception {
       ArrayList<BookingTable> allBookings=new ArrayList<>();
       ResultSet rst=CrudUtil.executeQuery("select * from bookingdetail");
       while(rst.next()){
           allBookings.add(new BookingTable(rst.getString(1),
                   rst.getString(2),
                   rst.getString(3),
                   rst.getString(4) ));
       }
       return allBookings;
    }
    
    
    
}
