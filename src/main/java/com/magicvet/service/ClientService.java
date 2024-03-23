package main.java.com.magicvet.service;

import main.java.com.magicvet.VetApp;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.service.validation.EnglishValidationService;

import java.util.Optional;

public class ClientService {
    private final EnglishValidationService validation = new EnglishValidationService();
    public Optional<Client> registerNewClient() {
        Client client = null;
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = VetApp.SCANNER.nextLine();

        if (validation.isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirsName()
                    + " " + client.getLastName()
                    + " (" + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }

        return Optional.ofNullable(client);
    }

    Client buildClient(String email) {

        Client client = new Client();
        client.setEmail(email);

        while (client.getFirsName() == null) {
            System.out.print("First name: ");
            String firstName = VetApp.SCANNER.nextLine();

            if (validation.isNameValid(firstName)) {
                client.setFirsName(firstName);
            } else {
                System.out.println("First Name is incorrect");
            }
        }
        while (client.getLastName() == null) {
            System.out.print("Last name: ");
            String lastName = VetApp.SCANNER.nextLine();

            if (validation.isNameValid(lastName)) {
                client.setLastName(lastName);
            } else {
                System.out.println("Last Name is incorrect");
            }
        }
        System.out.println("Location: ");
        Client.Location location;
        String locationInput = VetApp.SCANNER.nextLine();

        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value '"
                    + locationInput
                    + "'. Using default value: "
                    + Client.Location.UNKNOWN);
        }
        client.setLocation(location);

        return client;
    }
}
