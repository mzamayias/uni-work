public class TryComputer {
    public static void main(String[] args) {
        Disk[] eightDisks = new Disk[8]; // create a disk array of size eight
        // populate disk array with disks
        eightDisks[0] = new Disk("Samsung", "SSD SATA III", 0.5);
        eightDisks[1] = new Disk("Samsung", "SSD SATA III", 0.25);
        eightDisks[2] = new Disk("Corsair", "HDD", 1.0);
        eightDisks[3] = new Disk("Team Group", "SSD SATA III", 15.0);
        eightDisks[4] = new Disk("Seagate", "HDD", 12.0);
        eightDisks[5] = new Disk("Seagate", "HDD", 16.0);
        eightDisks[6] = new Disk("Samsung", "SSD M.2 NVMe", 1.0);
        eightDisks[7] = new Disk("Samsung", "SSD M.2 NVMe", 2.0);
        Computer computer = new Computer("Custom", "Ryzen"); // create a computer
        for (int i = 0; i < 3; i++) { // add the same disk three times
            computer.addDisk(eightDisks[7]);
        }
        computer.setMemory(32); // set computer memory
        System.out.println(computer.toString()); // print disk info
        computer.printDisks(); // print computer disks
        System.out.printf("Disk Capacity: %s%n", computer.totalDiskCapacity()); // print computer total disk capacity
        System.out.printf("Total Hardware objects generated: %s%n", computer.getCounter() + eightDisks.length); // print total hardware objects generated
    }
}
