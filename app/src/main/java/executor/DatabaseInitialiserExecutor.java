package executor;

import java.sql.Connection;
import java.sql.SQLException;

import models.Brand;
import models.Category;
import models.Order;
import models.Product;
import models.Properties;
import reader.PropertiesReader;
import thamcobackend.database.BrandOperation;
import thamcobackend.database.CategoryOperation;
import thamcobackend.database.OrderOperation;
import thamcobackend.database.ProductOperation;

public class DatabaseInitialiserExecutor {

    public static void main(String[] args) throws ClassNotFoundException {

        if (args.length < 1) {
            System.out.println("Usage: java Main <dbFile>");
            System.exit(1);
        }

        String filePath = args[0];

        Properties properties = new PropertiesReader().readProperties(filePath);

        DatabaseInitialiserFactory factory = new ConcreteDatabaseInitialiserFactory();
        DatabaseInitialiser databaseInitialiser = factory.createDatabaseInitialiser();

        String dbFile = properties.getDbFile();
        String productUrl = properties.getProductUrl();
        String categoryUrl = properties.getCategoryUrl();
        String brandUrl = properties.getBrandUrl();
        String orderUrl = properties.getOrderUrl();

        // Connect to the database
        Connection connection = databaseInitialiser.connectToDatabase(dbFile);

        try {
            new ProductOperation().createTable(connection);
            new CategoryOperation().createTable(connection);
            new BrandOperation().createTable(connection);
            new OrderOperation().createTable(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Product product = databaseInitialiser.readResponse(Product.class, productUrl);
        Category category = databaseInitialiser.readResponse(Category.class, categoryUrl);
        Brand brand = databaseInitialiser.readResponse(Brand.class, brandUrl);
        Order order = databaseInitialiser.readResponse(Order.class, orderUrl);

        try {
            new ProductOperation().insertData(connection, product);
            new CategoryOperation().insertData(connection, category);
            new BrandOperation().insertData(connection, brand);
            new OrderOperation().insertData(connection, order);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
