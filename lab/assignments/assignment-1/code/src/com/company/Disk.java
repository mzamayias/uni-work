public class Disk extends Hardware {
    private String brand; // disk brand
    private String type; // disk type (hdd or ssd)
    private double capacity; // disk capacity in tb

    public Disk(String brand, String type, double capacity) {
        super("Disk");
        this.brand = brand;
        this.type = type;
        this.capacity = capacity;
        super.counter++;
    }

    @Override
    public String toString() {
        // "Disk 0: HW Disk brand: WD 3.0 TB HDD"
        return "Disk %s: %s brand: %s %s %s".formatted(super.getCounter(), super.toString(), brand, capacity, this.type);
    }

    public double getCapacity() {
        return capacity;
    }
}
