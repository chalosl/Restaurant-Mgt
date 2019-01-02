/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.AccountDAO;
import lk.ijse.restaurantmgt.entity.Account;

/**
 *
 * @author CHALO
 */
public class AccountDAOImpl implements AccountDAO{

    @Override
    public boolean save(Account log) throws Exception {
        return CrudUtil.executeUpdate("insert into loging values(?,?)",log.getUsername(),log.getPassword())>0;
    }

    @Override
    public boolean update(Account log) throws Exception {
       return CrudUtil.executeUpdate("update loging set password=? where username=?", log.getUsername(),log.getPassword())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from loging where username=? ",id)>0;
    }

    @Override
    public Account search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from loging where username=? ",id);
        if(rst.next()){
            return new Account(rst.getString("username"),rst.getString("password"));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Account> getAll() throws Exception {
         ArrayList<Account>allAccounts=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from loging");
        while(rst.next()){
            allAccounts.add(new Account(rst.getString(1),
                    rst.getString(2)));
                    
        }
        return allAccounts;
    }
    
}
