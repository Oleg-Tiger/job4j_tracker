package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Двери закрываются. Поехали.");
    }

    @Override
    public void passengers(int paxCount) {
        System.out.println("В салоне" + paxCount + "пассажиров.");
    }

    @Override
    public double fillUp(double litresCount) {
        return litresCount * 45.5;
    }
}
