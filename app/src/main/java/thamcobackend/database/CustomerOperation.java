package thamcobackend.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import models.Customer;

public class CustomerOperation implements DatabaseOperation<Customer> {

    private final static String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS Customer_tbl ("
            + "customer_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "firstname TEXT NOT NULL,"
            + "lastname TEXT NOT NULL,"
            + "email TEXT NOT NULL,"
            + "postcode TEXT NOT NULL,"
            + "mobile TEXT NOT NULL"
            + ")";

    @Override
    public void createTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_CUSTOMER_TABLE);

            System.out.println("Customer_tbl created successfully");

        } catch (SQLException e) {
            SQLExceptionHandler.handleSQLException(e);
        }
    }

    @Override
    public void insertData(Connection connection, Customer[] product) throws SQLException {

        throw new UnsupportedOperationException("Unimplemented method 'insertData'");
    }

}
