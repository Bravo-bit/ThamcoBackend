package executor;

import java.sql.Connection;
import java.sql.SQLException;

import com.google.gson.reflect.TypeToken;

import models.Brand;
import models.Category;
import models.Product;
import models.Properties;
import reader.PropertiesReader;
import thamcobackend.database.BrandOperation;
import thamcobackend.database.CategoryOperation;
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

        // Connect to the database
        Connection connection = databaseInitialiser.connectToDatabase(dbFile);

        // create database tables
        try {
            new ProductOperation().createTable(connection);
            new CategoryOperation().createTable(connection);
            new BrandOperation().createTable(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get api response
        TypeToken<Product[]> productArrayTypeToken = new TypeToken<Product[]>() {
        };
        Product[] products = databaseInitialiser.readResponse(productArrayTypeToken, productUrl);

        TypeToken<Category[]> categoryArrayTypeToken = new TypeToken<Category[]>() {
        };
        Category[] category = databaseInitialiser.readResponse(categoryArrayTypeToken, categoryUrl);

        TypeToken<Brand[]> brandArrayTypeToken = new TypeToken<Brand[]>() {
        };
        Brand[] brand = databaseInitialiser.readResponse(brandArrayTypeToken, brandUrl);

        // insert to tables
        try {
            new ProductOperation().insertData(connection, products);
            new CategoryOperation().insertData(connection, category);
            new BrandOperation().insertData(connection, brand);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
