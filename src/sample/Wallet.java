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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wallet  {

    @FXML
    TextField T1;


    static Stage stage;

    public void start() throws IOException {
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Wallet.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Wallet");
        stage.show();
    }


    public void initialize() throws IOException {

        T1.setText(Global.Wallet+" $");

        }

    public void walletClose(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        String txt = b.getId();
        if(txt.equals("Close"))
        {
            stage.close();
        }
    }

}
