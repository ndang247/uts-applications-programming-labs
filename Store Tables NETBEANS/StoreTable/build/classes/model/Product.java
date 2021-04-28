package model;

import java.text.*;
import javafx.beans.property.*;
import javafx.beans.binding.*;
import java.util.*;

public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private String name;
    public final String getName() { return name; }

    private IntegerProperty stock = new SimpleIntegerProperty();
    public final int getStock() { return stock.get(); }
    public ReadOnlyIntegerProperty stockProperty() { return stock; }

    private DoubleProperty price = new SimpleDoubleProperty();
    public final double getPrice() { return price.get(); }
    private void setPrice(double price){ this.price.set(price); }
    public ReadOnlyDoubleProperty priceProperty() { return price; }
    
    private DoubleProperty money = new SimpleDoubleProperty();
    public final double getMoney() { return money.get(); }
    public ReadOnlyDoubleProperty moneyProperty() { return money; }
    
    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock.set(stock);
        this.price.set(price);
    }

    public void sell(int n) throws Exception{
        if(has(n)){
            stock.set(stock.get() - n);
            money.set(n * getPrice()); // double money = n * price;
            for (ProductObserver observer : observers)
                observer.handleSale(getMoney());
        }
        else throw new Exception();
    }

    public void restock(int n) {
        stock.set(stock.get() + n);
    }

    public boolean has(int n) {
        return stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return String.format("%s ($%.2f)", name, price);
    }
}
