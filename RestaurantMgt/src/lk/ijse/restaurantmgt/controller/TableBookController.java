/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import lk.ijse.restaurantmgt.business.custom.TableBookBO;
import lk.ijse.restaurantmgt.business.custom.impl.TableBookBOImpl;
import lk.ijse.restaurantmgt.common.IDGenerator;
import lk.ijse.restaurantmgt.model.TableBookDTO;

/**
 *
 * @author CHALO
 */
public class TableBookController implements Initializable{
    
    private static TableBookBO tableBookBO;
    
    public TableBookController(){
        tableBookBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.TABLEBOOK);
    }
    
    @FXML
    private AnchorPane addTablePane;
    
    @FXML
    private JFXTextField txtTableId;

    @FXML
    private JFXTextField txtNumberSeat;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnAdd;
    
    @FXML
    private ImageView closeView;

    @FXML
    private TableView<TableBookDTO> tblAddTable;

    @FXML
    void addClick(MouseEvent event) throws Exception {
        if(validate()){
            int seat=Integer.parseInt(txtNumberSeat.getText());
            TableBookDTO table=new TableBookDTO(txtTableId.getText(),seat);
            boolean isAdded=tableBookBO.addTable(table);
            if(isAdded){
                Alert added=new Alert(Alert.AlertType.INFORMATION,"SucessFully Added",ButtonType.OK);
                added.showAndWait();
                clearTableText();
                Window window = addTablePane.getScene().getWindow();
                ((Stage)window).close();
            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Something went wrong",ButtonType.OK);
                error.show();

            }
        }
        

    }

    @FXML
    void cancelClick(MouseEvent event) {
        txtTableId.setText("");
        txtNumberSeat.setText("");

    }

    @FXML
    void deleteClick(MouseEvent event) throws Exception {
        if(validate()){
            boolean deleted=tableBookBO.deleteTable(txtTableId.getText());
            if(deleted){
                Alert delete=new Alert(Alert.AlertType.INFORMATION,"Deleted Successfully",ButtonType.OK);
                delete.showAndWait();
                clearTableText();
                Window window = addTablePane.getScene().getWindow();
                ((Stage)window).close();

            }else{
                Alert error=new Alert(Alert.AlertType.INFORMATION,"Somthing went wrong",ButtonType.OK);
                error.show();

            }
        }

    }
    
    
    @FXML
    void closeAction(MouseEvent event) {
       Window window = addTablePane.getScene().getWindow();
       ((Stage)window).close();

    }

    @FXML
    void seatAction(ActionEvent event) {
        String seat=txtNumberSeat.getText();
        if(!seat.matches("[0-9]{2}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Seat Numbber",ButtonType.OK);
            a.show();
            txtNumberSeat.selectAll();
           // txtNumberSeat.setStyle("-fx-background-color: red;");
            txtNumberSeat.requestFocus();
        }else{
            //txtNumberSeat.setStyle("-fx-background-color: white;");
            btnAdd.requestFocus();
        }

    }

    @FXML
    void tableClick(MouseEvent event) {
        TableBookDTO selectedItem=tblAddTable.getSelectionModel().getSelectedItem();
        txtTableId.setText(selectedItem.getTableId());
        txtNumberSeat.setText(selectedItem.getNumber_of_seats()+"");

    }

    @FXML
    void tableIdAction(ActionEvent event) {
        String id=txtTableId.getText();
        if(!id.matches("[T]{1}[0-9]{3}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Table ID",ButtonType.OK);
            a.show();
            txtTableId.selectAll();
            //txtTableId.setStyle("-fx-background-color: red;");
            txtTableId.requestFocus();
        }else{
            //txtTableId.setStyle("-fx-background-color: white;");
            txtNumberSeat.requestFocus();
        }
        
    }

    @FXML
    void updateClick(MouseEvent event) throws Exception {
        if(validate()){
            int seat=Integer.parseInt(txtNumberSeat.getText());
            boolean updateFood=tableBookBO.updateTable(new TableBookDTO(txtTableId.getText(),seat));
            if(updateFood){
                Alert update=new Alert(Alert.AlertType.INFORMATION,"Successfully update",ButtonType.OK);
                update.showAndWait();
                clearTableText();
                Window window = addTablePane.getScene().getWindow();
                ((Stage)window).close();

            }else{
                Alert error=new Alert(Alert.AlertType.ERROR,"Something Error",ButtonType.OK);
                error.show();
            }
        }
        

    }
    
    public void clearTableText(){
        txtTableId.clear();
        txtNumberSeat.clear();
        
    }
    
    public boolean validate(){
        if(txtTableId.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING,"Table Id is Empty",ButtonType.OK);
            a.show();
            return false;
        }else{
            if(txtNumberSeat.getText().trim().isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Seat Number is Empty",ButtonType.OK);
                a.show();
                return false;
               
            }
        }
        return true;
    }

    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblAddTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("tableId"));
        tblAddTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("number_of_seats"));
        try {
            loadTableDetail();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            try {
                setTableId();
            } catch (IOException ex) {
                Logger.getLogger(TableBookController.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNumberSeat.requestFocus();
        } catch (SQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }
        
    }

    private void setTableId() throws SQLException, ClassNotFoundException, IOException {
       try {
            String tableId;
            tableId = IDGenerator.getNewID("bookingtable", "tableId", "T");
            txtTableId.setText(tableId);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void loadTableDetail() throws Exception {
        tblAddTable.setItems(FXCollections.observableArrayList(tableBookBO.getAllTable()));
    }
    
}
