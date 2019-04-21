package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.ConsumptionInput;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.model.Consumption;

import java.time.LocalDate;

public class ConsumptionMapper extends AbstractMapper{
    public static Consumption toEntity(final ConsumptionInput input) {
        if (input == null) {
            return null;
        }

        Consumption entity = new Consumption();
        update(entity, input);
        return entity;
    }

    public static Consumption update(final Consumption entity, final ConsumptionInput input) {
        entity.setWritingDate(LocalDate.parse(input.getWritingDate()));
        entity.setWaterConsumption(input.getWaterConsumption());
        entity.setEnergyConsumption(input.getEnergyConsumption());
        entity.setGasConsumption(input.getGasConsumption());
        entity.setMediaConsumption(input.getMediaConsumption());
        return entity;
    }

//    public static List<Consumption> map(final List<Long> consumptionIds){
//        if (consumptionIds == null) {
//            return null;
//        }
//        return consumptionIds.stream().map(id -> {
//            Consumption consumption = new Consumption();
//            consumption.setId(id);
//            return consumption;
//        }).collect(Collectors.toList());
//    }
}
