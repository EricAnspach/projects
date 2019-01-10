package db;

import business.Country;

import java.sql.*;
import java.util.ArrayList;

public class CountryDB {

    private Connection getConnection() throws SQLException{
        String dbURL = "jdbc:mysql://localhost:3306/country?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "country_user";
        String password = "sesame";

        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

    public ArrayList<String> getCountries() throws SQLException {
        ArrayList<String> countries = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM country;");
        while (rs.next()) {
            String name = rs.getString(2);
            countries.add(name);
        }
        rs.close();
        return countries;
    }

    public boolean addCountry(String country) throws SQLException {
    	boolean success = false;
    	Connection connection = getConnection();
    	
    	String query = "insert into country " +
    			"values (id, '" + country + "')";
    	
    	Statement statement = connection.createStatement();
    	int rowCount = statement.executeUpdate(query);
    	
    	if (rowCount > 0) {
    		success = true;
    	}
        return success;
    }

    public boolean deleteCountry(String country) throws SQLException {    	
    	boolean success = false;
    	Connection connection = getConnection();
    	String query = "DELETE FROM Country WHERE Name = '" + country + "'";
    	Statement statement = connection.createStatement();
    	int rowCount = statement.executeUpdate(query);
    	
    	if (rowCount > 0) {
			success = true;
		}
    	
        return success;
    }

}
