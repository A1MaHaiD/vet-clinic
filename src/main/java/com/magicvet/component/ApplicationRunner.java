package main.java.com.magicvet.component;

import java.util.List;

public class ApplicationRunner {
    private final EntityRegister register = new EntityRegister();

    public void run() {
        if (Authenticator.auth()) {
            register.printSandbox();
            register.registerClient();
        }
    }
}
