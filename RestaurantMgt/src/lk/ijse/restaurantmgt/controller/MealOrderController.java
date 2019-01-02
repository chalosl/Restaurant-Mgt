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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.CustomerBO;
import lk.ijse.restaurantmgt.business.custom.FoodBO;
import lk.ijse.restaurantmgt.business.custom.FoodOrderDetailBO;
import lk.ijse.restaurantmgt.business.custom.MealOrderBO;
import lk.ijse.restaurantmgt.business.custom.impl.CustomerBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.FoodBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.FoodOrderDetailBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.MealOrderBOImpl;
import lk.ijse.restaurantmgt.common.IDGenerator;
import lk.ijse.restaurantmgt.model.CustomerDTO;
import lk.ijse.restaurantmgt.model.FoodItemDTO;
import lk.ijse.restaurantmgt.model.FoodOrderDetailDTO;
import lk.ijse.restaurantmgt.model.MealOrderDTO;
import lk.ijse.restaurantmgt.model.OrderDetailDTO;

/**
 *
 * @author CHALO
 */
public class MealOrderController implements Initializable{
    
    public  static MealOrderBO mealOrderBO;
    public static CustomerBO customerBO;
    public static FoodBO foodBO;
    public static FoodOrderDetailBO foodOrderDetailBO;
    
    public MealOrderController(){
        mealOrderBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.MEALORDER);
        customerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        foodBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.FOOD);
        foodOrderDetailBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.FOODORDERDETAIL);
    }
    
    
    OrderDetailDTO orderDetailDTO=new OrderDetailDTO();
    FoodOrderDetailDTO foodOrderDetailDTO=new FoodOrderDetailDTO();
  
    @FXML
    private AnchorPane orderPane;

    @FXML
    private JFXTextField txtDate;
    
    @FXML
    private JFXTextField txtCustomerName;
    
    private double ammount;
    
    @FXML
    private JFXTextField txtFoodName;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtOrderID;
   
    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private TableView<OrderDetailDTO> tblOrder;

    @FXML
    private JFXTextField txtCustomerID;

    @FXML
    private JFXTextField txtFoodID;
    
    @FXML
    private JFXTextField txtTotal;
    
    @FXML
    private JFXButton btnAddCustomer;
    
    @FXML
    private JFXTextField qtyOnHand;

   
   
   
    @FXML
    void customerAction(ActionEvent event) throws IOException {
       Parent orderPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/restaurantmgt/view/newCustomerForm.fxml"));
       Scene scene=new Scene(orderPane);
       Stage stage=new Stage(StageStyle.UNDECORATED);
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.showAndWait();


    }
   
    @FXML
    void customerNameAction(ActionEvent event) {
        String name=txtCustomerName.getText();
        if(!name.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Customer Name",ButtonType.OK);
            a.show();
            txtCustomerName.selectAll();
            //txtCustomerName.setStyle("-fx-background-color: red;");
            txtCustomerName.requestFocus();
        }else{
            //txtCustomerName.setStyle("-fx-background-color: white;");
            foodIdCombo.requestFocus();
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
            //txtFoodName.setStyle("-fx-background-color: white;");
            txtUnitPrice.requestFocus();
        }

    }

    @FXML
    void orderCancelMouseClick(MouseEvent event) {
        customerIdCombo.getSelectionModel().getSelectedItem();
        txtCustomerName.setText("");
        foodIdCombo.getSelectionModel().getSelectedItem();
        txtFoodName.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
       

    }
    @FXML
    private JFXComboBox<String> customerIdCombo;

    @FXML
    private JFXComboBox<String> foodIdCombo;
    
    @FXML
    void dateAction(ActionEvent event) { 
        String date=txtDate.getText();
       if(date.trim().isEmpty()){
           Alert a = new Alert(Alert.AlertType.WARNING,"Enter Date",ButtonType.OK);
           a.show();
           txtDate.requestFocus();
       }else{
           btnAdd.requestFocus();
           
       }

    }
    @FXML
    void atyOnHandAction(ActionEvent event) {
        

    }


    
    @FXML
    void foodIdAction(ActionEvent event) throws Exception {
        String foodId=foodIdCombo.getSelectionModel().getSelectedItem();
        FoodItemDTO food=foodBO.searchFood(foodId);
        if(food!=null){
            txtFoodName.setText(food.getName());
            txtUnitPrice.setText(""+food.getUnitPrice());
            qtyOnHand.setText(food.getQty()+"");
        }
        txtQty.requestFocus();
       

    }
    
    @FXML
    void custIdAction(ActionEvent event) throws Exception {
        String custId=customerIdCombo.getSelectionModel().getSelectedItem();
        CustomerDTO customer=customerBO.searchCustomer(custId);
        if(customer!=null){
            txtCustomerName.setText(customer.getCustomerName());
        }
        foodIdCombo.requestFocus();
        
    }

    @FXML
    void orderIdAction(ActionEvent event) {
        String orderId=txtOrderID.getText();
        if(!orderId.matches("[O]{1}[0-9]{3}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Order ID",ButtonType.OK);
            a.show();
            txtOrderID.selectAll();
            //txtOrderID.setStyle("-fx-background-color: red;");
            txtOrderID.requestFocus();
        }else{
            //txtOrderID.setStyle("-fx-background-color: white;");
            customerIdCombo.requestFocus();
            
        }
    }
    
    @FXML
    void addOrderMouseClick(MouseEvent event) throws Exception {
        if(validate()){
            String mealId=txtOrderID.getText();
            String date=txtDate.getText();
            String customerID=customerIdCombo.getSelectionModel().getSelectedItem();
            String foodID=foodIdCombo.getSelectionModel().getSelectedItem();
            double totalM=Double.parseDouble(txtTotal.getText());
            int qty=Integer.parseInt(txtQty.getText());
            FoodOrderDetailDTO food=new FoodOrderDetailDTO(customerID,foodID,txtOrderID.getText(),qty,totalM);
            MealOrderDTO meal=new MealOrderDTO(txtOrderID.getText(), date, totalM, food);


            MealOrderDTO mealOrder=new MealOrderDTO(mealId,date,totalM,food);
            boolean isAdded=mealOrderBO.addOrder(mealOrder);
            if(isAdded){
                Alert add=new Alert(Alert.AlertType.INFORMATION,"added",ButtonType.OK);
                add.show();
                //clearMealOrderText();
                setOrderId();
            }
        }

    }

    @FXML
    void orderTableMouseClick(MouseEvent event) {
        
    }

    @FXML
    void qtyAction(ActionEvent event) {
        String orderId=txtOrderID.getText();
        String custId=customerIdCombo.getSelectionModel().getSelectedItem();
        String foodId=foodIdCombo.getSelectionModel().getSelectedItem();
        String foodName=txtFoodName.getText();
        double unitPrice=Double.parseDouble(txtUnitPrice.getText());
        int qty=Integer.parseInt(txtQty.getText());
        ammount=qty*unitPrice;
        OrderDetailDTO order=new OrderDetailDTO(orderId, custId,foodId, foodName, unitPrice, qty, ammount);
        tblOrder.getItems().add(order);
        ObservableList<OrderDetailDTO> items = tblOrder.getItems();
        double total = 0;
        for(OrderDetailDTO one : items){
            total += one.getTotal();
        }
        txtTotal.setText("" + total);
        
        double qtyn=Double.parseDouble(txtQty.getText());
        double qtyOnHad=Double.parseDouble(qtyOnHand.getText());
        if(qtyn>qtyOnHad){
            Alert a = new Alert(Alert.AlertType.ERROR,"Unsufficiant Quantity");
            a.show();
            txtQty.requestFocus();
        }
       
        
        String quantity=txtQty.getText();
        if(quantity.trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"No Quantity",ButtonType.OK);
            a.show();
            txtTotal.requestFocus();
       }else{
           btnAdd.requestFocus();
        }
       
    }
    
    @FXML
    void totalAction(ActionEvent event) {
        String total=txtTotal.getText();
        if(total.trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"No Total",ButtonType.OK);
            a.show();
           txtTotal.requestFocus();
       }else{
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
            txtQty.requestFocus();
        }

    }
    
    public void clearMealOrderText(){
        txtCustomerID.clear();
        txtCustomerName.clear();
        txtFoodID.clear();
        txtFoodName.clear();
        txtOrderID.clear();
        txtQty.clear();
        txtTotal.clear();
        txtUnitPrice.clear();
        
    }
    
    public boolean validate(){
        if(txtOrderID.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Order Id is Empty",ButtonType.OK);
            a.show();
            return false;
        }else{
            if(txtDate.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Date is Empty",ButtonType.OK);
                a.show();
                return false;
            }else{
                if(txtFoodName.getText().trim().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.WARNING,"Food Name is Empty",ButtonType.OK);
                    a.show();
                    return false;
                }else{
                    if(txtCustomerName.getText().trim().isEmpty()){
                        Alert a = new Alert(Alert.AlertType.WARNING,"Customer Name is Empty",ButtonType.OK);
                        a.show();
                        return false;
                    }else{
                        if(txtUnitPrice.getText().trim().isEmpty()){
                            Alert a = new Alert(Alert.AlertType.WARNING,"Unit Price is Empty",ButtonType.OK);
                            a.show();
                            return false;   
                        }else{
                            if(txtQty.getText().trim().isEmpty()){
                                Alert a = new Alert(Alert.AlertType.WARNING,"Quantity is Empty",ButtonType.OK);
                                a.show();
                                return false;             
                            }else{
                                if(txtTotal.getText().trim().isEmpty()){
                                    Alert a = new Alert(Alert.AlertType.WARNING,"Total is Empty",ButtonType.OK);
                                    a.show();
                                    return false; 

                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTimeDate();
        
        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        //tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("foodName"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        //tblOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        tblOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("total"));
        
        try {
            loadOrderDetail();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            try {
                setOrderId();
            } catch (IOException ex) {
                Logger.getLogger(MealOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            loadCustomerId();
            customerIdCombo.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            loadFoodId();
            foodIdCombo.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
        
    }

    private void setOrderId() throws SQLException, ClassNotFoundException, IOException {
       String mealId;
       mealId=IDGenerator.getNewID("MealOrder", "mealId","O");
       txtOrderID.setText(mealId);
       
    }

    private void loadCustomerId() throws Exception {
        ArrayList<String>customerId=customerBO.getAllCustomerIds();
        customerIdCombo.getItems().clear();
        for (String id : customerId) {
            customerIdCombo.getItems().add(id);
            
        }
    }

    private void loadFoodId() throws Exception {
       ArrayList<String>foodId=foodBO.getAllFoodIds();
       foodIdCombo.getItems().clear();
        for (String id : foodId) {
            foodIdCombo.getItems().add(id);
            
        }
    }

    private void loadOrderDetail() throws Exception {
       // tblOrder.setItems(FXCollections.observableArrayList(foodOrderDetailBO.getAllOrders()));
    }

    private void setTimeDate() {
         Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                txtDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                //lblTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }
            
        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }
   

   
    
}
