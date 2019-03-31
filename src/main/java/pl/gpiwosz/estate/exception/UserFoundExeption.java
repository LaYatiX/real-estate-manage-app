package pl.gpiwosz.estate.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserFoundExeption extends RuntimeException{
    public UserFoundExeption(String message) {
        super(message);
    }
}
