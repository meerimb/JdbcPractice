package peaksoft;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MayorTable {
    private static final String url="jdbc:postgresql://localhost:5432/postgres";
    private static final String user="postgres";
    private static final String password="meerim";

    public static Connection connection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,user,password);
            Statement statement=connection.createStatement();
            String sql;
            {
                sql="CREATE TABLE IF NOT EXISTS MAYORS"+
                        "(id serial PRIMARY KEY,"+
                        "mayorName VARCHAR(250),"+
                        "mayorSurname VARCHAR(250),"+
                        "age INTEGER NOT NULL,"+
                        "nationality VARCHAR(250))";
            }
            statement.executeUpdate(sql);
            System.out.println("create mayor table successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void saveMayors(int id,String mayorName,String mayorSurname,int age,String nationality){
        String Save_Mayors_Sql="INSERT INTO mayors(id,mayorName,mayorSurname,age,nationality) VALUES(?,?,?,?,?)";
        try {
            Connection connection=connection();
            PreparedStatement statement= connection().prepareStatement(Save_Mayors_Sql);
            statement.setInt(1,id);
            statement.setString(2,mayorName);
            statement.setString(3,mayorSurname);
            statement.setInt(4,age);
            statement.setString(5,nationality);
            statement.executeUpdate();
            System.out.println(mayorName+" add to mayors database");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @NotNull
    public static List<Mayor> getAllMayors(){
        String getAllMayor_Sql="SELECT * FROM mayors";
        List<Mayor>mayorList=new ArrayList<>();
        try {
            Connection connection=connection();
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery(getAllMayor_Sql);
            while (resultSet.next()){
                Mayor mayor=new Mayor();
                mayor.setId(resultSet.getInt("id"));
                mayor.setMayorName(resultSet.getString("mayorName"));
                mayor.setMayorSurname(resultSet.getString("mayorSurname"));
                mayor.setAge(resultSet.getInt("age"));
                mayor.setNationality(resultSet.getString("nationality"));
                mayorList.add(mayor);
                System.out.println(mayorList);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return mayorList;
    }
}
