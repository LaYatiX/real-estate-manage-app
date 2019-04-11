package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.ConsumptionInput;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.model.Consumption;

import java.time.LocalDate;

public class ConsumptionMapper {
    public static Consumption toEntity(final ConsumptionInput input) {
        if (input == null) {
            return null;
        }

        Consumption entity = new Consumption();
        Apartment apartment = new Apartment();
        apartment.setId(input.getApartment());
        entity.setApartment(apartment);
        entity.setWritingDate(LocalDate.parse(input.getWritingDate()));
        entity.setEnergyConsumption(input.getEnergyConsumption());
        entity.setGasConsumption(input.getGasConsumption());
        entity.setMediaConsumption(input.getMediaConsumption());

        return entity;
    }
}
