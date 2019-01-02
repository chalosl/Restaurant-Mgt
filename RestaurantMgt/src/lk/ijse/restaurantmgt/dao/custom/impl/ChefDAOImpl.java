/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.dao.custom.ChefDAO;
import lk.ijse.restaurantmgt.entity.Chef;

/**
 *
 * @author CHALO
 */
public class ChefDAOImpl implements ChefDAO{

    @Override
    public boolean save(Chef chef) throws Exception {
       return CrudUtil.executeUpdate("insert into chef values(?,?,?,?)",chef.getChefId(),chef.getChefName(),chef.getPhoneNumber(),chef.getAddress())>0;
    }

    @Override
    public boolean update(Chef chef) throws Exception {
        return CrudUtil.executeUpdate("update chef set chefName=?,phonenumber=?,address=? where chefID=? ", chef.getChefName(),chef.getPhoneNumber(),chef.getAddress(),chef.getChefId())>0;
    }

    @Override
    public boolean delete(String chefId) throws Exception {
        return CrudUtil.executeUpdate("delete from chef where chefID =? ",chefId)>0;
    }

    @Override
    public Chef search(String chefid) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from chef where chefname=? ",chefid);
        if(rst.next()){
            return new Chef(rst.getString("chefid"),rst.getString("chefName"),rst.getInt("phonenumber"),rst.getString("address"));
            
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Chef> getAll() throws Exception {
        ArrayList<Chef>allChefs=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from chef");
        while(rst.next()){
            allChefs.add(new Chef(rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getString(4)));
                    
        }
        return allChefs;
    }
    
}
