package CarConstructors;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    private List<String> parts;

    public Car() {
        this.parts = new ArrayList<>();
    }

    public Car(String brand, String model, int horsepower) {
        this();

        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;

        this.parts = new ArrayList<>();
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsepower);
    }
}
