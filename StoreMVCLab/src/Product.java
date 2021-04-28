import java.util.*;
import javafx.beans.property.*;

public class Product{
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private String name;
    private IntegerProperty stock = new SimpleIntegerProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private DoubleProperty money = new SimpleDoubleProperty();
    
    public Product(String name, int stock, double price){
        this.name = name;
        this.stock.set(stock);
        this.price.set(price);
    }
    
    public final String getName(){ return name; }
    public final double getMoney(){ return money.get(); }
    
    public final double getPrice(){ return price.get(); }
    public final DoubleProperty priceProperty(){ return price; }
    
    public final int getStock(){ return stock.get(); }
    public final IntegerProperty stockProperty(){ return stock; }
    
    public void sell(int n){
        stock.set(stock.get() - n);
        money.set(n*getPrice());
        // do the observer handle
        for(ProductObserver observer : observers){
            observer.handleSale(getMoney());
        }
    }
    
    public void restock(int n){
        stock.set(stock.get() + n);
    }
    
    //
    public boolean hasStock(int n){
        return getStock() >= n;
    }
    
    // add the product observer
    public void addProductObserver(ProductObserver observer){
        observers.add(observer);
    }
    
    @Override
    public String toString(){
        return stock + " " + name + " at $" + price;
    }

}