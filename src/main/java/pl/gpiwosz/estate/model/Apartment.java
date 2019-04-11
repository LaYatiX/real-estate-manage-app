package pl.gpiwosz.estate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Table(name = "apartment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Apartment extends AuditModel{
    @Id
    @GeneratedValue
    @SequenceGenerator(
            name = "apartment_generator",
            sequenceName = "apartment_sequence",
            initialValue = 1000
    )
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<User> residents;

    Float rent;

    Long apartmentNumber;
}
