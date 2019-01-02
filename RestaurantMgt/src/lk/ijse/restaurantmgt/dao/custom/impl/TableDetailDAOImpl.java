/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.TableDetailDAO;
import lk.ijse.restaurantmgt.entity.Customer;
import lk.ijse.restaurantmgt.entity.TableDetail;

/**
 *
 * @author CHALO
 */
public class TableDetailDAOImpl implements TableDetailDAO {

    @Override
    public boolean save(TableDetail tableDetail) throws Exception {
        return CrudUtil.executeUpdate("insert into bookingtable values(?,?) ",tableDetail.getTableId(),tableDetail.getNumber_of_seats())>0;
    }

    @Override
    public boolean update(TableDetail entity) throws Exception {
        return CrudUtil.executeUpdate("update bookingtable set number_of_seats=? where tableId=? ",entity.getNumber_of_seats(),entity.getTableId())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
         return CrudUtil.executeUpdate("delete from bookingtable where tableId=? ",id)>0;
    }

    @Override
    public TableDetail search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from bookingtable where tableId=? "  ,id);
       if(rst.next()){
           return new TableDetail(rst.getString("tableId"),rst.getInt("number_of__seats"));
       }else{
           return null;
       }
    }

    @Override
    public ArrayList<TableDetail> getAll() throws Exception {
       ArrayList<TableDetail>allTables=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from  bookingtable");
        while(rst.next()){
            allTables.add(new TableDetail(rst.getString(1),
                    rst.getInt(2)));
        }
        return allTables;
    }
    
}
