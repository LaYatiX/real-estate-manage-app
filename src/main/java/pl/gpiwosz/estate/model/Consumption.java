package pl.gpiwosz.estate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consumption extends AuditModel{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_apartment", referencedColumnName = "id")
    private Apartment apartment;

    @JsonSerialize(using= LocalDateSerializer.class)
    @JsonDeserialize(using= LocalDateDeserializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate writingDate;

    private Float waterConsumption;

    private Float energyConsumption;

    private Float gasConsumption;

    private Float mediaConsumption;
}
