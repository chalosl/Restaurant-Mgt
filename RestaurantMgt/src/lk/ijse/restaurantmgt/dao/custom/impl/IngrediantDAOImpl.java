/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.entity.Ingrediant;
import lk.ijse.restaurantmgt.dao.custom.IngrediantDAO;

/**
 *
 * @author CHALO
 */
public class IngrediantDAOImpl implements IngrediantDAO{

    @Override
    public boolean save(Ingrediant ingrediant) throws Exception {
       return CrudUtil.executeUpdate("insert into ingrediant values(?,?,?)",ingrediant.getIngrediantID(),ingrediant.getName(),ingrediant.getQuantity())>0;
    }

    @Override
    public boolean update(Ingrediant entity) throws Exception {
       return CrudUtil.executeUpdate("update ingrediant set name=?,qty=? where  ingrediantId=? ", entity.getName(),entity.getQuantity(),entity.getIngrediantID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("delete from ingrediant where ingrediantId=? " , id)>0;
    }

    @Override
    public Ingrediant search(String id) throws Exception {
       ResultSet rst=CrudUtil.executeQuery("select * from ingrediant where name=? " ,id);
       if(rst.next()){
           return new Ingrediant(rst.getString("ingrediantId"),rst.getString("name"),rst.getInt("qty"));
       }
       return null;
    }

    @Override
    public ArrayList<Ingrediant> getAll() throws Exception {
      ArrayList<Ingrediant>alIngrediants=new ArrayList();
      ResultSet rst=CrudUtil.executeQuery("select * from ingrediant");
      while(rst.next()){
          alIngrediants.add(new Ingrediant(rst.getString(1),
                  rst.getString(2),
                  rst.getInt(3)));
      }
      return alIngrediants;
    }
    
}
