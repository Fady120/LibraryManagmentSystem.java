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

import java.io.IOException;

public class ViewStudent {

    @FXML
    TextField T1;
    @FXML
    TextArea TA1;
    static Stage stage;
    public  void  start() throws IOException {
        stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Viewstudent(ActionEvent actionEvent)
    {

        Button B =(Button) actionEvent.getSource();
        String txt = B.getId();
        String Target;
        if(txt.equals("Search"))
        {
            Target= T1.getText();
            TA1.setText(Global.student.get(0).search(Target,Global.student,Global.teacher,Global.c2));
        }

    }
}
