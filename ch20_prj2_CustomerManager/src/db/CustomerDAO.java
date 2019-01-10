package db;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO<T> {

    List<T> getCustomers() throws SQLException;
    T getCustomer(String email) throws SQLException;
    boolean addCustomer(String firstName, String lastName, String email) throws SQLException;
    boolean updateCustomer(String email) throws SQLException;
    boolean deleteCustomer(String email) throws SQLException;
}
