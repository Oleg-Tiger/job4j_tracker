package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plain = new Plain();
        Vehicle[] vehicles = new Vehicle[] {bus, train, plain};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
