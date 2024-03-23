package main.java.org.svur.lld.design;

public class Database {
    private String name;
    private String host;
    private int port;
    private DatabaseType databaseType;

    private Database() {}

    private Database(String name, String host, int port, DatabaseType databaseType) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.databaseType = databaseType;
    }

    public static DatabaseBuilder builder() {
        return new DatabaseBuilder();
    }

    public static class DatabaseBuilder {
        Database database;

        DatabaseBuilder() {
            this.database = new Database();
        }

        public DatabaseBuilder withName(String name) {
            this.database.name = name;
            return this;
        }

        public DatabaseBuilder withUrl(String host, int port) {
            this.database.host = host;
            this.database.port = port;
            return this;
        }

        public DatabaseBuilder withMySql() {
            this.database.databaseType = DatabaseType.MYSQL;
            return this;
        }

        public Database build() {
            return new Database(this.database.name, this.database.host, this.database.port, this.database.databaseType);
        }
    }
}