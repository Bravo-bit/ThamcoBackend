package executor;

import java.sql.Connection;

import com.google.gson.reflect.TypeToken;

public interface DatabaseInitialiser {

    Connection connectToDatabase(String dbFile);

    <T> T[] readResponse(TypeToken<T[]> responseTypeToken, String url);
}
