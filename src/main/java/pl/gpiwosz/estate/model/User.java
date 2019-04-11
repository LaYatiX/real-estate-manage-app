package pl.gpiwosz.estate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends AuditModel {

    @Id
    @GeneratedValue
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            initialValue = 1000
    )
    private Long id;

    protected String pesel;

    protected String name;

    protected String surname;

    protected String address;

    protected String email;

    protected Long phone;

    protected String bankAccount;

    public User(String pesel, String name, String surname, String address, String email, Long phone, String bankAccount) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.bankAccount = bankAccount;
    }
}