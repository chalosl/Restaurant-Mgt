/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import javafx.scene.layout.AnchorPane;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.CustomerBO;
import lk.ijse.restaurantmgt.business.custom.impl.CustomerBOImpl;
import lk.ijse.restaurantmgt.common.IDGenerator;
import lk.ijse.restaurantmgt.model.CustomerDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author CHALO
 */
public class CustomerController implements Initializable{
    
    public static CustomerBO customerBO;

    public CustomerController() {
        customerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    }
    
    
    
    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtCustomerContact;

    @FXML
    private JFXButton btnNewCustomer;

    @FXML
    private JFXTextField txtSearchCustomer;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private JFXTextField txtCustomerID;
    
    
    
    @FXML
    void contactAction(ActionEvent event) {
        String phone=txtCustomerContact.getText();
        if(!phone.matches("[+]{1}[0-9]{11}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Contact Number",ButtonType.OK);
            a.show();
            txtCustomerContact.selectAll();
            //txtCustomerContact.setStyle("-fx-background-color: red;");
            txtCustomerContact.requestFocus();
            
        }else{
            //txtCustomerContact.setStyle("-fx-background-color: white;");
            btnSave.requestFocus();
            
        }
    }

    @FXML
    void customerIdAction(ActionEvent event) {
        String custId=txtCustomerID.getText();
        if(!custId.matches("[C]{1}[0-9]{3}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Customer ID",ButtonType.OK);
            a.show();
            txtCustomerID.selectAll();
            //txtCustomerID.setStyle("-fx-background-color: red;");
            txtCustomerID.requestFocus();
        }else{
           // txtCustomerID.setStyle("-fx-background-color: white;");
            txtCustomerName.requestFocus();
        }
        
        
       

    }

    @FXML
    void customerNameAction(ActionEvent event) {
        String name=txtCustomerName.getText();
        if(!name.matches("[a-zA-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Customer Name",ButtonType.OK);
            a.show();
            txtCustomerName.selectAll();
           // txtCustomerName.setStyle("-fx-background-color: red;");
            txtCustomerName.requestFocus();
        }else{
           // txtCustomerName.setStyle("-fx-background-color: white;");
            txtCustomerContact.requestFocus();   
        }
        
        
    }


    @FXML
    public void addNewCustomer(ActionEvent event) {
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerContact.setText("");
        txtSearchCustomer.setText("");
        
    }

    @FXML
    public void cancelCustomer(ActionEvent event) {
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerContact.setText("");
        txtSearchCustomer.setText("");

    }

    @FXML
    public void loadCustomer(ActionEvent event){
    
    }
   

    @FXML
    public void saveCustomer(ActionEvent event) throws Exception  {
        if(validate()){
            CustomerDTO customer = new CustomerDTO(txtCustomerID.getText(),txtCustomerName.getText(),txtCustomerContact.getText());
            boolean isAdded=customerBO.addCustomer(customer);
            if(isAdded){
                Alert added=new Alert(Alert.AlertType.INFORMATION,"successfully saved !",ButtonType.OK);
                added.show();
                clearCustomerText();
                loadCustomers(); 
                setCustomerId();
            }else{
                Alert error=new Alert(Alert.AlertType.INFORMATION,"Somthing Went Wrong !",ButtonType.OK);
                error.show();


            } 
        }
    }
    
    @FXML
    void customerTableClick(MouseEvent event) {
        CustomerDTO selectedItem=tblCustomer.getSelectionModel().getSelectedItem();
        txtCustomerID.setText(selectedItem.getCustomerId());
        txtCustomerName.setText(selectedItem.getCustomerName());
        txtCustomerContact.setText(selectedItem.getPhonenumber());

    }
    
    public void clearCustomerText(){
        txtCustomerID.clear();
        txtCustomerName.clear();
        txtCustomerContact.clear();
    }
    
    public boolean validate(){
        if(txtCustomerID.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Some Fields Are Empty",ButtonType.OK);
            a.show();
            return false;
        }else{
            if(txtCustomerName.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Some Fields Are Empty",ButtonType.OK);
                a.show();
                return false;    
            }else{
                if(txtCustomerContact.getText().trim().isEmpty()){
                     Alert a = new Alert(Alert.AlertType.WARNING,"Some Fields Are Empty",ButtonType.OK);
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
            for (CustomerDTO customerDTO : customerBO.getAllCustomers()) {
                names.add(customerDTO.getCustomerName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextFields.bindAutoCompletion(txtSearchCustomer, names);
        
        
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        try{
            loadCustomers();   
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try {
            setCustomerId();
            txtCustomerName.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    private void loadCustomers() throws Exception {
        tblCustomer.setItems(FXCollections.observableArrayList(customerBO.getAllCustomers()));
                
       
    }
     private void setCustomerId() throws Exception{
        try{
            String customerId;
            customerId=IDGenerator.getNewID("Customer","customerId", "C");
            txtCustomerID.setText(customerId);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    void searchCustomer(ActionEvent event) throws Exception {
        String customerID=txtSearchCustomer.getText();
        CustomerDTO customer=customerBO.searchCustomer(customerID);
        if(customer!=null){
            txtCustomerID.setText(customer.getCustomerId());
            txtCustomerName.setText(customer.getCustomerName());
            txtCustomerContact.setText(customer.getPhonenumber());
        }

    }

    
}
