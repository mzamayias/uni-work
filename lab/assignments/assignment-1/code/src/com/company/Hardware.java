package com.company;

public abstract class Hardware {
    String type; // hardware type (computer or disk)
    int counter = 0; // hardware tracker

    public Hardware(String type) {
        this.type = type;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "HW %s".formatted(type);
    }
}
