package thamcobackend.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import models.Order;

public class OrderOperation implements DatabaseOperation<Order> {

    private static final String CREATE_ORDER_TABLE = "CREATE TABLE IF NOT EXISTS Order_tbl(" +
            "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "account_name TEXT," +
            "card_number TEXT," +
            "product_id INTEGER," +
            "quantity INTEGER," +
            "date TEXT," +
            "product_name TEXT," +
            "product_ean TEXT," +
            "total_price REAL)";

    @Override
    public void createTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_ORDER_TABLE);

            System.out.println("Order_tbl created successfully");

        } catch (SQLException e) {
            SQLExceptionHandler.handleSQLException(e);
        }
    }

    @Override
    public void insertData(Connection connection, Order model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertData'");
    }

}
