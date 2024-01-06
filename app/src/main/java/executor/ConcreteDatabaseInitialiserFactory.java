package executor;

public class ConcreteDatabaseInitialiserFactory implements DatabaseInitialiserFactory {
    @Override
    public DatabaseInitialiser createDatabaseInitialiser() {
        return new ConcreteDatabaseInitialiser();
    }
}
