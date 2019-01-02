/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.IngrediantBO;
import lk.ijse.restaurantmgt.business.custom.impl.IngrediantBOImpl;
import lk.ijse.restaurantmgt.common.IDGenerator;
import lk.ijse.restaurantmgt.model.IngrediantDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author CHALO
 */
public class IngrediantController implements Initializable{
    
    public static IngrediantBO ingrediantBO;
    
    public IngrediantController(){
        ingrediantBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.INGREDIANT);
    }
    
    @FXML
    private JFXTextField txtIngrediantName;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton bynCancel;

    @FXML
    private JFXTextField txtIngrediantSearch;

    @FXML
    private JFXButton bynAddNewIng;

    @FXML
    private TableView<IngrediantDTO> tblIngrediant;

    @FXML
    private JFXTextField txtIngrediantId;

    @FXML
    private JFXButton bynAddNewIng1;

    @FXML
    private JFXButton bynAddNewIng2;

    @FXML
    void addNewMouseClicked(MouseEvent event) {
        txtIngrediantId.setText("");
        txtIngrediantName.setText("");
        txtQty.setText("");
        

    }

    @FXML
    void cancelMouseClick(MouseEvent event) {
        txtIngrediantId.setText("");
        txtIngrediantName.setText("");
        txtQty.setText("");

    }

    @FXML
    void deleteMouseClick(MouseEvent event) throws Exception {
        if(validate()){
            boolean deleted=ingrediantBO.deleteIngrediant(txtIngrediantId.getText());
            if(deleted){
                Alert delete=new Alert(Alert.AlertType.INFORMATION,"Succesfully Deleted",ButtonType.OK);
                delete.show();
                clearIngrediantText();
                loadIngrediant();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Somthing went wrong",ButtonType.OK);
                error.show();
            }
        }

    }

    @FXML
    void onActionIngrediantName(ActionEvent event) {
       String ingrediantName=txtIngrediantName.getText();
       if(!ingrediantName.matches("[A-Za-z .]+")){
           Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Ingrediant Name",ButtonType.OK);
           a.show();
           txtIngrediantName.selectAll();
          // txtIngrediantName.setStyle("-fx-background-color: red;");
           txtIngrediantName.requestFocus();
        }else{
          // txtIngrediantName.setStyle("-fx-background-color: white;");
           txtQty.requestFocus();
       }
    }

    @FXML
    void onActionQty(ActionEvent event) {
        String qty=txtQty.getText();
        if(!qty.matches("[0-9 .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Ingrediant Qty",ButtonType.OK);
            a.show();
            txtQty.selectAll();
            //txtQty.setStyle("-fx-background-color: red;");
            txtQty.requestFocus();
        }else{
            //txtQty.setStyle("-fx-background-color: white;");
            btnSave.requestFocus();
            
        }

    }

    @FXML
    void onActioningrediantID(ActionEvent event) {
        String ingrediantId=txtIngrediantId.getText();
        if(!ingrediantId.matches("[I]{1}[0-9]{3}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Ingrediant ID",ButtonType.OK);
            a.show();
            txtIngrediantId.selectAll();
            txtIngrediantId.setStyle("-fx-background-color: red;");
            txtIngrediantId.requestFocus();
        }else{
            txtIngrediantId.setStyle("-fx-background-color: white;");
            txtIngrediantName.requestFocus();
        }

    }

    @FXML
    void saveMouseClick(MouseEvent event) throws Exception {
        if(validate()){
            int qty=Integer.parseInt(txtQty.getText());
            IngrediantDTO ingrediant=new IngrediantDTO(txtIngrediantId.getText(),txtIngrediantName.getText(),qty);
            boolean isAdded=ingrediantBO.addIngrediant(ingrediant);
            if(isAdded){
                Alert added=new Alert(Alert.AlertType.INFORMATION,"SuccessFully Added",ButtonType.OK);
                added.show();
                clearIngrediantText();
                loadIngrediant();
                setIngrediantId();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Somthing Wrong",ButtonType.OK);
                error.show();
            }
        }
    }

    @FXML
    void updateMouseClick(MouseEvent event) throws Exception {
        if(validate()){
            int qty=Integer.parseInt(txtQty.getText());
            IngrediantDTO ingrediant=new IngrediantDTO(txtIngrediantId.getText(),txtIngrediantName.getText(),qty);
            boolean isUpdated=ingrediantBO.updateIngrediant(ingrediant);
            if(isUpdated){
                Alert updat=new Alert(Alert.AlertType.INFORMATION,"SuccessFully Updated",ButtonType.OK);
                updat.show();
                clearIngrediantText();
                loadIngrediant();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Somthing went wrong",ButtonType.OK);
                error.show();
            }
        }

    }
    
    public void clearIngrediantText(){
        txtIngrediantId.clear();
        txtIngrediantName.clear();
        txtQty.clear();
        
    }
    
    public boolean validate(){
        if(txtIngrediantId.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Ingrediant Id is Empty",ButtonType.OK);
            a.show();
            return false;
        }else{
            if(txtIngrediantName.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Ingrediant Name is Empty",ButtonType.OK);
                a.show();
                return false;
            }else{
                if(txtQty.getText().trim().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.WARNING,"Ingrediant Quantity is Empty",ButtonType.OK);
                    a.show();
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> names = new ArrayList<>();
        try {
            for (IngrediantDTO ingrediantDTO : ingrediantBO.getAllIngrediant()) {
                names.add(ingrediantDTO.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextFields.bindAutoCompletion(txtIngrediantSearch, names);
        
        
        
        tblIngrediant.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ingrediantID"));
        tblIngrediant.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblIngrediant.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        try{
            loadIngrediant();
            
        }catch(Exception e){
            e.printStackTrace();
        }  
        try {
            try {
                setIngrediantId();
            } catch (IOException ex) {
                Logger.getLogger(IngrediantController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
             txtIngrediantName.requestFocus();
            Logger.getLogger(IngrediantController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngrediantController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
   

    private void loadIngrediant() throws Exception {
        tblIngrediant.setItems(FXCollections.observableArrayList(ingrediantBO.getAllIngrediant()));   
    
    }
    @FXML
    void tblMouseClick(MouseEvent event) {
        IngrediantDTO selectedItem=tblIngrediant.getSelectionModel().getSelectedItem();
        txtIngrediantId.setText(selectedItem.getIngrediantID());
        txtIngrediantName.setText(selectedItem.getName());
        txtQty.setText(selectedItem.getQuantity()+"");
     

    }
     @FXML
    void searchIngrediant(ActionEvent event) throws Exception {
        String ingrediantId=txtIngrediantSearch.getText();
        IngrediantDTO ingrediant=ingrediantBO.searchIngrediant(ingrediantId);
        if(ingrediant!=null){
            txtIngrediantId.setText(ingrediant.getIngrediantID());
            txtIngrediantName.setText(ingrediant.getName());
            txtQty.setText(ingrediant.getQuantity()+"");
        }

    }

    private void setIngrediantId() throws SQLException, ClassNotFoundException, IOException {
        String ingrediantId;
        ingrediantId=IDGenerator.getNewID("Ingrediant", "ingrediantId", "I");
        txtIngrediantId.setText(ingrediantId);
       
    }


    
}
