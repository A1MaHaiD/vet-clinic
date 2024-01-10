package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {


    private Size size;

    public Dog() {

    }

    public Dog(String type, String sex, String age, String name, String ownerName, Size size) {
        super(type, sex, age, name, ownerName);
        this.size = size;
    }

    public Dog(Size size) {
        this.size = size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
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

    public enum Size {
        XS(1), S(2), M(3), L(4), XL(5), UNKNOWN(0);
        private final int values;


        Size(int values) {
            this.values = values;
        }

        public int getValues() {
            return values;
        }
    }
}
