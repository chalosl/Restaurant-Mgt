/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.RecipyBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.IngrediantDAO;
import lk.ijse.restaurantmgt.dao.custom.RecipyDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.RecipyDAOImpl;
import lk.ijse.restaurantmgt.entity.Recipy;
import lk.ijse.restaurantmgt.model.RecipyDTO;

/**
 *
 * @author CHALO
 */
public class RecipyBOImpl implements RecipyBO{
    
    private RecipyDAO recipyDAO;
    private IngrediantDAO ingrediantDAO;
    
    public RecipyBOImpl(){
        this.recipyDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECIPY);
        this.ingrediantDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INGREDIANT);
        
    }

    @Override
    public boolean addRecipy(RecipyDTO recipy) throws Exception {
        return recipyDAO.save(new Recipy(recipy.getFoodId(),recipy.getFoodName(),recipy.getIngrediantId(),recipy.getIngrediant_Name()));
    }

    @Override
    public boolean updateRecipy(RecipyDTO recipy) throws Exception {
        return recipyDAO.update(new Recipy(recipy.getFoodId(),recipy.getFoodName(),recipy.getIngrediantId(),recipy.getIngrediant_Name()));
    }

    @Override
    public RecipyDTO searchRecipy(String foodId) throws Exception {
       Recipy recipy=recipyDAO.search(foodId);
       return new RecipyDTO(recipy.getFoodId(),recipy.getFoodName(),recipy.getIngrediantId(),recipy.getIngrediant_Name());
    }

    @Override
    public boolean deleteRecipy(String foodId) throws Exception {
        return recipyDAO.delete(foodId);
    }

    @Override
    public ArrayList<RecipyDTO> getAllRecipy() throws Exception {
         ArrayList<Recipy>recipies=recipyDAO.getAll();
        ArrayList<RecipyDTO>dtos=new ArrayList<>();
        for (Recipy recipy : recipies) {
            dtos.add(new RecipyDTO(recipy.getFoodId(),recipy.getFoodName(),recipy.getIngrediantId(),recipy.getIngrediant_Name()));
            
        }
        return dtos;
        
    }

    @Override
    public ArrayList<String> getAllFoodIds() throws Exception {
        ArrayList<Recipy>allRecipies=new ArrayList<>();
        ArrayList<String> foodIds=new ArrayList<>();
        for (Recipy recipy : allRecipies) {
            foodIds.add(recipy.getFoodId());
        }
        return foodIds;
    }
    
}
