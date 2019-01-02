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
import lk.ijse.restaurantmgt.business.custom.ChefBO;
import lk.ijse.restaurantmgt.business.custom.impl.ChefBOImpl;
import lk.ijse.restaurantmgt.common.IDGenerator;
import static lk.ijse.restaurantmgt.controller.ChefDetailController.chefBO;
import lk.ijse.restaurantmgt.model.ChefDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author CHALO
 */
public class ChefDetailController implements Initializable{
    
    public static ChefBO chefBO;
    
    public ChefDetailController(){
        chefBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.CHEF);
    }
    
    @FXML
    private JFXTextField txtChefName;

    @FXML
    private JFXTextField txtChefContact;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtChefSearch;

    @FXML
    private JFXButton btnAddNew;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<ChefDTO> tblChef;

    @FXML
    private JFXTextField txtChefID;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;
    

    @FXML
    void addressAction(ActionEvent event) {
        String address=txtAddress.getText();
        if(!address.matches("[A-Za-z .]+")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter Valid Address",ButtonType.OK);
            alert.show();
            txtAddress.selectAll();
            //txtAddress.setStyle("-fx-background-color: red;");
            txtAddress.requestFocus();
        }else{
           // txtAddress.setStyle("-fx-background-color: white;");
           btnSave.requestFocus();
            
        }
       
        
    }

    @FXML
    void cancelMouseClicked(MouseEvent event) {
        txtChefID.setText("");
        txtChefName.setText("");
        txtChefContact.setText("");
        txtAddress.setText("");
        txtChefSearch.setText("");

    }

    @FXML
    void chefContactAction(ActionEvent event) {
        String phone=txtChefContact.getText();
        if(!phone.matches("[0-9]{10}")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter Valid Contact Number", ButtonType.OK);
            alert.show();
            txtChefContact.selectAll();
            //txtChefContact.setStyle("-fx-background-color: red;");
            txtChefContact.requestFocus();
        } else {
           // txtChefContact.setStyle("-fx-background-color: white;");
            txtAddress.requestFocus();
        
        
        }
        
       
    }

    @FXML
    void chefIdAction(ActionEvent event) {
        
        String chef=txtChefID.getText();
        if(!chef.matches("[CH]{2}[0-9]{3}")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter Valid Chef ID", ButtonType.OK);
            alert.show();
            txtChefID.selectAll();
            //txtChefID.setStyle("-fx-background-color: red;");
            txtChefID.requestFocus();
        } else {
            //txtChefID.setStyle("-fx-background-color: white;");
            txtChefName.requestFocus();
        }

    }

    @FXML
    void chefNameAction(ActionEvent event) {
        String chefName=txtChefName.getText();
        if(!chefName.matches("[a-zA-z .]+")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter Valid Chef Name", ButtonType.OK);
            alert.show();
            txtChefName.selectAll();
            //txtChefName.setStyle("-fx-background-color: red;");
            txtChefName.requestFocus();
        } else {
            //txtChefName.setStyle("-fx-background-color: white;");
            txtChefContact.requestFocus();
        }
        
       
    }

    @FXML
    void deleteChef(MouseEvent event) throws Exception {
        if(validate()){
            boolean deleted=chefBO.deleteChef(txtChefID.getText());
            if(deleted){
                Alert delete=new Alert(Alert.AlertType.INFORMATION,"Deleted",ButtonType.OK);
                delete.show();
                loadChef();
                clearChefText();
            }
        }
    }
    @FXML
    void newChefMouseClicked(MouseEvent event) {
        txtChefID.setText("");
        txtChefName.setText("");
        txtChefContact.setText("");
        txtAddress.setText("");
        txtChefSearch.setText("");
    }

    @FXML
    void saveMouseClick(MouseEvent event) throws Exception {
        if(validate()){
            int contactNumber=Integer.parseInt(txtChefContact.getText());
            ChefDTO chef=new ChefDTO(txtChefID.getText(),txtChefName.getText(),contactNumber,txtAddress.getText());
            boolean isAdded=chefBO.addChef(chef);
            if(isAdded){
                Alert added=new Alert(Alert.AlertType.INFORMATION,"SucessFully Added",ButtonType.OK);
                added.show();
                clearChefText();
                loadChef();
                setChefId();

            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Somthing Went Wrong",ButtonType.OK);
                error.show();

            }
        }
        

    }

    @FXML
    void updateMouseClicked(MouseEvent event) throws Exception {
        if(validate()){
            int conatctNumber=Integer.parseInt(txtChefContact.getText());
            ChefDTO chef=new ChefDTO(txtChefID.getText(),txtChefName.getText(),conatctNumber,txtAddress.getText());
            boolean isUpdate=chefBO.updateChef(chef);
            if(isUpdate){
                Alert update=new Alert(Alert.AlertType.INFORMATION,"SucessFully updated",ButtonType.OK);
                update.show();
                loadChef();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Something went wrong",ButtonType.OK);
                error.show();
            }
        }

    }
      @FXML
    void searchChef(ActionEvent event) throws Exception {
       String chefId=txtChefSearch.getText();
       ChefDTO chef=chefBO.searchChef(chefId);
       if(chef!=null){
           txtChefID.setText(chef.getChefID());
           txtChefName.setText(chef.getChefName());
           txtChefContact.setText(chef.getPhoneNumber()+"");
           txtAddress.setText(chef.getAddress());
           
       }
    }
    @FXML
    void chefTableMouseClick(MouseEvent event) {
       ChefDTO selectdItem=tblChef.getSelectionModel().getSelectedItem();
       txtChefID.setText(selectdItem.getChefID());
       txtChefName.setText(selectdItem.getChefName());
       txtChefContact.setText(selectdItem.getPhoneNumber()+"");
       txtAddress.setText(selectdItem.getAddress());
    }
    
    public void clearChefText(){
        txtChefID.clear();
        txtChefName.clear();
        txtChefContact.clear();
        txtAddress.clear();
    }
     public boolean validate(){
        if(txtChefID.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Chef ID is Empty",ButtonType.OK);
            a.show();
            return false; 
        }else{
            if(txtChefName.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Chef Name is Empty",ButtonType.OK);
                a.show();
                return false;
            }else{
                if(txtAddress.getText().trim().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.WARNING,"Chef Address is Empty",ButtonType.OK);
                    a.show();
                    return false;
                }else{
                    if(txtChefContact.getText().trim().isEmpty()){
                        Alert a = new Alert(Alert.AlertType.WARNING,"Chef Contact Number is Empty",ButtonType.OK);
                        a.show();
                        return false;
                    }
                }
            }
        }
        return true;
   
     }
        


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> names = new ArrayList<>();
        try {
            for (ChefDTO chefDTO : chefBO.getAllChefs()) {
                names.add(chefDTO.getChefName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextFields.bindAutoCompletion(txtChefSearch, names);
        
        
        
        tblChef.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("chefID"));
        tblChef.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("chefName"));
        tblChef.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tblChef.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        try{
            loadChef();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            setChefId();
        } catch (SQLException ex) {
            Logger.getLogger(ChefDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChefDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChefDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtChefName.requestFocus();
        
        
       
    }

    private void loadChef() throws Exception {
        tblChef.setItems(FXCollections.observableArrayList(chefBO.getAllChefs()));
        
    }

    private void setChefId() throws SQLException, ClassNotFoundException, IOException {
       String chefId;
       chefId=IDGenerator.getNewID("Chef", "chefId", "CH");
       txtChefID.setText(chefId);
       
       
    }
    
}

   
