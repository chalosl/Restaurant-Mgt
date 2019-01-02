/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.ChefBO;
import lk.ijse.restaurantmgt.business.custom.FoodBO;
import lk.ijse.restaurantmgt.business.custom.impl.ChefBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.FoodBOImpl;
import lk.ijse.restaurantmgt.common.IDGenerator;
import lk.ijse.restaurantmgt.model.ChefDTO;
import lk.ijse.restaurantmgt.model.FoodItemDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author CHALO
 */
public class FoodCollectionController implements Initializable{ 

    public static FoodBO foodBO;
    public static ChefBO chefBO;
    
    public FoodCollectionController(){
        foodBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.FOOD);
        chefBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.CHEF);
    }
    
    @FXML
    private AnchorPane foodPane;
    
    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtFoodName;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXButton newFoodID;

    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private JFXTextField searchFoodID;

    @FXML
    private TableView<FoodItemDTO> tblFood;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXTextField txtFoodID;
    
    @FXML
    private JFXButton btnDelete;
    
    @FXML
    private JFXTextField txtchefId;
    
    @FXML
    private JFXComboBox<String> chefIdCombo;
    
    @FXML
    private JFXButton btnRecipy;
    
    @FXML
    void clickRecipy(MouseEvent event) throws IOException {
       Parent foodPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/restaurantmgt/view/RecipyForm.fxml"));
       Scene scene=new Scene(foodPane);
       Stage stage=new Stage(StageStyle.UNDECORATED);
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.showAndWait();


    }
    
    
    @FXML
    void chefIdAction(ActionEvent event) {
        txtFoodName.requestFocus();

    }
    
    @FXML
    void chefIdComboAction(ActionEvent event) {
       
      
    }

    
    @FXML
    void foodIdAction(ActionEvent event) {
        String foodId=txtFoodID.getText();
        if(!foodId.matches("[F]{1}[0-9]{3}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Food ID",ButtonType.OK);
            a.show();
            txtFoodID.selectAll();
            //txtFoodID.setStyle("-fx-background-color: red;");
            txtFoodID.requestFocus();
        }else{
           // txtFoodID.setStyle("-fx-background-color: white;");
            txtFoodName.requestFocus();   
        }
    }

    @FXML
    void foodNameAction(ActionEvent event) {
        String foodName=txtFoodName.getText();
        if(!foodName.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Food Name",ButtonType.OK);
            a.show();
            txtFoodName.selectAll();
            //txtFoodName.setStyle("-fx-background-color: red;");
            txtFoodName.requestFocus();
        }else{
           // txtFoodName.setStyle("-fx-background-color: white;");
            txtUnitPrice.requestFocus();
        }
       

    }
    @FXML
    void qtyOnAction(ActionEvent event) {
        String qty=txtQuantity.getText();
        if(!qty.matches("[0-9 .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Quantity",ButtonType.OK);
            a.show();
            txtQuantity.selectAll();
           // txtQuantity.setStyle("-fx-background-color: red;");
            txtQuantity.requestFocus();
        }else{
           // txtQuantity.setStyle("-fx-background-color: white;");
           btnAdd.requestFocus();
        }
       
       
    }

    @FXML
    void unitPriceAction(ActionEvent event) {
        String price=txtUnitPrice.getText();
        if(!price.matches("[0-9 .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Unit Price",ButtonType.OK);
            a.show();
            txtUnitPrice.selectAll();
            //txtUnitPrice.setStyle("-fx-background-color: red;");
            txtUnitPrice.requestFocus();
        }else{
            //txtUnitPrice.setStyle("-fx-background-color: white;");
            txtQuantity.requestFocus();
        }
    }
    
  

    
    @FXML
    void searchFoodAction(ActionEvent event) throws Exception {
        String foodId=searchFoodID.getText();
        FoodItemDTO food=foodBO.searchFood(foodId);
        if(food!=null){
            txtFoodID.setText(food.getFoodId());
            txtFoodName.setText(food.getName());
            chefIdCombo.getSelectionModel().select(food.getChefId());
            txtUnitPrice.setText(""+food.getUnitPrice());
            txtQuantity.setText(food.getQty()+"");
        }
        

    }

    @FXML
    void addFood(ActionEvent event) throws Exception {
       if(validate()){ 
        double unitPrice=Double.parseDouble(txtUnitPrice.getText());
        int qty=Integer.parseInt(txtQuantity.getText());
        FoodItemDTO food=new FoodItemDTO(txtFoodID.getText(),txtFoodName.getText(),chefIdCombo.getSelectionModel().getSelectedItem(),unitPrice,qty);

            boolean isAdded=foodBO.addFood(food);
            if(isAdded){
                Alert added=new Alert(Alert.AlertType.INFORMATION,"SucessFully Added",ButtonType.OK);
                added.show();
                
                clearFoodText();
                loadFoodItem(); 
                setFoodId();
            } 
        }   
    }    
   
    @FXML
    void cancelFood(MouseEvent event) {
        txtFoodID.setText("");
        txtFoodName.setText("");
        txtUnitPrice.setText("");
        txtQuantity.setText("");
        txtchefId.setText("");
        searchFoodID.setText("");
    }

    @FXML
    void clickNewFood(MouseEvent event) {
        txtFoodID.setText("");
        txtFoodName.setText("");
        txtUnitPrice.setText("");
        txtQuantity.setText("");
        txtchefId.setText("");
        searchFoodID.setText("");
        

    }

    @FXML
    void deleteFood(MouseEvent event) throws Exception {
        if(validate()){
            boolean deleted=foodBO.deleteFood(txtFoodID.getText());
            if(deleted){
                Alert delete=new Alert(Alert.AlertType.INFORMATION,"Deleted Successfully",ButtonType.OK);
                delete.show();
                clearFoodText();
                loadFoodItem(); 
            }else{
                Alert error=new Alert(Alert.AlertType.INFORMATION,"Somthing went wrong",ButtonType.OK);
                error.show();

            }
        }
    
    }

    @FXML
    void updateFood(MouseEvent event) throws Exception {
        if(validate()){
            double unitPrice=Double.parseDouble(txtUnitPrice.getText());
            int qty=Integer.parseInt(txtQuantity.getText());
            boolean updateFood=foodBO.updateFood(new FoodItemDTO(txtFoodID.getText(),txtFoodName.getText(),chefIdCombo.getSelectionModel().getSelectedItem(),unitPrice,qty));
            if(updateFood){
                Alert update=new Alert(Alert.AlertType.INFORMATION,"Successfully update",ButtonType.OK);
                update.show();
                clearFoodText();
                loadFoodItem(); 
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Something Error",ButtonType.OK);
                error.show();
            }
        }
        
       
    }
    @FXML
    void foodTableMouseClick(MouseEvent event) {
        FoodItemDTO selectedItem=tblFood.getSelectionModel().getSelectedItem();
        txtFoodID.setText(selectedItem.getFoodId());
        txtFoodName.setText(selectedItem.getName());
        chefIdCombo.getSelectionModel().select(selectedItem.getChefId());
        txtUnitPrice.setText(""+selectedItem.getUnitPrice());
        txtQuantity.setText(selectedItem.getQty()+"");

    }
    
    public void clearFoodText(){
        txtFoodID.clear();
        txtFoodName.clear();
        txtUnitPrice.clear();
        txtQuantity.clear();
        chefIdCombo.getSelectionModel().clearSelection();
    }
    
    public boolean validate(){
        if(txtFoodID.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Food ID is Empty",ButtonType.OK);
            a.show();
            return false;
        }else{
            if(txtFoodName.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Food Name is Empty",ButtonType.OK);
                a.show();
                return false;
            }else{
                if(txtUnitPrice.getText().trim().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.WARNING,"Unit Price is Empty",ButtonType.OK);
                    a.show();
                    return false;    
                }else{
                    if(txtQuantity.getText().trim().isEmpty()){
                        Alert a = new Alert(Alert.AlertType.WARNING,"Unit Price is Empty",ButtonType.OK);
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
            for (FoodItemDTO foodDTO : foodBO.getAllFoods()) {
                names.add(foodDTO.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextFields.bindAutoCompletion(searchFoodID, names);

   
        
        
        tblFood.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        tblFood.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblFood.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("chefId"));
        tblFood.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblFood.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("qty"));
        
//        try{
//            chefIdCombo.getItems().addAll(
//                    "CH001"
//            );
//            loadChefId();  
//        } catch (Exception ex) {
//            Logger.getLogger(FoodCollectionController.class.getName()).log(Level.SEVERE, null, ex);
//        }
 
        try{
            loadFoodItem();
        }catch(Exception e){
            e.printStackTrace();
            
        }
        try {
            try {
                setFoodId();
            } catch (IOException ex) {
                Logger.getLogger(FoodCollectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtFoodName.requestFocus();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FoodCollectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadChefId();
            chefIdCombo.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            Logger.getLogger(FoodCollectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadFoodItem() throws Exception {
      tblFood.setItems(FXCollections.observableArrayList(foodBO.getAllFoods()));
      
    }

    private void setFoodId() throws SQLException, ClassNotFoundException, IOException {
       String foodId;
       foodId=IDGenerator.getNewID("FoodItem", "foodId", "F");
       txtFoodID.setText(foodId);
       
    }

    private void loadChefId() throws Exception {
        ArrayList<String>chefId=chefBO.getChefIds();
        chefIdCombo.getItems().clear();
        for (String my : chefId) {
            chefIdCombo.getItems().add(my);
            
        }
        
    }

   

   

  
}
       
    

