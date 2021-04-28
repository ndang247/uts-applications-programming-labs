import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class StadiumController{
    private Stadium stadium = new Stadium();
    @FXML private TextField sellTf;
    
    public final Stadium getStadium(){ return stadium; }
    
    @FXML private void handleSell(ActionEvent event){
        getStadium().getGroup().sell(getAmount());
        setSell(0);
    }
    
    private int getAmount(){
        return Integer.parseInt(sellTf.getText());
    }
    
    private void setSell(int amount){
        sellTf.setText("" + amount);
    }
    
}