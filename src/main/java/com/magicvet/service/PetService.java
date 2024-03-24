package main.java.com.magicvet.service;

import main.java.com.magicvet.VetApp;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.validation.ValidationImpl;

import java.util.InputMismatchException;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";
    private final ValidationImpl validation = new ValidationImpl();

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
        while (pet.getAge() == null) {
            System.out.print("Age: ");
            String ageInput = VetApp.SCANNER.nextLine();
            if (validation.isAgeValid(ageInput)) {
                pet.setAge(ageInput);
            } else {
                System.out.print("Age is incorrect: " + ageInput + "\n");
            }
        }

        Pet.Sex sex;
        while (pet.getSex() == null) {
            System.out.print("Sex (male / female): ");
            String sexInput = VetApp.SCANNER.nextLine();
            if (sexInput.equals(Pet.Sex.MALE.getValues())) {
                sex = Pet.Sex.MALE;
                pet.setSex(sex);
            }
            if (sexInput.equals(Pet.Sex.FEMALE.getValues())) {
                sex = Pet.Sex.FEMALE;
                pet.setSex(sex);
            }
        }

        while (pet.getName() == null) {
            System.out.print("Name: ");
            String petNameInput = VetApp.SCANNER.nextLine();
            if (validation.isNameValid(petNameInput)) {
                pet.setName(petNameInput);
            } else {
                System.out.println("Name is incorrect");
            }
        }

        if (type.equals(DOG_TYPE)) {
            Dog.Size size;
            System.out.print("Size (XS / S / M / L / XL): ");
            String sizeInput = VetApp.SCANNER.nextLine();
            try {
                size = Dog.Size.valueOf(sizeInput);
            } catch (IllegalArgumentException e) {
                size = Dog.Size.UNKNOWN;
                System.out.println("Unable to parse value '"
                        + sizeInput
                        + "'. Using default value: "
                        + Dog.Size.UNKNOWN
                );
            }
            ((Dog) pet).setSize(size);
        }

        System.out.print("Heath State (EMERGENCY(1) / BAD(2) / NORMAL(3) / GOOD(4) / WELL(5) / VERY_WELL(6)): ");
        Pet.HealthState healthState;
        try {
            int stateInput = Integer.parseInt(VetApp.SCANNER.nextLine());
            healthState = Pet.HealthState.values()[stateInput];
            pet.setHealthState(healthState);
        } catch (InputMismatchException | IllegalArgumentException e) {
            healthState = Pet.HealthState.UNKNOWN;
            System.out.println("Unable to parse value '"
                    + healthState
                    + "'. Using default value: "
                    + Pet.HealthState.UNKNOWN
            );
            pet.setHealthState(healthState);
        }
        return pet;
    }
}
