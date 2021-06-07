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

public class FormsConnections {


    static Stage stage;

    public void start() throws IOException {
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FormsConnections.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("library Management System");
        stage.show();
    }

    public void formconnections(ActionEvent actionEvent) throws IOException {
        Button b = (Button) actionEvent.getSource();
        String txt = b.getId();
        if (txt.equals("AddBook"))
        {
            AddBook addBook=new AddBook();
            addBook.start();
        }

        if (txt.equals("AddStudent"))
        {
            AddStudent addStudent=new AddStudent();
            addStudent.start();
        }

        if (txt.equals("AddTeacher"))
        {
            AddTeacher addTeacher=new AddTeacher();
            addTeacher.start();
        }

        if (txt.equals("ViewBook"))
        {
            ViewBook viewBook=new ViewBook();
            viewBook.start();
        }

        if (txt.equals("ViewStudent"))
        {
            ViewStudent viewStudent=new ViewStudent();
            viewStudent.start();
        }

        if (txt.equals("ViewTeacher"))
        {
            ViewTeacher viewTeacher=new ViewTeacher();
            viewTeacher.start();
        }

        if (txt.equals("BorrowStudent"))
        {
            BorrowStudent borrowStudent=new BorrowStudent();
            borrowStudent.start();
        }

        if (txt.equals("BorrowTeacher"))
        {
            BorrowTeacher borrowTeacher=new BorrowTeacher();
            borrowTeacher.start();
        }

        if (txt.equals("PurchasingStudent"))
        {
              PurchasingStudent purchasingStudent = new PurchasingStudent();
              purchasingStudent.start();
        }

        if (txt.equals("PurchasingTeacher"))
        {
            PurchasingTeacher purchasingTeacher = new PurchasingTeacher();
            purchasingTeacher.start();
        }

        if (txt.equals("ReturnBook"))
        {
            Return aReturn = new Return();
            aReturn.start();
        }

        if (txt.equals("Wallet"))
        {
            Wallet wallet = new Wallet();
            wallet.start();
        }

        if (txt.equals("Close"))
        {
            stage.close();
        }
    }

}
