/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import lk.ijse.restaurantmgt.db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CHALO
 */
public class ReportController implements Initializable{
    
    @FXML
    private JFXButton btnCustomer;
    
    @FXML
    private JFXButton btnFood;
    
    @FXML
    private JFXButton btnIngrediant;
    
    @FXML
    private JFXButton btnFoodOrder;

    @FXML
    private JFXButton btnMealOrder;

    @FXML
    private JFXButton btnRecipy;

     
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
     @FXML
    void customerAction(MouseEvent event) throws IOException, SQLException, JRException {
         
         try {
            InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/restaurantmgt/report/customer.jasper");
            HashMap map=new HashMap();
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    void foodAction(MouseEvent event) throws IOException {
        try {
            InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/restaurantmgt/report/food.jasper");
            HashMap map=new HashMap();
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    void chefAction(ActionEvent event) throws IOException {
         try {
            InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/restaurantmgt/report/chef.jasper");
            HashMap map=new HashMap();
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
     @FXML
    void ingrediantAction(ActionEvent event) throws IOException {
        try {
            InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/restaurantmgt/report/ingrediant.jasper");
            HashMap map=new HashMap();
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    void foodOrderAction(ActionEvent event) throws IOException {
         try {
            InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/restaurantmgt/report/foodorder.jasper");
            HashMap map=new HashMap();
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    @FXML
    void mealOrderAction(ActionEvent event) throws IOException {
        try {
            InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/restaurantmgt/report/mealOrder.jasper");
            HashMap map=new HashMap();
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void recipyAction(ActionEvent event) throws IOException {
         try {
            InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/restaurantmgt/report/recipy.jasper");
            HashMap map=new HashMap();
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }




    

}
