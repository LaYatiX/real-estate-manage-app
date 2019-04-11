package pl.gpiwosz.estate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estate")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estate extends AuditModel{
    @Id
    @GeneratedValue
    @SequenceGenerator(
            name = "estate_generator",
            sequenceName = "estate_sequence",
            initialValue = 1000
    )
    private Long id;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Apartment> apartments;

    Long floors;

    Float area;

    Boolean isElevator;

    Boolean isParking;

    Long entranceCode;
}
