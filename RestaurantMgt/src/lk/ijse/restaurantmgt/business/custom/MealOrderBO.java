/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.MealOrderDTO;

/**
 *
 * @author CHALO
 */
public interface MealOrderBO extends SuperBO {
    
    public boolean addOrder(MealOrderDTO mealOrder)throws Exception;


   
    
}
