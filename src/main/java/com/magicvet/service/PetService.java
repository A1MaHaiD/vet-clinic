package main.java.com.magicvet.service;

import main.java.com.magicvet.VetApp;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registetNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = VetApp.SCANNER.nextLine();

        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }
        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);
        System.out.print("Age: ");
        pet.setAge(VetApp.SCANNER.nextLine());
        System.out.print("Sex (male / female): ");
        pet.setSex(VetApp.SCANNER.nextLine());
        System.out.print("Name: ");
        pet.setName(VetApp.SCANNER.nextLine());

        if (type.equals(DOG_TYPE)){
            System.out.println("Size (xS / S / M / L / xL): ");
            ((Dog) pet).setSize(VetApp.SCANNER.nextLine());
        }

        return pet;
    }
}
