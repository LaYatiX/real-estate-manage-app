package pl.gpiwosz.estate.mappers;

import pl.gpiwosz.estate.inputs.EstateInput;
import pl.gpiwosz.estate.model.Estate;

public class EstateMapper extends AbstractMapper{
    public static Estate toEntity(final EstateInput input) {
        if (input == null) {
            return null;
        }
        Estate entity = new Estate();
        update(entity, input);

        return entity;
    }

    public static Estate update(final Estate entity, final EstateInput input) {
        entity.setAddress(input.getAddress());
        entity.setFloors(input.getFloors());
        entity.setArea(input.getArea());
        entity.setIsElevator(input.getIsElevator());
        entity.setIsParking(input.getIsParking());
        entity.setEntranceCode(input.getEntranceCode());
        return entity;
    }
}
