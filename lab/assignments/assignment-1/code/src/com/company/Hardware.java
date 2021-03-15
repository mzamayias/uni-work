public abstract class Hardware {
    private final String type; // hardware type (computer or disk)
    private int counter = 0; // hardware tracker

    public Hardware(String type) {
        this.type = type;
        this.counter++;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "HW %s".formatted(type);
    }
}
