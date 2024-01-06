package thamcobackend.database;

import java.sql.SQLException;

public class SQLExceptionHandler {

    protected static void handleSQLException(SQLException e) {
        System.err.println("SQL Exception:");

        while (e != null) {
            System.err.println("Message: " + e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("---------------");
            e = e.getNextException();
        }
    }
}
