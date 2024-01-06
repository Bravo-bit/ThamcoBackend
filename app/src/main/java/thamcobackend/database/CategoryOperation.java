package thamcobackend.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import models.Category;

public class CategoryOperation implements DatabaseOperation<Category> {

    private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS Category_tbl ("
            + "category_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "category_name TEXT NOT NULL,"
            + "category_description TEXT NOT NULL,"
            + "category_available_product_count INTEGER NOT NULL"
            + ")";

    @Override
    public void createTable(Connection connection) {

        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_CATEGORY_TABLE);

            System.out.println("Category_tbl created successfully");

        } catch (SQLException e) {
            SQLExceptionHandler.handleSQLException(e);
        }
    }

    @Override
    public void insertData(Connection connection, Category model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertData'");
    }

}
