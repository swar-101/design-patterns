package org.example;

import lombok.extern.log4j.Log4j2;
import org.example.database.Database;

@Log4j2
public class App {
    public static void main( String[] args ) {
        Database database = new Database.DatabaseBuilder()
                .withUrl("localhost", 8080)
                .withName("root")
                .withMySql()
                .build();
    }
}