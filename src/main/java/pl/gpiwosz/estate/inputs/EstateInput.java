package pl.gpiwosz.estate.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstateInput {
    private String address;
    private List<Long> apartments;
    private Long floors;
    private Float area;
    private Boolean isElevator;
    private Boolean isParking;
    private Long entranceCode;
}
