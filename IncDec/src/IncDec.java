import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class IncDec extends Application {
    public static void main(String[] args) { launch(args); }
    
    private Label valueLbl;
    private TextField valueTf;
    private Button incrementBtn;
    private Button decrementBtn;
    
     @Override
     public void start(Stage stage) throws Exception {
        valueLbl = new Label("Value:");
        valueTf = new TextField();
        decrementBtn = new Button("-1");
        incrementBtn = new Button("+1");
        HBox hbox = new HBox(10, valueLbl, valueTf, decrementBtn, incrementBtn);
        hbox.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(hbox));
        stage.setTitle("IncDec");
        stage.show();
        
        incrementBtn.setOnAction(event -> setValue(getValue() + 1));
        decrementBtn.setOnAction(event -> setValue(getValue() -1 ));
    }
     
     private int getValue() {
         return Integer.parseInt(valueTf.getText());
     }
     
     private void setValue(int value) {
         valueTf.setText("" + value);
     }
}