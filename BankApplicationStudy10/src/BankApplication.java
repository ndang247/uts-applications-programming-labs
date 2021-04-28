import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;
import model.*;
import au.edu.uts.ap.javafx.*;

public class BankApplication extends Application{
    public static void main(String[] args){ launch(args); }
    
    @Override
    public void start(Stage stage) throws Exception{
        Customer customer = new Customer("Mr Smith");
        ViewLoader.showStage(customer, "/view/customer.fxml", "Customer", stage);
    }
}


