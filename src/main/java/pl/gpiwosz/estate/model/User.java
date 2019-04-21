package pl.gpiwosz.estate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends AuditModel {

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