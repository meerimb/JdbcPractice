package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDb {

    private static final String url="jdbc:postgresql://localhost:5432/postgres";
    private static final String user="postgres";
    private static final String password="meerim";

    public static Connection connection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,user,password);
            System.out.println("connected successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
