/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.FoodDAO;
import lk.ijse.restaurantmgt.entity.FoodItem;

/**
 *
 * @author CHALO
 */
public class FoodDAOImpl implements FoodDAO{

    @Override
    public boolean save(FoodItem food) throws Exception {
        return CrudUtil.executeUpdate("insert into foodItem values(?,?,?,?,?)", food.getFoodId(),food.getName(),food.getChefId(),food.getUnitPrice(),food.getQty())>0;
        
    }

    @Override
    public boolean update(FoodItem entity) throws Exception {
       return CrudUtil.executeUpdate("update foodItem set name=?,chefId=? ,unitPrice=?,qty=? where foodId=? ",entity.getName(),entity.getChefId(),entity.getUnitPrice(),entity.getQty(),entity.getFoodId())>0;
    }

    @Override
    public boolean delete(String foodID) throws Exception {
        return CrudUtil.executeUpdate("delete from fooditem where foodId=? ",foodID)>0;
    }

    @Override
    public FoodItem search(String foodid) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from fooditem where name= ? ",foodid);
        if(rst.next()){
            return new FoodItem(rst.getString("foodId"),rst.getString("name"),rst.getString("chefId"),rst.getDouble("unitPrice"),rst.getInt("qty"));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<FoodItem> getAll() throws Exception {
        ArrayList<FoodItem>alFoods=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from fooditem");
        while(rst.next()){
            alFoods.add(new FoodItem(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getInt(5)));
        }
        return alFoods;
    }
    
}
