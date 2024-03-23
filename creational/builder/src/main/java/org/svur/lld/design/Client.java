package main.java.org.svur.lld.design;

public class Client {

    public static void main(String[] args) {
        Database database = new Database.DatabaseBuilder()
                .withUrl("localhost", 8080)
                .withName("root")
                .withMySql()
                .build();
    }
}