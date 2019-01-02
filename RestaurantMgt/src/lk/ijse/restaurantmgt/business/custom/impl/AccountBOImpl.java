/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.AccountBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.AccountDAO;
import lk.ijse.restaurantmgt.entity.Account;
import lk.ijse.restaurantmgt.model.AccountDTO;

/**
 *
 * @author CHALO
 */
public class AccountBOImpl implements AccountBO{
    
    private AccountDAO accountDAO;

    public AccountBOImpl() {
        this.accountDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ACCOUNT);
    }
   
    @Override
    public boolean addUser(AccountDTO login) throws Exception {
       return accountDAO.save(new Account(login.getUsername(),login.getPassword()));
    }

    @Override
    public boolean updateUser(AccountDTO login) throws Exception {
        return accountDAO.update(new Account(login.getUsername(),login.getPassword()));
    }

    @Override
    public boolean deleteUser(String userName) throws Exception {
        return accountDAO.delete(userName);
    }

    @Override
    public AccountDTO searchUser(String userName) throws Exception {
       Account account = accountDAO.search(userName);
       if(account!=null){
           return new AccountDTO(account.getUsername(),account.getPassword());
       }
       return null;
    }

    @Override
    public ArrayList<AccountDTO> getAllUsers() throws Exception {
      ArrayList<Account>accounts = accountDAO.getAll();
      ArrayList<AccountDTO> dtos=new ArrayList<>();
        for (Account account : accounts) {
            dtos.add(new AccountDTO(account.getUsername(),account.getPassword()));  
        }
        return dtos;
    }
    
    
}
