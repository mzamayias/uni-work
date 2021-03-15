public class Disk extends Hardware {
    private final String brand; // disk brand
    private final String type; // disk type (hdd or ssd)
    private final double capacity; // disk capacity in tb

    public Disk(String brand, String type, double capacity) {
        super("Disk");
        this.brand = brand;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        // "Disk 0: HW Disk brand: WD 3.0 TB HDD"
        return "%s brand: %s %s TB %s".formatted(super.toString(), brand, capacity, this.type);
    }

    public double getCapacity() {
        return capacity;
    }
}
