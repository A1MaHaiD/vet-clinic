package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XS),
                new Dog(Dog.Size.S),
        };
        Pet[] pets = {
                new Cat("cat", "female", "24", "Світлана", "Олександр Лук'янчук"),
                new Dog("dog", "female", "24", "Яна", "Олександр Лук'янчук", Dog.Size.S),
                new Cat("cat", "female", "2", "Світлана", "Олександр Лук'янчук"),
                new Cat("cat", "female", "26", "Валерія", "Олександр Лук'янчук"),
                new Cat("cat", "male", "3", "Шашлик", "Олександр Лук'янчук"),
                new Cat("cat", "female", "3", "Малібель", "Олександр Лук'янчук"),
                new Cat("cat", "female", "4", "Ракета", "Олександр Лук'янчук"),
                new Cat("cat", "female", "2", "Світлана", "Олександр Лук'янчук")
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog dog1, Dog dog2) {
                return dog1.getSize().getValues() - dog2.getSize().getValues();
            }
        });
        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        System.out.println();

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet pe1, Pet pet2) {
                return Integer.parseInt(pe1.getAge())
                        - Integer.parseInt(pet2.getAge());
            }
        });
        for (Pet pet : pets) {
            System.out.println(pet.getAge());
        }

        System.out.println();

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet pet1, Pet pet2) {
                return pet1.getName().charAt(0) - pet2.getName().charAt(0);
            }
        });
        for (Pet pet : pets) {
            System.out.println(pet.getName());
        }
    }
}
