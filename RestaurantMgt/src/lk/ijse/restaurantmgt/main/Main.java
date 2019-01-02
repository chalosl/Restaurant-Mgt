/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author CHALO
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.initStyle(StageStyle.UNDECORATED);
       Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/restaurantmgt/view/LoginForm.fxml"));
       Scene temp = new Scene(root);
       primaryStage.setScene(temp);
       primaryStage.setTitle("Doors Restaurant");
       primaryStage.show();
       
       
       
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
