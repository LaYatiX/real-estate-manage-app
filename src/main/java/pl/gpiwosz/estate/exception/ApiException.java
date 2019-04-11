package pl.gpiwosz.estate.exception;

public class ApiException extends RuntimeException {

    public ApiException(final String message) {
        super(message);
    }
}