/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business;

import lk.ijse.restaurantmgt.business.custom.impl.AccountBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.BookingTableBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.ChefBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.CustomerBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.FoodBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.FoodOrderDetailBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.IngrediantBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.MealOrderBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.RecipyBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.TableBookBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.TableDetailBOImpl;

/**
 *
 * @author CHALO
 */
public class BOFactory {
    
    public enum BOTypes{
        BOOKINGTABLE,CHEF,CUSTOMER,FOOD,INGREDIANT,FOODORDERDETAIL,MEALORDER,RECIPY,TABLEBOOK,TABLEDETAIL,ACCOUNT
    }
    
    private static BOFactory boFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    
    public <T extends SuperBO > T getBO(BOTypes boType){
        switch(boType){
            case BOOKINGTABLE:
                return (T) new BookingTableBOImpl();
            case CHEF:
                return (T) new ChefBOImpl();
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case FOOD:
                return (T) new FoodBOImpl();
            case INGREDIANT:
                return (T) new IngrediantBOImpl();
            case FOODORDERDETAIL:
                return (T) new FoodOrderDetailBOImpl();
            case MEALORDER:
                return (T) new MealOrderBOImpl();
            case RECIPY:
                return (T) new RecipyBOImpl();
            case TABLEBOOK:
                return (T) new TableBookBOImpl();
            case TABLEDETAIL:
                return (T) new TableDetailBOImpl();
            case ACCOUNT:
                return (T) new AccountBOImpl();
            default:
                return null;
        }
        
    }
    

    
}
