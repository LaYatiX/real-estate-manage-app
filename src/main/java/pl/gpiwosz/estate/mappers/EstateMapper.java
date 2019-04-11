package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.EstateInput;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.model.Estate;

import java.util.stream.Collectors;

public class EstateMapper {
    public static Estate toEntity(final EstateInput input) {
        if (input == null) {
            return null;
        }
        Estate entity = new Estate();
        entity.setAddress(input.getAddress());
        entity.setApartments(input.getApartments().stream().map(id -> {
            Apartment apartment = new Apartment();
            apartment.setId(id);
            return apartment;
        }).collect(Collectors.toList()));
        entity.setFloors(input.getFloors());
        entity.setArea(input.getArea());
        entity.setIsElevator(input.getIsElevator());
        entity.setIsParking(input.getIsParking());
        entity.setEntranceCode(input.getEntranceCode());

        return entity;
    }
}
