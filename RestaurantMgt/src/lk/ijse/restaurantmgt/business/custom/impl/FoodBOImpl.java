/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.FoodBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.FoodDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.FoodDAOImpl;
import lk.ijse.restaurantmgt.entity.FoodItem;
import lk.ijse.restaurantmgt.model.FoodItemDTO;

/**
 *
 * @author CHALO
 */
public class FoodBOImpl implements FoodBO {
    
    private FoodDAO foodDAO;

    public FoodBOImpl() {
        this.foodDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
       
    }
    
    
    @Override
    public boolean addFood(FoodItemDTO food) throws Exception {
       return foodDAO.save(new FoodItem(food.getFoodId(),food.getName(),food.getChefId(),food.getUnitPrice(),food.getQty()));
    }

    @Override
    public boolean updateFood(FoodItemDTO food) throws Exception {
       return foodDAO.update(new FoodItem(food.getFoodId(),food.getName(),food.getChefId(),food.getUnitPrice(),food.getQty()));
    }
    
   
    @Override
    public FoodItemDTO searchFood(String foodId) throws Exception {
       FoodItem  foodItem=foodDAO.search(foodId);
       if(foodItem!=null){
            return new FoodItemDTO(foodItem.getFoodId(),foodItem.getName(),foodItem.getChefId(),foodItem.getUnitPrice(),foodItem.getQty());
       }
       return null;
    }


    @Override
    public boolean deleteFood(String foodId) throws Exception {
       return foodDAO.delete(foodId);
    }
    
    @Override
    public ArrayList<FoodItemDTO> getAllFoods() throws Exception {
       ArrayList<FoodItem>foods=foodDAO.getAll();
       ArrayList<FoodItemDTO>dtos=new ArrayList<>();
        for (FoodItem foodItem : foods) {
            dtos.add(new FoodItemDTO(foodItem.getFoodId(),foodItem.getName(),foodItem.getChefId(),foodItem.getUnitPrice(),foodItem.getQty()));
            
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllFoodIds() throws Exception {
       ArrayList<FoodItem> allFoods=foodDAO.getAll();
       ArrayList<String> foodItemIds=new ArrayList<>();
       for (FoodItem foodItem : allFoods) {
            foodItemIds.add(foodItem.getFoodId());
            
        }
        return foodItemIds;
       
    }

  
   
    
}
