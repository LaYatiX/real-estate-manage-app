package pl.gpiwosz.estate.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionInput {
    private Long apartment;
    private String writingDate;
    private Float waterConsumption;
    private Float energyConsumption;
    private Float gasConsumption;
    private Float mediaConsumption;
}
