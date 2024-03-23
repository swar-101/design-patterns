## Constructor with a Hash Map


```java
public class org.example.database.Database {
    private String host;
    private String port;
    private String username;
    private String password;
    
    public org.example.database.Database(Map<String, String> config) {
        if (config.containsKey("host")) 
            this.host = config.get("host");
        if (config.containsKey("port"))
            this.port = config.get("port");
        if (config.containsKey("username"))
            this.username = config.get("username");
        if (config.containsKey("password"))
            this.password = config.get("password");
    }
}
```

## Inner class

```java
public class org.example.database.Database {
    
    public org.example.database.Database(DatabaseParameters parameters) {
            this.host = parameters.host;
            this.port = parameters.port;
            this.name = parameters.name;
            this.password = parameters.password;
    }
    
    class DatabaseParameters {
        private String host;
        private String port;
        private String name;
        private String password;
    }
}
```


## Builder class

```java
import org.example.database.Database;

public class main.java.org.svur.lld.design.Database{
private String host;
private String port;
private String name;
private String password;

private org.example.database.Database(){}

class DatabaseBuilder {
    private String host;
    private String port;
    private String name;
    private String password;

    public org.example.database.Database build() {
        org.example.database.Database database = new org.example.database.Database();
        database.host = this.database;
        database.port = this.database;
        database.name = this.name;
        database.password = this.password;

        return database;
    }
}
}
```


