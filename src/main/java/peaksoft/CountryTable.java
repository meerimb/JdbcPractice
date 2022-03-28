package peaksoft;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryTable {
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
                sql="CREATE TABLE IF NOT EXISTS countries"+
                        "(id serial PRIMARY KEY,"+
                        "countryName VARCHAR(50),"+
                        "population INTEGER NOT NULL ,"+
                        "language VARCHAR (50),"+
                        "currencyName VARCHAR(50),"+
                        "city_Id INTEGER REFERENCES cities(id))";
            }
            statement.executeUpdate(sql);
            System.out.println("create country table successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void saveCountries(int id,String countryName, int population, String language, String currencyName,int city_Id){
        String Save_Country_Sql="INSERT INTO countries(id,countryName,population,language,currencyName,city_Id) VALUES(?,?,?,?,?,?)";
        try {
            Connection connection=connection();
            PreparedStatement statement= connection().prepareStatement(Save_Country_Sql);
            statement.setInt(1,id);
            statement.setString(2,countryName);
            statement.setInt(3,population);
            statement.setString(4,language);
            statement.setString(5,currencyName);
            statement.setInt(6,city_Id);
            statement.executeUpdate();
            System.out.println(countryName+" add to database");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

        @NotNull
        public static List<Country>getAllCountries(){
            String getAllCountry_SQL="SELECT * FROM countries";
            List<Country>countryArrayList=new ArrayList<>();
            try {
                Connection connection=connection();
                Statement statement= connection.createStatement();
                ResultSet resultSet= statement.executeQuery(getAllCountry_SQL);
                while (resultSet.next()){
                    Country country=new Country();
                    country.setId(resultSet.getInt("id"));
                    country.setCountryName(resultSet.getString("countryName"));
                    country.setPopulation(resultSet.getInt("population"));
                    country.setLanguage(resultSet.getString("language"));
                    country.setCountryName(resultSet.getString("currencyName"));
                    country.setCityId(resultSet.getInt("city_Id"));
                    countryArrayList.add(country);
                    System.out.println(countryArrayList);
                }

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return countryArrayList;
        }
    }

