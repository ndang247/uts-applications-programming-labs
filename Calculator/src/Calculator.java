import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.Pos;

public class Calculator extends Application {
   public static void main(String[] args){
       launch(args);
    }
    
    private Label firstNumberLbl;
    private Label secondNumberLbl;
    private Label operationLbl;
    private Label resultLbl;
    private TextField firstNumberTf;
    private TextField secondNumberTf;
    private TextField resultTf;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    
    @Override
    public void start(Stage stage) throws Exception {
        // create leaf nodes
        firstNumberLbl = new Label("First number:");
        secondNumberLbl = new Label("Second number:");
        operationLbl = new Label("Operation:");
        resultLbl = new Label("Result:");
        firstNumberTf = new TextField();
        secondNumberTf = new TextField();
        resultTf = new TextField();
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        // create branches
        GridPane gridPane = new GridPane();
        HBox hbox = new HBox(10, addBtn, subBtn, mulBtn, divBtn);
        // add the children to the gridPane -- columns x rows
        gridPane.add(firstNumberLbl, 0 , 0); 
        gridPane.add(secondNumberLbl, 0 , 1);
        gridPane.add(resultLbl, 0, 3);
        gridPane.add(operationLbl, 0, 2);
        gridPane.add(firstNumberTf, 1, 0);
        gridPane.add(secondNumberTf, 1, 1);
        gridPane.add(resultTf, 1, 3);
        gridPane.add(hbox, 1, 2);
        // set the scene and show the stage
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
        // event handlers
        addBtn.setOnAction(new AddHandler());
        subBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent event){
                setResult(getFirstValue() - getSecondValue());
            }
        });
        
        mulBtn.setOnAction(event -> setResult(getFirstValue() * getSecondValue()));
        divBtn.setOnAction(event -> setResult(getFirstValue() / getSecondValue()));
    }
    
    
    private int getFirstValue() {
        return Integer.parseInt(firstNumberTf.getText());
    }
    
    private int getSecondValue() {
        return Integer.parseInt(secondNumberTf.getText());
    }
    
    private void setResult(int result){
        resultTf.setText(""+result);
    }
    private class AddHandler implements EventHandler<ActionEvent> {
        @Override public void handle(ActionEvent event){
            setResult(getFirstValue() + getSecondValue());
        }
    }
}
