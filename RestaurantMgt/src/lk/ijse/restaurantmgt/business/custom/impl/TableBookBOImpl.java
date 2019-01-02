/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.TableBookBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.CustomerDAO;
import lk.ijse.restaurantmgt.dao.custom.TableBookDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.TableBookDAOImpl;
import lk.ijse.restaurantmgt.entity.TableBook;
import lk.ijse.restaurantmgt.model.TableBookDTO;

/**
 *
 * @author CHALO
 */
public class TableBookBOImpl implements TableBookBO {
    
     private TableBookDAO tableBookDAO;
     
     
     public TableBookBOImpl(){
         this.tableBookDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TABLEBOOK);
         
     }

    @Override
    public boolean addTable(TableBookDTO tableBook) throws Exception {
        return tableBookDAO.save(new TableBook(tableBook.getTableId(),tableBook.getNumber_of_seats()));
    }

    @Override
    public boolean updateTable(TableBookDTO tableBook) throws Exception {
       return tableBookDAO.update(new TableBook(tableBook.getTableId(),tableBook.getNumber_of_seats()));
    }

    @Override
    public TableBookDTO searchTable(String tabelId) throws Exception {
       TableBook table=tableBookDAO.search(tabelId);
       if(table!=null){
            return new TableBookDTO(table.getTableId(),table.getNumber_of_seats());
       }
       return null;
    }

    @Override
    public boolean deleteTable(String tableId) throws Exception {
        return tableBookDAO.delete(tableId);
    }

    @Override
    public ArrayList<TableBookDTO> getAllTable() throws Exception {
        ArrayList<TableBook> table=tableBookDAO.getAll();
        ArrayList<TableBookDTO> dtos=new ArrayList<>();
        for (TableBook e : table) {
            dtos.add(new TableBookDTO(e.getTableId(),e.getNumber_of_seats()));  
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllTableIds() throws Exception {
        ArrayList<TableBook> allTables=tableBookDAO.getAll();
        ArrayList<String> tablesIds= new ArrayList<>();
        for (TableBook table : allTables) {
              tablesIds.add(table.getTableId());
        }
        return tablesIds;
            
        }
    
    
}
