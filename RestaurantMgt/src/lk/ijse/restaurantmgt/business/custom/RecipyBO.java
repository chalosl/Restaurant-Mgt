/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.RecipyDTO;

/**
 *
 * @author CHALO
 */
public interface RecipyBO extends SuperBO{
    
     public boolean addRecipy(RecipyDTO recipy)throws Exception;
    
    public boolean updateRecipy(RecipyDTO recipy)throws Exception;
    
    public RecipyDTO searchRecipy(String foodId)throws Exception;
    
    public boolean deleteRecipy(String foodId)throws Exception;
    
    public ArrayList<RecipyDTO>getAllRecipy()throws Exception;
    
    public ArrayList<String>getAllFoodIds()throws Exception;
    
}
