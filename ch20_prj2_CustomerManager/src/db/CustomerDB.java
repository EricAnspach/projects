package db;

import business.Customer;
import util.Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDB implements CustomerDAO<Customer> {

    private Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/customer?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "customer_user";
        String password = "sesame";

        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;

    }

    @Override
    public ArrayList<Customer> getCustomers() throws SQLException {
        ArrayList<Customer> customerList = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Customer");
        while (rs.next()) {
            String email = rs.getString(4);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            Customer customer = new Customer(email, firstName, lastName);
            customerList.add(customer);
        }
        rs.close();
        return customerList;
    }

    @Override
    public Customer getCustomer(String email) throws SQLException {

        return null;
    }

    @Override
    public boolean addCustomer(String firstName, String lastName, String email) throws SQLException {
        boolean success = false;
        Connection connection = getConnection();

        String query = "INSERT INTO Customer " +
                        "values (customerid, '" + firstName + "', '" + lastName +
                        "', '" + email + "');";

        Statement statement = connection.createStatement();
        int rowCount = statement.executeUpdate(query);

        if (rowCount > 0) {
            success = true;
        }

        return success;
    }

    @Override
    public boolean updateCustomer(String email) throws SQLException {

        return true;
    }

    @Override
    public boolean deleteCustomer(String email) throws SQLException {

        return true;
    }

}
