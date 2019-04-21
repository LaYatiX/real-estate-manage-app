package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.ApartmentInput;
import pl.gpiwosz.estate.model.Apartment;

import java.util.List;
import java.util.stream.Collectors;

public class ApartmentMapper extends AbstractMapper{
    public static Apartment toEntity(final ApartmentInput input) {
        if (input == null) {
            return null;
        }
        Apartment entity = new Apartment();
        update(entity, input);

        return entity;
    }

    public static Apartment update(final Apartment entity, final ApartmentInput input) {
        entity.setRent(input.getRent());
        entity.setApartmentNumber(input.getApartmentNumber());
        return entity;
    }

    public static List<Apartment> map(final List<Long> apartmentIds){
        if (apartmentIds == null) {
            return null;
        }
        return apartmentIds.stream().map(id -> {
            Apartment apartment = new Apartment();
            apartment.setId(id);
            return apartment;
        }).collect(Collectors.toList());
    }
}
