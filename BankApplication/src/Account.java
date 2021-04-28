import javafx.beans.property.*;

public class Account{
    private StringProperty name = new SimpleStringProperty();
    private DoubleProperty balance = new SimpleDoubleProperty();
    
    public Account(String name){
        this.name.set(name);
        this.balance.set(0.00);
    }
    
    public void deposit(double amount) { setBalance(getBalance() + amount); }
    
    public void withdraw(double amount) { setBalance(getBalance() - amount);}
   
    
    public final double getBalance() { return balance.get(); }
    
    private final void setBalance(double amount) { balance.set(amount); }
    
    public ReadOnlyDoubleProperty balanceProperty() { return balance; }
    
    
    public final String getName() { return name.get(); }
    
    public final void setName(String name) { this.name.set(name); }
    
    public StringProperty nameProperty() { return name; }
    
    
}