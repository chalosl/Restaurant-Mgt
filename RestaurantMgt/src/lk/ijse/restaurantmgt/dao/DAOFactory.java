/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao;

import lk.ijse.restaurantmgt.business.custom.impl.BookingTableBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.ChefBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.CustomerBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.FoodBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.IngrediantBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.MealOrderBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.TableBookBOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.AccountDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.BookingTableDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.ChefDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.FoodDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.FoodOrderDetailDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.IngrediantDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.MealOrderDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.RecipyDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.TableBookDAOImpl;
import lk.ijse.restaurantmgt.dao.custom.impl.TableDetailDAOImpl;

/**
 *
 * @author CHALO
 */
public class DAOFactory {
    
    public enum DAOTypes{
       BOOKINGTABLE,CHEF,CUSTOMER,FOOD,FOODORDERDETAIL,INGREDIANT,MEALORDER,RECIPY,TABLEBOOK,TABLEDETAIL,ACCOUNT
    }
    
    private static DAOFactory daoFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    
    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch(daoType){
            case BOOKINGTABLE:
                return (T) new BookingTableDAOImpl();
            case CHEF:
                return (T) new ChefDAOImpl();
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case FOOD:
                return (T) new FoodDAOImpl();
            case FOODORDERDETAIL:
                return (T) new FoodOrderDetailDAOImpl();
            case INGREDIANT:
                return (T) new IngrediantDAOImpl();
            case MEALORDER:
                return (T) new MealOrderDAOImpl();
            case RECIPY:
                return (T) new RecipyDAOImpl();
            case TABLEBOOK:
                return (T) new TableBookDAOImpl();
            case TABLEDETAIL:
                return (T) new TableDetailDAOImpl();
            case ACCOUNT:
                return (T) new AccountDAOImpl();
            default:
                return null;
                        
                
                        
                        
        }
    }
    
    
        
    
}
