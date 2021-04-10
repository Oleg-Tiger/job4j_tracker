package ru.job4j.stream;

public class Car {
    private String brand;
    private String model;
    private short yearOfManufacture;
    private int mileage;
    private String color;
    private short enginePower;
    private byte numberOfOwners;
    private boolean allWhileDrive;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", yearOfManufacture=" + yearOfManufacture
                + ", mileage=" + mileage
                + ", color='" + color + '\''
                + ", enginePower=" + enginePower
                + ", numberOfOwners=" + numberOfOwners
                + ", allWhileDrive=" + allWhileDrive
                + '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private short yearOfManufacture;
        private int mileage;
        private String color;
        private short enginePower;
        private byte numberOfOwners;
        private boolean allWhileDrive;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildYearOfManufacture(short yearOfManufacture) {
            this.yearOfManufacture = yearOfManufacture;
            return this;
        }

        Builder buildMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildEnginePower(short enginePower) {
            this.enginePower = enginePower;
            return this;
        }

        Builder buildNumberOfOwners(byte numberOfOwners) {
            this.numberOfOwners = numberOfOwners;
            return this;
        }

        Builder buildAllWhileDrive(boolean allWhileDrive) {
            this.allWhileDrive = allWhileDrive;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.yearOfManufacture = yearOfManufacture;
            car.mileage = mileage;
            car.color = color;
            car.enginePower = enginePower;
            car.numberOfOwners = numberOfOwners;
            car.allWhileDrive = allWhileDrive;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildYearOfManufacture((short) 2018)
                .buildMileage(37450)
                .buildColor("white")
                .buildEnginePower((short) 188)
                .buildNumberOfOwners((byte) 1)
                .buildAllWhileDrive(false)
                .build();
        System.out.println(car);

    }
}
