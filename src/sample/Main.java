package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Stage p = new Stage();
       /* Stage p1 = new Stage();
        Stage p2 = new Stage();
        Stage p3 = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("ViewTeacher.fxml"));
        Parent root4 = FXMLLoader.load(getClass().getResource("AddTeacher.fxml"));*/
        Parent root  = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        primaryStage.setTitle("Add Book");
        //p.setScene(new Scene(root1,700,700));
        //p1.setScene(new Scene(root2,700,700));
        // p2.setScene(new Scene(root3,700,700));
        //p3.setScene(new Scene(root4,700,700));
        primaryStage.setScene(new Scene(root, 700, 700));
        AddStudent addStudent=new AddStudent();
        addStudent.start();
        ViewTeacher viewTeacher=new ViewTeacher();
        viewTeacher.start();
        AddBook addBook=new AddBook();
        addBook.start();
        ViewBook viewBook=new ViewBook();
        viewBook.start();
        ViewStudent viewStudent=new ViewStudent();
        viewStudent.start();
        primaryStage.show();
        p.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
