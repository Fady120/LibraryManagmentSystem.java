package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
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
        Login login=new Login();
        login.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
