/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.TableBookDTO;

/**
 *
 * @author CHALO
 */
public interface TableBookBO extends SuperBO{
    public boolean addTable(TableBookDTO tableBook)throws Exception;
    
    public boolean updateTable(TableBookDTO tableBook)throws Exception;
    
    public TableBookDTO searchTable(String tabelId)throws Exception;
    
    public boolean deleteTable(String tableId)throws Exception;
    
    public ArrayList<TableBookDTO>getAllTable()throws Exception;
    
    public ArrayList<String>getAllTableIds()throws Exception;
    
}
