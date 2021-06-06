package com.company;

import static com.company.DatabaseConnector.databaseConnector;
import com.company.GUI.Frame;

public class Main {

    public static void main(String[] args) {
        databaseConnector();
        new Frame();
    }
}
