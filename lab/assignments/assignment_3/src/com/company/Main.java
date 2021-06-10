package com.company;

import static com.company.controller.DatabaseConnector.databaseConnector;
import com.company.view.Frame;

public class Main {

    public static void main(String[] args) {
        databaseConnector();
        new Frame();
    }
}
