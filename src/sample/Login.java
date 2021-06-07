package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    TextField email;
    @FXML
    PasswordField pass;
    static Stage stage;
    public void initialize() throws IOException {
        stage=new Stage();
    }
    public  void  start() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();

    }
    public void login() throws IOException {
        if(email.getText().contains("admin")&&pass.getText().equals("admin"))
        {
            FormsConnections formsConnections = new FormsConnections();
            formsConnections.start();
            stage.hide();
        }
    }
}
