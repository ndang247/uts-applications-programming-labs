import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;

public class BankApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("Account.fxml"));
	Parent root = loader.load();
	stage.setTitle("Account");
	stage.setScene(new Scene(root));
	stage.sizeToScene();
	stage.show();
    }
}
