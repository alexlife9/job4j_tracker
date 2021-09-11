package ru.job4j.stream;

public class Car {
    private String brand;
    private String model;
    private int releaseYear;
    private String colour;
    private boolean awd;
    private String bodyType;
    private double engineVolume;
    private int horsepower;

    static class Builder {
        private String brand;
        private String model;
        private int releaseYear;
        private String colour;
        private boolean awd;
        private String bodyType;
        private double engineVolume;
        private int horsepower;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        Builder buildColour(String colour) {
            this.colour = colour;
            return this;
        }

        Builder buildAwd(boolean awd) {
            this.awd = awd;
            return this;
        }

        Builder buildBodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        Builder buildEngineVolume(double engineVolume) {
            this.engineVolume = engineVolume;
            return this;
        }

        Builder buildHorsepower(int horsepower) {
            this.horsepower = horsepower;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.releaseYear = releaseYear;
            car.colour = colour;
            car.awd = awd;
            car.bodyType = bodyType;
            car.engineVolume = engineVolume;
            car.horsepower = horsepower;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", releaseYear=" + releaseYear
                + ", colour='" + colour + '\''
                + ", awd=" + awd
                + ", bodyType='" + bodyType + '\''
                + ", engineVolume=" + engineVolume
                + ", horsepower=" + horsepower
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Porshe")
                .buildModel("Macan")
                .buildReleaseYear(2021)
                .buildColour("Black")
                .buildAwd(true)
                .buildBodyType("Crossover")
                .buildEngineVolume(2.9)
                .buildHorsepower(380)
                .build();
        System.out.println(car);
    }
}
