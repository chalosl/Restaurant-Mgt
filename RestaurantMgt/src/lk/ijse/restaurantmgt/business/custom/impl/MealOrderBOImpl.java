/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.sql.Connection;
import lk.ijse.restaurantmgt.business.custom.MealOrderBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.CustomerDAO;
import lk.ijse.restaurantmgt.dao.custom.FoodDAO;
import lk.ijse.restaurantmgt.dao.custom.FoodOrderDetailDAO;
import lk.ijse.restaurantmgt.dao.custom.MealOrderDAO;
import lk.ijse.restaurantmgt.db.DBConnection;
import lk.ijse.restaurantmgt.entity.FoodItem;
import lk.ijse.restaurantmgt.entity.FoodOrderDetail;
import lk.ijse.restaurantmgt.entity.MealOrder;
import lk.ijse.restaurantmgt.model.FoodOrderDetailDTO;
import lk.ijse.restaurantmgt.model.MealOrderDTO;

/**
 *
 * @author CHALO
 */
public class MealOrderBOImpl implements MealOrderBO{
    
    private CustomerDAO customerDAO;
    private FoodDAO foodDAO;
    private MealOrderDAO mealOrderDAOImpl;
    private FoodOrderDetailDAO foodOrderDetailDAO;

    public MealOrderBOImpl() {
        this.customerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        this.foodDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
        this.foodOrderDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOODORDERDETAIL);
        this.mealOrderDAOImpl=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEALORDER);
    }
  
    @Override
    public boolean addOrder(MealOrderDTO mealOrder) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        try{
            boolean result = mealOrderDAOImpl.save(new MealOrder(mealOrder.getMealId(),mealOrder.getDate(),mealOrder.getTotalM()));
            if(!result){
                return false;
            }
            
            result = foodOrderDetailDAO.save(new FoodOrderDetail(mealOrder.getGetFoodOrderDetailDTO().getCustomerId(),mealOrder.getGetFoodOrderDetailDTO().getFoodId(),mealOrder.getGetFoodOrderDetailDTO().getMealId(),mealOrder.getGetFoodOrderDetailDTO().getQty(),mealOrder.getGetFoodOrderDetailDTO().getTotal()));
                if(!result){
                    connection.rollback();
                    return false;
                }
                FoodItem foodItem=foodDAO.search(mealOrder.getGetFoodOrderDetailDTO().getFoodId());
                int currentQty=foodItem.getQty();
                currentQty=currentQty-mealOrder.getGetFoodOrderDetailDTO().getQty();
                foodItem.setQty(currentQty);
                
                result = foodDAO.update(foodItem);
                if(!result){
                    connection.rollback();
                    return false;
                }
            connection.commit();
            return true;
        }finally{
            connection.setAutoCommit(true);
            
        }        

    }

    

   
}
