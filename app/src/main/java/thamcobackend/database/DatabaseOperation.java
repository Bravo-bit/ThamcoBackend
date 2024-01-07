package thamcobackend.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseOperation<T> {
    void createTable(Connection connection);

    void insertData(Connection connection, T[] data) throws SQLException;
}
