package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Pet;

import java.util.Comparator;

public class PetNameComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet pet1, Pet pet2) {
        return pet1.getName().charAt(0)
                - pet2.getName().charAt(0);
    }
}
