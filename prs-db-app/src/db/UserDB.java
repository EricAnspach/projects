package db;

import business.User;
import util.Console;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    private Connection getConnection() throws SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/prs?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "prs_user";
        String password = "sesame";

        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        return connection;
    }

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM User");
        while (rs.next()) {
            int id = rs.getInt(1);
            String userName = rs.getString(2);
            String password = rs.getString(3);
            String firstName = rs.getString(4);
            String lastName = rs.getString(5);
            String phoneNumber = rs.getString(6);
            String email = rs.getString(7);
            boolean isReviewer = rs.getBoolean(8);
            boolean isAdmin = rs.getBoolean(9);
            User user = new User(id, userName, password, firstName, lastName, phoneNumber, email,
                    isReviewer, isAdmin);
            users.add(user);
        }
        rs.close();
        return users;
    }
    
    public boolean addUser (String userName, String password, String firstName, String lastName, String phoneNumber,
    							String email) throws SQLException {
        boolean success = false;
        Connection connection = getConnection();

        String query = "INSERT INTO user " +
                        "(UserName, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin, UpdatedByUser)" +
                        "VALUES ('" + userName + "', '" + password + "', '" + firstName + "', '" + lastName + "', '" + 
                        phoneNumber + "', '" + email + "', 1, 1, 1);";
        
        Statement statement = connection.createStatement();
        int rowCount = statement.executeUpdate(query);
        
        if (rowCount > 0) {
			success = true;
		}
        return success;
    }
    
    public User get(int id) throws SQLException {
    	String query = "SELECT * FROM User WHERE ID = ?";
    	
    	Connection connection = getConnection();
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setInt(1, id);
    	ResultSet rs = ps.executeQuery();
    	User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
    						rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getBoolean(9));
    	rs.close();
		return null;
	}
}
