import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;

public class StoreController {
    private Store store = new Store();
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    
    public final Store getStore(){ return store; }
    
    @FXML private void initialize(){
        stockTxt.textProperty().bind(store.getProduct().stockProperty().asString().concat(" items"));
        cashTxt.textProperty().bind(store.getCashRegister().cashProperty().asString("$%.2f"));
        priceTxt.textProperty().bind(store.getProduct().priceProperty().asString("$%.2f"));
    }
    
    private final int getAmount(){ return Integer.parseInt(amountTf.getText()); }
    
    private void setAmount(int amount){ amountTf.setText(""+amount); }
    
    @FXML private void handleSell(ActionEvent event){
        Product product = getStore().getProduct();
        int amount = getAmount();
        if(product.hasStock(amount)){
            product.sell(amount);
        }
        setAmount(0);
    }
    
}