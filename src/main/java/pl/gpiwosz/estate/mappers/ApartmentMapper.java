package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.ApartmentInput;
import pl.gpiwosz.estate.model.Apartment;
import pl.gpiwosz.estate.model.User;

import java.util.stream.Collectors;

public class ApartmentMapper {
    public static Apartment toEntity(final ApartmentInput input) {
        if (input == null) {
            return null;
        }
        Apartment entity = new Apartment();
        entity.setResidents(input.getResidents().stream().map(id -> {
            User user = new User();
            user.setId(id);
            return user;
        }).collect(Collectors.toList()));
        entity.setRent(input.getRent());
        entity.setApartmentNumber(input.getApartmentNumber());

        return entity;
    }
}
