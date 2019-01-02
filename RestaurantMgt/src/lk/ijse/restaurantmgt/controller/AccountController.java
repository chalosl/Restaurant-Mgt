/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.security.spec.InvalidKeySpecException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.AccountBO;
import lk.ijse.restaurantmgt.business.custom.impl.AccountBOImpl;
import lk.ijse.restaurantmgt.common.PasswordUtil;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.model.AccountDTO;

/**
 *
 * @author CHALO
 */
public class AccountController implements Initializable{
    
    private static AccountBO accountBO;
    
    public AccountController(){
        accountBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.ACCOUNT);
    }
    
    @FXML
    private AnchorPane accountPane;
    
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtConfirmPassword;

    @FXML
    private JFXPasswordField txtPassWord;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private JFXPasswordField txtNewPass;


    @FXML
    private JFXButton btnDelete;
    
    @FXML
    private ImageView closeId;


    @FXML
    private JFXButton btnCancel;

    @FXML
    void addMouseClick(MouseEvent event) throws Exception {
try {
            String userName=txtUserName.getText();
            String password=txtPassWord.getText();
            String salt=PasswordUtil.getSalt(30);
            String secPw=PasswordUtil.generateSecurePassword(password, salt);
            CrudUtil.executeUpdate("Insert into loging values(?,?,?,?)", "001",userName,salt,secPw);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
  
    
    public void clearTextFields(){
        txtUserName.clear();
        txtPassWord.clear();
        txtNewPass.clear();
    }

    @FXML
    void cancelMouseClick(MouseEvent event) {
        txtUserName.setText("");
        txtPassWord.setText("");
        txtNewPass.setText("");

    }

    @FXML
    void confirmPasswordAction(ActionEvent event) {
        String confirm=txtNewPass.getText();
        String pass=txtPassWord.getText();
        if(pass==confirm){
            Alert b = new Alert(Alert.AlertType.CONFIRMATION,"Ok",ButtonType.OK);
            b.show();
           
            
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR,"Somthing Went Wrong",ButtonType.OK);
            a.show();
        }

    }
    
      @FXML
    void closeAction(MouseEvent event) {
         Window window = accountPane.getScene().getWindow();
        ((Stage)window).close();

    }

    @FXML
    void deleteMouseClick(MouseEvent event) throws Exception {
        if( validate()){
            boolean deleted=accountBO.deleteUser(txtUserName.getText());
               if(deleted){
                   Alert delete=new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK);
                   delete.show();
                   clearTextFields();
               }else{
                   Alert e = new Alert(Alert.AlertType.ERROR,"Not Deleted",ButtonType.OK);
                   e.show();
               }
        }

    }

    @FXML
    void passwordAction(ActionEvent event) {
        String pass=txtPassWord.getText();
        if(!pass.matches("[0-9]{5}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Password",ButtonType.OK);
            a.show();
            txtPassWord.selectAll();
            //txtPassWord.setStyle("-fx-background-color: red;");
            txtPassWord.requestFocus();
        }else{
            //txtPassWord.setStyle("-fx-background-color: white;");
            txtNewPass.requestFocus();
            
        }
        
        //txtConfirmPassword.requestFocus();

    }

    @FXML
    void updateMouseClick(MouseEvent event) throws Exception {
        if( validate()){
            String pass=txtPassWord.getText();
            String confirm=txtNewPass.getText();
            if(pass==confirm){
                AccountDTO account = new AccountDTO(txtUserName.getText(),pass);
                boolean isUpdated=accountBO.updateUser(account);
                if(isUpdated){
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK);
                    a.show();
                    clearTextFields();
                }else{
                    Alert e = new Alert(Alert.AlertType.ERROR,"Not Updated",ButtonType.OK);
                    e.show();
                }
            }
        }

    }

    @FXML
    void userNameAction(ActionEvent event) {
        txtPassWord.requestFocus();

    }
    
    public boolean validate(){
        if(txtUserName.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"NO UserName",ButtonType.OK);
            a.show();
            return false;
        }else{
            if(txtPassWord.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"NO PassWord",ButtonType.OK);
                a.show();
                return false;
            
            }else{
                if(txtNewPass.getText()==txtPassWord.getText()){
                    Alert a = new Alert(Alert.AlertType.WARNING,"Confirmation PassWord Is Invalid",ButtonType.OK);
                    a.show();
                    return false;
                }else{
                    if(txtNewPass.getText().trim().isEmpty()){
                        Alert a = new Alert(Alert.AlertType.WARNING,"No ConfirmationPassword",ButtonType.OK);
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
        
    }

    
}
