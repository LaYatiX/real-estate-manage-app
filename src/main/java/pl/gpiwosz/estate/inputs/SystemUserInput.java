package pl.gpiwosz.estate.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserInput {
    private UserInput user;
    private String username;
    private String password;
    private Boolean active;
    private List<Long> roles;
}
