package main.java.com.magicvet.service;

import main.java.com.magicvet.VetApp;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private final static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private final static String FIRST_NAME_PATTERN = "^[a-zA-Z]{2,}$";
    private final static String LAST_NAME_PATTERN = "^[a-zA-Z]{1,}\\-{0,}[a-zA-Z]{1,}$";

    public Client registerNewClient() {
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
        return client;
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);
        while (client.getFirsName() == null) {
            System.out.print("First name: ");
            String firstName = VetApp.SCANNER.nextLine();
            if (isNameValid(firstName, FIRST_NAME_PATTERN)) {
                client.setFirsName(firstName);
            } else {
                System.out.println("First Name is incorrect");
            }
        }
        while (client.getLastName() == null) {
            System.out.print("Last name: ");
            String lastName = VetApp.SCANNER.nextLine();
            if (isNameValid(lastName, LAST_NAME_PATTERN)) {
                client.setLastName(lastName);
            } else {
                System.out.println("Last Name is incorrect");
            }
        }
        return client;
    }

    private static boolean isNameValid(String lastName, String inputPattern) {
        Pattern pattern = Pattern.compile(inputPattern);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
