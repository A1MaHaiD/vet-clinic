package main.java.com.magicvet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String firsName;
    private String lastName;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private Location location;

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Client {"
                + "\n\tfirsName = " + firsName
                + ", lastName = " + lastName
                + ", email = " + email
                + ", location = " + location
                + ",\n\tpets = " + pets
                + "\n}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Client client = (Client) object;
        return Objects.equals(firsName, client.firsName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, lastName, email, pets);
    }

    public enum Location {
        KYIV, LVIV, ODESA
    }
}
