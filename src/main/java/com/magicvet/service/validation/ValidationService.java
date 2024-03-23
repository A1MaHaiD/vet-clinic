package main.java.com.magicvet.service.validation;

public interface ValidationService {
    boolean isNameValid(String lastName);
    boolean isEmailValid(String email);
}
