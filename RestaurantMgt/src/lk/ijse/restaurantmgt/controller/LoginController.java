/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.ijse.restaurantmgt.common.PasswordUtil;
import lk.ijse.restaurantmgt.dao.CrudUtil;
import lk.ijse.restaurantmgt.db.DBConnection;

/**
 *
 * @author CHALO
 */
public class LoginController implements Initializable{
    
    @FXML
    private AnchorPane mainLogin;
    
    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ImageView closeIcon;
    
    @FXML
    private Label lblLogin;
    
    @FXML
    void passwordAction(ActionEvent event) {

    }

    @FXML
    void userNameAction(ActionEvent event) {
        password.requestFocus();

    }

    @FXML
    void closeClick(MouseEvent event) {
        System.exit(0);
            

    }
    

   @FXML
   void loginClick(MouseEvent event) throws IOException, Exception {
       
//        ResultSet rst = CrudUtil.executeQuery("Select * from loging");
//        if(rst.next()){
//            String username=rst.getString(2);
//            String salt=rst.getString(3);
//            String secPw=rst.getString(4);
//            
//            boolean ifPasswordMatches=PasswordUtil.verifyUserPassword(password.getText(), secPw, salt);
//            if (ifPasswordMatches && userName.getText().equals(username)) {

                Parent mainL=FXMLLoader.load(this.getClass().getResource("/lk/ijse/restaurantmgt/view/HomeFrame.fxml"));
                Scene scene=new Scene(mainL);
                Stage stage=(Stage)this.mainLogin.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
           
               
//            } else {
//                JOptionPane.showMessageDialog(null, "Error in username password combination!");
//            }
//        }

   }
   
    
//    public boolean login(String userName, String password) throws ClassNotFoundException, SQLException, IOException{
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement prepareStm = null;
//        ResultSet rst = null;
//        
//        try{
//            String SQL = "select * from loging where username=? and password = ?";
//            prepareStm = (PreparedStatement) connection.prepareStatement(SQL);
//            prepareStm.setString(1, userName);
//            prepareStm.setString(2,password);
//            
//            rst = prepareStm.executeQuery();
//            if(rst.next()){
//                return true;
//            }else{
//                return false;
//            }
//            
//        }catch(Exception ex){
//            return false;
//        }finally{
//            prepareStm.close();
//            rst.close();
//        }
        
//    }

    
    
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
          
        FadeTransition fadeIn = new FadeTransition(Duration.millis(5000),mainLogin);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        
    }
    
}
