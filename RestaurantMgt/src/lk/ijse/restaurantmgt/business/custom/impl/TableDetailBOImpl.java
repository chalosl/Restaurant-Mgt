/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.custom.TableDetailBO;
import lk.ijse.restaurantmgt.dao.DAOFactory;
import lk.ijse.restaurantmgt.dao.custom.TableDetailDAO;
import lk.ijse.restaurantmgt.dao.custom.impl.TableDetailDAOImpl;
import lk.ijse.restaurantmgt.entity.TableDetail;
import lk.ijse.restaurantmgt.model.TableDetailDTO;

/**
 *
 * @author CHALO
 */
public class TableDetailBOImpl implements TableDetailBO {
    
    private TableDetailDAO tableDetailDAO;
    
    public TableDetailBOImpl(){
        this.tableDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TABLEDETAIL);
        
    }

    @Override
    public boolean addTable(TableDetailDTO tableDetail) throws Exception {
        return tableDetailDAO.save(new TableDetail(tableDetail.getTableId(),tableDetail.getNumber_of_seats()));
        
    }

    @Override
    public boolean updateTable(TableDetailDTO tableDetail) throws Exception {
        return tableDetailDAO.update(new TableDetail(tableDetail.getTableId(),tableDetail.getNumber_of_seats()));
    }

    @Override
    public boolean deleteTable(String tableId) throws Exception {
        return tableDetailDAO.delete(tableId);
    }

    @Override
    public TableDetailDTO searchTable(String tableId) throws Exception {
       TableDetail tableDetail=tableDetailDAO.search(tableId);
       if(tableDetail!=null){
            return new TableDetailDTO(tableDetail.getTableId(),tableDetail.getNumber_of_seats());
       }
       return null;
    }

    @Override
    public ArrayList<TableDetailDTO> getAllTables() throws Exception {
        ArrayList<TableDetail> tableDetails=tableDetailDAO.getAll();
        ArrayList<TableDetailDTO> dtos=new ArrayList<>();
        for (TableDetail e : tableDetails) {
            dtos.add(new TableDetailDTO(e.getTableId(),e.getNumber_of_seats()));  
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllTableIds() throws Exception {
        ArrayList<TableDetail> alltableDetails=tableDetailDAO.getAll();
        ArrayList<String> tableIds= new ArrayList<>();
        for (TableDetail tableDetail : alltableDetails) {
              tableIds.add(tableDetail.getTableId());
        }
        return tableIds ;
            
        }
    }
    

