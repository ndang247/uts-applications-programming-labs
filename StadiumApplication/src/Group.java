import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

public class Group{
    // in this application name could be final and thus could be declared as String
    private StringProperty name = new SimpleStringProperty();
    // in this application capacity could be final and thus could be declared as int
    private IntegerProperty capacity = new SimpleIntegerProperty();
    // in this application price could be final and thus could be declared as double
    private DoubleProperty price = new SimpleDoubleProperty();
    
    private IntegerProperty sold = new SimpleIntegerProperty();
    private DoubleProperty income = new SimpleDoubleProperty();
    private IntegerProperty left = new SimpleIntegerProperty();

    
    public Group(String name, int capacity, double price){
        this.name.set(name);
        this.capacity.set(capacity);
        this.price.set(price);
        // income bind to sold * price
        income.bind(sold.multiply(price));
        // left bind to capacity - sold
        left.bind(Bindings.subtract(capacity, sold));
        // set sold to 0 after selling
        sold.set(0);
    }
    
    public final String getName(){ return name.get(); }
    public ReadOnlyStringProperty nameProperty(){ return name; }

    
    public final int getCapacity(){ return capacity.get(); }
    public ReadOnlyIntegerProperty capacityProperty(){ return capacity; }

    public final double getPrice(){ return price.get(); }
    public ReadOnlyDoubleProperty priceProperty(){ return price; }
    
    public final int getSold(){ return sold.get(); }
    public ReadOnlyIntegerProperty soldProperty(){ return sold; }

    public final double getIncome(){ return income.get(); }
    public ReadOnlyDoubleProperty incomeProperty(){ return income; }
    
    
    public final int getLeft(){ return left.get(); }
    public ReadOnlyIntegerProperty leftProperty(){ return left; }

    public void sell(int number){
        sold.set(getSold() + number);
    }
}