package pl.gpiwosz.estate.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {
    private String pesel;
    private String name;
    private String surname;
    private String address;
    private String email;
    private Long phone;
    private String bankAccount;
}


