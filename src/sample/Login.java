package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    Hyperlink here;
    @FXML
    RadioButton teacherRad;
    @FXML
    RadioButton studentRad;
    @FXML
    Label signUp;
    static Stage stage;
    public void initialize() throws IOException {
        stage=new Stage();
        signUp.setVisible(false);
        here.setVisible(false);
    }
    public  void  start() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();

    }
    public void radio()
    {
            studentRad.setSelected(true);
            teacherRad.setSelected(false);
            signUp.setVisible(true);
            here.setVisible(true);
    }
    public void radio2()
    {
        studentRad.setSelected(false);
        teacherRad.setSelected(true);
        signUp.setVisible(false);
        here.setVisible(false);
    }
    public void signUP()
    {
        new Alert(Alert.AlertType.WARNING, "This is a test if i didn't make the sign up form please make it").showAndWait();
    }
    public void login()
    {
        new Alert(Alert.AlertType.WARNING, "This is a test\nplease make conditions depending on the selected radio button").showAndWait();
    }
}
