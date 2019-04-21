package pl.gpiwosz.estate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "estate")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estate extends AuditModel{
    private String address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Apartment> apartments;

    Long floors;

    Float area;

    Boolean isElevator;

    Boolean isParking;

    Long entranceCode;
}
