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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.restaurantmgt.business.BOFactory;
import lk.ijse.restaurantmgt.business.custom.BookingTableBO;
import lk.ijse.restaurantmgt.business.custom.CustomerBO;
import lk.ijse.restaurantmgt.business.custom.TableBookBO;
import lk.ijse.restaurantmgt.business.custom.TableDetailBO;
import lk.ijse.restaurantmgt.business.custom.impl.BookingTableBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.CustomerBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.TableBookBOImpl;
import lk.ijse.restaurantmgt.business.custom.impl.TableDetailBOImpl;
import lk.ijse.restaurantmgt.entity.TableBook;
import lk.ijse.restaurantmgt.model.BookingTableDTO;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author CHALO
 */
public class BookingTableController implements Initializable{
    
    public static BookingTableBO bookingTableBO;
    public static CustomerBO customerBO;
    public static TableBookBO tableBookBO;
    public static TableDetailBO tableDetailBO;
    
    public BookingTableController(){
        bookingTableBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.BOOKINGTABLE);
        customerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        tableBookBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.TABLEBOOK);
        tableDetailBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.TABLEDETAIL);
    }
    
    @FXML
    private AnchorPane bookingPane;
    
    @FXML
    private JFXButton btnBook;

    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<BookingTableDTO> tblTableBooking;

    @FXML
    private JFXComboBox<String> tableIdCombo;

     @FXML
    private JFXComboBox<String> customerIdCombo;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtTime;

    @FXML
    private JFXTextField txtSearch;
    
    @FXML
    private JFXTextField txtTableID;

    @FXML
    private JFXTextField txtCustomerId;
    
    @FXML
    private JFXButton btnAddTable;
    
    
    @FXML
    private JFXButton btnAddCustomer;
    
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
    void addTableAction(MouseEvent event) throws IOException {
       Parent bookingPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/restaurantmgt/view/AddTableForm.fxml"));
       Scene scene=new Scene(bookingPane);
       Stage bookStage=new Stage(StageStyle.UNDECORATED);
       bookStage.setScene(scene);
       bookStage.centerOnScreen();
       bookStage.showAndWait();

    }
    
   
    @FXML
    void customerIdAction(ActionEvent event) {
        txtDate.requestFocus();

    }
    
    @FXML
    void tableIdAction(ActionEvent event) {
        customerIdCombo.requestFocus();

    }


    @FXML
    void bookingMouseClick(MouseEvent event) throws Exception {
        if(validate()){
            BookingTableDTO bookingTable=new BookingTableDTO(tableIdCombo.getSelectionModel().getSelectedItem(),customerIdCombo.getSelectionModel().getSelectedItem(),txtDate.getText(),txtTime.getText());
            boolean isAdded=bookingTableBO.bookTable(bookingTable);
            if(isAdded){
                Alert add=new Alert(Alert.AlertType.INFORMATION,"SucessFullly Added",ButtonType.OK);
                add.show();
                loadBooking();

            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Somthing went wrong",ButtonType.OK);
                error.show();

            }
        }

    }
   
    @FXML
    void bookingTableMousClick(MouseEvent event) {
        BookingTableDTO selectedItem=tblTableBooking.getSelectionModel().getSelectedItem();
        customerIdCombo.getSelectionModel().select(selectedItem.getCustomerID());
        tableIdCombo.getSelectionModel().select(selectedItem.getTableID());
        txtDate.setText(selectedItem.getDate());
        txtTime.setText(selectedItem.getTime());

    }

    @FXML
    void cancelMouseClick(MouseEvent event) {
        txtTableID.setText("");
        txtCustomerId.setText("");
        txtDate.setText("");
        txtTime.setText("");
        txtSearch.setText("");

    }

   

    @FXML
    void dateTextAction(ActionEvent event) {
       String date=txtDate.getText();
       if(date.trim().isEmpty()){
           Alert a = new Alert(Alert.AlertType.WARNING,"Enter Date",ButtonType.OK);
           a.show();
           txtDate.requestFocus();
       }else{
           txtTime.requestFocus();
       }

    }

    @FXML
    void searchAction(ActionEvent event) throws Exception {
        String tableId=txtSearch.getText();
        BookingTableDTO bookingTable=bookingTableBO.searchTable(tableId);
        if(bookingTable!=null){
            tableIdCombo.getSelectionModel().select(bookingTable.getTableID());
            customerIdCombo.getSelectionModel().select(bookingTable.getCustomerID());
            txtDate.setText(bookingTable.getDate());
            txtTime.setText(bookingTable.getTime());
        }

    }

   

    @FXML
    void timeAction(ActionEvent event) {
        String time=txtTime.getText();
       if(time.trim().isEmpty()){
           Alert a = new Alert(Alert.AlertType.WARNING,"Enter Time",ButtonType.OK);
           a.show();
           txtTime.requestFocus();
       }else{
           btnAddTable.requestFocus();
       }

       

    }
    @FXML
    void updateMouseClick(MouseEvent event){
        if(validate()){
            boolean isUpdate;
            try {
                isUpdate = bookingTableBO.updateBooking(new BookingTableDTO(tableIdCombo.getSelectionModel().getSelectedItem(),customerIdCombo.getSelectionModel().getSelectedItem(),txtDate.getText(),txtTime.getText()));
                if(isUpdate){
                Alert update=new Alert(Alert.AlertType.INFORMATION,"Updated",ButtonType.OK);
                update.show();
                loadBooking();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Not Updated",ButtonType.OK);
                error.show();
            }
            } catch (Exception ex) {
                Logger.getLogger(BookingTableController.class.getName()).log(Level.SEVERE, null, ex);
                Alert update=new Alert(Alert.AlertType.INFORMATION,ex+"",ButtonType.OK);
            }
            
        }

    }
    @FXML
    void deleteMouseClick(MouseEvent event) throws Exception {
        if(validate()){
            boolean deleted=bookingTableBO.deleteBooking(tableIdCombo.getSelectionModel().getSelectedItem());
            if(deleted){
                Alert delete=new Alert(Alert.AlertType.INFORMATION,"Deleted..",ButtonType.OK);
                delete.show();
                loadBooking();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Not Deleted",ButtonType.OK);
                error.show();
            }
        }

    }
    
    public boolean validate(){
        if(txtDate.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Date Is Empty",ButtonType.OK);
            a.show();
            return false;
                    
        }else{
            if(txtTime.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Date Is Empty",ButtonType.OK);
                a.show();
                return false;
                        
            }
        }   
        return true;
        
    }
    
   
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
          ArrayList<String> names = new ArrayList<>();
        try {
            for (BookingTableDTO bookingTableDTO : bookingTableBO.getAllBooking()) {
                names.add(bookingTableDTO.getTableID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextFields.bindAutoCompletion(txtSearch, names);
        
        
        setTimeDate();
        
        tblTableBooking.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("tableID"));
        tblTableBooking.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblTableBooking.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblTableBooking.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("time"));
        
        
        try{
            loadBooking();
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            loadTableIds();
            tableIdCombo.getSelectionModel().selectFirst();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            loadCustomerIds();
            customerIdCombo.getSelectionModel().selectFirst();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        
    }

    private void loadBooking() throws Exception {
        tblTableBooking.setItems(FXCollections.observableArrayList(bookingTableBO.getAllBooking()));
    }

    private void loadTableIds() throws Exception {
       ArrayList<String>tableId=tableDetailBO.getAllTableIds();
       tableIdCombo.getItems().clear();
        for (String id : tableId) {
            tableIdCombo.getItems().add(id);
            
        }
    }

    private void loadCustomerIds() throws Exception {
       ArrayList<String>customerId=customerBO.getAllCustomerIds();
       customerIdCombo.getItems().clear();
        for (String id : customerId) {
            customerIdCombo.getItems().add(id);
            
        }
    }

    private void setTimeDate() {
         Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                txtDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                txtTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }
            
        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }
    
        
    
    
    
}
 