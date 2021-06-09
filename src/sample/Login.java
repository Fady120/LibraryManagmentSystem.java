package sample;
import com.sun.xml.internal.ws.api.message.Message;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login {
    Database myconnection = new Database();
    ResultSet rs;
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
    public void login() throws IOException, SQLException {


        String clientUname= email.getText();
        String clientpass=  pass.getText();

        Statement stmt=myconnection.openConnection().createStatement();
        rs = stmt.executeQuery("select * from admin where UserName = '" + clientUname + "' and Password ='" + clientpass + "' ");
        if(rs.next())
        {
            FormsConnections formsConnections = new FormsConnections();
            formsConnections.start();

            stage.close();
        }
        else
            JOptionPane.showMessageDialog(null, "Username/ Password Not Correct");
    }
}
