package co.com.sofka.exceptions.login;

public class ValidationLoginOrange extends AssertionError {
    public static final String VALIDATION_DO_NOT_MATCH = "The validation don't match. %s";

    public ValidationLoginOrange(String message, Throwable cause){
        super(message, cause);
    }
}
