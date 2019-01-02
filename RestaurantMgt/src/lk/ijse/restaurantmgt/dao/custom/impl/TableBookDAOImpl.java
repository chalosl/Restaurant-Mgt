/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.TableBookDAO;
import lk.ijse.restaurantmgt.entity.TableBook;

/**
 *
 * @author CHALO
 */
public class TableBookDAOImpl implements TableBookDAO{

    @Override
    public boolean save(TableBook table) throws Exception {
        return CrudUtil.executeUpdate("insert into bookingtable values(?,?)",table.getTableId(),table.getNumber_of_seats())>0;
    }

    @Override
    public boolean update(TableBook table) throws Exception {
        return CrudUtil.executeUpdate("update bookingtable set number_of_seats=?,tableId=? " ,table.getNumber_of_seats(),table.getTableId())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from bookingtable where tableId=? ",id)>0;
    }

    @Override
    public TableBook search(String id) throws Exception {
       ResultSet rst=CrudUtil.executeQuery("select * from bookingtable where tableId=? "  ,id);
       if(rst.next()){
           return new TableBook(rst.getString("tableId"),rst.getInt("number_of_seats"));
       }else{
           return null;
       }
    }

    @Override
    public ArrayList<TableBook> getAll() throws Exception {
        ArrayList<TableBook> allTables=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from bookingtable");
        while(rst.next()){
            allTables.add(new TableBook(rst.getString(1),
                rst.getInt(2)));
                
        }
        return allTables;
    }
    
}
