package thamcobackend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    private static final String INSERT_TO_CATEGORY_TABLE = "INSERT INTO Product_tbl (category_id, category_name, category_description, category_available_product_count) VALUES (?, ?, ?, ?)";

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
    public void insertData(Connection connection, Category[] categories) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TO_CATEGORY_TABLE)) {

            for (Category category : categories) {
                preparedStatement.setInt(1, category.getId());
                preparedStatement.setString(2, category.getName());
                preparedStatement.setString(3, category.getDescription());
                preparedStatement.setInt(4, category.getAvailableProductCount());
            }

            preparedStatement.executeUpdate();
        }
    }

}
