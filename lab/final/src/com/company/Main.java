package com.company;

import com.company.task1.Task1;

import static com.company.singletons.DatabaseConnection.closeDatabaseConnection;


public class Main {

    public static void main(String[] args) {
        new Task1();
    }
}
