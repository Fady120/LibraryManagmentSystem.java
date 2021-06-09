package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private Connection conn;
    private Statement stat;

    public Connection openConnection(){
        if(conn == null){
            String url = "jdbc:mysql://localhost/";
            String dbName = "librarymanagementsystem";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String pass = "";
            String myUrl = "jdbc:mysql://localhost:3306/librarymanagementsystem";
            try{
                Class.forName(driver);
                this.conn = (Connection) DriverManager.getConnection(url+dbName, userName,pass);
                System.out.println("Connection success");
            } catch(Exception e){
                System.out.println("Error");
            }
        }
        return conn;
    }


}
