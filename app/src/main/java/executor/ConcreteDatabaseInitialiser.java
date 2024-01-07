package executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.gson.reflect.TypeToken;

import reader.ResponseReader;

public class ConcreteDatabaseInitialiser implements DatabaseInitialiser {
    @Override
    public Connection connectToDatabase(String dbFile) {
        try {
            Connection connection = DriverManager.getConnection(dbFile);
            System.out.println("Database connected successfully!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection unsuccessful!");
        }

        return null;
    }

    @Override
    public <T> T[] readResponse(TypeToken<T[]> responseType, String url) {
        return new ResponseReader().readResponse(responseType, url);
    }


}
