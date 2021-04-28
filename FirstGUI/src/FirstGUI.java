import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;


public class FirstGUI extends Application {
    public static void main(String[] args){ launch(args);}
    
    private Label valueLbl;
    private TextField valueTf;
    private Button incrementBtn;
    
    @Override public void start(Stage stage) throws Exception {
    
        valueLbl = new Label("Value:");
        valueTf = new TextField();
        incrementBtn = new Button("+1");
        HBox hbox = new HBox(10, valueLbl, valueTf, incrementBtn);
        stage.setScene(new Scene(hbox));
        stage.setTitle("Incrementor");
        stage.show();
        
        incrementBtn.setOnAction(event -> setValue(getValue() + 1));
    }
    
    private int getValue(){
        return Integer.parseInt(valueTf.getText());
    }
    
    private void setValue(int value){
        valueTf.setText("" + value);
    }
}