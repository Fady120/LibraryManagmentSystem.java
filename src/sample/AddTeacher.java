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
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTeacher {

    Database myconnection = new Database();

    @FXML
    TextField T1;
    @FXML
    TextField T2;
    @FXML
    TextField T3;
    @FXML
    TextField T4;

    static Stage stage;
    public  void  start() throws IOException {
        stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddTeacher.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Teacher");
        stage.show();
    }
    public void Addteacher(ActionEvent actionEvent) throws SQLException {
        Button B = (Button) actionEvent.getSource();
        String txt= B.getId();
        if(txt.equals("Save"))
        {
            Teacher teachers = new Teacher();
            teachers.Name=T1.getText();
            teachers.Department=T2.getText();
            teachers.ID=Integer.parseInt(T3.getText());
            teachers.E_mail=T4.getText();
            Global.teacher.add(teachers);

            PreparedStatement ps = myconnection.openConnection().prepareStatement("insert into teacherinfo (ide,Name  , Department, ID, E_mail,BooksBorrewed,BooksBoughted)  values('"+ Global.c3 +"','" + T1.getText() + "','" + T2.getText() + "','" + T3.getText() + "','" + T4.getText() + "','" + teachers.C_borrow + "','" + teachers.C_bought + "')");
            ps.executeUpdate();
            ps.close();

            Global.c3++;



            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
        }

        if (txt.equals("Close"))
        {
            stage.close();
        }
    }

}
