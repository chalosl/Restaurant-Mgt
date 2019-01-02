/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.CustomerDAO;
import lk.ijse.restaurantmgt.entity.Customer;

/**
 *
 * @author CHALO
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean save(Customer customer) throws Exception {
       return CrudUtil.executeUpdate("insert into customer values(?,?,?)",customer.getCustomerId(),customer.getCustomerName(),customer.getPhonenumber())>0;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
       return CrudUtil.executeUpdate("update customer set customerName=?,phonenumber=? where CustomerId=? " ,entity.getCustomerName(),entity.getPhonenumber(),entity.getCustomerId())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("delete from customer where customerId=? ",id)>0;
    }

    @Override
    public Customer search(String id) throws Exception {
       ResultSet rst=CrudUtil.executeQuery("select * from customer where customerName=? "  ,id);
       if(rst.next()){
           return new Customer(rst.getString("customerId"),rst.getString("customerName"),rst.getString("phoneNumber"));
       }else{
           return null;
       }
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ArrayList<Customer> alCustomers=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from customer");
        while(rst.next()){
            alCustomers.add(new Customer(rst.getString(1),
                rst.getString(2),
                rst.getString(3)));
        }
        return alCustomers;
        
    }
    
}
