package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

   Database myconnection = new Database();
    ResultSet rs;


    @Override
    public void start(Stage primaryStage) throws Exception{


        Statement stmt=myconnection.openConnection().createStatement();
        rs = stmt.executeQuery("select * from book");


        while (rs.next()){
            Book b= new Book();
            b.Name=rs.getString("BookName");
            b.AuthorName=rs.getString("AuthorName");
            b.PublicationDate=rs.getString("PublicationDate");
            b.PurchasePrice= rs.getInt("PurchasePrice");
            b.Price= rs.getDouble("Price");
            b.RentPrice= rs.getDouble("RentPrice");
            b.Quantity= rs.getInt("Quantity");
            b.Publisher=rs.getString("Publisher");
            b.State=rs.getInt("State1");
            b.Access=rs.getInt("Access");
            b.Borrow=rs.getInt("BooksBorrowed");
            b.Bought=rs.getInt("BooksBoughted");

            Global.book.add(b);
            Global.c1++;


        }


        rs = stmt.executeQuery("select * from studentinfo");


        while (rs.next()) {
            Student s = new Student();
            s.Name = rs.getString("Name");
            s.Department = rs.getString("Department");
            s.ID = rs.getInt("ID");
            s.E_mail = rs.getString("E_mail");
            s.C_borrow = rs.getInt("BooksBorrewed");
            s.C_bought = rs.getInt("BooksBoughted");


            Global.student.add(s);
            Global.c2++;


        }


        rs = stmt.executeQuery("select * from teacherinfo");


        while (rs.next()) {
            Teacher t = new Teacher();
            t.Name = rs.getString("Name");
            t.Department = rs.getString("Department");
            t.ID = rs.getInt("ID");
            t.E_mail = rs.getString("E_mail");
            t.C_borrow = rs.getInt("BooksBorrewed");
            t.C_bought = rs.getInt("BooksBoughted");


            Global.teacher.add(t);
            Global.c3++;


        }


        rs = stmt.executeQuery("select * from studentborrow");

        for (int i = 0; i < Global.c2; i++) {
            while (rs.next()) {
                Book b = new Book();
                int k = rs.getInt("ide");
                b.Name = rs.getString("BookName");
                b.AuthorName = rs.getString("AuthorName");
                b.PublicationDate = rs.getString("PublicationDate");
                b.Publisher = rs.getString("Publisher");
                b.RentPrice = rs.getDouble("RentPrice");
                b.State = rs.getInt("State");
                b.Access = rs.getInt("Access");

                if(k==i)
                Global.book.add(b);


            }
        }


        rs = stmt.executeQuery("select * from teacherborrow");

        for (int i = 0; i < Global.c3; i++) {
            while (rs.next()) {
                Book b = new Book();
                int k = rs.getInt("ide");
                b.Name = rs.getString("BookName");
                b.AuthorName = rs.getString("AuthorName");
                b.PublicationDate = rs.getString("PublicationDate");
                b.Publisher = rs.getString("Publisher");
                b.RentPrice = rs.getDouble("RentPrice");
                b.State = rs.getInt("State");
                b.Access = rs.getInt("Access");

                if(k==i)
                    Global.book.add(b);


            }
        }



        rs = stmt.executeQuery("select * from studentbougth");

        for (int i = 0; i < Global.c2; i++) {
            while (rs.next()) {
                Book b = new Book();
                int k = rs.getInt("ide");
                b.Name = rs.getString("BookName");
                b.AuthorName = rs.getString("AuthorName");
                b.PublicationDate = rs.getString("PublicationDate");
                b.Publisher = rs.getString("Publisher");
                b.PurchasePrice = rs.getDouble("PurchasePrice");
                b.State = rs.getInt("State");
                b.Access = rs.getInt("Access");

                if(k==i)
                    Global.book.add(b);

            }
        }



        rs = stmt.executeQuery("select * from teacherbougth");

        for (int i = 0; i < Global.c3; i++) {
            while (rs.next()) {
                Book b = new Book();
                int k = rs.getInt("ide");
                b.Name = rs.getString("BookName");
                b.AuthorName = rs.getString("AuthorName");
                b.PublicationDate = rs.getString("PublicationDate");
                b.Publisher = rs.getString("Publisher");
                b.PurchasePrice = rs.getDouble("PurchasePrice");
                b.State = rs.getInt("State");
                b.Access = rs.getInt("Access");

                if(k==i)
                    Global.book.add(b);

            }
        }



        rs = stmt.executeQuery("select * from finance");

            while (rs.next()) {
                Global.Wallet = rs.getDouble("Wallet");
            }


        Login login = new Login();
        login.start();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
