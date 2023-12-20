package main.java.com.magicvet.service;

import main.java.com.magicvet.VetApp;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

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
        System.out.print("First name: ");
        client.setFirsName(VetApp.SCANNER.nextLine());
        System.out.print("Last name: ");
        client.setLastName(VetApp.SCANNER.nextLine());
        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
