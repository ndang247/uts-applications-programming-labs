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
import au.edu.uts.ap.javafx.*;
import model.*;

public class ProductController extends Controller<Product> {
	@FXML private TextField amountTf;
        @FXML private Button sellBtn;

	public final Product getProduct() { return model; }
	private final int getAmount() { return Integer.parseInt(amountTf.getText()); }
	private final void setAmount(int amount) { amountTf.setText(""+amount); }
        
        @FXML private void initialize(){
            amountTf.textProperty().addListener((o, oldAmount, newAmount) -> 
                    updateSellBtn());
        }
        
        private void updateSellBtn(){
            sellBtn.setDisable(amountTf.getText().isEmpty() || !getProduct().has(getAmount()));
        }
        
	@FXML private void handleSell(ActionEvent event){
            try{
                int amount = getAmount();
	        getProduct().sell(amount);
		setAmount(0);
            }
            catch (Exception e){
                
            }
            finally{
                setAmount(0);
            }
	}
}
