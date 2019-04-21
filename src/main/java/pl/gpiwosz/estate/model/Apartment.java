package pl.gpiwosz.estate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "apartment")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Apartment extends AuditModel{
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<User> residents;

    Float rent;
    Long apartmentNumber;
}
