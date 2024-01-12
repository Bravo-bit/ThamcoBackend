package thamcobackend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import models.Product;

public class ProductOperation implements DatabaseOperation<Product> {

    private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS Product_tbl ("
            + "product_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "product_ean TEXT NOT NULL,"
            + "category_id INTEGER,"
            + "brand_id INTEGER,"
            + "product_name TEXT,"
            + "product_description TEXT,"
            + "product_price REAL,"
            + "product_in_stock INTEGER,"
            + "product_expected_restock TEXT,"
            + "FOREIGN KEY (category_id) REFERENCES category_tbl(category_id),"
            + "FOREIGN KEY (brand_id) REFERENCES brand_tbl(brand_id)"
            + ")";

    private static final String INSERT_TO_PRODUCT_TABLE = "INSERT INTO Product_tbl (product_id, product_ean, category_id, brand_id, product_name, product_description, product_price, product_in_stock, product_expected_restock) VALUES (?,?,?,?,?,?,?,?,?)";

    @Override
    public void createTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_PRODUCT_TABLE);

            System.out.println("Product_tbl created successfully");

        } catch (SQLException e) {
            SQLExceptionHandler.handleSQLException(e);
        }
    }

    @Override
    public void insertData(Connection connection, Product[] products) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TO_PRODUCT_TABLE)) {

            for (Product product : products) {
                preparedStatement.setInt(1, product.getId());
                preparedStatement.setString(2, product.getEan());
                preparedStatement.setInt(3, product.getCategoryId());
                preparedStatement.setInt(4, product.getBrandId());
                preparedStatement.setString(5, product.getName());
                preparedStatement.setString(6, product.getDescription());
                preparedStatement.setDouble(7, product.getPrice());
                preparedStatement.setString(8, product.isInStock());
                preparedStatement.setString(9, product.getExpectedRestock());

                preparedStatement.executeUpdate();
            }

            System.out.println("Product data has been succefully entered");
        }
    }

}
