/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.CustomerDTO;

/**
 *
 * @author CHALO
 */
public interface CustomerBO extends SuperBO {
    
    public boolean addCustomer(CustomerDTO customer)throws Exception;
    
    public CustomerDTO searchCustomer(String customerID)throws Exception;
    
    public boolean updateCustomer(CustomerDTO customer)throws Exception;
    
    public boolean deleteCustomer(String customerID)throws Exception;
    
    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;
    
    public ArrayList<String> getAllCustomerIds()throws Exception;
    
}
