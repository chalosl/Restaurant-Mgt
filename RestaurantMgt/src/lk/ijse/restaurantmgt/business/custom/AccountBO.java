/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.AccountDTO;

/**
 *
 * @author CHALO
 */
public interface AccountBO extends SuperBO{
    public boolean addUser(AccountDTO login)throws Exception;
    
    public boolean updateUser(AccountDTO login)throws Exception;
    
    public boolean deleteUser(String userName)throws Exception;
    
    public AccountDTO searchUser(String userName)throws Exception;
    
    public ArrayList<AccountDTO> getAllUsers()throws Exception;
}
