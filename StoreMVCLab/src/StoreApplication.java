import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.fxml.*;

public class StoreApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));
        
        // Add code here to load the root node from the FXML file
        Parent root = loader.load();
        // and show it
        stage.setScene(new Scene(root));
        stage.setTitle("Store");
        stage.sizeToScene();
        stage.show();
    }
}