/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.TableDetailDTO;

/**
 *
 * @author CHALO
 */
public interface TableDetailBO extends SuperBO {
    
    public boolean addTable(TableDetailDTO tableDetail)throws Exception;
    
    public boolean updateTable(TableDetailDTO tableDetail)throws Exception;
    
   public boolean deleteTable(String tableId)throws Exception;
    
    public TableDetailDTO searchTable(String ingrediantID)throws Exception;
    
    public ArrayList<TableDetailDTO>getAllTables()throws Exception;
    
    public ArrayList<String>getAllTableIds()throws Exception;
    
}
