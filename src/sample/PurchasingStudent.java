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

public class PurchasingStudent {

    Database myconnection = new Database();
    private PreparedStatement ps;

    @FXML
    TextField T1;
    @FXML
    TextField T2;


    static Stage stage;

    public  void  start() throws IOException {
        stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PurchasingStudent.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Purchasing Student");
        stage.show();
    }

    public void purchasingstudent(ActionEvent actionEvent) throws SQLException {
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
                    Check2 = 1;
                    break;
                }
            }
            for (j = 0; j < Global.c2; j++)
            {
                if (StudentName.equals(Global.student.get(j).Name))
                {
                    Check1 = 1;
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
                if (Global.book.get(i).State == 1)
                {
                    JOptionPane.showMessageDialog(null, "Sorry, this book is for borrowing only", "Display Message",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (Global.book.get(i).Access == 1)
                {
                    JOptionPane.showMessageDialog(null, "Sorry, this book is available for teachers only", "Display Message",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    Global.student.get(j).Bought.add(Global.book.get(i));
                    Global.student.get(j).C_bought++;
                    Global.book.get(i).Bought++;
                    Global.book.get(i).Quantity--;
                    Global.Wallet += Global.book.get(i).Price;


                    ps = myconnection.openConnection().prepareStatement("insert into studentbougth values('" + j + "','" + Global.book.get(i).Name + "','" + Global.book.get(i).AuthorName + "','" + Global.book.get(i).PublicationDate + "','" + Global.book.get(i).Publisher + "','" + String.valueOf( Global.book.get(i).PurchasePrice )+ "','" + Global.book.get(i).State + "','" + Global.book.get(i).Access + "')");
                    ps.executeUpdate();

                    String sqlUpdate = "UPDATE studentinfo " + "SET BooksBoughted = ? " + "WHERE ide = ?";
                    ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                    ps.setInt(1,Global.student.get(j).C_bought );
                    ps.setInt(2, j);
                    ps.executeUpdate();


                    sqlUpdate = "UPDATE book "
                            + "SET BooksBoughted = ?"
                            + "WHERE ide = ?";
                    ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                    ps.setString(1,String.valueOf(Global.book.get(i).Bought) );
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


                    JOptionPane.showMessageDialog(null, "Book bought successfully", "Display Message",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            }


        }

        if(txt.equals("Close"))
        {
            stage.close();
        }
    }


}
