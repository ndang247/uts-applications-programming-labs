package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import au.edu.uts.ap.javafx.*;

public class CustomerController extends Controller<Customer> {
    @FXML private Button viewAccountBtn;
    @FXML private ListView<Account> accountsLv;
    
    private Customer customer = new Customer("Mr Smith");
    
    // set the view account button active when there is at least one account
    @FXML private void initialize() {
        accountsLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSubject, newSubject) -> viewAccountBtn.setDisable(newSubject == null));
    }
    
    public final Customer getCustomer(){ return model; }
    
    @FXML private void handleViewAccount(ActionEvent event) throws Exception{
        Account account = getSelectedAccount();
        if(account != null){
            ViewLoader.showStage(account, "/view/account.fxml", "Account", new Stage());
        }
    }
    
    @FXML private void handleAddAccount(ActionEvent event) throws Exception{
        ViewLoader.showStage(getCustomer(), "/view/add_account.fxml", "Add Account", new Stage());
    }
    
    private Account getSelectedAccount(){
        return accountsLv.getSelectionModel().getSelectedItem();
    }
}
