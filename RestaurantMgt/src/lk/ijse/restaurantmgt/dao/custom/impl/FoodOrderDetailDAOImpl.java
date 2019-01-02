/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.FoodOrderDetailDAO;
import lk.ijse.restaurantmgt.entity.FoodDetail_PK;
import lk.ijse.restaurantmgt.entity.FoodOrderDetail;

/**
 *
 * @author CHALO
 */
public class FoodOrderDetailDAOImpl implements FoodOrderDetailDAO{

    @Override
    public boolean save(FoodOrderDetail entity) throws Exception {
         return CrudUtil.executeUpdate("insert into foodorderdetail values(?,?,?,?,?)" ,entity.getFoodDetail_PK().getCustomerId(),entity.getFoodDetail_PK().getFoodId(),entity.getFoodDetail_PK().getMealId(),entity.getMealQty(),entity.getAmmountOrder())>0;
    }

    @Override
    public boolean update(FoodOrderDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public ArrayList<FoodOrderDetail> getAll() throws Exception {
        ArrayList<FoodOrderDetail> allFoods=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from foodorderdetail");
        while(rst.next()){
            allFoods.add(new FoodOrderDetail(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getDouble(5)));
               
        }
        return allFoods;
    }
    @Override
    public boolean delete(FoodDetail_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FoodOrderDetail search(FoodDetail_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
