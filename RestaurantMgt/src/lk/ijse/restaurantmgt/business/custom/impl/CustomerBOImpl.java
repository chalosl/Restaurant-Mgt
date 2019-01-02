/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.CustomerBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.CustomerDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.restaurantmgt.entity.Customer;
import lk.ijse.restaurantmgt.model.CustomerDTO;

/**
 *
 * @author CHALO
 */
public class CustomerBOImpl implements CustomerBO{
        
        private CustomerDAO customerDAO;
        
        public CustomerBOImpl(){
            this.customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
            
        }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.save(new Customer(customer.getCustomerId(),customer.getCustomerName(),customer.getPhonenumber()));
    }

    @Override
    public CustomerDTO searchCustomer(String cutomerID) throws Exception {
      Customer customer = customerDAO.search(cutomerID);
      if(customer != null){
          return new CustomerDTO(customer.getCustomerId(),customer.getCustomerName(),customer.getPhonenumber());
      }
      return null;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(customer.getCustomerId(),customer.getCustomerName(),customer.getPhonenumber()));
    }

    @Override
    public boolean deleteCustomer(String customerID) throws Exception {
        return customerDAO.delete(customerID);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> customers=customerDAO.getAll();
        ArrayList<CustomerDTO> dtos=new ArrayList<>();
        for (Customer e : customers) {
            dtos.add(new CustomerDTO(e.getCustomerId(),e.getCustomerName(),e.getPhonenumber()));  
        }
        return dtos;
       
    }

    @Override
    public ArrayList<String> getAllCustomerIds() throws Exception {
        ArrayList<Customer> allCustomers=customerDAO.getAll();
        ArrayList<String> customerIds= new ArrayList<>();
        for (Customer customer : allCustomers) {
              customerIds.add(customer.getCustomerId());
        }
        return customerIds;
            
        }
    }
  
