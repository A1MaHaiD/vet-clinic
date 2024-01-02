package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.comparator.PetNameComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;

public class Sandbox {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XL),
                new Dog(Dog.XL),
                new Dog(Dog.XS),
                new Dog(Dog.S),
        };
        Pet[] pets = {
                new Cat("cat", "female", "24", "Світлана", "Олександр Лук'янчук"),
                new Dog("dog", "female", "24", "Яна", "Олександр Лук'янчук", Dog.S),
                new Cat("cat", "female", "2", "Світлана", "Олександр Лук'янчук"),
                new Cat("cat", "female", "26", "Валерія", "Олександр Лук'янчук"),
                new Cat("cat", "male", "3", "Шашлик", "Олександр Лук'янчук"),
                new Cat("cat", "female", "3", "Малібель", "Олександр Лук'янчук"),
                new Cat("cat", "female", "4", "Ракета", "Олександр Лук'янчук"),
                new Cat("cat", "female", "2", "Світлана", "Олександр Лук'янчук")
        };

        Arrays.sort(dogs, new DogSizeComparator());
        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        System.out.println();

        Arrays.sort(pets, new PetAgeComparator());
        for (Pet pet : pets) {
            System.out.println(pet.getAge());
        }

        System.out.println();

        Arrays.sort(pets, new PetNameComparator());
        for (Pet pet : pets) {
            System.out.println(pet.getName());
        }
    }
}
