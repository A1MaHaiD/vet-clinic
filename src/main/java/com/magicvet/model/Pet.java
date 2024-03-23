package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {

    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private String type;
    private Sex sex;
    private String age;
    private String name;
    private String ownerName;

    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet() {
    }

    public Pet(String type, Sex sex, String age, String name, String ownerName) {
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.ownerName = ownerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "\nPet {" +
                "type = " + type
                + ", sex = " + sex.getValues()
                + ", age = " + age
                + ", name = " + name
                + ", ownerName = " + ownerName
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pet pet = (Pet) object;

        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }

    public enum Sex {
        MALE("male"), FEMALE("female");

        private final String values;

        Sex(String values) {
            this.values = values;
        }

        public String getValues() {
            return values;
        }
    }

    public enum HealthState{
        EMERGENCY(1),BAD(2),NORMAL(3),
        GOOD(4),WELL(5),VERY_WELL(6);
        private final int value;

        HealthState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
