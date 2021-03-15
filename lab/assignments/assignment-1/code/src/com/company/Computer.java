public class Computer extends Hardware {
    private final String brand; // computer brand
    private final String cpu; // computer cpu
    private int memory; // computer memory in gb
    private final Disk[] disks = new Disk[10]; // disk array of size 10

    public Computer(String brand, String cpu) {
        super("Computer");
        this.brand = brand;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        // "HW Computer: Dell i5 RAM: 2GB"
        return "%s: %s %s RAM: %sGB".formatted(super.toString(), brand, cpu, memory);
    }

    public void addDisk(Disk disk) {
        int nullAtIndex;
        for (nullAtIndex = 0; nullAtIndex < disks.length; nullAtIndex++) {
            if (disks[nullAtIndex] == null) break;
        }
        disks[nullAtIndex] = disk;
    }

    public void printDisks() {
        for (int diskIndex = 0; diskIndex < disks.length; diskIndex++) {
            if (disks[diskIndex] != null)
                System.out.println("Disk %s: %s".formatted(diskIndex, disks[diskIndex].toString()));
        }
    }

    public float totalDiskCapacity() {
        float sum = 0;
        for (Disk disk : disks) {
            if (disk != null) sum += disk.getCapacity();
        }
        return sum;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
