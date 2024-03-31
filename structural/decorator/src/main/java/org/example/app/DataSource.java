package org.example.app;

public interface DataSource {
    void writeData(String data);
    String readData();
}