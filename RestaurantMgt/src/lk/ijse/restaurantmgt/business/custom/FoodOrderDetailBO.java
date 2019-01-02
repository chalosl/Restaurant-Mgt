/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.FoodOrderDetailDTO;

/**
 *
 * @author CHALO
 */
public interface FoodOrderDetailBO extends SuperBO {
    public boolean addFoodOrder(FoodOrderDetailDTO foodOrderDetail)throws Exception;
    
    public FoodOrderDetailDTO searchFood(String mealId)throws Exception;
    
    public boolean updateCustomer(FoodOrderDetailDTO foodOrderDetail)throws Exception;
    
    public boolean deleteCustomer(String mealId)throws Exception;
    
    public ArrayList<FoodOrderDetailDTO> getAllOrders()throws Exception;
    
    public ArrayList<String> getAllOrderIds()throws Exception;
    
    
}
