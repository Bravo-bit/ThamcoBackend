package thamcobackend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import models.Brand;

public class BrandOperation implements DatabaseOperation<Brand> {

    private static final String CREATE_BRAND_TABLE = "CREATE TABLE IF NOT EXISTS Brand_tbl ("
            + "brand_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "brand_name TEXT NOT NULL,"
            + "brand_available_product_count INTEGER NOT NULL"
            + ")";

    private static final String INSERT_TO_BRAND_TABLE = "INSERT INTO Brand_tbl (brand_id, brand_name, brand_available_product_count) VALUES (?, ?, ?)";

    @Override
    public void createTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_BRAND_TABLE);

            System.out.println("Brand_tbl created successfully");

        } catch (SQLException e) {
            SQLExceptionHandler.handleSQLException(e);
        }
    }

    @Override
    public void insertData(Connection connection, Brand[] brand) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TO_BRAND_TABLE)) {

            for (Brand br : brand) {
                preparedStatement.setInt(1, br.getId());
                preparedStatement.setString(2, br.getName());
                preparedStatement.setInt(3, br.getAvailableProductCount());

                preparedStatement.executeUpdate();
            }

            System.out.println("Brand data has been succefully entered");
        }
    }

}
