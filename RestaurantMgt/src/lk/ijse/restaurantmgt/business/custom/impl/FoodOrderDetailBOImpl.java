/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.FoodOrderDetailBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.FoodOrderDetailDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.FoodOrderDetailDAOImpl;
import lk.ijse.restaurantmgt.entity.FoodOrderDetail;
import lk.ijse.restaurantmgt.model.FoodOrderDetailDTO;

/**
 *
 * @author CHALO
 */
public class FoodOrderDetailBOImpl implements FoodOrderDetailBO{
    private FoodOrderDetailDAO foodOrderDetailDAO;
    
    public FoodOrderDetailBOImpl(){
        this.foodOrderDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOODORDERDETAIL);
        
    }

    @Override
    public boolean addFoodOrder(FoodOrderDetailDTO foodOrderDetail) throws Exception {
        return foodOrderDetailDAO.save(new FoodOrderDetail(foodOrderDetail.getCustomerId(),foodOrderDetail.getFoodId(),foodOrderDetail.getMealId(),foodOrderDetail.getQty(),foodOrderDetail.getTotal()));
    }

    @Override
    public FoodOrderDetailDTO searchFood(String mealId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomer(FoodOrderDetailDTO foodOrderDetail) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomer(String mealId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FoodOrderDetailDTO> getAllOrders() throws Exception {
        ArrayList<FoodOrderDetail> foodOrders=foodOrderDetailDAO.getAll();
        ArrayList<FoodOrderDetailDTO> dtos=new ArrayList<>();
        for (FoodOrderDetail foodOrder : foodOrders) {
            dtos.add(new FoodOrderDetailDTO(foodOrder.getFoodDetail_PK().getCustomerId(),foodOrder.getFoodDetail_PK().getFoodId(),foodOrder.getFoodDetail_PK().getMealId(),foodOrder.getMealQty(),foodOrder.getAmmountOrder()));  
        }
        return dtos;
       
    }

    @Override
    public ArrayList<String> getAllOrderIds() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
