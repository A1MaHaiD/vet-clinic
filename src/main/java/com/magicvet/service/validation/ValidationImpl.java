package main.java.com.magicvet.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationImpl implements ValidationService {
    private final static Pattern EMAIL_PATTERN = Pattern
            .compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private final static Pattern NAME_PATTERN = Pattern
            .compile("^[a-zA-Z]{2,}+(-[a-zA-Z]{2,}+)?$");

    private final static Pattern AGE_PATTERN = Pattern.compile("^[0-9]{1,}$");

    public boolean isNameValid(String lastName) {
        Matcher matcher = NAME_PATTERN.matcher(lastName);

        return matcher.matches();
    }

    public boolean isEmailValid(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);

        return matcher.matches();
    }

    public boolean isAgeValid(String lastName) {
        Matcher matcher = AGE_PATTERN.matcher(lastName);

        return matcher.matches();
    }
}
