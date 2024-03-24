package main.java.com.magicvet.component;

import main.java.com.magicvet.VetApp;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    private final Sandbox sandbox = new Sandbox();

    public void registerClient() {
        List<Client> clients = new ArrayList<>();
        String message = "Do you want to register more client? (y/n)";
        do {
            Optional<Client> client = addClient();
            client.ifPresent(clients::add);
        } while (hasNextClient(message));

        Map<Client.Location, List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));
        printClients(clientsByLocation);
        sandbox.writeSandbox(clients.toString());
    }

    public void printSandbox() {
        sandbox.writeSandbox("");
        List<String> sandboxList = sandbox.readSandbox();
        for (String line : sandboxList) {
            System.out.println(line);
        }
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = "\nLocation: " + clients.getKey()
                    + "\nClients (" + clients.getValue().size()
                    + "):"
                    + "\n\t" + clients.getValue();
            System.out.println(content);
            printSandbox();
        }
    }

    private Optional<Client> addClient() {
        Optional<Client> client = clientService.registerNewClient();
        client.ifPresent(this::registerPets);
        System.out.println(client);

        return client;
    }

    private void registerPets(Client client) {
        String message = "Do you want to add more pets for the current client? (y/n)";
        do {
            addPet(client);
            System.out.println(client);
            sandbox.readSandbox();
        } while (hasNextClient(message));
    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet.");
        Optional<Pet> pet = Optional.ofNullable(petService.registetNewPet());
        if (pet.isPresent()) {
            client.addPet(pet.get());
            pet.get().setOwnerName(client.getFirsName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
    }

    private static boolean hasNextClient(String message) {
        System.out.println(message);
        String answer = VetApp.SCANNER.nextLine();
        if ("y".equals(answer)) {
            return true;
        } else if ("n".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please try again.");
            return hasNextClient(message);
        }
    }
}
