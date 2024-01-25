package common.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDbConnector {
      // Replace these with your database details
        String hostname = "localhost";
        String database = "bhbg3ury0rbjdqvkjbmx";
        String user = "root";
        String pw = "";
    private Connection myConnection = null;
    String url = "jdbc:mysql://" + hostname + ":3306/" + database;
   
    private void registerMyConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          
            System.out.println("Successfully Connected");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error in registering the diver" + ex.getMessage());
        }
    }

    
    public Connection getMyConnection(){
        
        registerMyConnection();

        try {
            myConnection = DriverManager.getConnection(url, user, pw);
        } catch (SQLException ex) {
            System.out.println("Error in getting connection");
        }
        return myConnection;
    }
}

