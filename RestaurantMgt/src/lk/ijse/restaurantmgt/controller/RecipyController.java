/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.FoodBO;
import lk.ijse.restaurantmgt.business.custom.IngrediantBO;
import lk.ijse.restaurantmgt.business.custom.RecipyBO;
import lk.ijse.restaurantmgt.business.custom.impl.FoodBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.IngrediantBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.RecipyBOImpl;
import lk.ijse.restaurantmgt.model.FoodItemDTO;
import lk.ijse.restaurantmgt.model.IngrediantDTO;
import lk.ijse.restaurantmgt.model.RecipyDTO;

/**
 *
 * @author CHALO
 */
public class RecipyController implements Initializable{
    
    private static RecipyBO recipyBO;
    private static FoodBO foodBO;
    private static IngrediantBO ingrediantBO;
    
    public RecipyController(){
        recipyBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.RECIPY);
        foodBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.FOOD);
        ingrediantBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.INGREDIANT);
    }
    
    @FXML
    private AnchorPane recipyPane;
    
    @FXML
    private JFXTextField txtFoodName;

    @FXML
    private JFXComboBox<String> foodIdCombo;

   
    @FXML
    private JFXTextField txtIngrediantName1;

    @FXML
    private JFXComboBox<String> ingrediantIdCombo1;

   
    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<RecipyDTO> tblRecipy;
    
    @FXML
    private ImageView closeImg;

    

    @FXML
    void cancelFood(MouseEvent event) {
       txtFoodName.setText("");
       txtIngrediantName1.setText("");

    }

    @FXML
    void deleteFood(MouseEvent event) throws Exception {
        if(validate()){
            boolean deleted=recipyBO.deleteRecipy(foodIdCombo.getSelectionModel().getSelectedItem());
            if(deleted){
                Alert delete=new Alert(Alert.AlertType.INFORMATION,"Deleted Successfully",ButtonType.OK);
                delete.show();
                clearRecipyText();
                loadRecipyDetail();

            }else{
                Alert error=new Alert(Alert.AlertType.INFORMATION,"Somthing went wrong",ButtonType.OK);
                error.show();

            }
        }

    }

    @FXML
    void foodIdAction(ActionEvent event) throws Exception {
        String foodId=foodIdCombo.getSelectionModel().getSelectedItem();
        FoodItemDTO food=foodBO.searchFood(foodId);
        if(food!=null){
            txtFoodName.setText(food.getName());
        }
        txtFoodName.requestFocus();

    }

    @FXML
    void foodNameAction(ActionEvent event) {
        String foodName=txtFoodName.getText();
        if(!foodName.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Food Name",ButtonType.OK);
            a.show();
            txtFoodName.selectAll();
           // txtFoodName.setStyle("-fx-background-color: red;");
            txtFoodName.requestFocus();
        }else{
           // txtFoodName.setStyle("-fx-background-color: white;");
            ingrediantIdCombo1.requestFocus();
        }
       

    }

    @FXML
    void ingrediantActionCombo1(ActionEvent event) throws Exception {
        String ingrediantId=ingrediantIdCombo1.getSelectionModel().getSelectedItem();
        IngrediantDTO ingrediant=ingrediantBO.searchIngrediant(ingrediantId);
        if(ingrediant!=null){
            txtIngrediantName1.setText(ingrediant.getName());
        }
        txtIngrediantName1.requestFocus();

    }

    @FXML
    void ingrediantActionText1(ActionEvent event) {
        String ingrediantName=txtIngrediantName1.getText();
       if(!ingrediantName.matches("[A-Za-z .]+")){
           Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Ingrediant Name",ButtonType.OK);
           a.show();
           txtIngrediantName1.selectAll();
          // txtIngrediantName1.setStyle("-fx-background-color: red;");
           txtIngrediantName1.requestFocus();
        }else{
           //txtIngrediantName1.setStyle("-fx-background-color: white;");
           btnSave.requestFocus();
           
       }

    }


    @FXML
    void saveClick(MouseEvent event) throws Exception {
        if(validate()){
            RecipyDTO recipy=new RecipyDTO(foodIdCombo.getSelectionModel().getSelectedItem(),txtFoodName.getText(),ingrediantIdCombo1.getSelectionModel().getSelectedItem(),txtIngrediantName1.getText());
            boolean isAdded=recipyBO.addRecipy(recipy);
            if(isAdded){
                Alert added=new Alert(Alert.AlertType.INFORMATION,"SucessFully Added",ButtonType.OK);
                added.show();
                clearRecipyText();
                loadRecipyDetail();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Somthing Went Worng",ButtonType.OK);
                error.show();

            }
        }
    }

    @FXML
    void tblRecipyClick(MouseEvent event) {
        RecipyDTO selectedItem=tblRecipy.getSelectionModel().getSelectedItem();
        foodIdCombo.getSelectionModel().select(selectedItem.getFoodId());
        txtFoodName.setText(selectedItem.getFoodName());
        ingrediantIdCombo1.getSelectionModel().select(selectedItem.getIngrediantId());
        txtIngrediantName1.setText(selectedItem.getIngrediant_Name());
        
    }

    @FXML
    void updateFood(MouseEvent event) throws Exception {
        if(validate()){
            boolean update=recipyBO.updateRecipy(new RecipyDTO(foodIdCombo.getSelectionModel().getSelectedItem(),txtFoodName.getText(),ingrediantIdCombo1.getSelectionModel().getSelectedItem(),txtIngrediantName1.getText()));
            if(update){
                Alert upda=new Alert(Alert.AlertType.INFORMATION,"Successfully update",ButtonType.OK);
                upda.show();
                clearRecipyText();
                loadRecipyDetail();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Something Error",ButtonType.OK);
                error.show();
            }
        }

    }
    
    @FXML
    void cloceClick(MouseEvent event) {
        Window window = recipyPane.getScene().getWindow();
       ((Stage)window).close();

    }
    public void clearRecipyText(){
       txtFoodName.clear();
       txtIngrediantName1.clear();
    }
    
    public boolean validate(){
            if(txtFoodName.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Food Name is Empty",ButtonType.OK);
                a.show();
                return false;   
            }else{
                if(txtIngrediantName1.getText().trim().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.WARNING,"Food Name is Empty",ButtonType.OK);
                    a.show();
                    return false; 
                        
                }
            }
            return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblRecipy.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        tblRecipy.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("foodName"));
        tblRecipy.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("ingrediantId"));
        tblRecipy.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ingrediant_Name"));
        
        try {
            loadRecipyDetail();
        } catch (Exception ex) {
            Logger.getLogger(RecipyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            loadFoodId();
            foodIdCombo.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            Logger.getLogger(RecipyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadIngrediantId();
            ingrediantIdCombo1.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            Logger.getLogger(RecipyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadFoodId() throws Exception {
        ArrayList<String>foodId=foodBO.getAllFoodIds();
        foodIdCombo.getItems().clear();
        for (String id : foodId) {
            foodIdCombo.getItems().add(id);
        
        }
    }

    private void loadIngrediantId() throws Exception {
        ArrayList<String>ingrediantId=ingrediantBO.getAllIngrediantIds();
        ingrediantIdCombo1.getItems().clear();
        for (String id : ingrediantId) {
            ingrediantIdCombo1.getItems().add(id);
        
        }
      
    }

    private void loadRecipyDetail() throws Exception {
       tblRecipy.setItems(FXCollections.observableArrayList(recipyBO.getAllRecipy()));
    }
    
}
