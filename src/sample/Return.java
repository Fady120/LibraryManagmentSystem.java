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


public class Return {


    Database myconnection = new Database();
    private PreparedStatement ps;

    @FXML
    TextField T1;
    @FXML
    TextField T2;
    @FXML
    RadioButton R1;
    @FXML
    RadioButton R2;

    static Stage stage;

    public void start() throws IOException {
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Return.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Return");
        stage.show();
    }

    public void ReturnThings(ActionEvent actionEvent) throws SQLException {
        Button b = (Button) actionEvent.getSource();
        String txt = b.getId();
        if (txt.equals("Excute")) {

            if (R1.isSelected())
            {
                int flag = 0;
                for (int i = 0; i < Global.c3; i++)
                {
                    if (Global.teacher.get(i).Name.equals(T1.getText()))
                    {
                        for (int j = 0; j < Global.teacher.get(i).C_borrow; j++)
                        {
                            if (Global.teacher.get(i).Borrow.get(j).Name.equals(T2.getText()))
                            {
                                Global.teacher.get(i).C_borrow--;
                                Global.teacher.get(i).Borrow.remove(j);



                                String sqlUpdate = "UPDATE teacherinfo " + "SET BooksBorrewed = ? " + "WHERE ide = ?";
                                ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                ps.setInt(1,Global.student.get(i).C_borrow );
                                ps.setInt(2, i);
                                ps.executeUpdate();


                                for (int z = 0; z < Global.c1; z++)
                                {
                                    if (T2.getText().equals(Global.book.get(z).Name))
                                    {
                                        Global.book.get(z).Borrow--;
                                        Global.book.get(z).Quantity++;

                                        sqlUpdate = "UPDATE book "
                                                + "SET BooksBorrowed = ?"
                                                + "WHERE ide = ?";
                                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                        ps.setString(1,String.valueOf(Global.book.get(z).Borrow) );
                                        ps.setInt(2, z);
                                        ps.executeUpdate();


                                        sqlUpdate = "UPDATE book "
                                                + "SET Quantity = ?"
                                                + "WHERE ide = ?";
                                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                        ps.setString(1,String.valueOf(Global.book.get(z).Quantity) );
                                        ps.setInt(2, z);
                                        ps.executeUpdate();


                                        sqlUpdate = "DELETE from teacherBorrow "
                                                + "WHERE ide = ?"
                                                +"AND BookName = ?";
                                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                        ps.setString(1,String.valueOf(Global.book.get(z).Name) );
                                        ps.setInt(2, i);
                                        ps.executeUpdate();


                                        break;
                                    }

                                }
                                flag = 1;

                            }
                        }
                    }
                }
                if (flag == 1)
                    JOptionPane.showMessageDialog(null, "Book returned to the library successfully", "Display Message",
                            JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "operation failed", "Display Message",
                            JOptionPane.INFORMATION_MESSAGE);
            }
            else if (R2.isSelected())
            {
                int flag = 0;
                for (int i = 0; i < Global.c2; i++)
                {
                    if (Global.student.get(i).Name.equals(T1.getText()))
                    {
                        for (int j = 0; j < Global.student.get(i).C_borrow; j++)
                        {
                            if (Global.student.get(i).Borrow.get(j).Name.equals(T2.getText()))
                            {
                                Global.student.get(i).C_borrow--;
                                Global.student.get(i).Borrow.remove(j);


                                String sqlUpdate = "UPDATE studentinfo " + "SET BooksBorrewed = ? " + "WHERE ide = ?";
                                ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                ps.setInt(1,Global.student.get(i).C_borrow );
                                ps.setInt(2, i);
                                ps.executeUpdate();

                                for (int z = 0; z < Global.c1; z++)
                                {
                                    if (T2.getText().equals(Global.book.get(z).Name))
                                    {
                                        Global.book.get(z).Borrow--;
                                        Global.book.get(z).Quantity++;

                                        sqlUpdate = "UPDATE book "
                                                + "SET BooksBorrowed = ?"
                                                + "WHERE ide = ?";
                                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                        ps.setString(1,String.valueOf(Global.book.get(z).Borrow) );
                                        ps.setInt(2, z);
                                        ps.executeUpdate();

                                        sqlUpdate = "UPDATE book "
                                                + "SET Quantity = ?"
                                                + "WHERE ide = ?";
                                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                        ps.setString(1,String.valueOf(Global.book.get(z).Quantity) );
                                        ps.setInt(2, z);
                                        ps.executeUpdate();


                                        sqlUpdate = "DELETE from studentBorrow "
                                                + "WHERE ide = ?"
                                                +"AND BookName = ?";
                                        ps = myconnection.openConnection().prepareStatement(sqlUpdate);
                                        ps.setString(1,String.valueOf(Global.book.get(z).Name) );
                                        ps.setInt(2, i);
                                        ps.executeUpdate();


                                        break;
                                    }

                                }
                                flag = 1;

                            }
                        }
                    }
                }
                if (flag == 1)
                    JOptionPane.showMessageDialog(null, "Book returned to the library successfully", "Display Message",
                            JOptionPane.INFORMATION_MESSAGE);
                else
                JOptionPane.showMessageDialog(null, "operation failed", "Display Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }


        if(txt.equals("Close"))
        {
            stage.close();
        }


    }


}

