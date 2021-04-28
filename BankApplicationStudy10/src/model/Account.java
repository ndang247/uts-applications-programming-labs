package model;
import javafx.beans.property.*;

public class Account {
    private StringProperty type = new SimpleStringProperty();
    private DoubleProperty balance = new SimpleDoubleProperty();
    
    public Account(String type){
        this.type.set(type);
        balance.set(0.0);
    }
    
    public final String getType(){ return type.get(); }
    public final void setType(String type){ this.type.set(type); }
    public StringProperty typeProperty(){ return type; }
    
    public final double getBalance(){ return balance.get(); }
    private final void setBalance(double value){ balance.set(value); }
    public ReadOnlyDoubleProperty balanceProperty(){ return balance; }
    
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }
    
    @Override
    public String toString() {
        return type.get() + " account";
    }
}
