package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    public static final String XS = "xS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String XL = "xL";
    private String size;

    public Dog() {

    }

    public Dog(String type, String sex, String age, String name, String ownerName, String size) {
        super(type, sex, age, name, ownerName);
        this.size = size;
    }

    public Dog(String size) {
        this.size = size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Dog {" +
                "\n\tsize = " + size
                + "\n\t" + super.toString()
                + '\n' + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Dog dog = (Dog) object;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}
