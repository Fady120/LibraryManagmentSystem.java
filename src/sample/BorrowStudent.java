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
import java.sql.SQLException;


public class BorrowStudent {

    Database myconnection = new Database();
    private PreparedStatement ps;

    @FXML
    TextField T1;
    @FXML
    TextField T2;


    static Stage stage;

    public  void  start() throws IOException {
        stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("BorrowStudent.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Borrow Student");
        stage.show();
    }



    public void borrowstudent(ActionEvent actionEvent) throws SQLException {
        Button B =(Button) actionEvent.getSource();
        String txt = B.getId();

        if(txt.equals("Excute"))
        {
            String StudentName, BookName;
            int Check1=0,Check2=0,i=0,j=0;
            StudentName = T1.getText();
            BookName = T2.getText();

            for (i = 0; i < Global.c1; i++)
            {
                if (BookName.equals(Global.book.get(i).Name))
                {
                    Check1 = 1;
                    break;
                }
            }
            for (j = 0; j < Global.c2; j++)
            {
                if (StudentName.equals(Global.student.get(j).Name))
                {
                    Check2 = 1;
                    break;
                }
            }

            if (Check1 == 0 && Check2 == 0)

                JOptionPane.showMessageDialog(null, "Invalid student's name, and book's name", "Display Message",
                        JOptionPane.INFORMATION_MESSAGE);
            else if (Check1 == 0)
                JOptionPane.showMessageDialog(null, "Invalid student's name", "Display Message",
                        JOptionPane.INFORMATION_MESSAGE);
            else if (Check2 == 0)
                JOptionPane.showMessageDialog(null, "Invalid book's name", "Display Message",
                        JOptionPane.INFORMATION_MESSAGE);

              else
            {
                int flag = 0;
                for (int z = 0; z < Global.student.get(j).C_borrow; z++)
                {
                    if (BookName.equals(Global.student.get(j).Borrow.get(z).Name))
                    {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                {
                    if (Global.book.get(i).State == 2)
                    {
                        JOptionPane.showMessageDialog(null, "Sorry, this book is for purchasing only", "Display Message",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (Global.book.get(i).Access == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Sorry, this book is available for teachers only", "Display Message",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        Global.student.get(j).Borrow.add(Global.book.get(i));
                        Global.student.get(j).C_borrow++;
                        Global.book.get(i).Borrow++;
                        Global.book.get(i).Quantity--;
                        Global.Wallet += Global.book.get(i).RentPrice;


                        ps = myconnection.openConnection().prepareStatement("insert into studentborrow values('" + j + "','" + Global.book.get(i).Name + "','" + Global.book.get(i).AuthorName + "','" + Global.book.get(i).PublicationDate + "','" + Global.book.get(i).Publisher + "','" + String.valueOf( Global.book.get(i).RentPrice )+ "','" + Global.book.get(i).State + "','" + Global.book.get(i).Access + "')");
                        ps.executeUpdate();

                        String sqlUpdate = "UPDATE studentinfo " + "SET BooksBorrewed = ? " + "WHERE ide = ?";
                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                        ps.setInt(1,Global.student.get(j).C_borrow );
                        ps.setInt(2, j);
                        ps.executeUpdate();


                        sqlUpdate = "UPDATE book "
                                + "SET BooksBorrowed = ?"
                                + "WHERE ide = ?";
                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                        ps.setString(1,String.valueOf(Global.book.get(i).Borrow) );
                        ps.setInt(2, i);
                        ps.executeUpdate();


                        sqlUpdate = "UPDATE book "
                                + "SET Quantity = ?"
                                + "WHERE ide = ?";
                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                        ps.setString(1,String.valueOf(Global.book.get(i).Quantity));
                        ps.setInt(2, i);
                        ps.executeUpdate();


                        sqlUpdate = "UPDATE finance "
                                + "SET Wallet = ? ";
                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                        ps.setDouble(1,Global.Wallet);
                        ps.executeUpdate();

                        ps.close();



                        JOptionPane.showMessageDialog(null, "Book borrowed successfully", "Display Message",
                                JOptionPane.INFORMATION_MESSAGE);

                        T1.clear();
                        T2.clear();
                    }
                }
                else
                JOptionPane.showMessageDialog(null, "Sorry, You can't borrow the same book more than once", "Display Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }


        }

        if(txt.equals("Close"))
        {
            stage.close();
        }
    }

}
