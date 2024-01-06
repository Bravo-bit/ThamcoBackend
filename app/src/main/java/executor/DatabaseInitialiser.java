package executor;

import java.sql.Connection;

public interface DatabaseInitialiser {

    Connection connectToDatabase(String dbFile);

    <T> T readResponse(Class<T> responseType, String url);
}
