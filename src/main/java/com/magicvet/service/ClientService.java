package main.java.com.magicvet.service;

import main.java.com.magicvet.VetApp;
import main.java.com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private final static Pattern EMAIL_PATTERN = Pattern
            .compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private final static Pattern NAME_PATTERN = Pattern
            .compile("^[a-zA-Z]{2,}+(-[a-zA-Z]{2,}+)?$");

    public Optional<Client> registerNewClient() {
        Client client = null;
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = VetApp.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirsName()
                    + " " + client.getLastName()
                    + " (" + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }

        return Optional.ofNullable(client);
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        while (client.getFirsName() == null) {
            System.out.print("First name: ");
            String firstName = VetApp.SCANNER.nextLine();

            if (isNameValid(firstName)) {
                client.setFirsName(firstName);
            } else {
                System.out.println("First Name is incorrect");
            }
        }
        while (client.getLastName() == null) {
            System.out.print("Last name: ");
            String lastName = VetApp.SCANNER.nextLine();

            if (isNameValid(lastName)) {
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

    private static boolean isNameValid(String lastName) {
        Matcher matcher = NAME_PATTERN.matcher(lastName);

        return matcher.matches();
    }

    static boolean isEmailValid(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);

        return matcher.matches();
    }
}
