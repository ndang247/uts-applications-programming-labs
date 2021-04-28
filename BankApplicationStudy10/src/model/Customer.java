package model;

import javafx.collections.*;
import javafx.beans.property.*;

public class Customer {
    private StringProperty name = new SimpleStringProperty();
    private ObservableList<Account> accounts = FXCollections.observableArrayList();
    
    public Customer(String name){
        this.name.set(name);
    }
    
    public void addAccount(String type){
        accounts.add(new Account(type));
    }
    
    public final ObservableList<Account> getAccounts(){
        return accounts;
    }
    
    public final String getName(){ return name.get(); }
    public void setName(String name){ this.name.set(name); }
    public StringProperty nameProperty(){ return name; }
    
}
