public class Computer extends Hardware {
    private final String brand; // computer brand
    private final String cpu; // computer cpu
    private int memory; // computer memory in gb
    private final Disk[] disks = new Disk[10]; // disk array of size 10

    public Computer(String brand, String cpu) { // computer class constructor
        super("Computer");
        this.brand = brand;
        this.cpu = cpu;
    }

    @Override
    public String toString() { // return computer info
        // "HW Computer: Dell i5 RAM: 2GB"
        // return "%s: %s %s RAM: %sGB".formatted(super.toString(), brand, cpu, memory);
        return super.toString() + ": " + brand + " " + cpu + " RAM: " + memory + "GB";
    }

    public void addDisk(Disk disk) { // add disk to commputer
        int nullAtIndex; // whats the index of a null item in disks array?
        for (nullAtIndex = 0; nullAtIndex < disks.length; nullAtIndex++) { // iterate through disk array
            if (disks[nullAtIndex] == null)
                break; // break the loop when the item at that index is null
        }
        disks[nullAtIndex] = disk; // at that index a disk to the computer
    }

    public void printDisks() { // print computer disks
        for (int diskIndex = 0; diskIndex < disks.length; diskIndex++) {
            if (disks[diskIndex] != null)
                // System.out.println("Disk %s: %s".formatted(diskIndex, disks[diskIndex].toString()));
                System.out.println("Disk " + diskIndex + ": " + disks[diskIndex].toString());
        }
    }

    public float totalDiskCapacity() { // print total capacity of installed disks
        float sum = 0;
        for (Disk disk : disks) {
            if (disk != null)
                sum += disk.getCapacity();
        }
        return sum;
    }

    public void setMemory(int memory) { // set memory value
        this.memory = memory;
    }
}
