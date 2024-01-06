package thamcobackend.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import models.Brand;

public class BrandOperation implements DatabaseOperation<Brand> {

    private static final String CREATE_BRAND_TABLE = "CREATE TABLE IF NOT EXISTS Brand_tbl ("
            + "brand_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "brand_name TEXT NOT NULL,"
            + "brand_available_product_count INTEGER NOT NULL"
            + ")";

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
    public void insertData(Connection connection, Brand brand) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertData'");
    }

}
