/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.MealOrderDAO;
import lk.ijse.restaurantmgt.entity.MealOrder;

/**
 *
 * @author CHALO
 */
public class MealOrderDAOImpl implements MealOrderDAO {

    @Override
    public boolean save(MealOrder mealOrder) throws Exception {
        return CrudUtil.executeUpdate("insert into mealorder values(?,?,?)" ,mealOrder.getMealId(),mealOrder.getDate(),mealOrder.getTotalM())>0;
        
    }

    @Override
    public boolean update(MealOrder entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MealOrder search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MealOrder> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
