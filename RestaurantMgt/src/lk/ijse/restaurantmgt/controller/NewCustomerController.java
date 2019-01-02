/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.CustomerBO;
import lk.ijse.restaurantmgt.common.IDGenerator;
import static lk.ijse.restaurantmgt.controller.CustomerController.customerBO;
import lk.ijse.restaurantmgt.model.CustomerDTO;

/**
 *
 * @author CHALO
 */
public class NewCustomerController implements Initializable{
    
    private static CustomerBO customerBO;

    public NewCustomerController() {
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
    private AnchorPane addPane;
    
    @FXML
    private ImageView closeView;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private JFXTextField txtCustomerID;

    @FXML
    void addNewCustomer(ActionEvent event) {
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerContact.setText("");
        txtSearchCustomer.setText("");
        

    }

    @FXML
    void cancelCustomer(ActionEvent event) {
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerContact.setText("");
        txtSearchCustomer.setText("");

    }

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
        if(!name.matches("[a-zA-Z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Customer Name",ButtonType.OK);
            a.show();
            txtCustomerName.selectAll();
            //txtCustomerName.setStyle("-fx-background-color: red;");
            txtCustomerName.requestFocus();
        }else{
           // txtCustomerName.setStyle("-fx-background-color: white;");
            txtCustomerContact.requestFocus();   
        }
    
    }

    @FXML
    void customerTableClick(MouseEvent event) {
        CustomerDTO selectedItem=(CustomerDTO) tblCustomer.getSelectionModel().getSelectedItem();
        txtCustomerID.setText(selectedItem.getCustomerId());
        txtCustomerName.setText(selectedItem.getCustomerName());
        txtCustomerContact.setText(selectedItem.getPhonenumber());

    }

    @FXML
    void saveCustomer(ActionEvent event) {
        if(validate()){
            CustomerDTO customer = new CustomerDTO(txtCustomerID.getText(),txtCustomerName.getText(),txtCustomerContact.getText());
                    try{
                        boolean isAdded=customerBO.addCustomer(customer);
                        if(isAdded){
                            Alert added=new Alert(Alert.AlertType.INFORMATION,"successfully saved !",ButtonType.OK);
                            added.showAndWait();                       
                            clearNewCustText();
                            Window window = addPane.getScene().getWindow();
                            ((Stage)window).close();
                            loadCustomers();
                        }
                    }catch(Exception ex){    
                        Alert error=new Alert(Alert.AlertType.ERROR,"Somthing went wrong !",ButtonType.OK);
                        error.show();

                    }
        }
    }
    
     @FXML
    void CloseClick(MouseEvent event) {
        Window window = addPane.getScene().getWindow();
        ((Stage)window).close();

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
    
    public void clearNewCustText(){
        txtCustomerID.clear();
        txtCustomerName.clear();
        txtCustomerContact.clear();
        
    }
    public boolean validate(){
        if(txtCustomerID.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Customer Id is Empty",ButtonType.OK);
            a.show();
            return false;
        }else{
            if(txtCustomerName.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Customer Name is Empty",ButtonType.OK);
                a.show();
                return false;   
            }else{
                if(txtCustomerContact.getText().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.WARNING,"Customer Contact Number is Empty",ButtonType.OK);
                    a.show();
                    return false;  
                    
                }
            }
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            ex.printStackTrace();  
        }
       
    }

    private void loadCustomers() throws Exception {
        tblCustomer.setItems(FXCollections.observableArrayList(customerBO.getAllCustomers()));
        
    }

    private void setCustomerId() {
         try{
            String customerId;
            customerId=IDGenerator.getNewID("Customer","customerId", "C");
            txtCustomerID.setText(customerId);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
