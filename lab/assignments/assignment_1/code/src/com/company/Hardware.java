public abstract class Hardware {
    private final String type; // hardware type (computer or disk)
    private int counter = 0; // hardware tracker

    public Hardware(String type) { // Hardware class constructor
        this.type = type;
        this.counter++; // increment counter whenever constructor is called
    }

    public int getCounter() {
        return counter; // return counter value
    }

    @Override
    public String toString() { // return hardware info
        // return "HW %s".formatted(type);
        return "HW " + type;
    }
}
