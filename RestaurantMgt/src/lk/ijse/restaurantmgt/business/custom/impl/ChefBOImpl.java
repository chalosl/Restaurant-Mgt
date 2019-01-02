/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.ChefBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.ChefDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.ChefDAOImpl;
import lk.ijse.restaurantmgt.entity.Chef;
import lk.ijse.restaurantmgt.model.ChefDTO;

/**
 *
 * @author CHALO
 */
public class ChefBOImpl implements ChefBO{
    
    private ChefDAO chefDAO;
    
    public ChefBOImpl(){
        this.chefDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHEF);
    
    }

    @Override
    public boolean addChef(ChefDTO chef) throws Exception {
       return chefDAO.save(new Chef(chef.getChefID(),chef.getChefName(),chef.getPhoneNumber(),chef.getAddress()));
    }

    @Override
    public boolean updateChef(ChefDTO chef) throws Exception {
       return chefDAO.update(new Chef(chef.getChefID(),chef.getChefName(),chef.getPhoneNumber(),chef.getAddress()));
    }
    
    @Override
    public boolean deleteChef(String chefID) throws Exception {
       return chefDAO.delete(chefID);
    }


    @Override
    public ChefDTO searchChef(String chefID) throws Exception {
        Chef chef=chefDAO.search(chefID);
        if(chef!=null){
             return new ChefDTO(chef.getChefId(),chef.getChefName(),chef.getPhoneNumber(),chef.getAddress());
        }
        return null;
        
    }

  
    @Override
    public ArrayList<ChefDTO> getAllChefs() throws Exception {
        ArrayList<Chef> chefs=chefDAO.getAll();
        ArrayList<ChefDTO> dtos=new ArrayList<>();
        for (Chef e : chefs) {
            dtos.add(new ChefDTO(e.getChefId(),e.getChefName(),e.getPhoneNumber(),e.getAddress()));
            
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getChefIds() throws Exception {
        ArrayList<Chef> allChefs=chefDAO.getAll();
        ArrayList<String> chefIds=new ArrayList<>();
        for (Chef chef: allChefs) {
            chefIds.add(chef.getChefId());
            
        }
        return chefIds;
        
    }
    
}
