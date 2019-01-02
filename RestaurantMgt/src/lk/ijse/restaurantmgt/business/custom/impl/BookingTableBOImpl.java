/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.BookingTableBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.BookingTableDAO;
import lk.ijse.restaurantmgt.dao.custom.TableBookDAO;
import lk.ijse.restaurantmgt.dao.custom.TableDetailDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.BookingTableDAOImpl;
import lk.ijse.restaurantmgt.entity.BookingTable;
import lk.ijse.restaurantmgt.model.BookingTableDTO;

/**
 *
 * @author CHALO
 */
public class BookingTableBOImpl implements BookingTableBO {
    
    private BookingTableDAO bookingTableDAO;
    private TableBookDAO tableBookDAO;
    private TableDetailDAO tableDetailDAO;
    
    public BookingTableBOImpl(){
        this.bookingTableDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKINGTABLE);
        this.tableBookDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TABLEBOOK);
        this.tableDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TABLEDETAIL);
    }

    @Override
    public boolean bookTable(BookingTableDTO bookTable) throws Exception {
        return bookingTableDAO.save(new BookingTable(bookTable.getTableID(),bookTable.getCustomerID(),bookTable.getDate(),bookTable.getTime()));

    }

    @Override
    public boolean updateBooking(BookingTableDTO bookingTable) throws Exception {
        return bookingTableDAO.update(new BookingTable(bookingTable.getTableID(),bookingTable.getCustomerID(),bookingTable.getDate(),bookingTable.getTime()));
    }

    @Override
    public BookingTableDTO searchTable(String tabelId) throws Exception {
        BookingTable bookingTable=bookingTableDAO.search(tabelId);
        if(bookingTable!=null){
            return new BookingTableDTO(bookingTable.getTableId(),bookingTable.getCustomerId(),bookingTable.getDate(),bookingTable.getTime());
        }
        return null;
    }

    @Override
    public boolean deleteBooking(String tableId) throws Exception {
        return bookingTableDAO.delete(tableId);
    }

    @Override
    public ArrayList<BookingTableDTO> getAllBooking() throws Exception {
        ArrayList<BookingTable>allBooking=bookingTableDAO.getAll();
        ArrayList<BookingTableDTO>table=new ArrayList<>();
        for(BookingTable e : allBooking){
            BookingTableDTO book = new BookingTableDTO();
            book.setCustomerID(e.getCustomerId());
            book.setDate(e.getDate());
            book.setTableID(e.getTableId());
            book.setTime(e.getTime());
            table.add(book);
           
        }
        return table;
    }

    @Override
    public ArrayList<String> getAllTableIds() throws Exception {
       ArrayList<BookingTable> allBookings=bookingTableDAO.getAll();
       ArrayList<String>tableIds=new ArrayList<>();
        for (BookingTable bookingTable : allBookings) {
            tableIds.add(bookingTable.getTableId());
            
        }
        return tableIds;
    }

   

       
}
