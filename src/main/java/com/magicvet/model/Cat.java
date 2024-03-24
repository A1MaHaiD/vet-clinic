package main.java.com.magicvet.model;

public class Cat extends Pet {
    public Cat() {
    }

    public Cat(String type, Sex sex, String age, String name, HealthState healthState, String ownerName) {
        super(type, sex, age, name, healthState, ownerName);
    }
}
