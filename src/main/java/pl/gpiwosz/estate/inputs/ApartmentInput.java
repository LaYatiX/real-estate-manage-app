package pl.gpiwosz.estate.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentInput {
    List<Long> residents;
    Float rent;
    Long apartmentNumber;
}
