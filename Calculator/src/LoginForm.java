import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class LoginForm extends Application {
	public static void main(String[] args) { 
            launch(args);
        }

	private Label usernameLbl;
	private TextField usernameTf;
	private Label passwordLbl;
	private PasswordField passwordPf;
	private Button loginBtn;
	private Text resultTxt;

	@Override
	public void start(Stage stage) throws Exception {
            // create leaf nodes
            usernameLbl = new Label("Username:");
            usernameTf = new TextField();
            passwordLbl = new Label("Password:");
            passwordPf = new PasswordField();
            loginBtn = new Button("Login");
            resultTxt = new Text();
            // create branches
            GridPane gridPane = new GridPane();
            gridPane.add(usernameLbl, 0 ,0);
            gridPane.add(usernameTf, 1, 0);
            gridPane.add(passwordLbl, 0, 1);
            gridPane.add(passwordPf, 1, 1);
            gridPane.add(loginBtn, 1, 2);
            gridPane.add(resultTxt, 1, 3);
            // set the scene and show the stage
            Scene scene = new Scene(gridPane);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
            // event handlers
            loginBtn.setOnAction(event -> checkPassword());
	}

	private void checkPassword() {
            if(getPassword().equals("mypassword") && getUsername().equals("sam")){
                setResult("Password correct!");
            }
            else setResult("Password incorrect!");
	}

	private String getUsername() {
            return usernameTf.getText();
	}

	private String getPassword() {
            return passwordPf.getText();
	}

	private void setResult(String result) {
            resultTxt.setText(result);
        }
}