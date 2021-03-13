package com.company;

public class TryComputer {

    public static void main(String[] args) {
        Disk[] eightDisks = new Disk[8];
        eightDisks[0] = new Disk("Samsung", "SSD SATA III", 0.5);
        eightDisks[1] = new Disk("Samsung", "SSD SATA III", 0.25);
        eightDisks[2] = new Disk("Corsair", "HDD", 1.0);
        eightDisks[3] = new Disk("Team Group", "SSD SATA III", 15.0);
        eightDisks[4] = new Disk("Seagate", "HDD", 12.0);
        eightDisks[5] = new Disk("Seagate", "HDD", 16.0);
        eightDisks[6] = new Disk("Samsung", "SSD M.2 NVMe", 1.0);
        eightDisks[7] = new Disk("Samsung", "SSD M.2 NVMe", 2.0);
        Computer computer = new Computer("Custom", "Ryzen");
        for (int i = 0; i < 3; i++) {
            computer.addDisk(eightDisks[7]);
        }
        computer.setMemory(32);
        System.out.println(computer.toString());
        computer.printDisks();
        System.out.println("Disk Capacity: %s".formatted(computer.totalDiskCapacity()));
//        System.out.println("Total Hardware objects generated: %s".formatted());
    }
}
