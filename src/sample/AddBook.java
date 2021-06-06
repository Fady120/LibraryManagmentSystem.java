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


public class AddBook {

    @FXML
    TextField T1;
    @FXML
    TextField T2;
    @FXML
    TextField T3;
    @FXML
    TextField T4;
    @FXML
    TextField T5;
    @FXML
    TextField T6;
    @FXML
    TextField T7;
    @FXML
    TextField T8;
    @FXML
    TextField T9;
    @FXML
    RadioButton R1;
    @FXML
    RadioButton R2;
    @FXML
    RadioButton R3;
    @FXML
    RadioButton R4;
    @FXML
    RadioButton R5;
    @FXML
    AnchorPane A1;
    static Stage stage;
    public  void  start() throws IOException {
        stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Book");
        stage.show();
    }


    public void NewBook(ActionEvent actionEvent)
    {
        Button b = (Button) actionEvent.getSource();
        String txtButton = b.getId();
        String Check = T1.getText();
        if(txtButton.equals("Save")) {
            int flag = 0;
            if(Global.c1!=0)
            {
                for (int i = 0; i < Global.c1; i++) {
                    if (Check.equals(Global.book.get(i).Name)) {
                        T9.setText("This book is already in your inventory, " + T6.getText() + " copies of it was added succesfully ");
                        Global.book.get(i).Quantity += Integer.parseInt(T6.getText());
                        Global.Wallet -= (Global.book.get(i).PurchasePrice * Global.book.get(i).Quantity);
                        flag = 1;
                    }
                }
            }


            if(flag==0) {

                Book B = new Book();
                B.Name = T1.getText();
                B.AuthorName = T2.getText();
                B.PublicationDate = T3.getText();
                B.PurchasePrice = Double.parseDouble(T4.getText());
                B.Price = Double.parseDouble(T5.getText());
                B.RentPrice = Double.parseDouble(T6.getText());
                B.Quantity = Integer.parseInt(T7.getText());
                B.Publisher = T8.getText();
                if (R1.isSelected() == true) B.State = 1;
                else if (R1.isSelected() == true) B.State = 2;
                else if (R1.isSelected() == true) B.State = 3;
                if (R1.isSelected() == true) B.Access = 1;
                else if (R1.isSelected() == true) B.State = 2;
                Global.book.add(B);
                Global.Wallet -= (B.PurchasePrice * B.Quantity);
                Global.c1++;

            }


            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
            T7.clear();
            T8.clear();
            R1.setSelected(false);
            R2.setSelected(false);
            R3.setSelected(false);
            R4.setSelected(false);
            R5.setSelected(false);


        }


        if(txtButton.equals("Close"))
        {
           /* String t =T9.getText();
            T9.setText(Book.Search(t,Global.book,Global.c1));
            Just to make sure everything work*/
            stage.close();
        }


    }

}




