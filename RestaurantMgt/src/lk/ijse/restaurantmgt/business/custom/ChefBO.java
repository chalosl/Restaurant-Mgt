/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.ChefDTO;

/**
 *
 * @author CHALO
 */
public interface ChefBO extends SuperBO{
    public boolean addChef(ChefDTO chef)throws Exception;
    
    public boolean updateChef(ChefDTO chef)throws Exception;
    
    public ChefDTO searchChef(String chefID)throws Exception;
    
    public boolean deleteChef(String chefID)throws Exception;
    
    public ArrayList<ChefDTO>getAllChefs()throws Exception;
    
    public ArrayList<String>getChefIds()throws Exception;
    
    
    
   
    
    
}
