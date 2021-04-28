import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

public class StadiumApplication extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Stadium.fxml"));
	Parent root = loader.load();
	stage.setTitle("Stadium");
	stage.setScene(new Scene(root));
	stage.sizeToScene();
	stage.show();
    }
}

