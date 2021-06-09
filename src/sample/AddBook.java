package sample;

import com.sun.xml.internal.ws.api.message.Message;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

import java.net.URL;



public class AddBook {

    Database myconnection = new Database();
    private PreparedStatement ps;

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




    public void NewBook(ActionEvent actionEvent) throws SQLException {
        Button b = (Button) actionEvent.getSource();
        String txtButton = b.getId();
        String Check = T1.getText();
        if(txtButton.equals("Save")) {
            int flag = 0;
            if(Global.c1!=0)
            {
                for (int i = 0; i < Global.c1; i++) {
                    if (Check.equals(Global.book.get(i).Name)) {
                        JOptionPane.showMessageDialog(null, "This book is already in your inventory, " + T7.getText() + " copies of it was added succesfully ", "Display Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        Global.book.get(i).Quantity += Integer.parseInt(T7.getText());
                        Global.Wallet -= (Global.book.get(i).PurchasePrice * Integer.parseInt(T7.getText()));
                        flag = 1;


                        String sqlUpdate = "UPDATE book "
                                + "SET Quantity = ? "
                                + "WHERE ide = ?";

                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);


                        ps.setInt(1,Global.book.get(i).Quantity );
                        ps.setInt(2, i);

                        ps.executeUpdate();
                         sqlUpdate = "UPDATE finance "
                                + "SET Wallet = ? ";

                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);


                        ps.setDouble(1,Global.Wallet);

                        ps.executeUpdate();
                        ps.close();
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
                Global.Wallet =Global.Wallet - (B.Quantity * B.Price);

                if (R1.isSelected())
                {
                    B.State = 1;
                    R2.setSelected(false);
                    R3.setSelected(false);
                }

                 else if (R2.isSelected())
                {
                    B.State = 2;
                    R1.setSelected(false);
                    R3.setSelected(false);
                }

                 else if (R3.isSelected())
                {
                    B.State = 3;
                    R1.setSelected(false);
                    R2.setSelected(false);
                }

                if (R4.isSelected())
                {
                    B.Access = 1;
                    R5.setSelected(false);
                }
                 else if (R5.isSelected())
                {
                    B.Access = 2;
                    R4.setSelected(false);
                }

                Global.book.add(B);
                Global.Wallet -= (B.PurchasePrice * B.Quantity);
                ps = myconnection.openConnection().prepareStatement("insert into book values('" + Global.c1 + "','" + T1.getText() + "','" + T2.getText() + "','" + T3.getText() + "','" + T4.getText() + "','" + T5.getText() + "','" + T6.getText() + "','" + Integer.parseInt( T7.getText()) + "','" + T8.getText() + "','"+B.State+"','"+B.Access+"','"+B.Borrow+"','"+B.Bought+"')");
                ps.executeUpdate();
                String sqlUpdate = "UPDATE finance "
                        + "SET Wallet = ? ";
                ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                ps.setDouble(1,Global.Wallet);
                ps.executeUpdate();
                ps.close();
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




