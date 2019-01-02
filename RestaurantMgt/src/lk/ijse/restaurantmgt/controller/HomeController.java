/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.BookingTableBO;
import lk.ijse.restaurantmgt.business.custom.FoodBO;
import lk.ijse.restaurantmgt.business.custom.impl.BookingTableBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.FoodBOImpl;
import lk.ijse.restaurantmgt.model.BookingTableDTO;
import lk.ijse.restaurantmgt.model.FoodItemDTO;

/**
 *
 * @author CHALO
 */
public class HomeController implements Initializable{
    
    private static FoodBO foodBO;
    private static BookingTableBO bookingTableBO;
    @FXML
    private ImageView logout;
    
    public HomeController(){
        foodBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.FOOD);
        bookingTableBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.BOOKINGTABLE);
                
    }
 
    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton ingrediantId;

    @FXML
    private JFXButton tableId;

    @FXML
    private JFXButton chefId;
    
    @FXML
    private JFXButton btnSettings;

    @FXML
    private JFXButton foodClick;

    @FXML
    private JFXButton customerId;

    @FXML
    private JFXButton orderId;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private ImageView report;

    @FXML
    private ImageView settings;
    

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableView<FoodItemDTO> tblFood;

    @FXML
    private ImageView customer;

    @FXML
    private ImageView burger;

    @FXML
    private ImageView order;

    @FXML
    private ImageView table;

    @FXML
    private ImageView chef;

    @FXML
    private ImageView ingrediant;
    
    @FXML
    private JFXButton btnReport;

    @FXML
    private TableView<BookingTableDTO> tblBooking;

    @FXML
    private Label display;

    @FXML
    private ImageView closeId;

   
   
    void reportView(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/ReportFrame.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void reportClicked(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/ReportFrame.fxml"));
        mainPane.getChildren().setAll(pane);


    }
    @FXML
    void reportClick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/ReportFrame.fxml"));
        mainPane.getChildren().setAll(pane);

    }
    
    
   
    @FXML
    void settingClick(MouseEvent event) throws IOException {
        

    }

    @FXML
    void HomeAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/homeFrameMini.fxml"));
        mainPane.getChildren().setAll(pane);
    }
    

    void reportEnterd(MouseEvent event) {

    }

    void reportExists(MouseEvent event) {

    }
    
     @FXML
    void settingAction(MouseEvent event) throws IOException {
       Parent orderPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/restaurantmgt/view/AccountForm.fxml"));
       Scene scene=new Scene(orderPane);
       Stage stage=new Stage(StageStyle.UNDECORATED);
       stage.setScene(scene);
       stage.centerOnScreen();
       stage.showAndWait();

    }
    
    

    
    @FXML
    void FoodCollectionClick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/FoodCollectionForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }
    
 
    @FXML
    void viewChef(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/chefDetailForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void viewCustomer(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/CustomerForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void viewFood(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/FoodCollectionForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void viewIngrediant(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/IngrediantForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void viewOrder(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/OrderForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }
      @FXML
    void viewTable(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/BookingForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void chefClicked(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/chefDetailForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void customerClicked(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/CustomerForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void ingrediantClick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/IngrediantForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }
    
    @FXML
    void orderClicked(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/OrderForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    void tableClicked(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/lk/ijse/restaurantmgt/view/BookingForm.fxml"));
        mainPane.getChildren().setAll(pane);

    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        tblFood.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        tblFood.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        //tblFood.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("chefId"));
        tblFood.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblFood.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        
        try {
            loadFoodItem();
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        tblBooking.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("tableID"));
//        //tblBooking.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerID"));
//        tblBooking.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
//        tblBooking.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("time"));
//        
//        try {
//            loadBookingDetail();
//        } catch (Exception ex) {
//            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
// 
// 
        
        setTimeDate();
        
        FadeTransition fadeIn = new FadeTransition(Duration.millis(5000), mainPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

       
    }
    @FXML
    void mouseEntered(MouseEvent event) {
         try {
            if (event.getSource() instanceof ImageView) {
                ImageView image = (ImageView) event.getSource();
                String id = image.getId();
                FadeTransition t = new FadeTransition(Duration.millis(2000), display);
                switch (id) {
                    case "burger":
                        display.setText("Food Collection");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    case "customer":
                        display.setText("Manage Customers");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    case "order":
                        display.setText("Customer Orders");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    case "ingrediant":
                        display.setText("Ingrediants");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    case "chef":
                        display.setText("Chef");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    case "table":
                        display.setText("Table Resrvation");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    case "display":
                        display.setText("WelCome");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    case "report" :
                        display.setText("Reports");
                        t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                    default:
                        break;

                }

                ScaleTransition sca = new ScaleTransition(Duration.millis(200), image);
                sca.setToX(1.2);
                sca.setToY(1.2);
                sca.play();


                DropShadow d = new DropShadow();
                d.setColor(Color.CORNFLOWERBLUE);
                d.setHeight(20);
                d.setWidth(20);
                d.setRadius(20);
                image.setEffect(d);
                display.setEffect(d);
            }
        } catch (Exception e) {

        } 
    }
    
     @FXML
    void mouseExits(MouseEvent event) {
         
        if (event.getSource() instanceof ImageView) {
            ImageView image = (ImageView) event.getSource();
            String id = image.getId();

            image.setEffect(null);

            ScaleTransition s = new ScaleTransition(Duration.millis(200), image);
            s.setToX(1.0);
            s.setToY(1.0);
            s.play();
            display.setEffect(null);
        }

    }

    private void setTimeDate() {
         Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }
            
        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }

    private void loadFoodItem() throws Exception {
        tblFood.setItems(FXCollections.observableArrayList(foodBO.getAllFoods()));
    }

    private void loadBookingDetail() throws Exception {
       tblBooking.setItems(FXCollections.observableArrayList(bookingTableBO.getAllBooking()));
    }

  
    }
    

   
 
