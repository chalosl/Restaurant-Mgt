/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.RecipyDAO;
import lk.ijse.restaurantmgt.entity.Recipy;

/**
 *
 * @author CHALO
 */
public class RecipyDAOImpl implements RecipyDAO{

    @Override
    public boolean save(Recipy recipy) throws Exception {
       return CrudUtil.executeUpdate("insert into recipy values(?,?,?,?)",recipy.getFoodId(),recipy.getFoodName(),recipy.getIngrediantId(),recipy.getIngrediant_Name())>0;
    }

    @Override
    public boolean update(Recipy recipy) throws Exception {
        return CrudUtil.executeUpdate("update recipy set foodName=?,ingrediantId=?,ingrediant_Name=? where foodId=? ",recipy.getFoodName(),recipy.getIngrediantId(),recipy.getIngrediant_Name(),recipy.getFoodId())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("delete from recipy where foodId=? ",id)>0;
    }

    @Override
    public Recipy search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from recipy where foodId=? ",id);
        if(rst.next()){
            return new Recipy(rst.getString("foodId"),rst.getString("foodName"),rst.getString("ingrediantId"),rst.getString("ingrediant_Name"));
            
        }else{
            return null;
        }    }

    @Override
    public ArrayList<Recipy> getAll() throws Exception {
        ArrayList<Recipy>allRecipy=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from Recipy");
        while(rst.next()){
            allRecipy.add(new Recipy(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
                    
        }
        return allRecipy;
    }
    
}
