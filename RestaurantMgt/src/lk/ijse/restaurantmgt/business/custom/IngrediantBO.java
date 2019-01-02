/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.IngrediantDTO;

/**
 *
 * @author CHALO
 */
public interface IngrediantBO extends SuperBO{
    
    public boolean addIngrediant(IngrediantDTO ingrediant)throws Exception;
    
    public boolean updateIngrediant(IngrediantDTO ingrediant)throws Exception;
    
    public boolean deleteIngrediant(String ingrediantID)throws Exception;
    
    public IngrediantDTO searchIngrediant(String ingrediantID)throws Exception;
    
    public ArrayList<IngrediantDTO>getAllIngrediant()throws Exception;
    
    public ArrayList<String>getAllIngrediantIds()throws Exception;
    
}
