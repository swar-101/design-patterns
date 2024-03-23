package org.example;

import org.example.database.Database;

public class App {
    public static void main( String[] args ) {
        Database database = new Database.DatabaseBuilder()
                .withUrl("localhost", 8080)
                .withName("root")
                .withMySql()
                .build();
    }
}