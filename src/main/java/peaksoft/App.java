package peaksoft;

import peaksoft.util.MyDb;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );
        MyDb.connection();

        CityTable table=new CityTable();
        CityTable.connection();

        CountryTable countryTable=new CountryTable();
        CountryTable.connection();

        MayorTable mayorTable=new MayorTable();
        MayorTable.connection();

        MayorTable.saveMayors(1,"Eric","Adam",62,"american");
        MayorTable.saveMayors(2,"Sadiq","Khan",50,"pakistan");
        MayorTable.getAllMayors();

        CityTable.saveCity(1,"New York",8,"The Statue of Liberty",1);
        CityTable.saveCity(2,"London",6,"Big Ben",2);
        CityTable.getAllCities();


        CountryTable.saveCountries(1,"USA",330,"english","dollar",1);
        CountryTable.saveCountries(2,"RF",144,"russian","ruble",2);
        CountryTable.getAllCountries();
    }


}
