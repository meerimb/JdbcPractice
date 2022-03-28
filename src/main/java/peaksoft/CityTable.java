package peaksoft;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityTable {
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
                sql="CREATE TABLE IF NOT EXISTS CITIES"+
                        "(id serial PRIMARY KEY,"+
                        "name VARCHAR(50),"+
                        "population INTEGER NOT NULL,"+
                        "sightCity VARCHAR (100),"+
                        "mayor_Id INTEGER REFERENCES mayors(id))";
            }
            statement.executeUpdate(sql);
            System.out.println("create city table successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void saveCity(int id,String name,int population,String sightCity,int mayor_Id){
    String SAVE_SQL="INSERT INTO cities(id,name,population,sightCity,mayor_Id)VALUES(?,?,?,?,?)";
    try {
        Connection connection=connection();
        PreparedStatement statement=connection.prepareStatement(SAVE_SQL);
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,population);
            statement.setString(4,sightCity);
            statement.setInt(5,mayor_Id);
            statement.executeUpdate();
            System.out.println(name+" "+" add to database");

    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
    }

    @NotNull
    public static List<City>getAllCities(){
        String getAllCity_SQL="SELECT * FROM cities";
        List<City>cityArrayList=new ArrayList<>();
        try {
            Connection connection=connection();
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(getAllCity_SQL);
            while (resultSet.next()){
                City city=new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setPopulation(resultSet.getInt("population"));
                city.setMayorId(resultSet.getInt("mayor_Id"));
                cityArrayList.add(city);
                System.out.println(cityArrayList);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cityArrayList;
    }
}
