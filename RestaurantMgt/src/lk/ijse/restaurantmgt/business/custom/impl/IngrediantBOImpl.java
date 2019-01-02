/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.IngrediantBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.IngrediantDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.IngrediantDAOImpl;
import lk.ijse.restaurantmgt.entity.Ingrediant;
import lk.ijse.restaurantmgt.model.IngrediantDTO;

/**
 *
 * @author CHALO
 */
public class IngrediantBOImpl implements IngrediantBO{
    
   private IngrediantDAO ingrediantDAO;
   
   public IngrediantBOImpl(){
       this.ingrediantDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INGREDIANT);
       
   }

   

    @Override
    public boolean addIngrediant(IngrediantDTO ingrediant) throws Exception {
        return ingrediantDAO.save(new Ingrediant(ingrediant.getIngrediantID(),ingrediant.getName(),ingrediant.getQuantity()));
    }

    @Override
    public boolean updateIngrediant(IngrediantDTO ingrediant) throws Exception {
        return ingrediantDAO.update(new Ingrediant(ingrediant.getIngrediantID(),ingrediant.getName(),ingrediant.getQuantity()));
    }

    @Override
    public boolean deleteIngrediant(String ingrediantID) throws Exception {
        return ingrediantDAO.delete(ingrediantID);
    }

    @Override
    public IngrediantDTO searchIngrediant(String ingrediantID) throws Exception {
       Ingrediant ingrediant=ingrediantDAO.search(ingrediantID);
       return new IngrediantDTO(ingrediant.getIngrediantID(),ingrediant.getName(),ingrediant.getQuantity());
    }

   

    @Override
    public ArrayList<String> getAllIngrediantIds() throws Exception {
        ArrayList<Ingrediant>allIngrediants=ingrediantDAO.getAll();
        ArrayList<String> ingrediantIds=new ArrayList<>();
        for (Ingrediant ingrediant : allIngrediants) {
            ingrediantIds.add(ingrediant.getIngrediantID());
        }
        return ingrediantIds;
    }


    @Override
    public ArrayList<IngrediantDTO> getAllIngrediant() throws Exception {
        ArrayList<Ingrediant>ingrediants=ingrediantDAO.getAll();
        ArrayList<IngrediantDTO>dtos=new ArrayList<>();
        for (Ingrediant ingrediant : ingrediants) {
            dtos.add(new IngrediantDTO(ingrediant.getIngrediantID(),ingrediant.getName(),ingrediant.getQuantity()));
            
        }
        return dtos;
    }

   
    
}
